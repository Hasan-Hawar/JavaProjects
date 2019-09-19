
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

	@FXML
	private Text output;

	@FXML
	Button button;

	private float num1 = 0;
	private String operator = "";
	private boolean start = true;

	private Model model = new Model();

	@FXML
	private void processNumPad(ActionEvent e) {

		if (start) {
			output.setText("");
			start = false;
		}

		String value = ((Button) e.getSource()).getText();
		output.setText(output.getText() + value);
	}

	@FXML
	private void processOperator(ActionEvent e) {
		String value = ((Button) e.getSource()).getText();

		if (!value.equals("=")) {
			if (!operator.isEmpty())
				return;
			operator = value;
			num1 = Float.parseFloat(output.getText());
			output.setText("");
		} else {
			if (operator.isEmpty())
				return;

			output.setText(String.valueOf(model.caclulate(num1, Float.parseFloat(output.getText()), operator)));
			operator = "";

		}
	}

	@FXML
	private void clearSheet() {
		output.setText("");
	}

	@FXML
	private void negateOutput() {
		float out = (Float.parseFloat(output.getText())) * -1;
		output.setText(String.valueOf(out));
	}

	@FXML
	public void dragMouse(ActionEvent e) {
		button.setStyle(" background-color: #f4511e;\r\n" + "  border: none;\r\n" + "  color: white;\r\n"
				+ "  padding: 16px 32px;\r\n" + "  text-align: center;\r\n" + "  font-size: 16px;\r\n"
				+ "  margin: 4px 2px;\r\n" + "  opacity: 0.6;\r\n" + "  transition: 0.3s;");
	}
}
