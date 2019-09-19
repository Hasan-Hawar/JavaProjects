package extendedFunctions;

/**
 * This class provides basic functions to format Strings
 * 
 * @author Dmytriy Pelts
 * @version 1.0
 */
public class Formatter 
{
	/**
	 * This methode generates a chain of strings from arguments
	 * 
	 * @param args (unspecified amount of arguments)
	 * @return formattedText
	 */
	public static String getCombinedArgs(String... args)
	{
		String formattedText = "";
		int toLoop = (args.length - 1);
		
		for (int i = 0; i < toLoop; i++) 
			formattedText += (args[i] + ";");
		formattedText += args[toLoop];
		
		return formattedText;
	}
	
	/**
	 * This methode generates a chain of strings from an array
	 * 
	 * @param args (Array)
	 * @return formattedText
	 */
	public static String getCombinedArray(String[] args)
	{
		String formattedText = "";
		int toLoop = (args.length - 1);
		
		for (int i = 0; i < toLoop; i++)
			formattedText += (args[i] + ";");
		formattedText += args[toLoop];
		
		return formattedText;
	}
	
	/**
	 * This methode splites a chain of strings into a string array
	 * 
	 * @param args (formattedText)
	 * @return array
	 */
	public static String[] getSplitedString(String arg)
	{
		return (arg.split(";"));
	}
}
