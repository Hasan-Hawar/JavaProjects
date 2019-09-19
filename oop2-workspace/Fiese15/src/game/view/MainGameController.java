package game.view;

import java.io.IOException;

import game.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainGameController {

	private Main main;

	@FXML
	public void showPlayersScreen() throws IOException {
		main.showTwoPlayer();
	}

	@FXML
	public Button closeButton;

	@FXML
	public void handleCloseButtonAction(ActionEvent event) {
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void closeMainGame() {
		main.closeMainGame();
	}

}
