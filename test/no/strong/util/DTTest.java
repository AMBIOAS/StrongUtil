

package no.strong.util;


import static org.junit.Assert.*;

import org.junit.Test;

public class DTTest {
	@Test
	public void testYears() {
		assertTrue("from 2000.1.1 to 2001.1.1 is a year.", 1 == DT.years(DT.date(2000, 1, 1), DT.date(2001, 1, 1)));
	}
	@Test
	public void testMonths() {
		assertTrue("from 2000.1.1 to 2000.2.1 is a month.", 1 == DT.months(DT.date(2000, 1, 1), DT.date(2000, 2, 1)));
	}
	@Test
	public void testDays() {
		assertTrue("from 2000.1.1 to 2000.1.2 is a day.", 1 == DT.days(DT.date(2000, 1, 1), DT.date(2000, 1, 2)));
	}
}
