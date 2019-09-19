package Banksystem.view.EBanking;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Contain the scene and panes of loginScreen of EBanking
 *
 */
public class LoginScreen extends VBox {

	private ControllerEBanking controller;
	protected TextField txtCustomerNumber;
	protected PasswordField txtPassword;
	
	public LoginScreen(ControllerEBanking controller) {
		this.controller = controller;
		this.setId("LoginScreen");

		GridPane pane = new GridPane();

		Label lAccountNumber = new Label("Benutzernummer");
		Label lPassword = new Label("Password");
		txtCustomerNumber = new TextField();
		txtPassword = new PasswordField();


			
		pane.add(lAccountNumber, 0, 0);
		pane.add(txtCustomerNumber, 1, 0, 2, 1);
		pane.add(lPassword, 0, 1);
		pane.add(txtPassword, 1, 1, 2, 1);

		Button bLogin = new Button("login");
		bLogin.setOnAction(event -> {
		
					controller.loginEBanking(txtCustomerNumber.getText(), txtPassword.getText());
					controller.nextScreen();
	
			
		});

		pane.add(bLogin, 1, 2);
		getChildren().addAll(pane);
	}

	protected String getTxtCustomerNumber() {
		return txtCustomerNumber.getText();
	}


}