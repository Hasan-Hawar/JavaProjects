package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AlertBuilder {
	public static Alert createErrorAlert(String title, String header, String message) {
		Alert alert = new Alert(AlertType.ERROR, message);
		alert.setTitle(title);
		alert.setHeaderText(header);
		((Stage)alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("Icon.jpg"));
		return alert;
	}
}
