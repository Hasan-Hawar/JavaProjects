package persistence.TextFile;

import persistence.PersistenceException;

public class PersistenceParseFileException extends PersistenceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pathfile;
	private int lineNm;
	private String line;

	public PersistenceParseFileException(String filename, int lineNm, String line, Exception e) {
		// TODO Auto-generated constructor stub
		super(e);
		this.pathfile = filename;
		this.lineNm = lineNm;
		this.line = line;
	}

	public String getPathFile() {
		return pathfile;
	}

	public int getLineNm() {
		return lineNm;
	}

	public String getLine() {
		return line;
	}
}
