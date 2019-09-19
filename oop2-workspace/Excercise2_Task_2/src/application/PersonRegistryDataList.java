package application;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class PersonRegistryDataList {

	public static Scene creatScene(ObservableList<Person> persons) {

		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));
		Insets insets = new Insets(10);
		root.setMinWidth(650);

		Label registeryLabel = new Label("Person Registry");
		root.setTop(registeryLabel);
		BorderPane.setMargin(registeryLabel, insets);

		ListView<Person> list = new ListView<>(persons);
		root.setCenter(list);
		BorderPane.setMargin(list, insets);

		HBox hBox = new HBox();
		root.setBottom(hBox);

		Button addPersonButton = new Button("Add Persons .. ");
		addPersonButton.setOnAction(new AddPersonToTheList(persons));
		hBox.getChildren().add(addPersonButton);
		HBox.setMargin(addPersonButton, insets);

		Button exitButton = new Button("Exit");
		exitButton.setOnAction(new CancelButtonAction(root));
		hBox.getChildren().add(exitButton);
		HBox.setMargin(exitButton, insets);

		BorderPane.setAlignment(hBox, Pos.BOTTOM_CENTER);
		hBox.setAlignment(Pos.BOTTOM_RIGHT);

		Scene scene = new Scene(root);
		return scene;

	}
}
