package loginApplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ProfileController implements Initializable {

	@FXML
	private TextField name;

	@FXML
	private TextField email;

	@FXML
	private TextField gender;

	@FXML
	private TextField contact;

	@FXML
	private TextField age;

	@FXML
	private PasswordField password;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		name.setText(Storage.getName());
		age.setText(Storage.getAge());
		gender.setText(Storage.getGender());
		email.setText(Storage.getEmail());
		contact.setText(Storage.getContact());
		password.setText(Storage.getPassword());

		// Open windows for sign up if nall else do this
		if (Storage.getEmail() != null) {
			// Disable everything
			name.setDisable(true);
			age.setDisable(true);
			gender.setDisable(true);
			email.setDisable(true);
			contact.setDisable(true);
			password.setDisable(true);
		}

	}

	@FXML
	private Button save;

	@FXML
	private Button edit;

	@FXML
	void editButton(ActionEvent event) {
		System.out.println("edit button");
		// Active everything
		name.setDisable(false);
		age.setDisable(false);
		gender.setDisable(false);
		email.setDisable(false);
		contact.setDisable(false);
		password.setDisable(false);
	}

	@FXML
	void saveButton(ActionEvent event) {
		// Disable everything
		name.setDisable(true);
		age.setDisable(true);
		gender.setDisable(true);
		email.setDisable(true);
		contact.setDisable(true);
		password.setDisable(true);

		removeLine();
		addLine();
	}

	private void addLine() {
		String line = name.getText() + "," + email.getText() + "," + password.getText() + "," + age.getText() + ","
				+ gender.getText() + "," + contact.getText();

		FileWriter file_writer;
		try {
			file_writer = new FileWriter("TextFiles/data.txt", true);
			BufferedWriter buffered_Writer = new BufferedWriter(file_writer);
			buffered_Writer.write(line);
			buffered_Writer.flush();
			buffered_Writer.close();

		} catch (IOException e) {
			System.out.println("Add line failed!!" + e);
		}

	}

	private void removeLine() {
		try {
			BufferedReader file = new BufferedReader(new FileReader("TextFiles/data.txt"));
			String line;
			String input = "";
			while ((line = file.readLine()) != null) {
				// System.out.println(line);
				if (line.contains(Storage.getEmail())) {
					line = "";
					System.out.println("Line deleted.");
				}
				input += line + '\n';
			}
			FileOutputStream File = new FileOutputStream("TextFiles/data.txt");
			File.write(input.getBytes());
			file.close();
			File.close();

		} catch (Exception e) {
			System.out.println("Problem reading file.");
		}

	}

}