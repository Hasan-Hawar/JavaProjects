package application;

import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class AddPersonSceneBiulder {
	public static Scene creatScene(ObservableList<Person> persons) {

		GridPane grid = new GridPane();
		grid.setHgap(25);
		grid.setVgap(25);
		grid.setPadding(new Insets(20));

		Label nameLabel = new Label("name");
		nameLabel.setMinWidth(Region.USE_PREF_SIZE);
		TextField nameText = new TextField();
		nameText.setId("name");
		grid.add(nameLabel, 0, 0);
		grid.add(nameText, 1, 0);

		Label firstnameLabel = new Label("First Name");
		firstnameLabel.setMinWidth(Region.USE_PREF_SIZE);
		TextField firstnameText = new TextField();
		firstnameText.setId("firstname");
		grid.add(firstnameLabel, 0, 1);
		grid.add(firstnameText, 1, 1);

		Label birthdateLabel = new Label("Birthdate");
		birthdateLabel.setMinWidth(Region.USE_PREF_SIZE);
		DatePicker birthdateDatePicker = new DatePicker();
		birthdateDatePicker.setId("birthdate");
		birthdateDatePicker.setMaxWidth(Double.POSITIVE_INFINITY);
		grid.add(birthdateLabel, 0, 2);
		grid.add(birthdateDatePicker, 1, 2);

		Label civilSattusLabel = new Label("Marital Sataus");
		civilSattusLabel.setMinWidth(Region.USE_PREF_SIZE);
		ChoiceBox<CivilStatus> cbCivilStatus = new ChoiceBox<>();
		cbCivilStatus.getItems().setAll(CivilStatus.values());
		cbCivilStatus.setId("civilstatus");
		grid.add(civilSattusLabel, 0, 3);
		grid.add(cbCivilStatus, 1, 3);

		Button saveButton = new Button("Save");
		saveButton.setOnAction(new SaveActionHandler(grid, persons));

		grid.add(saveButton, 1, 4);
		GridPane.setHalignment(saveButton, HPos.RIGHT);

		Scene scene = new Scene(grid);

		return scene;

	}

}
