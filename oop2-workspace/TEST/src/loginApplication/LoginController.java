package loginApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

	@FXML
	private TextField email_textfield;

	@FXML
	private PasswordField password_textfield;

	@FXML
	private Label error_lab;

	@FXML
	public void signupButton(ActionEvent event) {
		openWindow();
	}

	@FXML
	public void loginButton(ActionEvent event) throws IOException {

		// Path to text file
		Path path = Paths.get("TextFiles/data.txt");

		// Counts number of line in text file
		long count = Files.lines(path).count();

		/// read each line
		for (int i = 0; i < count; i++) {
			String line = Files.readAllLines(path).get(i);
			if (!line.trim().equals("")) {

				// According to format Name, Email, Password, Age, Gender
				String[] profile = line.split(",");

				String name = profile[0];
				String email = profile[1];
				String password = profile[2];
				String age = profile[3];
				String gender = profile[4];
				String contact = profile[5];

				// Email Matched!
				if (email.trim().equals(email_textfield.getText())) { // Note trim() method remove space from front and
																		// behind of string if there is any
																		// Now checking if password match
					if (password.trim().equals(password_textfield.getText())) {

						Alert msg = new Alert(AlertType.CONFIRMATION);
						msg.setTitle(email_textfield.getText());
						msg.setContentText("Email and password matched");
						msg.showAndWait();

						// Store values
						Storage.setName(name);
						Storage.setEmail(email);
						Storage.setAge(age);
						Storage.setGender(gender);
						Storage.setContact(contact);
						Storage.setPassword(password);

						// open login window
						openWindow();

						break; // Email match and pass match, Close loop

					}

				}

			}

		}

		if (Storage.getEmail() == null) {
			System.out.println("No such email");

			Alert msg = new Alert(AlertType.ERROR);
			msg.setTitle(email_textfield.getText());
			msg.setContentText("No such Email : " + email_textfield.getText());
			msg.showAndWait();

		} else if (Storage.getPassword() == null) {
			System.out.println("No such email");

			Alert msg = new Alert(AlertType.ERROR);
			msg.setTitle(email_textfield.getText());
			msg.setContentText("Wrong password");
			msg.showAndWait();
		}

	}

	private void openWindow() {
		System.out.println("Profile open");

		try {
			Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
			Luncher.stage.setScene(new Scene(root));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}