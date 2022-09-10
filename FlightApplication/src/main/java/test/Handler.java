package test;

public interface Handler {
	
	public void handleRequest(String request1,String request2);
	public void setHandler(Handler nextHandler);

}
