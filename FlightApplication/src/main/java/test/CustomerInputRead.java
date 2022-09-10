package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;

public class CustomerInputRead implements ReadFile{
	
	public static LinkedHashMap<String, Customer> customerDB = new LinkedHashMap<String, Customer>();
	
	public void readFiles(String filepath) {
		
		String line = "";
		try {
			
			@SuppressWarnings("resource")
			BufferedReader inputreader = new BufferedReader(new FileReader(filepath));
			inputreader.readLine();
			while ((line = inputreader.readLine()) != null) {

				
				//customer details 
				String[] customerdetails = line.split(",");
				Customer customermodel = new Customer();
				customermodel.setCustomerName(customerdetails[0]);
				customermodel.setFlightNumber(customerdetails[1]);
				customermodel.setSeatType(customerdetails[2]);
				customermodel.setNumberOfSeats(Integer.parseInt(customerdetails[3]));
				customermodel.setCreditCardNumber(customerdetails[4]);
				customerDB.put(customerdetails[0], customermodel);
			
			}
		} catch (IOException e) {
			System.out.println("Error in reading Customer Input file");
			e.printStackTrace();
		}
		
	}

}
