package Theorie;

public class ExTest2 {
	public static int FELD;

	public ExTest2(int a) throws ParameterException {
		try {
			if (a < 0)
				throw new ParameterException();
		} finally {
			FELD = a;
		}
	}

	public int func(int n) throws ParameterException {
		try {
			if (n < 0)
				throw new ParameterException();
		} finally {
			FELD = FELD + n;
		}
		return FELD;
	}
}