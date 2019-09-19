package game;

import java.io.IOException;

import game.players.SixPlayersController;
import game.view.MainGameController2;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.game.Alpha;
import logic.game.Player;
import persistence.PersistenceException;
import persistence.PlayerDAO;

public class Main extends Application {

	private static Stage primaryStage;
	private static BorderPane mainLayout;
	private PlayerDAO dao;
	private ObservableList<Player> players;

//	@Override
//	public void stop() {
//		dao.savePlayer(new ArrayList<Player>(players));
//	}

	// private static TwoPlayersController twoPlayers;
	// private static StartGameController gameController = new
	// StartGameController();
	// private static FirstCard firstCardClass = new FirstCard();

	static Stage twoPlayersStage = new Stage();
	static Stage threePlayersStage = new Stage();
	static Stage fourPlayersStage = new Stage();
	static Stage fivePlayersStage = new Stage();
	static Stage sixPlayersStage = new Stage();
	static Stage startStage = new Stage();
	static Stage firstCard = new Stage();
	static Stage listViewStage = new Stage();
	static Stage testStage = new Stage();
	static Stage loadGameStage = new Stage();
	static Stage loadGameStage2 = new Stage();

	static MainGameController2 MGController;
	static BorderPane home;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Fiese15");

		showMainGame();
		// showTwoPlayer();
	}

	public void showMainGame() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainGame2.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void showHomeScreen() throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainGame2.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		twoPlayersStage.close();
		threePlayersStage.close();
		fourPlayersStage.close();
		fivePlayersStage.close();
		sixPlayersStage.close();
		startStage.close();
		listViewStage.close();
		loadGameStage.close();
		primaryStage.show();
	}

	public static void showTwoPlayer() throws IOException, IllegalStateException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("players/TwoPlayers.fxml"));
		BorderPane two_Players = loader.load();
		twoPlayersStage.setTitle("Two Players");
		// twoPlayerStage.initModality(Modality.WINDOW_MODAL);
		// twoPlayersStage.initOwner(primaryStage);
		Scene scene = new Scene(two_Players);
		twoPlayersStage.setScene(scene);
		primaryStage.close();
		twoPlayersStage.show();

	}

	public static void showThreePlayer() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("players/ThreePlayers.fxml"));
		BorderPane three_Players = loader.load();
		threePlayersStage.setTitle("Three Players");
		Scene scene = new Scene(three_Players);
		threePlayersStage.setScene(scene);
		primaryStage.close();
		threePlayersStage.showAndWait();

	}

	public static void showFourPlayer() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("players/FourPlayers.fxml"));
		BorderPane four_Players = loader.load();
		fourPlayersStage.setTitle("Four Players");
		// fourPlayerStage.initModality(Modality.WINDOW_MODAL);
		// fourPlayerStage.initOwner(primaryStage);
		Scene scene = new Scene(four_Players);
		fourPlayersStage.setScene(scene);
		primaryStage.close();
		fourPlayersStage.showAndWait();

	}

	public static void showFivePlayer() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("players/FivePlayers.fxml"));
		BorderPane five_Players = loader.load();
		fivePlayersStage.setTitle("Four Players");
		Scene scene = new Scene(five_Players);
		fivePlayersStage.setScene(scene);
		primaryStage.close();
		fivePlayersStage.showAndWait();

	}

	public void showSixPlayer(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("players/SixPlayers.fxml"));
		// loader.setLocation(Main.class.getResource(""));
		BorderPane six_Players = loader.load();
		loader.<SixPlayersController>getController();
		((Button) e.getSource()).getScene().setRoot(six_Players);

//		FXMLLoader loader = new FXMLLoader(getClass().getResource("players/SixPlayers.fxml"));
//		// loader.setLocation(Main.class.getResource(""));
//		BorderPane six_Players = loader.load();
//
//		sixPlayersStage.setTitle("Players");
//		Scene scene = new Scene(six_Players);
//		sixPlayersStage.setScene(scene);
//		primaryStage.close();
//		sixPlayersStage.show();
		// SixPlayersController controller = new SixPlayersController();
		// controller.text_1.setVisible(false);

//		MainGameController2 controller2 = loader.getController();
//		controller2.showTextGameStage();

	}

	public static void startGame(ActionEvent e) throws IOException {

//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(Main.class.getResource("view/LoadGame2.fxml"));
//		BorderPane start_Game = loader.load();
//		loadGameStage2.setTitle("Choose Cards");
//		loader.<LoadGame2>getController();
//		((Button) e.getSource()).getScene().setRoot(start_Game);
		Alpha alpha = new Alpha();
		alpha.start(primaryStage);

	}

	public static void loadPlayerList() throws IOException, PersistenceException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("players/ListViewPlayers.fxml"));
		BorderPane listViewPlayers = loader.load();
		listViewStage.setTitle("Player List");
		Scene scene = new Scene(listViewPlayers);
		listViewStage.setScene(scene);
		listViewStage.initModality(Modality.WINDOW_MODAL);
		listViewStage.showAndWait();
//		ObservableList<Player> playersList = FXCollections.observableArrayList();
//		ListView<Player> players = new ListView<>(playersList);
//		FileChooser fileChooser = new FileChooser();
//		fileChooser.setTitle("Load Game state Data");
//		fileChooser.getExtensionFilters().add(new ExtensionFilter("text file", "*.txt"));
//		File selectedFile = fileChooser.showOpenDialog(scene.getWindow());
//		if (selectedFile != null) {
//			PlayerDAO dao = new TextFilePlayer(selectedFile);
//			playersList.clear();
//			try {
//				playersList.addAll(dao.loadPlayers());
//			} catch (TextFileParseException e) {
//				String filePath = e.getFilePath();
//				int lineNb = e.getLineNb();
//				String line = e.getLine();
//				String message = "Check Line" + lineNb + " in file " + filePath + " :\n" + line;
//				Alert alert = AlertBuilder.createErrorAlert("Load error", "Cannot parse data", message);
//				alert.showAndWait();
//
//				// TODO: handle exception
//			} catch (PersistenceException e) {
//				Alert alert = AlertBuilder.createErrorAlert("Load error", "Cannot load from file", "Check file path");
//				alert.showAndWait();
//			}
//		}
	}

	public static void closeTwoPlayers() {
		twoPlayersStage.hide();
	}

	public static void closeThreePlayers() {
		threePlayersStage.hide();
	}

	public static void showChooseCard() throws IOException {

//		if (StartGameController.r1.isSelected()) {
//
//			String l1 = gameController.H1L1.textProperty().getValue();
//			String l2 = gameController.H1L2.getText();
//			String l3 = gameController.H1L3.getText();
//			String l4 = gameController.H1L4.getText();
//			String l5 = gameController.H1L5.getText();
//			String l6 = gameController.H1L6.getText();
//			firstCardClass.setText(l1, l2, l3, l4, l5, l6);
//			// firstCardClass.l1.textProperty().setValue(l1);
//
//		}

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("startGame/FirstCard.fxml"));
		BorderPane first_Card = loader.load();
		startStage.setTitle("Choose Cards");
		Scene scene = new Scene(first_Card);
		firstCard.setScene(scene);
		// startStage.close();
		twoPlayersStage.close();
		threePlayersStage.close();
		fourPlayersStage.close();
		fivePlayersStage.close();
		sixPlayersStage.close();
		firstCard.showAndWait();
//		Random diceValue = new Random();
//		int validValue = diceValue.nextInt(6) + 1;
//		String l1 = Integer.toString(validValue);
//		firstCardClass.l1.textProperty().isEqualTo(l1);
//		System.out.println(l1);

		// firstCardClass.l1.textProperty().setValue(l1);

	}

//	public static void generateNumber() {
//		Random diceValue = new Random();
//		int validValue = diceValue.nextInt(6) + 1;
//		String l1 = Integer.toString(validValue);
//		firstCardClass.v1_l1.setText(l1);
//	}

	public static void main(String[] args) {
		launch(args);
	}

}
