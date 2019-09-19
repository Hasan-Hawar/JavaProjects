package game.view;

import java.io.IOException;

import game.Main;
import game.players.FivePlayersController;
import game.players.FourPlayersController;
import game.players.SixPlayersController;
import game.players.ThreePlayersController;
import game.players.TwoPlayersController;
import game.players.onePlayersController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainGameController2 {

	Main main;
	private static SixPlayersController controller = null;
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/players/SixPlayers.fxml"));

	@FXML
	public TextField playersNumField = new TextField();

	@FXML
	Button one = new Button();
	@FXML
	Button two = new Button();
	@FXML
	Button three = new Button();
	@FXML
	Button four = new Button();
	@FXML
	Button five = new Button();
	@FXML
	Button six = new Button();

	@FXML
	public Button start = new Button();
	@FXML
	public Button Load = new Button();

	@FXML
	public Button closeButton = new Button();
	@FXML
	public Button howToPlay = new Button();

	@FXML
	public void showTextGameStage(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("players/SixPlayers.fxml"));
		BorderPane six_Players = loader.load();
		loader.<SixPlayersController>getController();
		((Button) e.getSource()).getScene().setRoot(six_Players);
	}

	@FXML
	private void showOnePlayer(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("players/OnePlayers.fxml"));
		BorderPane one_Players = loader.load();
		loader.<onePlayersController>getController();
		((Button) e.getSource()).getScene().setRoot(one_Players);
	}

	@FXML
	private void showTwoPlayers(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("players/TwoPlayers.fxml"));
		BorderPane two_Players = loader.load();
		loader.<TwoPlayersController>getController();
		((Button) e.getSource()).getScene().setRoot(two_Players);
	}

	@FXML
	private void showThreePlayers(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("players/ThreePlayers.fxml"));
		BorderPane three_Players = loader.load();
		loader.<ThreePlayersController>getController();
		((Button) e.getSource()).getScene().setRoot(three_Players);
	}

	@FXML
	private void showFourPlayers(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("players/FourPlayers.fxml"));
		BorderPane four_Players = loader.load();
		loader.<FourPlayersController>getController();
		((Button) e.getSource()).getScene().setRoot(four_Players);
	}

	@FXML
	private void showFivePlayers(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("players/FivePlayers.fxml"));
		BorderPane five_Players = loader.load();
		loader.<FivePlayersController>getController();
		((Button) e.getSource()).getScene().setRoot(five_Players);
	}

	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

}
