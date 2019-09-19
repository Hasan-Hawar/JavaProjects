package application;

import java.time.LocalDate;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.MaritalStatus;
import model.Person;

public final class SaveActionHandler implements EventHandler<ActionEvent> {
	private Pane pane;
	private ObservableList<Person> persons;

	public SaveActionHandler(Pane pane, ObservableList<Person> persons) {
		this.pane = pane;
		this.persons = persons;
	}

	@Override
	public void handle(ActionEvent event) {
		TextField textField = (TextField)pane.lookup("#name");
		String name = textField.getText();
		if (isInvalidString(name, textField, "Enter a valid name.")) return;
		
		textField = (TextField)pane.lookup("#firstname");
		String firstname = textField.getText();
		if (isInvalidString(firstname, textField, "Enter a valid first name.")) return;
		
		DatePicker datePicker = (DatePicker)pane.lookup("#birthdate");
		LocalDate birthdate = datePicker.getValue();
		if (isInvalidBirthdate(birthdate, datePicker)) return;
		
		ChoiceBox<MaritalStatus> choiceBox = (ChoiceBox<MaritalStatus>)pane.lookup("#maritalStatus");
		MaritalStatus maritalStatus = choiceBox.getValue();
		if (isInvalidObject(maritalStatus, choiceBox, "Enter a valid marital status.")) return;
		
		Person person = new Person(firstname, name, birthdate, maritalStatus);
		persons.add(person);
		pane.getScene().getWindow().hide();
	}
	
	private boolean isInvalidString(String string, Node node, String message) {
		if (string == null || string.isEmpty()) {
			showErrorAlert(node, message);
			return true;
		}
		return false;
	}
	
	private boolean isInvalidBirthdate(LocalDate birthdate, DatePicker datePicker) {
		if (birthdate == null) {
			showErrorAlert(datePicker, "Enter a valid birthdate.");
			return true;
		}
		if (birthdate.isAfter(LocalDate.now())) {
			showErrorAlert(datePicker, "Birthdate must not be in the future.");
			return true;
		}
		return false;
	}

	private boolean isInvalidObject(Object object, Node node, String message) {
		if (object == null) {
			showErrorAlert(node, message);
			return true;
		}
		return false;
	}

	private void showErrorAlert(Node node, String message) {
		Alert alert = AlertBuilder.createErrorAlert("Validation Error", "Invalid or missing data.", message);
		alert.showAndWait();
		node.requestFocus();
	}
}
