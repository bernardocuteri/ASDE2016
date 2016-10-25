package fibonacci;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logging {
	
	
	public void beforeCompute()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println("I invoked the compute fibonacci function ");
		System.out.println(dateFormat.format(cal.getTime())); //2014/08/06 16:00:22
	}
	public void afterCompute()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		System.out.println("I computed fibonacci function ");
		System.out.println(dateFormat.format(cal.getTime())); //2014/08/06 16:00:22
	}
}
