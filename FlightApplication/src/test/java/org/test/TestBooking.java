package org.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Test;

import com.opencsv.CSVWriter;

import test.Booking;
import test.CustomerInputRead;
import test.FlightInputRead;
import test.RunClient;

public class TestBooking {

	@Test
	public void test() {
//		fail("Not yet implemented");
		
		RunClient.OutputCSVFilePath = "TestOutput.csv";
		
		String[] header = {"Booking Name" , "Flight Number", "Category", "number of seats booked", "Total Price"};
		
		
		try (CSVWriter writer = new CSVWriter(new FileWriter(RunClient.OutputCSVFilePath))) {
			writer.writeNext(header);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FlightInputRead inputDB = new FlightInputRead();
		inputDB.readFiles("TestFlightInput.csv");
		
		CustomerInputRead customerInput = new CustomerInputRead();
		customerInput.readFiles("TestCustomerInput.csv");
		

	
		
		Booking book = new Booking();
		book.booking();
		
		
		String itenery = "";
		try {
			
			@SuppressWarnings("resource")
			BufferedReader inputreader = new BufferedReader(new FileReader("TestOutput.csv"));
			inputreader.readLine();
			String line = "";
			while ((line = inputreader.readLine()) != null) {
//				System.out.println(line);
				itenery=line;
			
			}
		} catch (IOException e) {
			System.out.println("error while reading file");
			e.printStackTrace();
		}
		boolean checkbooking=false;
		String expecteditenery = "\"testSam\",\"SJ456\",\"Economy\",\"2\",\"500\"";
		if(itenery.compareTo(expecteditenery)==0) {
			System.out.println("Itenery for customer :"+itenery);
			checkbooking=true;
			
		}
		
		assertEquals(true, checkbooking);
	}
		
}


