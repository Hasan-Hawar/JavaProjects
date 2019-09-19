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
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import logic.game.Player;
import persistence.PersistenceException;
import persistence.PlayerDAO;
import persistence.textFIle.TextFilePlayer;

public class onePlayersController {

	private Main main;
	// private TextFilePlayer textFilePlayer = new TextFilePlayer("playerList.txt");

	@FXML
	public Button start;
	@FXML
	private Button save;
	@FXML
	private Button load;
	@FXML
	public Button home;

	@FXML
	public TextField player1 = new TextField();

	@FXML
	private VBox vBox;
	@FXML
	private BorderPane pane;

//	private String path;
	private List<Player> players = new ArrayList<>();
//	private Player player;
//	private Scene scene;

//	@FXML
//	private void saveAction(List<Player> players) {
//		this.players = players;
//	}

	@FXML
	public void showHomeScreen() throws IOException {
		Main.showHomeScreen();
	}

	@FXML
	private void showList() throws IOException, PersistenceException {
		Main.loadPlayerList();
	}

	@FXML
	public void startGame(ActionEvent e) throws IOException {
		Main.startGame(e);
		Player player = new Player(player1.getText());

	}

	@FXML
	private void goAndGenerate() throws IOException {
		Main.showChooseCard();
	}

	@FXML
	private void saveAction(ActionEvent event) throws PersistenceException {

		BorderPane root = new BorderPane();
		root.setMinWidth(600);
		root.setPadding(new Insets(10));
		// Insets insets = new Insets(10);
		Scene scene = new Scene(root);

		// players.add(new Player(secondPlayer.getText()));
		Player Nplayer1 = new Player(player1.getText());

		players.add(Nplayer1);

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
		// textFilePlayer.savePlayer(players);
	}

}