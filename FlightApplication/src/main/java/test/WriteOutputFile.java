package test;


import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;

public class WriteOutputFile implements WriteFile{

	@Override
	public void writeToFile(String Itenery) {
		
		String[] reachString_split = Itenery.split(",");
			
		try (CSVWriter writer = new CSVWriter(new FileWriter(RunClient.OutputCSVFilePath, true))) {
            writer.writeNext(reachString_split);
        } catch (IOException e) {
        	System.out.println("Error in writing to output file");
			e.printStackTrace();
		}

		
		
	}

}
