import javax.swing.JOptionPane;
import java.util.Scanner;
public class Exerceises {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("The Minimum Num is : "+ min(50,60,32));
		
		//min(60, 51, 900);
		
		Square("8");
		
		change(31.78);
		
		Pyramide(8);
		
		sinValue();
		
		int array[] = { 3, 2, 6, 5, 7 };
		int target = 9;
		findPair(array, target);
		
		reverse("cba", "xyz");
	
	}
	public static long min (long a , long b , long c) {
		
		long d;
		long mini;
		d = Math.min(a, b);
		mini = Math.min(d, c);
		System.out.println();
		return mini;
		
	}


//-------------------------------------------------------------------------------------------------



	
	
	public static void Square(String S) {
		
		int num = Integer.parseInt(S);
		
		int sqr =num*num;
		
		//System.out.println("Square of the String Num is : " + sqr*sqr);
		
		
		JOptionPane.showMessageDialog (null,sqr);
		
	}


//---------------------------------------------------------------------------------------------------

	
	public static void change(double d) {
		
		double coins [] = {20.00 , 10.00 , 5.00, 2.00, 1.00, 0.5, 0.2, 0.1, 0.05};
		int num ;
		
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= d) {
				num = (int) (d / coins[i]);
				 System.out.println(d+ " = " + num + " * " + coins[i]);
				d -= num * coins[i];
				
			}
			
		}
		
	}


//----------------------------------------------------------------------------------------------------




	public static void sinValue() {
		
		double Sin = 0;
		double Num = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the Value to calulate Sin of it ...  ");
		Num = scan.nextDouble();
		Sin = Math.sin(Num);
		if(Num < 0 ) {
		System.out.print("Ungultige Eingabe: " + Num + " Wert Sinus ist : " + Sin );	
		}
		else if (Sin < 0  ) {
			System.out.println("\n" + "Ungultige Eingabe:  " + Num +"  Wert Sinus ist Negativ: " + Sin);			
		}
		
		else if (Num > 0 && Sin > 0) {
		
		System.out.println("Gultige Eingabe : " + Num + "  Sinus Wert : " + Sin);
		}
	}	
		
	


//-----------------------------------------------------------------------------------------------------


	public static void Pyramide(int n) {

		int i;
		int j;
		int count = n - 1;

		for ( i = 1; i <= n; i++) {

			for (j = 1; j <= count; j++) {
				System.out.print(" ");
			}

			for (j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}
			System.out.println("  ");
			count--; 
		}
	}


//----------------------------------------------------------------------------------------------------


	

	public static int[] findPair(int[] array, int target) {

		for (int i = 0; i < array.length - 1; i++) {

			for (int j = i + 1; j < array.length; j++) {

				if (array[i] + array[j] == target) {
					System.out.println("{" + array[i] + "," + array[j] + "}");

				} else if (array[i] + array[j] == target) {
					System.out.println("{-1,-1}");
				}
			}

		}
		return array;
	}


//-----------------------------------------------------------------------------------------------------



	public static String reverse(String s, String t) {

		int i;
		int j;

		for (i = s.length() - 1; i >= 0; i--) {
			t = t + s.charAt(i);
		}
		/*for (j = t.length() - 1; j <= 0; j--) {
			t = t + t.charAt(j);
		}*/
		System.out.println("Reverse String is : " + t);
		return t;

	}
}
