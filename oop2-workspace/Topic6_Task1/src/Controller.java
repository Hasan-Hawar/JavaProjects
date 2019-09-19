import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

	private int countA;
	private int countB;

	@FXML
	private Label countLabel1;
	@FXML
	private Label countLabel2;

	@FXML
	private Button click1;
	@FXML
	private Button click2;

	@FXML
	private void clickOnClick1() {

		countA++;
		countLabel1.setText("A : " + countA);

	}

	@FXML
	private void clickOnClick2() {
		countB++;
		countLabel2.setText("B :" + countB);
	}
}
