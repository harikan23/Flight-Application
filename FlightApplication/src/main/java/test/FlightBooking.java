package test;



public class FlightBooking {
	
	public void customerBooking() {
		
		
		//flight file
		FlightInputRead flightInput = new FlightInputRead();
		flightInput.readFiles(RunClient.FlightDetailsFilePath);
		//customer file Input
		CustomerInputRead customerInput = new CustomerInputRead();
		customerInput.readFiles(RunClient.InputFilePath);
		
		//ticket booking
		Booking book = new Booking();
		book.booking();
		
		

		
		
	}

}
