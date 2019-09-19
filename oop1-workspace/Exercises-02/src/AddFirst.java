import java.util.Arrays;

public class AddFirst {

	public static double [] addFirst(double [] list, double a){
		
		int i ;
		for (i = list.length-1; i > 0; i--) {
			list[i] = list[i-1];
			
			
		}
		list[0] = a;
		for( i=0; i  < list.length; i++) {
		System.out.print(list[i] + " ");
		}
		System.out.println(" ");
		return null;
	}
}
