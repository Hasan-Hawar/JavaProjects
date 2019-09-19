import java.util.Arrays;

public class MinVektor {

	public static double[] minVektor(double[][] vectors) {
		double mul = 0;
		double x = 0;
		double y = 0;
		double z = 0;
		for (int i = 0; i < vectors.length; i++) {
			for (int j = 0; j < vectors.length; ++j) {
				System.out.print(vectors[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\nThe Square of all Vectors..");

		for (int i = 0; i < vectors.length; i++) {
			for (int j = 0; j < vectors.length; j++) {
				mul = vectors[i][j] * vectors[i][j];
				System.out.print(mul + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < vectors.length; i++) {
				x += vectors[i][0];
		}System.out.println(x + " ");
		
		for (int i = 0; i < vectors.length; i++) {
			y += vectors[i][1];
		}
		System.out.println(y + " ");
		for (int i = 0; i < vectors.length; i++) {
			z += vectors[i][2];
		}
		System.out.println(z + " ");
		
		
		double d = 0;
		d = Math.min(x, y);
		double minVektor = Math.min(d, z);
		
		System.out.println("The Minimum Vektor is : " + minVektor);

		return null;

	}

}