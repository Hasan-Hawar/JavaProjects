package logic.game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dices {

	private ImageView diceFace;
	private Image[] images;

	public Dices(Image[] images) {
		this.images = images;
		diceFace = new ImageView(this.images[0]);// set default to image 0
		diceFace.setFitHeight(100);
		diceFace.setFitWidth(100);
		diceFace.setStyle("-fx-border-width: 3;" + "-fx-border-color: Black;" + "-fx-border-radius: 10 ");
		// diceFace.setStyle("-fx-border-radius: 10 10 10 10;" + "-fx-background-radius:
		// 10 10 10 10;");
		// diceFace.getStyleClass().setAll(Dices.class.getResource("stylesheets.css").toString());
		diceFace.setPreserveRatio(true);
	}

	public Dices(Image[] images, int diceFaceValue) {
		// Need to catch for values less than 1 and greater than 6!
		this.images = images;
		diceFace = new ImageView(this.images[diceFaceValue - 1]);
	}

	public ImageView getDiceFace() {
		return diceFace;
	}

	public void setDiceFace(int diceFaceValue) {
		if (diceFaceValue != 0) {
			// Need to catch for values less than 1 and greater than 6!
			diceFace.setImage(this.images[diceFaceValue - 1]);
		} else {
			diceFace.setImage(null);
		}
	}
}
