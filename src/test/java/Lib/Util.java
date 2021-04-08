package Lib;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
	
	public Util() {
		
	}
	
	
	public String dateFormater(String dateFormat, int duration) {
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, duration);
		dt = c.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		String strDate= formatter.format(dt);
		System.out.println(strDate);
		return strDate;
	}
}
