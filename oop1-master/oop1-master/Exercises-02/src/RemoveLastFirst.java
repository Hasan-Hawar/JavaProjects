import java.util.Arrays;

public class RemoveLastFirst {

	public static double[] removeLast(double[] list) {
		int i = 0;
		System.out.println("The List without Remove ..");
		for (i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		for (i = list.length - 1; i < list.length - 1; i++) {
			list[i] = list[i + 1];
		}
		System.out.println("\nRemove the Last Item ..");
		for (i = 0; i < list.length - 1; i++) {
			System.out.print(list[i] + " ");
		}
		return null;
	}

	public static double[] removeFirst(double[] list) {
		int i;
		System.out.println("\nRemove the First Item .. ");
		for (i = 0; i < list.length - 1; i++) {
			list[i] = list[i + 1];
		}
		for (i = 0; i < list.length - 1; i++) {
			System.out.print(list[i] + " ");
		}

		return null;

	}

}
