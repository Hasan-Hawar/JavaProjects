
public class AddVectors {
	
	public static double[] addVectors(double[] a, double [] b) {
			double sum [] = new double [a.length] ;	
		for (int i = 0; i < a.length; i++) {
			 sum [i] = a[i] + b[i];
		}
		System.out.println("The Sum of the Vektors : ");
		return sum;
		
	}

}
