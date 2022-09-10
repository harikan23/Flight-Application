package test;

import java.io.FileWriter;
import java.io.IOException;


public class WriteErrorFile implements WriteFile{

	@Override
	public void writeToFile(String errornote) {
		
		
		
		try  {
			FileWriter myWriter = new FileWriter(RunClient.OutputErrorFilePath, true);
		      myWriter.write(errornote);
		      myWriter.write("\n");
		      myWriter.close();
        } catch (IOException e) {
        	System.out.println("Error in writing to output file");
			e.printStackTrace();
		}
		
	}
	

}
