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
	public void showTwoPlayersScreen() throws IOException {
		main.showTwoPlayer();
	}

	@FXML
	public void showThreePlayersScreen() throws IOException {
		main.showThreePlayer();
	}

	@FXML
	public void showFourPlayersScreen() throws IOException {

		main.showFourPlayer();
	}

	@FXML
	public void showFivePlayersScreen() throws IOException {
		main.showFivePlayer();
	}

	@FXML
	public void showSixPlayersScreen() throws IOException {
		main.showSixPlayer();
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
