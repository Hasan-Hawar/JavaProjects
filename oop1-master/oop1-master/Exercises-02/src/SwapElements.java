
public class SwapElements {

	public static double[] swap(double[] list, int position1, int position2) {
		System.out.println("   \nBefore Swapping ..  ");

		for (int i = 0; i < list.length ; i++) {
			System.out.print(list[i] + " ");
		}

		System.out.println("\nSwitch Positions..");
		double a = 0;
		a = list[position1];
		list[position1] = list[position2];
		list[position2] = a;
		
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
			}
		
		/*int temp = list.length ;
		list[position2] = list[position1];
		list[position1] = temp;

		for (int i = 0; i < list.length ; i++) {
			System.out.print(list[i] + " ");
		}*/
		return null;

	}
}
