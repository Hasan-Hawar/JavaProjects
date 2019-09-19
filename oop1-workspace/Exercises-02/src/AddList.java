import java.util.Arrays;

import javax.swing.text.html.StyleSheet.ListPainter;

public class AddList {
	
	public static double [] addLast(double []list, double a) {
		int i;
		for(i = 0; i < list.length; i++) {
			
			System.out.print(list[i] + " ");
		}
		list = Arrays.copyOf(list, list.length+1);
		list[list.length - 1] = a;
		System.out.print(list[i]+ "  ");
		System.out.println(" ");
		return null;
	}
}
