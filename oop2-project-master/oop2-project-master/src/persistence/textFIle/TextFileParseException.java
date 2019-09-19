package persistence.textFIle;

import persistence.PersistenceException;

public class TextFileParseException extends PersistenceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String filePath;
	private int lineNb;
	private String line;

	public TextFileParseException(String fileName, int lineNb, String line, Exception e) {
		super(e);
		this.filePath = fileName;
		this.lineNb = lineNb;
		this.line = line;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @return the lineNb
	 */
	public int getLineNb() {
		return lineNb;
	}

	/**
	 * @return the line
	 */
	public String getLine() {
		return line;
	}

}
