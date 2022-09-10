package codesmell;

import java.sql.Date;

public class RentalDates {
	
	private Date rentalDate;
	private Date dueDate;
	
	public boolean isOverdue() {
		Date now = new Date(0);
		return dueDate.before(now);
	}

}
