package test;

import java.util.HashMap;

public class CheckFlight implements Handler{
	
	private Handler nextHandler;
	public void setHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	public void handleRequest(String flightNumber, String customerName) {
		
		HashMap<String, Flight> flightDB = FlightInputRead.flightDB;
		
		if(flightDB.get(flightNumber)==null) {
			
			String errorNode = "Please enter correct booking details for "+customerName+":" +"requested flight is not available";
			System.out.println(errorNode);
			Context context = new Context();
			WriteErrorFile writeError = new WriteErrorFile();
			context.setContext(writeError);
//			System.out.println("incorrect flight number");
			context.executeWriteFile(errorNode);
		}
		else {
			nextHandler.handleRequest(flightNumber,customerName);
		}
		
		
	}

}
