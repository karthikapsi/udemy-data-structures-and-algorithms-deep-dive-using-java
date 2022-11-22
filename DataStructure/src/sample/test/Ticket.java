package sample.test;

public class Ticket {

	private String ticketNumber;
	private String ticketType;
		
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}	
	
	public Ticket(String ticketNumber, String ticketType) {
		this.ticketNumber = ticketNumber;
		this.ticketType = ticketType;
	}
}