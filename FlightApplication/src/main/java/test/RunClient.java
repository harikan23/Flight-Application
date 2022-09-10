package test;



public class RunClient {
	
	
	public static String InputFilePath;
	public static String FlightDetailsFilePath;
	public static String OutputErrorFilePath;
	public static String OutputCSVFilePath;

	public static void main(String[] args) {
		
		if(args.length<4) {
			System.out.println("Please pass required arguments");
			System.exit(0);
		}
		
		InputFilePath = args[0];  			// customer details

		FlightDetailsFilePath = args[1]; 	// flight DB details

		OutputErrorFilePath = args[3];		// error log 

		OutputCSVFilePath = args[2];		// customer booking details

		//output csv and error log files
		AddNewFiles addNewFile = new AddNewFiles();
		addNewFile.NewFiles();
		//book flight tickets
		FlightBooking flightbooking = new FlightBooking();
		flightbooking.customerBooking();

		
	}

}
