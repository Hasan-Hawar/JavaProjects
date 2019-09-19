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
		System.out.print("java Test  ");
		String s = new Scanner(System.in).nextLine();
		String[] n = s.split(" ");
		int result = 1;
		int num[] = new int[n.length];
		int i;
		try {
			for (i = 0; i < n.length; i++) {
				num[i] = Integer.parseInt(n[i]);
				result *= num[i];
			}
			System.out.println(" the Result is :  " + result);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Ungultige eingabe");
		}
	}
}
