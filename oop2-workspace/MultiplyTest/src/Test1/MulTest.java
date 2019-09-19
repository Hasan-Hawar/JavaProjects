/**
 * 
 */
package Test1;

import java.util.Scanner;

/**
 * @author hasan
 *
 */
public class MulTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("my name is: " + myName());
		Mul();
	}

	static String name = "Hasan";

	public static String myName() {
		return name;
	}

	public static void Mul() {
		System.out.print("java Test : ");
		String s = new Scanner(System.in).nextLine();
		String[] n = s.split(" ");
		int result = 1;
		int num[] = new int[n.length];
		
		int i;
		String output = "";
		try {
			for (i = 0; i < n.length; i++) {
				num[i] = Integer.parseInt(n[i]);
				result *= num[i];
				output = output + num[i];
				if (i < n.length - 1) {
					output = output + " * ";
				}
			}
			System.out.print(" the Result is :  " + output);

			System.out.println(" = "+result);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Ungultige eingabe");
		}
	}
}
