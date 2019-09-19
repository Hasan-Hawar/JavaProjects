package logic.game;

import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Game game = new Game();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(6);
		int randomInt2 = randomGenerator.nextInt(6);
		int randomInt3 = randomGenerator.nextInt(6);
		int randomInt4 = randomGenerator.nextInt(6);
		int randomInt5 = randomGenerator.nextInt(6);
		int randomInt6 = randomGenerator.nextInt(6);

		int[] numbers = { randomInt, randomInt2, randomInt3, randomInt4, randomInt5, randomInt6 };
		int[] num = { 1, 2, 3, 1, 4, 5 };
		System.out.println(num);
		System.out.println(Arrays.toString(numbers));
	}

}
