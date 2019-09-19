package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		Scene scene = PersonRegistryDataList.creatScene(null);
		primaryStage.setTitle("Person Registry");
		primaryStage.getIcons().add(new Image("/index.jpg"));
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {

		launch(args);

	}

}
