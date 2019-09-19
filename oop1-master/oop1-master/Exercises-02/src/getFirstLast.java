import java.util.Arrays;

public class getFirstLast {
	
	public static double getlast(double[] list) {
		int i = 0;
		if (list[i] == list [list.length-1] ) {
			System.out.print("\n"+"The last Element is : "+ list[i]);
			System.out.println(" ");
		}else
		System.out.print( "\n"+"The last Element is : "+ list[list.length-1] + " ");

		return 0;

	}

	public static double getFirst(double[] list) {
		int i = 0;
		if (list[0] == list[i]) {
			System.out.println("\n"+"The First Element is : "+list[i]);
		}else 
			System.out.println("\n"+"The First Element is : "+"\n"+list[0]);

		return 0;

	}
}
