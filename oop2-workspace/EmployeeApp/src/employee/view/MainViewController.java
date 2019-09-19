package employee.view;

import java.io.IOException;

import employee.Main;
import javafx.fxml.FXML;

public class MainViewController {

	private Main main;

	@FXML

	public void goHome() throws IOException {

		main.showMainItems();
	}

	@FXML
	private void addEmployee() throws IOException {
		main.showAddStage();
	}
}
