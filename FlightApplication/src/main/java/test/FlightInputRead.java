package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import test.Seat.SeatType;

public class FlightInputRead implements ReadFile{
	
	public static HashMap<String, Flight> flightDB= new HashMap<String, Flight>();
	
	public void readFiles(String filepath) {
		
		String line = "";
		try {
			
			@SuppressWarnings("resource")
			BufferedReader inputreader = new BufferedReader(new FileReader(filepath));
			inputreader.readLine();
			
			while ((line = inputreader.readLine()) != null) {
				
				String[] flightdetails = line.split(",");
				
				//seats type, number of available seats and price of seat
				Seat seatsmodel = new Seat();
				seatsmodel.setNumberOfSeats(Integer.parseInt(flightdetails[2]));
				seatsmodel.setSeatPrice(Integer.parseInt(flightdetails[3]));
				if(flightdetails[0].compareTo("Economy")==0) {
					seatsmodel.setSeat(SeatType.Economy);
				}
				else if(flightdetails[0].compareTo("Premium Economy")==0) {
					seatsmodel.setSeat(SeatType.PremiumEconomy);
				}
				else if(flightdetails[0].compareTo("Business")==0) {
					seatsmodel.setSeat(SeatType.Business);
				}
				
				Flight flightmodel = new Flight();
				flightmodel.setArrival(flightdetails[4]);
				flightmodel.setDeparture(flightdetails[5]);

				ArrayList<Seat> seat = new ArrayList<Seat>();
				if(flightDB.get(flightdetails[1])==null) {
					seat.add(seatsmodel);
				}
				else {
					seat = flightDB.get(flightdetails[1]).getSeats();
					seat.add(seatsmodel);
				}
				flightmodel.setSeats(seat);
				flightDB.put(flightdetails[1], flightmodel);
				
			}
		} catch (IOException e) {
			System.out.println( "error in reading Flight input file" );
			e.printStackTrace();
		}
		
	}
	
	

}
