package game;

import java.io.IOException;

import game.view.MainGameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage primaryStage;
	private static BorderPane mainLayout;

	static Stage twoPlayersStage = new Stage();
	static Stage threePlayersStage = new Stage();
	static Stage fourPlayersStage = new Stage();
	static Stage fivePlayersStage = new Stage();
	static Stage sixPlayersStage = new Stage();
	static Stage startStage = new Stage();

	static MainGameController MGController;
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
		loader.setLocation(Main.class.getResource("view/MainGame.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void closeMainGame() {

	}

	public static void showHomeScreen() throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainGame.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		twoPlayersStage.close();
		threePlayersStage.close();
		fourPlayersStage.close();
		fivePlayersStage.close();
		sixPlayersStage.close();
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
		twoPlayersStage.showAndWait();

	}

	public static void showThreePlayer() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("players/ThreePlayers.fxml"));
		BorderPane three_Players = loader.load();
		threePlayersStage.setTitle("Three Players");
		// threePlayerStage.initModality(Modality.WINDOW_MODAL);
		// threePlayerStage.initOwner(primaryStage);
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

	public static void showSixPlayer() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("players/SixPlayers.fxml"));
		BorderPane six_Players = loader.load();
		sixPlayersStage.setTitle("Four Players");
		Scene scene = new Scene(six_Players);
		sixPlayersStage.setScene(scene);
		primaryStage.close();
		sixPlayersStage.showAndWait();

	}

	public static void startGame() throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("startGame/StartGame.fxml"));
		BorderPane start_Game = loader.load();
		startStage.setTitle("Choose Cards");
		Scene scene = new Scene(start_Game);
		startStage.setScene(scene);
		twoPlayersStage.close();
		threePlayersStage.close();
		fourPlayersStage.close();
		fivePlayersStage.close();
		sixPlayersStage.close();
		startStage.showAndWait();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
