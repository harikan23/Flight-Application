package org.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

import test.CheckCreditCard;
import test.RunClient;

public class TestCheckCreditCard {

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
		
		
		CheckCreditCard checkCardDetails = new CheckCreditCard();
		checkCardDetails.handleRequest("1234567890234533", "testSam");
		
		String errorline = "";
		try {
			
			@SuppressWarnings("resource")
			BufferedReader inputreader = new BufferedReader(new FileReader("TestOutput.txt"));
			inputreader.readLine();
			String line = "";
			while ((line = inputreader.readLine()) != null) {
				System.out.println(line);
				errorline=line;
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean checkflightFlag=true;
		String expectedErrorNote = "Please enter correct booking details for testSam:Invalid credit card details";
		if(errorline.equals(expectedErrorNote)==true) {
//			System.out.println(errorline);
			checkflightFlag=false;
			
		}
		
		assertEquals(false, checkflightFlag);
		
		
		
	}

}
