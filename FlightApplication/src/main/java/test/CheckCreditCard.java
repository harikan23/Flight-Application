package test;

import java.util.ArrayList;
import java.util.List;

public class CheckCreditCard implements Handler{
	
	public static List<String> outputCustomerDetails = new ArrayList<String>();
	
	private Handler nextHandler;
	public void setHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}
	@Override
	public void handleRequest(String CardNumber, String Iternery) {
		

		String customerName = Iternery.split(",")[0];
		
		

		
		Integer CardNumberLength = CardNumber.length();
		
		boolean isValidCard=false;
		
		//Invalid Card
		if(CardNumberLength>19) {
//			System.out.println("in invalid credit card");
			isValidCard=false;
		}
		//Visa Card
		else if((CardNumberLength==13 || CardNumberLength==16) &&((CardNumber.charAt(0) - '0')==4)) {
//			System.out.println("in visa");
			isValidCard=true;
		}
		//Master card
		else if(CardNumberLength==16 && ((CardNumber.charAt(0) - '0')==5) && (CardNumber.charAt(1) - '0')>=1 && (CardNumber.charAt(1) - '0')<=5) {
//			System.out.println("in master");
			isValidCard=true;
		}
		//Discover Card
		else if(CardNumberLength==16 && ((CardNumber.charAt(0) - '0')==6) && (CardNumber.charAt(1) - '0')==0 && (CardNumber.charAt(2) - '0')==1&& (CardNumber.charAt(3) - '0')==1) {
//			System.out.println("in discover");
			isValidCard=true;
		}
		//Amex Card
		else if(CardNumberLength==15 && ((CardNumber.charAt(0) - '0')==3) && ((CardNumber.charAt(1) - '0')==4 || (CardNumber.charAt(2) - '0')==7)) {
//			System.out.println("in amex");
			isValidCard=true;
		}
		
		Context context = new Context();
		
		if(isValidCard) {
			
//			System.out.println("Card details are valid");
			
			outputCustomerDetails.add(Iternery);
			WriteOutputFile writeOutput = new WriteOutputFile();
			context.setContext(writeOutput);
			context.executeWriteFile(Iternery);
			
		}
		else {
//			System.out.println("Invalid Credit card details");
		
			String errorNode = "Please enter correct booking details for "+customerName+":" +"Invalid credit card details";
			WriteErrorFile writeError = new WriteErrorFile();
			context.setContext(writeError);
			context.executeWriteFile(errorNode);
			
		}

		
	
		
	}
	

}
