package test;



public class Seat {
	
	public enum SeatType{
		Economy,PremiumEconomy, Business
	}
	
	private SeatType seat;
	private Integer numberOfSeats;
	private Integer seatPrice;
	
	public SeatType getSeat() {
		return seat;
	}
	public void setSeat(SeatType seat) {
		this.seat = seat;
	}
	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	public Integer getSeatPrice() {
		return seatPrice;
	}
	public void setSeatPrice(Integer seatPrice) {
		this.seatPrice = seatPrice;
	}


}
