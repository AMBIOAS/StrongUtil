package no.strong.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;


public class DTTest {
	
	@Test
	public void endOfYearTest() {
		Date thisYear = DT.date(2000, 12, 1);
		Date nextYear = DT.date(2000, 12+1, 1);
		assertTrue("make sure next month at end of year goes to next year", nextYear.getYear() > thisYear.getYear());
	}
	
}
