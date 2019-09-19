/**
 * 
 */

/**
 * @author hasan
 *
 */
public class Minimum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("The Minimum Num is : "+ min(50,60,32));
		
		//min(60, 51, 900);
		
	}
	
	public static long min (long a , long b , long c) {
		
		long d;
		long mini;
		d = Math.min(a, b);
		mini = Math.min(d, c);
		System.out.println();
		return mini;
		
	}

}
