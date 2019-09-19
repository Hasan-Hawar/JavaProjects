package game.players;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertBuilder {
	public static Alert createErrorAlert(String title, String header, String message) {
		Alert alert = new Alert(AlertType.ERROR, message);
		alert.setTitle(title);
		alert.setHeaderText(header);
		return alert;
	}
}
