package net.zaf.tools;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeHelper {
	
	private static final SimpleDateFormat format_date_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static final SimpleDateFormat format_date = new SimpleDateFormat("yyyy-MM-dd");

	public static String getDateTime() {
		return format_date_time.format(new Date());
	}
	
	public static String getDate() {
		return format_date.format(new Date());
	}
}
