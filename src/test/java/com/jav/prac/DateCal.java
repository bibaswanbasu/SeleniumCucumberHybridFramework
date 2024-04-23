package com.jav.prac;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.testng.annotations.Test;

public class DateCal {

	public DateCal() {
		System.out.println("I am on the constructor");
	}

	@Test
	public void calenderConcept() {

		Calendar cal = Calendar.getInstance();
//		System.out.println(cal);
		SimpleDateFormat sdf = new SimpleDateFormat("MMDDyyyy");

		System.out.println(cal.get(Calendar.AM_PM));

	}

}
