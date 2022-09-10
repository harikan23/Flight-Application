package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class CheckSeatRequest implements Handler{
	
	private Handler nextHandler;
	public void setHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}
	public void handleRequest(String flightNumber, String customerName) {
		
		HashMap<String, Flight> flightDB = FlightInputRead.flightDB;
		LinkedHashMap<String, Customer> customerDB = CustomerInputRead.customerDB;
		Customer customer = customerDB.get(customerName);
		Flight flight = flightDB.get(customer.getFlightNumber());
		ArrayList<Seat> seats = flight.getSeats();
		
		boolean seatcheck=false;
		for(Seat seatEntry: seats) {
			
			String seattype = seatEntry.getSeat().toString();
			String customerSeat = customer.getSeatType().replaceAll("\\s+","");
			if(seattype.compareTo(customerSeat)==0){
				
				if(seatEntry.getNumberOfSeats()>=customer.getNumberOfSeats()) {
					
					Integer indx = seats.indexOf(seatEntry);
					seatEntry.setNumberOfSeats(seatEntry.getNumberOfSeats()-customer.getNumberOfSeats());
					flight.getSeats().set(indx, seatEntry);
					flightDB.replace(customer.getFlightNumber(), flight);
					String CardNumber = customerDB.get(customerName).getCreditCardNumber();
					Integer totalPrice = customer.getNumberOfSeats() * seatEntry.getSeatPrice();
					String Iternery = customerName+","+flightNumber+","+customer.getSeatType()+","+customer.getNumberOfSeats().toString()+","+ totalPrice.toString();					
					nextHandler.handleRequest(CardNumber,Iternery);
					
				}
				else {
					
					String errorNode = "Please enter correct booking details for "+customer.getCustomerName()+":" +"requested number of seats not available in flight "+ customer.getFlightNumber();
					System.out.println(errorNode);
					WriteErrorFile writeError = new WriteErrorFile();
					writeError.writeToFile(errorNode);
				}
				seatcheck=true;
				break;
			}
			
		}
		if(!seatcheck) {
			
			String errorNode = "Please enter correct booking details for "+customer.getCustomerName()+":" +"requested seat type not available in flight "+ customer.getFlightNumber();
			System.out.println(errorNode);
			WriteErrorFile writeError = new WriteErrorFile();
			writeError.writeToFile(errorNode);
		}
			
		
	}

}
