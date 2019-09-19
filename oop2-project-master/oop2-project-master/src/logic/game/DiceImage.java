package logic.game;

import javafx.scene.image.Image;

public class DiceImage {

	final Image diceBlack1 = new Image(getClass().getResourceAsStream("/DiceImages/black/black1.png"));
	final Image diceBlack2 = new Image(getClass().getResourceAsStream("/DiceImages/black/black2.png"));
	final Image diceBlack3 = new Image(getClass().getResourceAsStream("/DiceImages/black/black3.png"));
	final Image diceBlack4 = new Image(getClass().getResourceAsStream("/DiceImages/black/black4.png"));
	final Image diceBlack5 = new Image(getClass().getResourceAsStream("/DiceImages/black/black5.png"));
	final Image diceBlack6 = new Image(getClass().getResourceAsStream("/DiceImages/black/black6.png"));

	final Image diceBlue1 = new Image(getClass().getResourceAsStream("/DiceImages/blue/blue1.png"));
	final Image diceBlue2 = new Image(getClass().getResourceAsStream("/DiceImages/blue/blue2.png"));
	final Image diceBlue3 = new Image(getClass().getResourceAsStream("/DiceImages/blue/blue3.png"));
	final Image diceBlue4 = new Image(getClass().getResourceAsStream("/DiceImages/blue/blue4.png"));
	final Image diceBlue5 = new Image(getClass().getResourceAsStream("/DiceImages/blue/blue5.png"));
	final Image diceBlue6 = new Image(getClass().getResourceAsStream("/DiceImages/blue/blue6.png"));

	final Image diceGreen1 = new Image(getClass().getResourceAsStream("/DiceImages/green/green1.png"));
	final Image diceGreen2 = new Image(getClass().getResourceAsStream("/DiceImages/green/green2.png"));
	final Image diceGreen3 = new Image(getClass().getResourceAsStream("/DiceImages/green/green3.png"));
	final Image diceGreen4 = new Image(getClass().getResourceAsStream("/DiceImages/green/green4.png"));
	final Image diceGreen5 = new Image(getClass().getResourceAsStream("/DiceImages/green/green5.png"));
	final Image diceGreen6 = new Image(getClass().getResourceAsStream("/DiceImages/green/green6.png"));

	final Image diceRed1 = new Image(getClass().getResourceAsStream("/DiceImages/red/red1.png"));
	final Image diceRed2 = new Image(getClass().getResourceAsStream("/DiceImages/red/red2.png"));
	final Image diceRed3 = new Image(getClass().getResourceAsStream("/DiceImages/red/red3.png"));
	final Image diceRed4 = new Image(getClass().getResourceAsStream("/DiceImages/red/red4.png"));
	final Image diceRed5 = new Image(getClass().getResourceAsStream("/DiceImages/red/red5.png"));
	final Image diceRed6 = new Image(getClass().getResourceAsStream("/DiceImages/red/red6.png"));

	final Image diceWhite1 = new Image(getClass().getResourceAsStream("/DiceImages/white/white1.png"));
	final Image diceWhite2 = new Image(getClass().getResourceAsStream("/DiceImages/white/white2.png"));
	final Image diceWhite3 = new Image(getClass().getResourceAsStream("/DiceImages/white/white3.png"));
	final Image diceWhite4 = new Image(getClass().getResourceAsStream("/DiceImages/white/white4.png"));
	final Image diceWhite5 = new Image(getClass().getResourceAsStream("/DiceImages/white/white5.png"));
	final Image diceWhite6 = new Image(getClass().getResourceAsStream("/DiceImages/white/white6.png"));

	final Image diceYellow1 = new Image(getClass().getResourceAsStream("/DiceImages/yellow/yellow1.png"));
	final Image diceYellow2 = new Image(getClass().getResourceAsStream("/DiceImages/yellow/yellow2.png"));
	final Image diceYellow3 = new Image(getClass().getResourceAsStream("/DiceImages/yellow/yellow3.png"));
	final Image diceYellow4 = new Image(getClass().getResourceAsStream("/DiceImages/yellow/yellow4.png"));
	final Image diceYellow5 = new Image(getClass().getResourceAsStream("/DiceImages/yellow/yellow5.png"));
	final Image diceYellow6 = new Image(getClass().getResourceAsStream("/DiceImages/yellow/yellow6.png"));

	final Image[] imagesBlack = new Image[6];
	final Image[] imagesBlue = new Image[6];
	final Image[] imagesGreen = new Image[6];
	final Image[] imagesRed = new Image[6];
	final Image[] imagesWhite = new Image[6];
	final Image[] imagesYellow = new Image[6];

	public DiceImage() {

		imagesBlack[0] = diceBlack1;
		imagesBlack[1] = diceBlack2;
		imagesBlack[2] = diceBlack3;
		imagesBlack[3] = diceBlack4;
		imagesBlack[4] = diceBlack5;
		imagesBlack[5] = diceBlack6;

		imagesBlue[0] = diceBlue1;
		imagesBlue[1] = diceBlue2;
		imagesBlue[2] = diceBlue3;
		imagesBlue[3] = diceBlue4;
		imagesBlue[4] = diceBlue5;
		imagesBlue[5] = diceBlue6;

		imagesGreen[0] = diceGreen1;
		imagesGreen[1] = diceGreen2;
		imagesGreen[2] = diceGreen3;
		imagesGreen[3] = diceGreen4;
		imagesGreen[4] = diceGreen5;
		imagesGreen[5] = diceGreen6;

		imagesRed[0] = diceRed1;
		imagesRed[1] = diceRed2;
		imagesRed[2] = diceRed3;
		imagesRed[3] = diceRed4;
		imagesRed[4] = diceRed5;
		imagesRed[5] = diceRed6;

		imagesWhite[0] = diceWhite1;
		imagesWhite[1] = diceWhite2;
		imagesWhite[2] = diceWhite3;
		imagesWhite[3] = diceWhite4;
		imagesWhite[4] = diceWhite5;
		imagesWhite[5] = diceWhite6;

		imagesYellow[0] = diceYellow1;
		imagesYellow[1] = diceYellow2;
		imagesYellow[2] = diceYellow3;
		imagesYellow[3] = diceYellow4;
		imagesYellow[4] = diceYellow5;
		imagesYellow[5] = diceYellow6;

	}

	public Image[] getImagesBlack() {
		return imagesBlack;
	}

	public Image[] getImagesBlue() {
		return imagesBlue;
	}

	public Image[] getImagesGreen() {
		return imagesGreen;
	}

	public Image[] getImagesRed() {
		return imagesRed;
	}

	public Image[] getImagesWhite() {
		return imagesWhite;
	}

	public Image[] getImagesYellow() {
		return imagesYellow;
	}
}
