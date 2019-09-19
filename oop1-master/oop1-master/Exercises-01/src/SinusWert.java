import java.util.Scanner;

public class SinusWert {
	public static void main(String[] args) {
		sinValue();
	}
	
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

}
