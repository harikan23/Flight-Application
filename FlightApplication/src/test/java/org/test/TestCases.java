package org.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import org.junit.Test;

import test.Flight;
import test.FlightInputRead;

public class TestCases {

	@Test
	public void testCase1() {
		HashMap<String, Flight> flightDB= FlightInputRead.flightDB;
		
		Integer flightDBSize_before = flightDB.size();
		
		boolean testCheck = false;
		
		FlightInputRead inputDB = new FlightInputRead();
		inputDB.readFiles("TestFlightInput.csv");
		
		Integer flightDBSize_after = flightDB.size();
		
		if(flightDBSize_after>flightDBSize_before) {
			testCheck = true;
			
		}
		assertEquals(true, testCheck);
	}
	

	
	
	

}
