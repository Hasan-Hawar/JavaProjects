package persistence;

public class PersistenceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // Exception is Serializable...
	/*
	 * es gibt eine Warrinig wenn ich eine Serialisierbale Klasse verwende ohne
	 * Setialisiere Nummer zu derklarieren
	 * 
	 */

	public PersistenceException() {

	}

	public PersistenceException(String message) {
		super(message);
	}

	public PersistenceException(Throwable cause) {
		super(cause);
	}

	public PersistenceException(String message, Throwable cause) { // Combination the Exceprion
		super(message, cause);
	}
}