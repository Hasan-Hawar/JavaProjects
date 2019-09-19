package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Person;

public final class PersonRegistryListSceneBuilder {
	public static Scene createScene() {
		BorderPane root = new BorderPane();
		root.setMinWidth(600);
		root.setPadding(new Insets(10));
		Insets insets = new Insets(10);
		Scene scene = new Scene(root);

		Label listViewLabel = new Label("Registered Persons:");
		root.setTop(listViewLabel);
		BorderPane.setMargin(listViewLabel, insets);

		ObservableList<Person> observablePersons = FXCollections.observableArrayList();
		ListView<Person> personListView = new ListView<>(observablePersons);
		root.setCenter(personListView);
		BorderPane.setMargin(personListView, insets);

		HBox buttonHBox = new HBox();
		buttonHBox.setAlignment(Pos.CENTER_RIGHT);
		buttonHBox.setSpacing(10);
		Button loadPersonButton = new Button("Load");
		loadPersonButton.setOnAction(new LoadActionHandler(observablePersons, scene));
		buttonHBox.getChildren().add(loadPersonButton);
		Button storePersonButton = new Button("Store");
		storePersonButton.setOnAction(new StoreActionHandler(observablePersons, scene));
		buttonHBox.getChildren().add(storePersonButton);
		Button addPersonButton = new Button("Add ...");
		addPersonButton.setOnAction(new AddActionHandler(observablePersons));
		buttonHBox.getChildren().add(addPersonButton);
		root.setBottom(buttonHBox);
		BorderPane.setMargin(buttonHBox, insets);

		return scene;
	}
}
