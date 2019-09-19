
/**
 * 
 */

/**
 * @author hasan
 *
 */
public class FindPairOf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stufindPair(array, target)
		int array[] = { 3, 2, 6, 5, 7 };
		int target = 9;
		findPair(array, target);
	}

	public static int[] findPair(int[] array, int target) {

		for (int i = 0; i < array.length - 1; i++) {

			for (int j = i + 1; j < array.length; j++) {

				if (array[i] + array[j] == target) {
					System.out.println("{" + array[i] + "," + array[j] + "}");

				} else if (array[i] + array[j] == target) {
					System.out.println("{-1,-1}");
				}
			}

		}
		return array;
	}

}
