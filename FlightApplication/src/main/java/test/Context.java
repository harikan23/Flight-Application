package test;

public class Context {
	
	private WriteFile writeFile;
	
	public void setContext(WriteFile writeFile) {
		this.writeFile=writeFile;
	}
	
	public void executeWriteFile(String fileNote) {
		writeFile.writeToFile(fileNote);
	}

}
