package org.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Test;

import test.CheckFlight;
import test.CustomerInputRead;
import test.FlightInputRead;
import test.RunClient;

public class TestCheckFlight {

	@Test
	public void test() {
//		fail("Not yet implemented");
		
		RunClient.OutputErrorFilePath = "TestOutput.txt";
		
		try  {
			FileWriter myWriter = new FileWriter("TestOutput.txt");
		      myWriter.write("Error Log");
		      myWriter.write("\n");
		      myWriter.close();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FlightInputRead inputDB = new FlightInputRead();
		inputDB.readFiles("TestFlightInput.csv");
		
		CustomerInputRead customerInput = new CustomerInputRead();
		customerInput.readFiles("TestCustomerInput.csv");
		
		
		CheckFlight checkflight = new CheckFlight();
		checkflight.handleRequest("testSJ456", "testSam");
		
		String errorline = "";
		try {
			
			@SuppressWarnings("resource")
			BufferedReader inputreader = new BufferedReader(new FileReader("TestOutput.txt"));
			inputreader.readLine();
			String line = "";
			while ((line = inputreader.readLine()) != null) {
//				System.out.println(line);
				errorline=line;
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean checkflightFlag=true;
		String expectedErrorNote = "Please enter correct booking details for testSam:requested flight is not available";
		if(errorline.compareTo(expectedErrorNote)==0) {
			checkflightFlag=false;
			
		}
		
		assertEquals(false, checkflightFlag);
	}

}
