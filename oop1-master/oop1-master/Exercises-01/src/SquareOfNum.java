import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author hasan
 *
 */
public class SquareOfNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Square("8");
		
	}
	
	public static void Square(String S) {
		
		int num = Integer.parseInt(S);
		
		int sqr =num*num;
		
		//System.out.println("Square of the String Num is : " + sqr*sqr);
		
		
		JOptionPane.showMessageDialog (null,sqr);
		
	}

}
