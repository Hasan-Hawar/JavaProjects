package library.admin;

public class NoAvailableItemsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1737478116467179169L;

	public NoAvailableItemsException(String message) {
		super("keine Verfügbaren Items gefunden");
		// TODO Auto-generated constructor stub
	}

}
