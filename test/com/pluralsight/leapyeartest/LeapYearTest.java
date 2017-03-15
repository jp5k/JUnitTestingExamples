package com.pluralsight.leapyeartest;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pluralsight.leapyeartest.LeapYear;

public class LeapYearTest {
	
	// a year is a leap year if it is divisible by four
	// but, leap years divisible by 100 are not leap years
	// except years divisible by 400
	
	@Test
	public void leapYearsAreDivisibleByFour(){
		assertTrue(LeapYear.isLeapYear(2016));
	}
	
	@Test
	public void normalYearsAreNotDivisibleByFour(){
		assertFalse(LeapYear.isLeapYear(3));
	}
	
	@Test
	public void leapYearsAreNotDivisibleByOneHundred(){
		assertFalse(LeapYear.isLeapYear(1900));
	}
	
	@Test
	public void leapYearsAreDivisibleByOneHundred(){
		assertTrue(LeapYear.isLeapYear(2000));
	}

}
