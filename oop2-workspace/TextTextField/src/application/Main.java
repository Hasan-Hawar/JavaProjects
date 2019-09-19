package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		final int numTextFields = 20;
		TextField[] textFields = new TextField[numTextFields];
		VBox root = new VBox(5);
		for (int i = 1; i <= numTextFields; i++) {
			TextField tf = new TextField();
			String name = "Text field " + i;
			tf.setOnAction(e -> {
				System.out.println("Action on " + name + ": text is " + tf.getText());
			});
			root.getChildren().add(tf);
			textFields[i - 1] = tf;
		}
		Scene scene = new Scene(new ScrollPane(root), 250, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}