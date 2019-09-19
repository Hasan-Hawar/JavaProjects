package application;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class PersonRegistryData {

	public static Scene creatScene(ObservableList<Person> persons) {

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(25));
		grid.setVgap(25);
		grid.setHgap(25);

		Label nameLable = new Label("Name");
		nameLable.setMinWidth(Region.USE_PREF_SIZE);
		TextField nameText = new TextField();
		nameText.setPromptText("Type your last name");
		nameText.setId("name");
		grid.add(nameLable, 0, 0);
		grid.add(nameText, 1, 0);

		Label firstnameLable = new Label("First Name");
		firstnameLable.setMinWidth(Region.USE_PREF_SIZE);
		TextField firstnmaeText = new TextField();
		firstnmaeText.setId("firstname");
		firstnmaeText.setPromptText("Type your first Name");
		grid.add(firstnameLable, 0, 1);
		grid.add(firstnmaeText, 1, 1);

		Label datePickerLable = new Label("Date of Birth");
		datePickerLable.setMinWidth(Region.USE_PREF_SIZE);
		DatePicker datePicker = new DatePicker();
		datePicker.setPromptText("Enter your Birthdate");
		datePicker.setId("date");
		grid.add(datePickerLable, 0, 2);
		grid.add(datePicker, 1, 2);

		Label statusLable = new Label("Material status");
		statusLable.setMinWidth(Region.USE_PREF_SIZE);
		ComboBox<CivilStatus> cbxStatus = new ComboBox<>();
		cbxStatus.setId("statusBox");
		cbxStatus.getItems().addAll(CivilStatus.values());
		cbxStatus.setValue(CivilStatus.Single);
		cbxStatus.setMaxWidth(Double.POSITIVE_INFINITY);
		grid.add(statusLable, 0, 3);
		grid.add(cbxStatus, 1, 3);

		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER_RIGHT);
		hbox.setSpacing(10);

		// ====================== // ==== SaveButto handler ==== \\ ==================\\

		Button saveButton = new Button("Save");
		// GridPane.setHalignment(saveButton, HPos.RIGHT);
		saveButton.setOnAction(new SaveActionButton(grid, persons));
		saveButton.isDefaultButton();
		hbox.getChildren().add(saveButton);

		// ====================== // ==== CancelButton handler ==== \\ ==================\\

		Button cancelButton = new Button("Cancel");
		hbox.getChildren().add(cancelButton);
		cancelButton.setOnAction(new CancelButtonAction(grid));

		grid.add(hbox, 1, 4);
		Scene scene = new Scene(grid);

		return scene;

	}

}
