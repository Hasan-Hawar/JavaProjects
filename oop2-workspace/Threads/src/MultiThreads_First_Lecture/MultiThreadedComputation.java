package MultiThreads_First_Lecture;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultiThreadedComputation extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Slow Computation - MultiThreaded");
		final StackPane stack = new StackPane();
		Scene scene = new Scene(stack, 400, 200);
		VBox box = new VBox();
		box.setSpacing(10);
		box.setPadding(new Insets(0, 20, 10, 20));

		Button button = new Button("Slow");
		Label res = new Label();
		button.setOnAction((ActionEvent event) -> {
			new Thread(() -> {
				try {
					Thread.sleep(10000); // pause 4 seconds
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Platform.runLater(() -> {
					res.setText("Slow Computation!"); // THREAD-SAFE!
				});
			}).start();
		});

		Button button2 = new Button("Fast");
		Label res2 = new Label();
		button2.setOnAction((ActionEvent event) -> {
			new Thread(() -> {
				Platform.runLater(() -> {
					res2.setText("Fast Computation!"); // THREAD-SAFE!
				});
			}).start();
		});

		box.getChildren().addAll(button, res, button2, res2);
		stack.getChildren().add(box);

		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
