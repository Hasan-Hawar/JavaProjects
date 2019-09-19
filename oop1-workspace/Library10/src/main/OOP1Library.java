package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import view.DetailsScreen;
import view.IntroScreen;
import view.LoginScreen;
import view.SearchScreen;
import view.TableScreen;

public class OOP1Library extends Application {
	private Pane[] panes;
	private int nr = 0;
	private final int numberOfScreens = 5;
	private Button button;
	//private Button button1;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void init() {
		panes = new Pane[numberOfScreens];
		panes[0] = new IntroScreen();
		panes[1] = new LoginScreen();
		panes[2] = new SearchScreen();
		panes[3] = new TableScreen();
		panes[4] = new DetailsScreen();
		

	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("OOP1 Library System");
		stage.setWidth(850);
		stage.setHeight(700);

		BorderPane root = new BorderPane();
		HBox box = new HBox();
		box.setMaxWidth(600);
		box.getChildren().add(panes[0]);
		button = new Button("Next");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				showNextPane(box);
			}
		});
		root.setCenter(box);
		
		
		BorderPane.setAlignment(box, Pos.CENTER);
		root.setBottom(button);
		BorderPane.setAlignment(button, Pos.BASELINE_CENTER);

		
		Scene scene = new Scene(root);
		scene.getStylesheets().add("res/style.css");
		stage.setScene(scene);
		stage.show();
	}

	private void showNextPane(HBox box) {
		box.getChildren().remove(panes[nr]);
		nr = ++nr % numberOfScreens;
		if (nr == 0) {
			box.setMaxWidth(600);
			button.setText("Next");
		}
		if (nr == 1) {
			box.setMaxWidth(800);
			button.setText("Login");
		}
		if (nr == 2) {
			button.setText("Search");
		}
		if (nr == 3) {
			button.setText("Details");
		}
		if (nr == 4) {
			button.setText("Home");
		}
		box.getChildren().add(panes[nr]);
	}
		/*private void showBackPane(HBox box1) {
		box1.getChildren().remove(panes[nr]);
		nr = --nr % numberOfScreens;
		if (nr == 4) {
			box1.setMaxWidth(600);
			button1.setText("Back");
		}
		if (nr == 3) {
			box1.setMaxWidth(800);
			button1.setText("Back");
		}
		if (nr == 2) {
			button1.setText("Back");
		}
		if (nr == 1) {
			button1.setText("Back");
		}
		if (nr == 0) {
			button1.setText("Back");
		}
		box1.getChildren().add(panes[nr]);
	}*/
}
