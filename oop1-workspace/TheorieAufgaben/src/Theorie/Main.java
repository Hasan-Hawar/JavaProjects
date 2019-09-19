package Theorie;

public class Main {

	private static int FELD;

	public static void main(String[] args) {
		try {
			ExTest test = new ExTest(1);
			System.out.printf("-m1-: %d %d %n", Main.FELD, ExTest.FELD);
			FELD = test.func(-1);
		} catch (ParameterException e) {
			System.out.printf("-ex-: %d %d %n", Main.FELD, ExTest.FELD);
		}
		System.out.printf("-m2-: %d %d %n", Main.FELD, ExTest.FELD);
	}
}
