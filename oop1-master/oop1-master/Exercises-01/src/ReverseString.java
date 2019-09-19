
public class ReverseString {

	public static void main(String[] args) {

		reverse("cba", "xyz");

	}

	public static String reverse(String s, String t) {

		int i;
		int j;
		for (i = s.length() - 1; i >= 0; i--) {
			t = t + s.charAt(i);
		}
		/*for (j = t.length() - 1; j <= 0; j--) {
			t = t + t.charAt(j);
		}*/
		System.out.println("Reverse String is : " + t);
		return t;

	}
}
