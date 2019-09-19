package logic.game;

import java.util.Arrays;
import java.util.Collections;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Alpha extends Application {

	private static int counter = 0;
	private static Player[] players = new Player[6];
	private static int counterRound = 0;

	private DiceImage images = new DiceImage();

	// get Images for EmptyStripe
	private Dices diceBlack1 = new Dices(images.getImagesBlack());
	private Dices diceBlue1 = new Dices(images.getImagesBlue());
	private Dices diceGreen1 = new Dices(images.getImagesGreen());
	private Dices diceRed1 = new Dices(images.getImagesRed());
	private Dices diceWhite1 = new Dices(images.getImagesWhite());
	private Dices diceYellow1 = new Dices(images.getImagesYellow());

	// get Images for SoultionStripe
	private Dices diceBlack2 = new Dices(images.getImagesBlack());
	private Dices diceBlue2 = new Dices(images.getImagesBlue());
	private Dices diceGreen2 = new Dices(images.getImagesGreen());
	private Dices diceRed2 = new Dices(images.getImagesRed());
	private Dices diceWhite2 = new Dices(images.getImagesWhite());
	private Dices diceYellow2 = new Dices(images.getImagesYellow());

	// get Images for FinalStripe
	private Dices diceBlack3 = new Dices(images.getImagesBlack());
	private Dices diceBlue3 = new Dices(images.getImagesBlue());
	private Dices diceGreen3 = new Dices(images.getImagesGreen());
	private Dices diceRed3 = new Dices(images.getImagesRed());
	private Dices diceWhite3 = new Dices(images.getImagesWhite());
	private Dices diceYellow3 = new Dices(images.getImagesYellow());

	@Override
	public void start(Stage primaryStage) {

		Player player1 = new Player("Lea");
		Player player2 = new Player("Tobias");
		Player player3 = new Player("Nina");
		Player player4 = new Player("Yasmin");
		Player player5 = new Player("Tobi");
		Player player6 = new Player("Timo");

		Alpha.players[0] = player1;
		Alpha.players[1] = player2;
		Alpha.players[2] = player3;
		Alpha.players[3] = player4;
		Alpha.players[4] = player5;
		Alpha.players[5] = player6;

		int[] stripe = newStripe();
		startGame(Alpha.players[Alpha.counter], primaryStage, stripe);

	}

	private void isSelectedAlert(String message) {
		Alert alert = new Alert(AlertType.ERROR, message);
		alert.setTitle("Validation Error");
		alert.setHeaderText("Mindestens ein Wuerfel muss ausgewaehlt werden");
		alert.showAndWait();
	}

	private void showScoreAlert(int currentScore) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Zug Ende");
		alert.setHeaderText("Sie haben in dieser Runde " + currentScore + " Punkte erreicht");
		alert.showAndWait();
	}

	int getBonusPoints(int[] finalStripe) {
		int score = 0;
		int counter = 0;
		int temporaryPoints = 0;
		for (int i = 0; i < finalStripe.length; i++) {
			if (finalStripe[i] > 0) {
				counter++;
			} else {
				continue;
			}
		}
		if (counter == 6) {
			for (int i = 0; i < finalStripe.length; i++) {
				temporaryPoints = temporaryPoints + finalStripe[i];
			}
			score = score + (temporaryPoints * 2);
		} else if (counter == 5) {
			score += 5;
		} else if (counter == 0) {
			score += 15;
		} else {
			score += 0;
		}
		counter = 0;
		temporaryPoints = 0;
		return score;
	}

	public void noValidDiceAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Zug Ende");
		alert.setHeaderText("Keine Wuerfeln sind gueltig. Sie erhalten Punkte aller unbedeckten Felder");
		alert.showAndWait();
	}

	public void getBonusAlert(int bonus) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Bonuspunkte");
		alert.setHeaderText("Sie erhalten" + bonus + " Bonuspunkte");
		alert.showAndWait();
	}

	public int regularCalculation(int[] finalStripe) {
		int currentScore = 0;
		for (int i = 0; i < finalStripe.length; i++) {
			currentScore += finalStripe[i];
		}
		return currentScore;
	}

	// if a player can't roll dices anymore because no values equal or less
	public int noValidDiceCalculation(int[] solutionStripe, boolean[] decisionStripe) {
		int currentScore = 0;

		for (int i = 0; i < solutionStripe.length; i++) {
			if (decisionStripe[i] == false) {
				currentScore += solutionStripe[i];
			}
		}
		return currentScore;
	}

	// check if at least one valid dice is selected if it's possible
	public boolean isSelected(RadioButton[] radioButtons) {
		boolean check = false;
		int counter = 0;
		for (int i = 0; i < radioButtons.length; i++) {
			if (radioButtons[i].isSelected() && radioButtons[i].isVisible()) {
				counter++;
				check = true;
				radioButtons[i].setVisible(false);
				;
			}
		}
		if (counter == 0) {
			check = false;
			isSelectedAlert("AUSWAEHLEN");
		}
		return check;
	}

	// check if a player can't still roll dices again (maximal six times)
	public boolean isRollable(int[] finalStripe) {
		boolean check = false;
		int counter = 0;

		for (int i = 0; i < finalStripe.length; i++) {
			if (finalStripe[i] != 0) {
				counter++;
			}
		}
		if (counter < 6) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}

	// Info which player's round it is and how much the currentScore is
	private void playerInfo(Player player) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Spieler INFO");
		alert.setHeaderText("Spieler/in: " + player.getName() + " ist an der Reihe");
		alert.setContentText("Aktueller Punktestand: " + Integer.toString(player.getScore()) + " ");
		alert.showAndWait();
	}

	private void noMoreRollable() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Spieler INFO");
		alert.setHeaderText("Alle Würfel sind ausgwählt. Beenden Sie die Runde.");
		alert.showAndWait();
	}

	public void startGame(Player players, Stage primaryStage, int[] solutionStripe) {

		// if (counterRound != 3) {
		// counterRound++;
		playerInfo(players);
		// SolutionStripe stripe2 = new SolutionStripe();
//		if (counter == 6) {
//			counter = 0;
//			Platform.exit();
//			// stripe2 = new SolutionStripe();
//		}

		EmptyStripe stripe1 = new EmptyStripe();

		int[] emptyStripe = stripe1.getStripe();

		int[] finalStripe = new int[6];
		boolean[] decisionStripe = stripe1.getDecisionStripe();

		// root object
		GridPane root = new GridPane();
		// root.setStyle("-fx-background-image:url(\"src\\1.png\");");

		root.setBackground(new Background(
				new BackgroundFill(javafx.scene.paint.Color.ALICEBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

		Rectangle r1 = new Rectangle();
		r1.setHeight(70);
		r1.setWidth(70);
		r1.setRotate(45);
		r1.setFill(Color.BLACK);
//		r1.setLayoutX(300);
//		r1.setLayoutY(100);

		TranslateTransition t1 = new TranslateTransition();
		t1.setDuration(Duration.seconds(1));
		t1.setAutoReverse(true);
		t1.setCycleCount(1000);
		t1.setToY(600);
		t1.setNode(r1);
		t1.play();

		Rectangle r2 = new Rectangle();
		r2.setHeight(70);
		r2.setWidth(70);
		r2.setRotate(45);
		r2.setFill(Color.DARKRED);
//		r2.setLayoutX(600);
//		r2.setLayoutY(100);

		TranslateTransition t2 = new TranslateTransition();
		t2.setDuration(Duration.seconds(1));
		t2.setAutoReverse(true);
		t2.setCycleCount(1000);
		t2.setToX(-1024);
		t2.setNode(r2);
		t2.play();

		Rectangle r3 = new Rectangle();
		r3.setHeight(70);
		r3.setWidth(70);
		r3.setRotate(45);
		r3.setFill(Color.DARKBLUE);
//		r1.setLayoutX(300);
//		r1.setLayoutY(100);

		TranslateTransition t3 = new TranslateTransition();
		t3.setDuration(Duration.seconds(1));
		t3.setAutoReverse(true);
		t3.setCycleCount(1000);
		t3.setToX(1024);
		t3.setNode(r3);
		t3.play();

		Rectangle r4 = new Rectangle();
		r4.setHeight(70);
		r4.setWidth(70);
		r4.setRotate(45);
		r4.setFill(Color.DARKGREEN);
//		r1.setLayoutX(300);
//		r1.setLayoutY(100);

		TranslateTransition t4 = new TranslateTransition();
		t4.setDuration(Duration.seconds(1));
		t4.setAutoReverse(true);
		t4.setCycleCount(1000);
		t4.setToY(-678);
		t4.setNode(r4);
		t4.play();

		root.add(r1, 0, 0);
		root.add(r2, 10, 0);
		root.add(r3, 0, 9);
		root.add(r4, 9, 9);
//    root.setGridLinesVisible(true);
		final int numCols = 10;
		final int numRows = 10;
		for (int i = 0; i < numCols; i++) {
			ColumnConstraints colConst = new ColumnConstraints();
			colConst.setPercentWidth(100.0 / numCols);
			root.getColumnConstraints().add(colConst);
		}
		for (int i = 0; i < numRows; i++) {
			RowConstraints rowConst = new RowConstraints();
			rowConst.setPercentHeight(100.0 / numRows);
			root.getRowConstraints().add(rowConst);
		}

		// EmptyStripe
		HBox emptyStripeBox = new HBox();
		emptyStripeBox.setAlignment(Pos.CENTER_LEFT);
		emptyStripeBox.setStyle("-fx-border-width: 3;" + "-fx-border-style: dashed;" + "-fx-border-color: black;"
				+ "-fx-border-radius: 10 ");

		Label emptyStripeLabel1 = new Label();
		emptyStripeLabel1.setMinSize(105, 100);
		emptyStripeLabel1.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label emptyStripeLabel2 = new Label();
		emptyStripeLabel2.setMinSize(105, 100);
		emptyStripeLabel2.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label emptyStripeLabel3 = new Label();
		emptyStripeLabel3.setMinSize(105, 100);
		emptyStripeLabel3.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label emptyStripeLabel4 = new Label();
		emptyStripeLabel4.setMinSize(105, 100);
		emptyStripeLabel4.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label emptyStripeLabel5 = new Label();
		emptyStripeLabel5.setMinSize(105, 100);
		emptyStripeLabel5.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label emptyStripeLabel6 = new Label();
		emptyStripeLabel6.setMinSize(105, 100);
		emptyStripeLabel6.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		// SolutionStripe
		HBox solutionStripeBox = new HBox();
		solutionStripeBox.setAlignment(Pos.CENTER);
		solutionStripeBox.setStyle("-fx-border-width: 3;" + "-fx-border-style: dashed;" + "-fx-border-color: black;"
				+ "-fx-border-radius: 10 ");

		Label solutionStripeLabel1 = new Label();
		solutionStripeLabel1.setMinSize(105, 100);
		solutionStripeLabel1.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label solutionStripeLabel2 = new Label();
		solutionStripeLabel2.setMinSize(105, 100);
		solutionStripeLabel2.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label solutionStripeLabel3 = new Label();
		solutionStripeLabel3.setMinSize(105, 100);
		solutionStripeLabel3.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label solutionStripeLabel4 = new Label();
		solutionStripeLabel4.setMinSize(105, 100);
		solutionStripeLabel4.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label solutionStripeLabel5 = new Label();
		solutionStripeLabel5.setMinSize(105, 100);
		solutionStripeLabel5.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label solutionStripeLabel6 = new Label();
		solutionStripeLabel6.setMinSize(105, 100);
		solutionStripeLabel6.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");
		// FinalStripe
		HBox finalStripeBox = new HBox();
		finalStripeBox.setAlignment(Pos.CENTER);
		finalStripeBox.setStyle("-fx-border-width: 3;" + "-fx-border-style: dashed;" + "-fx-border-color: black;"
				+ "-fx-border-radius: 10 ");

		Label finaleStripeLabel1 = new Label();
		finaleStripeLabel1.setMinSize(105, 100);
		finaleStripeLabel1.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label finaleStripeLabel2 = new Label();
		finaleStripeLabel2.setMinSize(105, 100);
		finaleStripeLabel2.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label finaleStripeLabel3 = new Label();
		finaleStripeLabel3.setMinSize(105, 100);
		finaleStripeLabel3.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label finaleStripeLabel4 = new Label();
		finaleStripeLabel4.setMinSize(105, 100);
		finaleStripeLabel4.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label finaleStripeLabel5 = new Label();
		finaleStripeLabel5.setMinSize(105, 100);
		finaleStripeLabel5.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		Label finaleStripeLabel6 = new Label();
		finaleStripeLabel6.setMinSize(105, 100);
		finaleStripeLabel6.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;");

		// Radio Buttons for Dice Selection
		HBox selection = new HBox();
		selection.setAlignment(Pos.CENTER);

		RadioButton selectDice1 = new RadioButton();
		selectDice1.setAlignment(Pos.CENTER);
		selectDice1.setMinSize(120, 5);
		selectDice1.setDisable(true);

		RadioButton selectDice2 = new RadioButton();
		selectDice2.setAlignment(Pos.CENTER);
		selectDice2.setMinSize(120, 5);
		selectDice2.setDisable(true);

		RadioButton selectDice3 = new RadioButton();
		selectDice3.setAlignment(Pos.CENTER);
		selectDice3.setMinSize(120, 5);
		selectDice3.setDisable(true);

		RadioButton selectDice4 = new RadioButton();
		selectDice4.setAlignment(Pos.CENTER);
		selectDice4.setMinSize(120, 5);
		selectDice4.setDisable(true);

		RadioButton selectDice5 = new RadioButton();
		selectDice5.setAlignment(Pos.CENTER);
		selectDice5.setMinSize(120, 5);
		selectDice5.setDisable(true);

		RadioButton selectDice6 = new RadioButton();
		selectDice6.setAlignment(Pos.CENTER);
		selectDice6.setMinSize(120, 5);
		selectDice6.setDisable(true);

		RadioButton[] radioButtons = { selectDice1, selectDice2, selectDice3, selectDice4, selectDice5, selectDice6 };

		// Rest Labels, Buttons...
		Label playerName = new Label();
		playerName.setText("Name: " + players.getName());
		playerName.setMinSize(250, 60);
		playerName.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-alignment:center;"
				+ "-fx-font:18px Sans-Serif;" + "-fx-border-width: 4;" + "-fx-border-color: #8B1B91;");

		Label score = new Label();
		score.setText("Punktestand: " + Integer.toString(players.getScore()));
		score.setMinSize(250, 60);
		score.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-alignment:center;"
				+ "-fx-font:18px Sans-Serif;" + "-fx-border-width: 4;" + "-fx-border-color: #8B1B91;");

		Button buttonRollDice = new Button("Wuerfeln");
		buttonRollDice.setDisable(true);
		buttonRollDice.setMinSize(180, 30);
		buttonRollDice.setStyle("-fx-background-color: \n" + "        #ecebe9,\n" + "        rgba(0,0,0,0.05),\n"
				+ "        linear-gradient(#dcca8a, #c7a740),\n"
				+ "        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n"
				+ "        linear-gradient(#f6ebbe, #e6c34d);\n" + "    -fx-background-insets: 0,9 9 8 9,9,10,11;\n"
				+ "    -fx-background-radius: 50;\n" + "    -fx-padding: 15 30 15 30;\n"
				+ "    -fx-font-family: \"Helvetica\";\n" + "    -fx-text-fill: #311c09;\n"
				+ "    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1)");

		Button finish = new Button("Zug Beenden");
		finish.setMinSize(180, 30);
		finish.setDisable(true);
		finish.setStyle("-fx-background-color: \n" + "        #ecebe9,\n" + "        rgba(0,0,0,0.05),\n"
				+ "        linear-gradient(#dcca8a, #c7a740),\n"
				+ "        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n"
				+ "        linear-gradient(#f6ebbe, #e6c34d);\n" + "    -fx-background-insets: 0,9 9 8 9,9,10,11;\n"
				+ "    -fx-background-radius: 50;\n" + "    -fx-padding: 15 30 15 30;\n"
				+ "    -fx-font-family: \"Helvetica\";\n" + "    -fx-text-fill: #311c09;\n"
				+ "    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1)");

		Button exit = new Button("Spiel verlassen");
		exit.setMinSize(180, 30);
		exit.setStyle("-fx-background-color: \n" + "        #ecebe9,\n" + "        rgba(0,0,0,0.05),\n"
				+ "        linear-gradient(#dcca8a, #c7a740),\n"
				+ "        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n"
				+ "        linear-gradient(#f6ebbe, #e6c34d);\n" + "    -fx-background-insets: 0,9 9 8 9,9,10,11;\n"
				+ "    -fx-background-radius: 50;\n" + "    -fx-padding: 15 30 15 30;\n"
				+ "    -fx-font-family: \"Helvetica\";\n" + "    -fx-text-fill: #311c09;\n"
				+ "    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1)");

		Button saveButton = new Button("Save");

		Button startButton = new Button("Spiel Starten");
		startButton.setMinSize(180, 30);
		startButton.setStyle(" -fx-background-color: \n" + "        linear-gradient(#ffd65b, #e68400),\n"
				+ "        linear-gradient(#ffef84, #f2ba44),\n" + "        linear-gradient(#ffea6a, #efaa22),\n"
				+ "        linear-gradient(#ffe657 0%, #f8c202 50%, #eea10b 100%),\n"
				+ "        linear-gradient(from 0% 0% to 15% 50%, rgba(255,255,255,0.9), rgba(255,255,255,0));\n"
				+ "    -fx-background-radius: 30;\n" + "    -fx-background-insets: 0,1,2,3,0;\n"
				+ "    -fx-text-fill: #654b00;\n" + "    -fx-font-weight: bold;\n" + "    -fx-font-size: 14px;\n"
				+ "    -fx-padding: 10 20 10 20;");

		Button selected = new Button("Auswahl fertig");
		selected.setMinSize(180, 10);
		selected.setDisable(true);
		selected.setStyle("-fx-background-color: \n" + "        #ecebe9,\n" + "        rgba(0,0,0,0.05),\n"
				+ "        linear-gradient(#dcca8a, #c7a740),\n"
				+ "        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n"
				+ "        linear-gradient(#f6ebbe, #e6c34d);\n" + "    -fx-background-insets: 0,9 9 8 9,9,10,11;\n"
				+ "    -fx-background-radius: 50;\n" + "    -fx-padding: 15 30 15 30;\n"
				+ "    -fx-font-family: \"Helvetica\";\n" + "    -fx-text-fill: #311c09;\n"
				+ "    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1)");

		startButton.setOnMouseClicked(e -> {
			buttonRollDice.setDisable(false);

			diceBlack2.setDiceFace(solutionStripe[0]);
			solutionStripeLabel1.setGraphic(diceBlack2.getDiceFace());

			diceWhite2.setDiceFace(solutionStripe[1]);
			solutionStripeLabel2.setGraphic(diceWhite2.getDiceFace());

			diceRed2.setDiceFace(solutionStripe[2]);
			solutionStripeLabel3.setGraphic(diceRed2.getDiceFace());

			diceGreen2.setDiceFace(solutionStripe[3]);
			solutionStripeLabel4.setGraphic(diceGreen2.getDiceFace());

			diceBlue2.setDiceFace(solutionStripe[4]);
			solutionStripeLabel5.setGraphic(diceBlue2.getDiceFace());

			diceYellow2.setDiceFace(solutionStripe[5]);
			solutionStripeLabel6.setGraphic(diceYellow2.getDiceFace());
			startButton.setDisable(true);
		});

		selectDice1.setOnMouseClicked(e -> {

			if (selectDice1.isSelected()) {
				finalStripe[0] = emptyStripe[0];
				diceBlack3.setDiceFace(emptyStripe[0]);
				finaleStripeLabel1.setGraphic(diceBlack3.getDiceFace());
				emptyStripeLabel1.setGraphic(null);
				decisionStripe[0] = true;
			} else {
				diceBlack1.setDiceFace(emptyStripe[0]);
				emptyStripeLabel1.setGraphic(diceBlack1.getDiceFace());
				finaleStripeLabel1.setGraphic(null);
				finalStripe[0] = 0;
				decisionStripe[0] = false;
			}
		});

		selectDice2.setOnMouseClicked(e -> {
			if (selectDice2.isSelected()) {
				finalStripe[1] = emptyStripe[1];
				diceWhite3.setDiceFace(emptyStripe[1]);
				finaleStripeLabel2.setGraphic(diceWhite3.getDiceFace());
				emptyStripeLabel2.setGraphic(null);
				decisionStripe[1] = true;
			} else {
				diceWhite1.setDiceFace(emptyStripe[1]);
				emptyStripeLabel2.setGraphic(diceWhite1.getDiceFace());
				finaleStripeLabel2.setGraphic(null);
				finalStripe[1] = 0;
				decisionStripe[1] = false;
			}
		});

		selectDice3.setOnMouseClicked(e -> {
			if (selectDice3.isSelected()) {
				finalStripe[2] = emptyStripe[2];
				diceRed3.setDiceFace(emptyStripe[2]);
				finaleStripeLabel3.setGraphic(diceRed3.getDiceFace());
				emptyStripeLabel3.setGraphic(null);
				decisionStripe[2] = true;
			} else {
				diceRed1.setDiceFace(emptyStripe[2]);
				emptyStripeLabel3.setGraphic(diceRed1.getDiceFace());
				finaleStripeLabel3.setGraphic(null);
				finalStripe[2] = 0;
				;
				decisionStripe[2] = false;
			}
		});

		selectDice4.setOnMouseClicked(e -> {
			if (selectDice4.isSelected()) {
				finalStripe[3] = emptyStripe[3];
				diceGreen3.setDiceFace(emptyStripe[3]);
				finaleStripeLabel4.setGraphic(diceGreen3.getDiceFace());
				emptyStripeLabel4.setGraphic(null);
				decisionStripe[3] = true;
			} else {
				diceGreen1.setDiceFace(emptyStripe[3]);
				emptyStripeLabel4.setGraphic(diceGreen1.getDiceFace());
				finaleStripeLabel4.setGraphic(null);
				finalStripe[3] = 0;
				decisionStripe[3] = false;
			}
		});

		selectDice5.setOnMouseClicked(e -> {
			if (selectDice5.isSelected()) {
				finalStripe[4] = emptyStripe[4];
				diceBlue3.setDiceFace(emptyStripe[4]);
				finaleStripeLabel5.setGraphic(diceBlue3.getDiceFace());
				emptyStripeLabel5.setGraphic(null);
				decisionStripe[4] = true;
			} else {
				finalStripe[4] = 0;
				diceBlue1.setDiceFace(emptyStripe[4]);
				emptyStripeLabel5.setGraphic(diceBlue1.getDiceFace());
				finaleStripeLabel5.setGraphic(null);
				decisionStripe[4] = false;
			}
		});

		selectDice6.setOnMouseClicked(e -> {
			if (selectDice6.isSelected()) {
				finalStripe[5] = emptyStripe[5];
				diceYellow3.setDiceFace(emptyStripe[5]);
				finaleStripeLabel6.setGraphic(diceYellow3.getDiceFace());
				emptyStripeLabel6.setGraphic(null);
				decisionStripe[5] = true;
			} else {
				finalStripe[5] = 0;
				diceYellow1.setDiceFace(emptyStripe[5]);
				emptyStripeLabel6.setGraphic(diceYellow1.getDiceFace());
				finaleStripeLabel6.setGraphic(null);
				decisionStripe[5] = false;
			}
		});

		finish.setOnMouseClicked(e -> {
			// next Player should play with the same stripe
			players.addScore(regularCalculation(finalStripe));
			showScoreAlert(regularCalculation(finalStripe));
			score.setText(Integer.toString(players.getScore()));
			players.addScore(getBonusPoints(finalStripe));
			Alpha.counter++;
			// startButton.setDisable(false);
			Alpha.counterRound++;
			if (Alpha.counterRound < 12) {
				if (Alpha.counter + 1 > Alpha.players.length) {

					Alpha.counter = 0;

					int[] stripe = newStripe();
					startGame(Alpha.players[Alpha.counter], primaryStage, stripe);
				} else {
					startGame(Alpha.players[Alpha.counter], primaryStage, solutionStripe);
				}
			} else {
				isWinner(Alpha.players);
				Platform.exit();
			}
		});

		exit.setOnMouseClicked(e -> {
			Platform.exit();
		});

		selected.setOnMouseClicked(e -> {
			if (isRollable(finalStripe)) {
				if (isSelected(radioButtons)) {
					buttonRollDice.setDisable(false);
					for (int i = 0; i < finalStripe.length; i++) {
						if (finalStripe[i] != 0) {
							finish.setDisable(false);
						}
						if ((!radioButtons[i].isSelected()) && radioButtons[i].isVisible()) {
							radioButtons[i].setDisable(true);
						}
						selected.setDisable(true);
					}
				} else {
					buttonRollDice.setDisable(true);
				}
			} else {
				buttonRollDice.setDisable(true);
				finish.setDisable(false);
				noMoreRollable();
			}
		});

		buttonRollDice.setOnMouseClicked(e -> {
			int counter = 0;
			finish.setDisable(true);
			selected.setDisable(false);
			selectDice1.setDisable(true);
			selectDice2.setDisable(true);
			selectDice3.setDisable(true);
			selectDice4.setDisable(true);
			selectDice5.setDisable(true);
			selectDice6.setDisable(true);

			stripe1.rollDice(emptyStripe, decisionStripe);

			diceBlack1.setDiceFace(emptyStripe[0]);
			emptyStripeLabel1.setGraphic(diceBlack1.getDiceFace());
			diceWhite1.setDiceFace(emptyStripe[1]);
			emptyStripeLabel2.setGraphic(diceWhite1.getDiceFace());
			diceRed1.setDiceFace(emptyStripe[2]);
			emptyStripeLabel3.setGraphic(diceRed1.getDiceFace());
			diceGreen1.setDiceFace(emptyStripe[3]);
			emptyStripeLabel4.setGraphic(diceGreen1.getDiceFace());
			diceBlue1.setDiceFace(emptyStripe[4]);
			emptyStripeLabel5.setGraphic(diceBlue1.getDiceFace());
			diceYellow1.setDiceFace(emptyStripe[5]);
			emptyStripeLabel6.setGraphic(diceYellow1.getDiceFace());

			if (emptyStripe[0] <= solutionStripe[0] && emptyStripe[0] != 0) {
				selectDice1.setDisable(false);
				counter++;
			}
			if (emptyStripe[1] <= solutionStripe[1] && emptyStripe[1] != 0) {
				selectDice2.setDisable(false);
				counter++;
			}

			if (emptyStripe[2] <= solutionStripe[2] && emptyStripe[2] != 0) {
				selectDice3.setDisable(false);
				counter++;
			}

			if (emptyStripe[3] <= solutionStripe[3] && emptyStripe[3] != 0) {
				selectDice4.setDisable(false);
				counter++;
			}

			if (emptyStripe[4] <= solutionStripe[4] && emptyStripe[4] != 0) {
				selectDice5.setDisable(false);
				counter++;
			}

			if (emptyStripe[5] <= solutionStripe[5] && emptyStripe[5] != 0) {
				selectDice6.setDisable(false);
				counter++;
			}

			buttonRollDice.setDisable(true);
			if (counter < 1) {
				noValidDiceAlert();

				showScoreAlert(noValidDiceCalculation(solutionStripe, decisionStripe));
				players.addScore(noValidDiceCalculation(solutionStripe, decisionStripe));
				score.setText(Integer.toString(players.getScore()));
				Alpha.counter++;

				Alpha.counterRound++;
				if (Alpha.counterRound < 12) {
					if (Alpha.counter + 1 > Alpha.players.length) {

						Alpha.counter = 0;

						int[] stripe = newStripe();
						startGame(Alpha.players[Alpha.counter], primaryStage, stripe);
					} else {
						startGame(Alpha.players[Alpha.counter], primaryStage, solutionStripe);
					}
				} else {
					isWinner(Alpha.players);
					Platform.exit();
				}
			}
		});

		selection.getChildren().addAll(selectDice1, selectDice2, selectDice3, selectDice4, selectDice5, selectDice6);

		solutionStripeBox.getChildren().addAll(solutionStripeLabel1, solutionStripeLabel2, solutionStripeLabel3,
				solutionStripeLabel4, solutionStripeLabel5, solutionStripeLabel6);

		emptyStripeBox.getChildren().addAll(emptyStripeLabel1, emptyStripeLabel2, emptyStripeLabel3, emptyStripeLabel4,
				emptyStripeLabel5, emptyStripeLabel6);

		finalStripeBox.getChildren().addAll(finaleStripeLabel1, finaleStripeLabel2, finaleStripeLabel3,
				finaleStripeLabel4, finaleStripeLabel5, finaleStripeLabel6);

		// Column , Row
		root.add(solutionStripeBox, 2, 2);
		root.add(emptyStripeBox, 2, 4);
		root.add(finalStripeBox, 2, 6);
		root.add(startButton, 4, 0);
		root.add(selected, 0, 4);
		root.add(selection, 2, 5);
		root.add(buttonRollDice, 0, 2);
		root.add(finish, 0, 6);
		root.add(exit, 8, 9);
		// root.add(saveButton, 1, 1);
		root.add(playerName, 5, 8);
		root.add(score, 5, 9);

		Scene scene = new Scene(root, 1024, 678);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Fiese 15");
		primaryStage.show();

	}

	public void isWinner(Player[] players) {

		Integer[] allScores = new Integer[players.length];
		Player[] rankingList = new Player[players.length];

		for (int i = 0; i < players.length; i++) {
			allScores[i] = players[i].getScore();
		}

		Arrays.sort(allScores, Collections.reverseOrder());

		int b = 0;
		for (int i = 0; i < players.length;) {
			if (allScores[b].intValue() == players[i].getScore()) {
				rankingList[b] = players[i];
				if (b == players.length - 1) {
					break;
				} else {
					b++;
					i = 0;
				}
			} else {
				i++;
			}
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Endergebnis");
		alert.setHeaderText(
				"Spieler/in: " + rankingList[0].getName() + " hat mit " + rankingList[0].getScore() + " gewonnen");

		alert.showAndWait();

	}

	public int[] newStripe() {
		boolean check = false;
		int counter = 0;
		int[] stripe = new int[6];
		while (!check) {
			SolutionStripe stripe1 = new SolutionStripe();
			stripe = stripe1.getStripe();

			for (int i = 0; i < 6; i++) {
				if (stripe[i] > 0 && stripe[i] < 7) {
					counter++;
				}
			}
			if (counter == 6) {
				check = true;
			} else {
				check = false;
			}
		}
		return stripe;
	}

	public static void main(String[] args) {
		launch(args);

	}

}
