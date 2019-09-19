/**
 * 
 */

/**
 * @author hasan
 *
 */
public class PyramideClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pyramide(8);
	}

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

}
