/**
 * 
 */

/**
 * @author hasan
 *
 */
public class InsertAtPosition {
	
	public static double[] insert(double[] list, double a, int position) {
		int i;
		for (i = list.length-1; i > position; i--) {
			list[i] = list[i-1];
			//System.out.print(list[i] + " ");
		}
		list[position] = a;
		
		for(i = 0 ; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println(" ");
		return null;
		
	}

}
