package application;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import model.MaritalStatus;
import model.Person;

public final class AddPersonSceneBuilder {

	public static Scene createScene(ObservableList<Person> persons) {
		GridPane root = new GridPane();
		root.setHgap(20);
		root.setVgap(20);
		root.setPadding(new Insets(20));
		
		Label nameLabel = new Label("Name");
		nameLabel.setMinWidth(Region.USE_PREF_SIZE);
		TextField  nameTextField  = new TextField();
		nameTextField.setId("name");
		root.add(nameLabel, 0,  0);
		root.add(nameTextField, 1,  0);
		
		Label firstnameLabel = new Label("First name");
		firstnameLabel.setMinWidth(Region.USE_PREF_SIZE);
		TextField  firstnameTextField  = new TextField();
		firstnameTextField.setId("firstname");
		root.add(firstnameLabel, 0,  1);
		root.add(firstnameTextField, 1,  1);
		
		Label birthdateLabel = new Label("Date of birth");
		birthdateLabel.setMinWidth(Region.USE_PREF_SIZE);
		DatePicker birthdateDatePicker = new DatePicker();
		birthdateDatePicker.setId("birthdate");
		birthdateDatePicker.setMaxWidth(Double.POSITIVE_INFINITY);
		root.add(birthdateLabel, 0,  2);
		root.add(birthdateDatePicker, 1,  2);
		
		Label maritalStatusLabel = new Label("Marital status");
		maritalStatusLabel.setMinWidth(Region.USE_PREF_SIZE);
		ChoiceBox<MaritalStatus>  maritalStatusChoiceBox  = new ChoiceBox<>();
		maritalStatusChoiceBox.getItems().setAll(MaritalStatus.values());
		maritalStatusChoiceBox.setId("maritalStatus");
		maritalStatusChoiceBox.setMaxWidth(Double.POSITIVE_INFINITY);
		root.add(maritalStatusLabel, 0,  3);
		root.add(maritalStatusChoiceBox, 1,  3);
		
		HBox buttonHBox = new HBox();
		buttonHBox.setAlignment(Pos.CENTER_RIGHT);
		buttonHBox.setSpacing(10);
		Button saveButton = new Button("Save");
		saveButton.setOnAction(new SaveActionHandler(root, persons));
		saveButton.setDefaultButton(true);
		buttonHBox.getChildren().add(saveButton);
		Button cancelButton = new Button("Cancel");
		cancelButton.setOnAction(new CancelActionHandler(root));
		buttonHBox.getChildren().add(cancelButton);
		root.add(buttonHBox, 1, 4);
		
		Scene scene = new Scene(root);
		return scene;
	}

}
