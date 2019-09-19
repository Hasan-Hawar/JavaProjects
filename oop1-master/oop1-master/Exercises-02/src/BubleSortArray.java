
public class BubleSortArray {

	public static double[] bubleSort(double[] list1) {
		System.out.println("\nList After sorting...");
		double a = 0;
		int n = list1.length;
		for (int i = 1; i <= (n-1); i++) {
			for(int j = 0; j < (n-1); j++) {
				if (list1[j+1] < list1[j]) {
					a = list1[j];
					list1[j] = list1[j+1];
					list1[j+1] = a;
				}
			}
		}
		for(int i = 0; i < list1.length; i++) {
			System.out.print(list1[i] + " ");
		}
		return null;
	}
}
