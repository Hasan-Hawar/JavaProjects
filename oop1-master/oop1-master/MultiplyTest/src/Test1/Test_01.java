package Test1;

import java.util.Scanner;

public class Test_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clacMethod();
	}

	public static void clacMethod() {

		System.out.println("Enter numbers to calculation and '+' or '-'");
		String input = new Scanner(System.in).nextLine();
		String[] numberString = input.split(" +");
		int[] number = new int[numberString.length];
		int result = 0;
		try {
			for (int i = 0; i < numberString.length; i = i + 2) {
				number[i] = Integer.parseInt(numberString[i]);
				result = result + number[i];
			}
			System.out.println(result);

		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Fehler eingabe");
		}

	}
}
