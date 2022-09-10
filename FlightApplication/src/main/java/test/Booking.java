package test;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Booking {
	
	public void booking() {
		
		LinkedHashMap<String, Customer> customerDB = CustomerInputRead.customerDB;
		
		if(customerDB.size()==0) {
			System.out.println("No customers are here to book tickets");
		}
		//verify customer details before confirming flight booking
		for(Entry<String,Customer> customerEntry : customerDB.entrySet()) {
			
			Customer customer = customerEntry.getValue();
			
			CheckFlight checkflight = new CheckFlight();
			
			CheckSeatRequest checkseat = new CheckSeatRequest();
			
			CheckCreditCard checkCardDetails = new CheckCreditCard();
			
			checkflight.setHandler(checkseat);
			checkseat.setHandler(checkCardDetails);
			checkflight.handleRequest(customer.getFlightNumber(), customer.getCustomerName());
			
		}
		
	}

}
