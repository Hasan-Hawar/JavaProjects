package Banksystem.view.ATM;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Contain the scene and panes of LoginScreen of ATM
 *
 */
public class LoginScreen extends VBox {

	private ControllerATM controller;
	protected TextField txtAccountNumber;
	protected PasswordField txtPassword;

	public LoginScreen(ControllerATM controller) {

		this.controller = controller;
		this.setId("LoginScreen");

		GridPane pane = new GridPane();

		Label lAccountNumber = new Label("Kontonummer");
		Label lPassword = new Label("Password");
		txtAccountNumber = new TextField();
		txtPassword = new PasswordField();

		Button bLogin = new Button("login");
		bLogin.setOnAction(event -> {
			controller.loginATM(txtAccountNumber.getText(), txtPassword.getText());
			controller.nextScreen();
		});

		pane.add(lAccountNumber, 0, 0);
		pane.add(txtAccountNumber, 1, 0, 2, 1);
		pane.add(lPassword, 0, 1);
		pane.add(txtPassword, 1, 1, 2, 1);

		pane.add(bLogin, 1, 2);
		getChildren().addAll(pane);
	}

	protected String getTxtAccountNumber() {
		return txtAccountNumber.getText();
	}

}