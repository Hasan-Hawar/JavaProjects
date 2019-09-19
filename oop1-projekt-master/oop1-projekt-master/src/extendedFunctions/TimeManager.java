package extendedFunctions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class gives us the time in a specific format
 * 
 * @author Dmytriy Pelts
 * @version 1.0
 */
public class TimeManager 
{
	private static final DateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	
	public static String getCurrentTime()
	{
		Date date = new Date();
		return sdf.format(date);
	}
}
