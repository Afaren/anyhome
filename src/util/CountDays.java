package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CountDays {
	private final static String DATE_PATTERN = "yyyy-MM-dd HH:mm";

	// private final static String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static int getDays(String startTime, String stopTime) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
		long days = 0;
		try {
			Date startDate = format.parse(startTime);
			Date stopDate = format.parse(stopTime);
			days = (stopDate.getTime() - startDate.getTime())
					/ (1000 * 60 * 60 * 24);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (int) days;
	}
}
