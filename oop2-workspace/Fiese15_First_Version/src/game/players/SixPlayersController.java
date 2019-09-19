package game.players;

import java.io.IOException;

import game.Main;
import javafx.fxml.FXML;

public class SixPlayersController {

	private Main main;

	@FXML
	private void showHomeScreen() throws IOException {
		main.showHomeScreen();
	}

	@FXML
	private void startGame() throws IOException {
		main.startGame();
	}
}
