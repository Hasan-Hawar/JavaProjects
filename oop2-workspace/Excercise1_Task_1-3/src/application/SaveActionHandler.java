package application;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public final class SaveActionHandler implements EventHandler<ActionEvent> {

	private Node root;

	public SaveActionHandler(Node root) {
		// TODO Auto-generated constructor stub
		this.root = root;
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		TextField textField = (TextField) root.lookup("#name");
		String name = textField.getText();
		if (isValidString(name, textField, "Enter a valid name"))
			return;

		textField = (TextField) root.lookup("#firstname");
		String firstname = textField.getText();
		if (isValidString(firstname, textField, "Enter a valid first name"))
			return;

		DatePicker datePicker = (DatePicker) root.lookup("#birthdate");
		LocalDate birthdate = datePicker.getValue();
		if (isValidBirthdate(birthdate, datePicker))
			return;

		ChoiceBox<CivilStatus> box = (ChoiceBox<CivilStatus>) root.lookup("#civilstatus");
		CivilStatus civilStatus = box.getValue();
		if (isValidObject(civilStatus, box, "Enter a valid marital Status. "))
			return;

		Person person = new Person(firstname, name, birthdate, civilStatus);

		System.out.println(person);

	}

	public boolean isValidString(String string, Node node, String message) {
		if (string == null || string.isEmpty()) {
			showError(node, message);
			return true;
		}
		return false;
	}

	public boolean isValidBirthdate(LocalDate birthdate, DatePicker datePicker) {
		if (birthdate == null) {
			showError(datePicker, "Enter a valid birthdate");
			return true;
		}
		if (birthdate.isAfter(LocalDate.now())) {
			showError(datePicker, "Birthdate must not be in Future");
			return true;
		}
		return false;
	}

	public boolean isValidObject(Object object, Node node, String message) {
		if (object == null) {
			showError(node, message);
			return true;
		}
		return false;
	}

	public void showError(Node node, String message) {
		Alert alert = new Alert(AlertType.ERROR, message);
		alert.setTitle("Validation Error");
		alert.setHeaderText("Invalide or missing Data");
		// ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new
		// Image("Icon.jpg"));
		alert.showAndWait();
		node.requestFocus();
	}

}
