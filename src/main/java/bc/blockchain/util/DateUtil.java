package bc.blockchain.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	
	public static Date addSecond(Date date,Integer sec){
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(Calendar.SECOND,sec);
		date=c.getTime();
		return date;
	}

}
