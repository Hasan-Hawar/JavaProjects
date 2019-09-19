import java.util.Arrays;

public class VerkorLength {
	
	public static double vectorLength(double[] vector) {
		System.out.println("\nVector Element are :");
		
		for (int i = 0; i < vector.length; i++) {
			//vector[i] = Math.pow(vector[i], 2);
			System.out.print(vector[i] + " " );
			
		}
		System.out.println("\nThe Square Vektor Elemente : ");
		for (int i = 0; i < vector.length; i++) {
			vector[i] = Math.pow(vector[i], 2);
			System.out.print(vector[i] + " " );
			
		}
		
		double x = Arrays.stream(vector).sum();
		x = Math.sqrt(x);
		
		System.out.println("\nLength of Vector : " + x);
		return 0;
		
	}

}
