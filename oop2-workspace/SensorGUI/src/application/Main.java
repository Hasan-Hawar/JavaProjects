package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	Stage windows;

	@Override
	public void start(Stage primaryStage) {

		windows = primaryStage;
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(25, 15, 15, 25));
		grid.setVgap(8);
		grid.setHgap(10);

		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(15);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(25);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setPercentWidth(50);
		grid.getColumnConstraints().addAll(col1, col2, col3);

		Label l1 = new Label("Type");
		Label l2 = new Label("Preis");
		Label l3 = new Label("Anzahl");
		Label l4 = new Label("Total Preis");
		Label l5 = new Label("");
		TextField t1 = new TextField();
		t1.setPromptText("Type of a Sensor");
		TextField t2 = new TextField();
		t2.setPromptText("enter the price");
		TextField t3 = new TextField();
		t3.setPromptText("the number of sensor");
		TextField t4 = new TextField();
		t4.setPromptText("please wait ..");

		Button b = new Button("Sensor Bestellen");
		Button r = new Button("Reset .. ");
		Button e = new Button("Exit");
		grid.setConstraints(l1, 0, 0);
		grid.setConstraints(t1, 1, 0);
		grid.setConstraints(l2, 0, 1);
		grid.setConstraints(t2, 1, 1);
		grid.setConstraints(l3, 0, 2);
		grid.setConstraints(t3, 1, 2);
		grid.setConstraints(l4, 0, 3);
		grid.setConstraints(t4, 1, 3);
		grid.setConstraints(l5, 2, 4);
		grid.setConstraints(b, 1, 6);
		grid.setConstraints(r, 2, 7);
		grid.setConstraints(e, 2, 8);
		// b.setAlignment(Pos.BASELINE_CENTER);

		b.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				try {
					double price = Double.parseDouble(t2.getText());
					int anzahl = Integer.parseInt(t3.getText());
					double priceForAll = anzahl * price;
					t4.textProperty().setValue(Double.toString(priceForAll));
					l5.textProperty().setValue("Gute Eingabe");
				} catch (NumberFormatException NumberException) {
					// TODO: handle exception
					l5.textProperty().setValue("Fehlerhafte Eingabe");
				}

			}
		});
		r.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				t1.textProperty().setValue("");
				t2.textProperty().setValue("");
				t3.textProperty().setValue("");
				t4.textProperty().setValue("");
			}
		});
		e.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});
		grid.getChildren().addAll(l1, t1, l2, t2, l3, t3, l4, t4, b, r, e, l5);
		Scene scene = new Scene(grid, 600, 400);
		windows.setScene(scene);
		windows.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
