package game.players;

import java.io.IOException;

import game.Main;
import javafx.fxml.FXML;

public class TwoPlayersController {

	private Main main;

	@FXML
	public void showHomeScreen() throws IOException {
		main.showHomeScreen();
	}

}
