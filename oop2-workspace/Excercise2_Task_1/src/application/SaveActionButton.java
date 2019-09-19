package application;

import java.time.LocalDate;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class SaveActionButton implements EventHandler<ActionEvent> {

	private Pane pane;
	private List<Person> persons;

	public SaveActionButton(Pane pane, List<Person> persons) {

		this.pane = pane;
		this.persons = persons;
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

		TextField textField = (TextField) pane.lookup("#name");
		String name = textField.getText();
		if (isValidString(name, textField, "Enter a valid Name"))
			return;

		textField = (TextField) pane.lookup("#firstname");
		String firstname = textField.getText();
		if (isValidString(firstname, textField, "Enter a Valid First Name."))
			return;

		DatePicker date = (DatePicker) pane.lookup("#date");
		LocalDate birthdate = date.getValue();
		if (isValidDate(birthdate, date))
			return;

		ComboBox<CivilStatus> cbxStatus = (ComboBox<CivilStatus>) pane.lookup("#statusBox");
		CivilStatus civilStatus = cbxStatus.getValue();
		if (isValidObject(civilStatus, cbxStatus, "Enter a valid Marital Status"))
			return;

		Person person = new Person(firstname, name, birthdate, civilStatus);
		persons.add(person);
		pane.getScene().getWindow().hide();
	}

	public boolean isValidString(String string, Node node, String message) {
		if (string == null || string.isEmpty()) {
			showError(node, message);
			return true;
		}
		return false;
	}

	public boolean isValidDate(LocalDate birthdate, DatePicker date) {

		if (birthdate == null) {
			showError(date, "Enter a valid Date");
			return false;
		}
		if (birthdate.isAfter(LocalDate.now())) {
			showError(date, " Date can not be in Future");
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
		alert.setTitle("Validation Data");
		alert.setHeaderText("Invalid Data or Date");
		alert.showAndWait();
		node.requestFocus();
	}

}
