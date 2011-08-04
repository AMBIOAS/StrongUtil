package no.strong.util;





import java.util.Calendar;
import java.util.Date;

/**
 * Date and Time utilities
 * 
 * @author fredpallesen
 *
 */

public class DT {

	/**
	 * number of years between two dates
	 * @param first date
	 * @param last date
	 * @return diff years
	 */
	public static int years( Date first, Date last ) {
		int diff = 0;
		boolean swap = false;
		if (first.getTime() > last.getTime()) swap = true;
		Calendar f = Calendar.getInstance();
		Calendar l = Calendar.getInstance();
		f.setTime(swap ? last : first);
		l.setTime(swap ? first : last);
		diff = l.get(Calendar.YEAR) - f.get(Calendar.YEAR);
		// corrections needed?
		int mDiff = l.get(Calendar.MONTH) - f.get(Calendar.MONTH);
		int dDiff = l.get(Calendar.DAY_OF_MONTH) - f.get(Calendar.DAY_OF_MONTH);
		if (mDiff < 0) {
			diff--;
		}
		else if (mDiff == 0) {
			if (dDiff < 0) diff--;
		}
		return swap ? -diff : diff;
	}

	public static int months( Date first, Date last ) {
		int diff = 0;
		boolean swap = false;
		if (first.getTime() > last.getTime()) swap = true;
		Calendar f = Calendar.getInstance();
		Calendar l = Calendar.getInstance();
		f.setTime(swap ? last : first);
		l.setTime(swap ? first : last);
		diff = 12 * (l.get(Calendar.YEAR) - f.get(Calendar.YEAR));
		// corrections needed?
		int mDiff = l.get(Calendar.MONTH) - f.get(Calendar.MONTH);
		diff += mDiff;
		int dDiff = l.get(Calendar.DAY_OF_MONTH) - f.get(Calendar.DAY_OF_MONTH);
		if (dDiff < 0) diff--;
		return swap ? -diff : diff;
	}

	public static int days( Date first, Date last ) {
		Calendar f = Calendar.getInstance();
		Calendar l = Calendar.getInstance();
		f.setTime(first);
		l.setTime(last);
		int mDiff = l.get(Calendar.MONTH) - f.get(Calendar.MONTH);
		return mDiff;
	}

	public static Date date( int y, int m, int d ) {
		Calendar c = Calendar.getInstance();
		c.set(y, m - 1, d, 0, 0, 0);
		return c.getTime();
	}
	
	public static String formatDate(Date date){
		return date.toString().substring(0, 10);
	}
}