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
		String[] numberString = input.split("\\+");
		int[] number = new int[numberString.length];
		int result = 0;
		String output = "";
		try {
			for (int i = 0; i < numberString.length; i++) {
				number[i] = Integer.parseInt(numberString[i]);
				result += number[i];
				output = output + number[i];
				if (i < number.length - 1) {
					output = output + " + ";
				}
			}
			System.out.print(" the Result is :  " + output);
			System.out.println(" = " + result);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Fehler eingabe");
		} catch (ArrayIndexOutOfBoundsException e1) {
			System.out.println("OutOfBoundException");
		}

	}
}
