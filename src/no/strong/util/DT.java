

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
		int yDiff = years(first, last);
		int dDiff = l.get(Calendar.DAY_OF_YEAR) - f.get(Calendar.DAY_OF_YEAR);
		return (yDiff * 365) + dDiff;
	}


	public static Date today() {
		Calendar c = Calendar.getInstance();
		return date(c.get(Calendar.YEAR), 1 + c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
	}

	
	public static Date date( int y, int m, int d ) {
		Calendar c = Calendar.getInstance();
		c.set(y, m - 1, d, 0, 0, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static Date date( int y, int m, int d, int hours, int minutes ) {
		Calendar c = Calendar.getInstance();
		c.set(y, m - 1, d, hours, minutes, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	public static Date date( int y, int m, int d, String hmin ) {
		String[] hm = hmin.split(":");
		return date(y, m, d, (new Integer(hm[0])), (new Integer(hm[1])));
	}

	public static Date date( Date date ) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}
}
