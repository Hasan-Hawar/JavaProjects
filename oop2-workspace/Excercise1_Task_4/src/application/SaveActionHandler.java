package application;

import java.time.LocalDate;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public final class SaveActionHandler implements EventHandler<ActionEvent> {

	private Pane pane;
	private List<Person> persons;

	public SaveActionHandler(Pane pane, List<Person> persons) {
		// TODO Auto-generated constructor stub
		this.pane = pane;
		this.persons = persons;

	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		TextField textField = (TextField) pane.lookup("#name");
		String name = textField.getText();
		if (isValidString(name, textField, "Enter a valid name"))
			return;

		textField = (TextField) pane.lookup("#firstname");
		String firstname = textField.getText();
		if (isValidString(firstname, textField, "Enter a valid first name"))
			return;

		DatePicker datePicker = (DatePicker) pane.lookup("#birthdate");
		LocalDate birthdate = datePicker.getValue();
		if (isValidBirthdate(birthdate, datePicker))
			return;

		ChoiceBox<CivilStatus> box = (ChoiceBox<CivilStatus>) pane.lookup("#civilstatus");
		CivilStatus civilStatus = box.getValue();
		if (isValidObject(civilStatus, box, "Enter a valid marital Status. "))
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
		alert.showAndWait();
		node.requestFocus();
	}

}
