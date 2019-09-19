package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class LoginScreen extends Pane {

	public LoginScreen() {
		this.setId("loginScreen");

		// Pane durch sinnvollen Container ersetzen und mit Inhalt füllen.
		// . . .
		ImageView image = new ImageView(new Image(getClass().getClassLoader().getResourceAsStream("res/img.jpg")));
		image.setFitWidth(270);
		image.setFitHeight(120);
		image.setPreserveRatio(false);
		image.setX(420);
		image.setY(80);
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(220, 15, 15, 90));
		grid.setVgap(5);
		grid.setHgap(5);
		
	     ColumnConstraints col1 = new ColumnConstraints();
	     col1.setPercentWidth(15);
	     ColumnConstraints col2 = new ColumnConstraints();
	     col2.setPercentWidth(25);
	     ColumnConstraints col3 = new ColumnConstraints();
	     col3.setPercentWidth(50);
	     grid.getColumnConstraints().addAll(col1,col2,col3);
	 

		
		Label lb1 = new Label("First Name");
		Label lb2 = new Label("Last Name");
		Label lb3 = new Label("E-Mail");
		Label lb4 = new Label("Password");
		Label lb5 = new Label("");
		

		TextField tF1 = new TextField();
		tF1.setPromptText("Your first name");
		TextField tF2 = new TextField();
		tF2.setPromptText("Your last name");
		TextField tF3 = new TextField();
		tF3.setPromptText("Your Email");
		PasswordField pw = new PasswordField();
		pw.setPromptText("Your password");
		Button B = new Button("Login");
		grid.add(image, 0, 0);
		grid.add(lb1, 0, 1);  grid.add(tF1, 1, 1);
		grid.add(lb2, 0, 2); grid.add(tF2, 1, 2);
		grid.add(lb3, 0, 3);    grid.add(tF3, 1, 3);
		grid.add(lb4, 0, 4); grid.add(pw, 1, 4);
		grid.add(lb5, 0, 5);
		B.setAlignment(Pos.BASELINE_CENTER);
		
		B.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e) {
				if(!pw.getText().equals(tF3.getText())) {
				lb5.setText("Password is not correct");
				lb5.setTextFill(Color.RED);
				}
				else {
					lb5.setText("Password is correct");
					lb5.setTextFill(Color.DARKSEAGREEN);
				}
				pw.clear();
			}
		});
		
		
		getChildren().addAll(image,grid);

	}
}
