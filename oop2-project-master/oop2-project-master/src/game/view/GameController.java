package game.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;

public class GameController {

	private void showErrorAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Validation Error");
		alert.setHeaderText("Mindestens ein Wuerfel muss ausgewaehlt werden");
		alert.showAndWait();
	}

	private void showScore(int currentScore) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Zug Ende");
		alert.setHeaderText("Sie haben in dieser Runde " + currentScore + " Punkte erreicht");
		alert.showAndWait();
	}

	private void noValidDice() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Zug Ende");
		alert.setHeaderText("Keine Wuerfeln sind gueltig. Sie erhalten Punkte aller unbedeckten Felder");
		alert.showAndWait();
	}

	public int regularCalculation(int[] finalStripe) {
		int currentScore = 0;
		for (int i = 0; i < finalStripe.length; i++) {
			currentScore += finalStripe[i];
		}
		return currentScore;
	}

	public int noValidDiceCalculation(int[] solutionStripe, boolean[] decisionStripe) {
		int currentScore = 0;

		for (int i = 0; i < solutionStripe.length; i++) {
			if (decisionStripe[i] == false) {
				currentScore += solutionStripe[i];
			}
		}
		return currentScore;
	}

	public boolean check(RadioButton[] radioButtons) {
		boolean check = false;
		int counter = 0;
		for (int i = 0; i < radioButtons.length; i++) {
			if (radioButtons[i].isSelected() && radioButtons[i].isVisible()) {
				counter++;
				check = true;
				radioButtons[i].setVisible(false);
				;
			}
		}
		if (counter == 0) {
			check = false;
			showErrorAlert();
		}
		return check;
	}
}
