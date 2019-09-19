package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		ObservableList<Person> persons = FXCollections.observableArrayList();
		Scene scene = PersonRegistryListSceneBuilder.creatScene(persons);
		primaryStage.getIcons().add(new Image("/Icon.jpg"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
