/**
 * 
 */

/**
 * @author hasan
 *
 */
public class ChangeCoins {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		change(31.78);
	}
	
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

}
