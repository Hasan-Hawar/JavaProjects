package game.players;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import logic.game.Player;
import persistence.PersistenceException;
import persistence.PlayerDAO;
import persistence.textFIle.TextFilePlayer;

public class FourPlayersController {

	private Main main;
	private List<Player> players = new ArrayList<>();
	@FXML
	private TextField Player1;
	@FXML
	private TextField Player2;
	@FXML
	private TextField Player3;
	@FXML
	private TextField Player4;

	@FXML
	public Button start;
	@FXML
	public Button save;
	@FXML
	public Button home;

	@FXML
	private void showHomeScreen() throws IOException {
		main.showHomeScreen();
	}

	@FXML
	private void startGame(ActionEvent e) throws IOException {
		main.startGame(e);
	}

	@FXML
	private void goAndGenerate() throws IOException {
		main.showChooseCard();
	}

	@FXML
	private void saveAction(ActionEvent event) throws PersistenceException {

		BorderPane root = new BorderPane();
		root.setMinWidth(600);
		root.setPadding(new Insets(10));
		// Insets insets = new Insets(10);
		Scene scene = new Scene(root);

		// players.add(new Player(secondPlayer.getText()));
		Player player1 = new Player(Player1.getText());
		Player player2 = new Player(Player2.getText());
		Player player3 = new Player(Player2.getText());
		Player player4 = new Player(Player2.getText());
		players.add(player1);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Store Game state");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("Text files", "*.txt"));
		File selectedFile = fileChooser.showSaveDialog(scene.getWindow());
		if (selectedFile != null) {
			PlayerDAO dao = new TextFilePlayer(selectedFile);
			try {
				dao.savePlayer(players);
			} catch (Exception e) {
				Alert alert = AlertBuilder.createErrorAlert("Store error", "Cannot store to file", "Check file path");
			}
		}

		System.out.println(players);
	}
}
