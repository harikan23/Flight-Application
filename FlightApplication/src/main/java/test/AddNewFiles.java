package test;

import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;


public class AddNewFiles {
	
	public void NewFiles() {
		
		
		String[] header = {"Booking Name" , "Flight Number", "Category", "number of seats booked", "Total Price"};
		
		
		try (CSVWriter writer = new CSVWriter(new FileWriter(RunClient.OutputCSVFilePath))) {
			writer.writeNext(header);
		} catch (IOException e) {
			System.out.println("Error in writing to output file");
			e.printStackTrace();
		}
		
		try  {
			FileWriter myWriter = new FileWriter(RunClient.OutputErrorFilePath);
		      myWriter.write("Error Log");
		      myWriter.write("\n");
		      myWriter.close();
        } catch (IOException e) {
        	System.out.println("Error in writing to output file");
			e.printStackTrace();
		}
		
		
		
	}

}
