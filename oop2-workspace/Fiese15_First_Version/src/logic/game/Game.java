package logic.game;

import java.util.Random;

public class Game {

	int[] card_1 = { 2, 1, 1, 5, 3, 3 };
	int[] card_2 = { 4, 1, 2, 2, 3, 5 };

	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(6) + 1;

}
