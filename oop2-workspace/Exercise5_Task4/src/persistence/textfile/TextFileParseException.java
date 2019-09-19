package persistence.textfile;

import persistence.PersistenceException;

public class TextFileParseException extends PersistenceException {
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

	public String getFilePath() {
		return filePath;
	}

	public int getLineNb() {
		return lineNb;
	}

	public String getLine() {
		return line;
	}
}
