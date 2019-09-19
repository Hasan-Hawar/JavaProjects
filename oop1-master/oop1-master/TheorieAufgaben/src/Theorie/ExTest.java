package Theorie;

public class ExTest {
	public static int FELD = 0;

	public ExTest(int a) throws ParameterException {
		if (a < 0) {
			throw new ParameterException();
		}
		FELD = a;
	}

	public int func(int n) throws ParameterException {
		if (n < 0) {
			throw new ParameterException();
		}
		FELD = FELD + n;
		return FELD + n;
	}
}