package game.players;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import game.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import logic.game.Player;
import persistence.PersistenceException;
import persistence.PlayerDAO;
import persistence.textFIle.TextFileParseException;
import persistence.textFIle.TextFilePlayer;

public class ListViewController implements Initializable, EventHandler<ActionEvent> {

//	private Main main;
//	private TwoPlayersController twoPlayers;
//	private FirstCard card;

//	private void showList() throws IOException {
//		main.loadPlayerList();
//	}

	@FXML
	public void showHomeScreen() throws IOException {
		Main.showHomeScreen();
	}

	ObservableList<Player> playersList = FXCollections.observableArrayList();

	@FXML
	private ListView<Player> players = new ListView<>(playersList);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			loadData();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// int score = Integer.parseInt(card.scoreField.textProperty().getValue());

	public void loadData() throws PersistenceException {
		// score = 0;
		BorderPane root = new BorderPane();
		root.setMinWidth(600);
		root.setPadding(new Insets(10));
		Scene scene = new Scene(root);

		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Load Game state Data");
		fileChooser.getExtensionFilters().add(new ExtensionFilter("text file", "*.txt"));
		File selectedFile = fileChooser.showOpenDialog(scene.getWindow());
		if (selectedFile != null) {
			PlayerDAO dao = new TextFilePlayer(selectedFile);
			// playersList.clear();
			try {
				playersList.addAll(dao.loadPlayers());
			} catch (TextFileParseException e) {
				String filePath = e.getFilePath();
				int lineNb = e.getLineNb();
				String line = e.getLine();
				String message = "Check Line" + lineNb + " in file " + filePath + " :\n" + line;
				Alert alert = AlertBuilder.createErrorAlert("Load error", "Cannot parse data", message);
				alert.showAndWait();

				// TODO: handle exception
			} catch (PersistenceException e) {
				Alert alert = AlertBuilder.createErrorAlert("Load error", "Cannot load from file", "Check file path");
				alert.showAndWait();
			}
		}

//		Player p = new Player(twoPlayers.firstPlayer.getText());
//		Player p1 = new Player("Kausi");
//		list.addAll(p);
//
//		players.getItems().addAll(list);
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}

}
