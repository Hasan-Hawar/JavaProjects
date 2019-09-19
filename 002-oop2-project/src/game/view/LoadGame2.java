package game.view;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import logic.game.DiceImage;
import logic.game.Dices;
import logic.game.EmptyStripe;
import logic.game.Player;
import logic.game.SolutionStripe;

public class LoadGame2 {

	static int counter = 0;
	static Player[] players = new Player[3];
	static int counterRound = 0;

	private Player player;
	Stage primaryStage;
//public void startGame(Player player, int [] solutionStripe) {
	SolutionStripe solutionStripe2;
	int[] solutionStripe = new SolutionStripe().getStripe();
	EmptyStripe stripe1 = new EmptyStripe();
	int[] emptyStripe = stripe1.getStripe();
	int[] finalStripe = new int[6];
	boolean[] decisionStripe = stripe1.getDecisionStripe();

	/**
	 * Images Array
	 */
	DiceImage images = new DiceImage();

	// get Images for EmptyStripe
	Dices diceBlack1 = new Dices(images.getImagesBlack());
	Dices diceBlue1 = new Dices(images.getImagesBlue());
	Dices diceGreen1 = new Dices(images.getImagesGreen());
	Dices diceRed1 = new Dices(images.getImagesRed());
	Dices diceWhite1 = new Dices(images.getImagesWhite());
	Dices diceYellow1 = new Dices(images.getImagesYellow());

	// get Images for SoultionStripe
	Dices diceBlack2 = new Dices(images.getImagesBlack());
	Dices diceBlue2 = new Dices(images.getImagesBlue());
	Dices diceGreen2 = new Dices(images.getImagesGreen());
	Dices diceRed2 = new Dices(images.getImagesRed());
	Dices diceWhite2 = new Dices(images.getImagesWhite());
	Dices diceYellow2 = new Dices(images.getImagesYellow());

	// get Images for FinalStripe
	Dices diceBlack3 = new Dices(images.getImagesBlack());
	Dices diceBlue3 = new Dices(images.getImagesBlue());
	Dices diceGreen3 = new Dices(images.getImagesGreen());
	Dices diceRed3 = new Dices(images.getImagesRed());
	Dices diceWhite3 = new Dices(images.getImagesWhite());
	Dices diceYellow3 = new Dices(images.getImagesYellow());

	/**
	 * first Card Labels..
	 */
	@FXML
	private Label label_card_1 = new Label();
	@FXML
	private Label label_card_2;
	@FXML
	private Label label_card_3;
	@FXML
	private Label label_card_4;
	@FXML
	private Label label_card_5;
	@FXML
	private Label label_card_6;

	/**
	 * Dice Throw label..
	 */
	@FXML
	private Label label_Dice_1;
	@FXML
	private Label label_Dice_2;
	@FXML
	private Label label_Dice_3;
	@FXML
	private Label label_Dice_4;
	@FXML
	private Label label_Dice_5;
	@FXML
	private Label label_Dice_6;

	/**
	 * Label Choose AFTER throws..
	 */
	@FXML
	private Label Label_Choose_1;
	@FXML
	private Label Label_Choose_2;
	@FXML
	private Label Label_Choose_3;
	@FXML
	private Label Label_Choose_4;
	@FXML
	private Label Label_Choose_5;
	@FXML
	private Label Label_Choose_6;

	/**
	 * Score Label
	 */
	@FXML
	private Label scoreLabel;

	/**
	 * start, selection, rollDice, saving, loading, home,How To Play and Exit
	 * Buttons..
	 */
	@FXML
	private Button start;
	@FXML
	private Button selection = new Button();
	@FXML
	private Button rollDice = new Button();
	@FXML
	private Button finishRound = new Button();
	@FXML
	private Button saving = new Button();
	@FXML
	private Button loading = new Button();
	@FXML
	private Button home = new Button();
	@FXML
	private Button exit = new Button();

	/**
	 * Radio Buttons
	 */
	@FXML
	private RadioButton selection_1 = new RadioButton();
	@FXML
	private RadioButton selection_2 = new RadioButton();
	@FXML
	private RadioButton selection_3 = new RadioButton();
	@FXML
	private RadioButton selection_4 = new RadioButton();
	@FXML
	private RadioButton selection_5 = new RadioButton();
	@FXML
	private RadioButton selection_6 = new RadioButton();
	/**
	 * RadioButtons Array..
	 */
	RadioButton[] radioButtons = { selection_1, selection_2, selection_3, selection_4, selection_5, selection_6 };

	@FXML
	public void start() {

//		Stage primaryStage;
		rollDice.setDisable(false);
//		label1a.setText(Integer.toString(solutionStripe[0]));
		diceBlack2.setDiceFace(solutionStripe[0]);
		label_card_1.setGraphic(diceBlack2.getDiceFace());

//  label2a.setText(Integer.toString(solutionStripe[1]));
		diceWhite2.setDiceFace(solutionStripe[1]);
		label_card_2.setGraphic(diceWhite2.getDiceFace());

//  label3a.setText(Integer.toString(solutionStripe[2]));
		diceRed2.setDiceFace(solutionStripe[2]);
		label_card_3.setGraphic(diceRed2.getDiceFace());

//  label4a.setText(Integer.toString(solutionStripe[3]));
		diceGreen2.setDiceFace(solutionStripe[3]);
		label_card_4.setGraphic(diceGreen2.getDiceFace());

//  label5a.setText(Integer.toString(solutionStripe[4]));
		diceBlue2.setDiceFace(solutionStripe[4]);
		label_card_5.setGraphic(diceBlue2.getDiceFace());

//  label6a.setText(Integer.toString(solutionStripe[5]));
		diceYellow2.setDiceFace(solutionStripe[5]);
		label_card_6.setGraphic(diceYellow2.getDiceFace());
		start.setDisable(true);
//		 start(players, primaryStage, solutionStripe);
	}

	@FXML
	private void rollDice() {
		int counter = 0;

		finishRound.setDisable(true);
		selection.setDisable(false);
		selection_1.setDisable(true);
		selection_2.setDisable(true);
		selection_3.setDisable(true);
		selection_4.setDisable(true);
		selection_5.setDisable(true);
		selection_6.setDisable(true);

		stripe1.rollDice(emptyStripe, decisionStripe);

		diceBlack1.setDiceFace(emptyStripe[0]);
		label_Dice_1.setGraphic(diceBlack1.getDiceFace());

		diceWhite1.setDiceFace(emptyStripe[1]);
		label_Dice_2.setGraphic(diceWhite1.getDiceFace());

		diceRed1.setDiceFace(emptyStripe[2]);
		label_Dice_3.setGraphic(diceRed1.getDiceFace());

		diceGreen1.setDiceFace(emptyStripe[3]);
		label_Dice_4.setGraphic(diceGreen1.getDiceFace());

		diceBlue1.setDiceFace(emptyStripe[4]);
		label_Dice_5.setGraphic(diceBlue1.getDiceFace());

		diceYellow1.setDiceFace(emptyStripe[5]);
		label_Dice_6.setGraphic(diceYellow1.getDiceFace());

		if (emptyStripe[0] <= solutionStripe[0] && emptyStripe[0] != 0) {
			selection_1.setDisable(false);
			counter++;
		}
		if (emptyStripe[1] <= solutionStripe[1] && emptyStripe[1] != 0) {
			selection_2.setDisable(false);
			counter++;
		}
		if (emptyStripe[2] <= solutionStripe[2] && emptyStripe[2] != 0) {
			selection_3.setDisable(false);
			counter++;
		}
		if (emptyStripe[3] <= solutionStripe[3] && emptyStripe[3] != 0) {
			selection_4.setDisable(false);
			counter++;
		}
		if (emptyStripe[4] <= solutionStripe[4] && emptyStripe[4] != 0) {
			selection_5.setDisable(false);
			counter++;
		}
		if (emptyStripe[5] <= solutionStripe[5] && emptyStripe[5] != 0) {
			selection_6.setDisable(false);
			counter++;
		}
		rollDice.setDisable(true);

		if (counter < 1) {
			noValidDiceAlert();
			noValidDiceAlert();

			showScoreAlert(noValidDiceCalculation(solutionStripe, decisionStripe));
			player.addScore(noValidDiceCalculation(solutionStripe, decisionStripe));
			scoreLabel.setText(Integer.toString(player.getScore()));
			LoadGame2.counter++;
			if (LoadGame2.counter < 3) {
				if (LoadGame2.counter + 1 > LoadGame2.players.length) {
					LoadGame2.counter = 0;
					int[] stripe = newStripe();
					// rollDice();
					// startGame(LoadGame2.players[LoadGame2.counter], primaryStage, stripe);
				} else {
					// rollDice();
					// startGame(LoadGame2.players[LoadGame2.counter], primaryStage,
					// solutionStripe);
				}
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Fertig");
				alert.setHeaderText("Spiel Fertig");
				alert.showAndWait();
				Platform.exit();
			}
		}

	}

	@FXML
	private void selectedDice() {

	}

	@FXML
	private void selection_1() {
		if (selection_1.isSelected()) {
			finalStripe[0] = emptyStripe[0];
			diceBlack3.setDiceFace(emptyStripe[0]);
			Label_Choose_1.setGraphic(diceBlack3.getDiceFace());
			label_Dice_1.setGraphic(null);
			decisionStripe[0] = true;
		} else {
			diceBlack1.setDiceFace(emptyStripe[0]);
			label_Dice_1.setGraphic(diceBlack1.getDiceFace());
			Label_Choose_1.setGraphic(null);
			finalStripe[0] = 0;
			decisionStripe[0] = false;
		}
	}

	@FXML
	private void selection_2() {
		if (selection_2.isSelected()) {
			finalStripe[1] = emptyStripe[1];
			diceWhite3.setDiceFace(emptyStripe[1]);
			Label_Choose_2.setGraphic(diceWhite3.getDiceFace());
			label_Dice_2.setGraphic(null);
			decisionStripe[1] = true;
		} else {
			diceWhite1.setDiceFace(emptyStripe[1]);
			label_Dice_2.setGraphic(diceWhite1.getDiceFace());
			Label_Choose_2.setGraphic(null);
			finalStripe[1] = 0;
			decisionStripe[1] = false;
		}
	}

	@FXML
	private void selection_3() {
		if (selection_3.isSelected()) {
			finalStripe[2] = emptyStripe[2];
			diceRed3.setDiceFace(emptyStripe[2]);
			Label_Choose_3.setGraphic(diceRed3.getDiceFace());
			label_Dice_3.setGraphic(null);
			decisionStripe[2] = true;
		} else {
			diceRed1.setDiceFace(emptyStripe[0]);
			label_Dice_3.setGraphic(diceRed1.getDiceFace());
			Label_Choose_3.setGraphic(null);
			finalStripe[2] = 0;
			decisionStripe[2] = false;
		}
	}

	@FXML
	private void selection_4() {
		if (selection_4.isSelected()) {
			finalStripe[3] = emptyStripe[3];
			diceGreen3.setDiceFace(emptyStripe[3]);
			Label_Choose_4.setGraphic(diceGreen3.getDiceFace());
			label_Dice_4.setGraphic(null);
			decisionStripe[3] = true;
		} else {
			diceBlack3.setDiceFace(emptyStripe[3]);
			label_Dice_4.setGraphic(diceGreen1.getDiceFace());
			Label_Choose_4.setGraphic(null);
			finalStripe[3] = 0;
			decisionStripe[3] = false;
		}
	}

	@FXML
	private void selection_5() {
		if (selection_5.isSelected()) {
			finalStripe[4] = emptyStripe[4];
			diceBlue3.setDiceFace(emptyStripe[4]);
			Label_Choose_5.setGraphic(diceBlue3.getDiceFace());
			label_Dice_5.setGraphic(null);
			decisionStripe[4] = true;
		} else {
			diceBlack1.setDiceFace(emptyStripe[4]);
			label_Dice_5.setGraphic(diceBlue1.getDiceFace());
			Label_Choose_5.setGraphic(null);
			finalStripe[4] = 0;
			decisionStripe[4] = false;
		}
	}

	@FXML
	private void selection_6() {
		if (selection_6.isSelected()) {
			finalStripe[5] = emptyStripe[5];
			diceYellow3.setDiceFace(emptyStripe[5]);
			Label_Choose_6.setGraphic(diceYellow3.getDiceFace());
			label_Dice_6.setGraphic(null);
			decisionStripe[5] = true;
		} else {
			diceBlack1.setDiceFace(emptyStripe[5]);
			label_Dice_6.setGraphic(diceYellow1.getDiceFace());
			Label_Choose_6.setGraphic(null);
			finalStripe[5] = 0;
			decisionStripe[5] = false;
		}
	}

	@FXML
	private void finishRound() {
		player.addScore(regularCalculation(finalStripe));
		showScoreAlert(regularCalculation(finalStripe));
		scoreLabel.setText(Integer.toString(player.getScore()));
		LoadGame2.counter++;
		if (LoadGame2.counter + 1 > LoadGame2.players.length) {
			LoadGame2.counter = 0;
			int[] stripe = newStripe();

		}
	}
	// }

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

	private void noValidDiceAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Zug Ende");
		alert.setHeaderText("Keine Wuerfeln sind gueltig. Sie erhalten Punkte aller unbedeckten Felder");
		alert.showAndWait();
	}

	public int regularCalculation(int[] finalStripe) {
		int currentScore = 0;
		for (int i = 0; i < finalStripe.length; i++) {
			currentScore += finalStripe[i];
		}
		return currentScore;
	}

	public int noValidDiceCalculation(int[] solutionStripe, boolean[] decisionStripe) {
		int currentScore = 0;

		for (int i = 0; i < solutionStripe.length; i++) {
			if (decisionStripe[i] == false) {
				currentScore += solutionStripe[i];
			}
		}
		return currentScore;
	}

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

	private void playerInfo(Player player) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Spieler INFO");
		alert.setHeaderText("Spieler " + player.getName() + " ist an der Reihe");
		alert.setContentText("Aktueller Punktestand: " + Integer.toString(player.getScore()) + " ");
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

}
