import java.math.BigInteger;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

	private Model model = new Model();
	private BigInteger factorial;
	@FXML
	private Button calc;
	@FXML
	public TextField number;
	@FXML
	public Label result;

	@FXML
	private void factorialCalc() {
		new Thread(new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				// TODO Auto-generated method stub
				long num = Long.parseLong(number.getText());
				factorial = Model.factorialer(BigInteger.valueOf(num));
				return null;
			}

			@Override
			protected void running() {
				result.textProperty().setValue(" Waiting ...  ");
			}

			@Override
			protected void succeeded() {
				result.textProperty().setValue(" " + factorial);
			}
		}).start();
	}

	@FXML
	private void reset() {
		result.setText("");
		number.setText("");
	}
}
