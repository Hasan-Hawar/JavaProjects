package employee.view;

import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class AddNewEmployeeController {

	ObservableList<String> maritalStatusList = FXCollections.observableArrayList("Single", "Married", "Divorced");
	ObservableList<String> mainDepartmentList = FXCollections.observableArrayList("Electrical", "Mechanical");
	ObservableList<String> electricalList = FXCollections.observableArrayList("Design", "R&D");
	ObservableList<String> mechanicalList = FXCollections.observableArrayList("Sales", "Managment");
	// Contact information

	@FXML
	private TextField name;
	@FXML
	private TextField adress;
	@FXML
	private TextField city;
	@FXML
	private TextField phone;
	@FXML
	private TextField email;

	// Personal Informatin

	@FXML
	private DatePicker dateofBirth;
	@FXML
	private TextField ageField;
	@FXML
	private ChoiceBox<String> maritalStatus;
	@FXML
	private RadioButton maleButton;
	@FXML
	private RadioButton femaleButton;

	// Employee Informations

	@FXML
	private TextField idField;
	@FXML
	private ComboBox mainDepartment;
	@FXML
	private ComboBox departmentBox;
	@FXML
	private CheckBox yesBox;
	@FXML
	private CheckBox noBox;

	@FXML
	private void initialize() {
		maritalStatus.setValue("Single");
		maritalStatus.setItems(maritalStatusList);

		mainDepartment.setValue("Electrical");
		mainDepartment.setItems(mainDepartmentList);

		departmentBox.setValue("Design");
		departmentBox.setItems(electricalList);

	}

	@FXML
	private void showAge() {

		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int birthYear = (dateofBirth.getValue().getYear());
		int age = year - birthYear;
		ageField.setText(Integer.toString(age) + " Years ");
	}

	@FXML
	private void mainDepartmentChoice() {
		if (mainDepartment.getValue().equals("Electrical")) {
			departmentBox.setItems(electricalList);
		} else {
			departmentBox.setItems(mechanicalList);
		}
	}

	@FXML
	private void handleYesBox() {
		if (yesBox.isSelected()) {
			noBox.setSelected(false);
		}
	}

	@FXML
	private void handleNoBox() {
		if (noBox.isSelected()) {
			yesBox.setSelected(false);
		}
	}

}
