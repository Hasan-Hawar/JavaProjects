package Banksystem;

/**
 * Specific Exception when a creditlimit or dailylimit was hit
 * @author Dmytriy Pelts
 * @version 1.0
 */
public class BankLimitException extends Exception {

	private static final long serialVersionUID = 1555049023801224591L;

	public BankLimitException(String message) {
		super(message);
	}

	
}
