package sample.test;

import java.util.ArrayList;
import java.util.Scanner;

abstract class State {

	static State NotBooked, Confirmed, RAC, WaitingList, Cancelled, current, prev;

	static ArrayList<Ticket> confirmedTicket = new ArrayList<>(10);
	static ArrayList<Ticket> RACTicket = new ArrayList<>(3);
	static ArrayList<Ticket> waitingListTicket = new ArrayList<>();
	static int ticketNumber = 1;
	static String bookedTicket = "";
	
	static enum Type {
		CONFIRM, RAC, WAITINGLIST
	}

	void getState() {
		System.out.print("Now in the " + State.current.getClass().getName().replace("sample.test.", "") + " state \n");
	}

	void getNextState(State next) {
		System.out.print("Next state is " + next.getClass().getName().replace("sample.test.", "") + " state \n");
	}

	void nextEvent() {

	}
};

class NotBooked extends State {
	void nextEvent() {
		prev = NotBooked;
		State.Type type = null;
		
		
		if (confirmedTicket.size() < 10) {
			System.out.println("Available Ticket(s) = " + (10 - confirmedTicket.size()));
			State.current = Confirmed;
			State.current.getNextState(Confirmed);
			type = State.Type.CONFIRM;
		} 
		
		if (confirmedTicket.size() == 10 && RACTicket.size() >= 0 && RACTicket.size() < 3) {
			System.out.println("RAC Available Ticket(s) = " + (3 - RACTicket.size()));
			State.current = RAC;
			State.current.getNextState(RAC);
			type = State.Type.RAC;
		}
		
		/*System.out.println("Confirmed = " + confirmedTicket.size());
		System.out.println("RACTicket = " + RACTicket.size());
		System.out.println("waitingListTicket = " + waitingListTicket.size());
		*/
		if (confirmedTicket.size() == 10 && RACTicket.size() == 3) {
			System.out.println("Your ticket(s) will go to waiting list");
			State.current = WaitingList;
			State.current.getNextState(WaitingList);
			type = State.Type.WAITINGLIST;
		}
		System.out.println("Enter no of ticket(s)");
		Scanner s = new Scanner(System.in);
		int ticket = 0;
		try {
			ticket = Integer.parseInt(s.next());
		}catch(Exception e) {
			System.out.println("Invalid input");
			current = NotBooked;
			return;
		}
		switch (type) {

		case CONFIRM:
			bookedTicket = "";
			for (int i = 0; i < ticket; i++) {
				State.confirmedTicket.add(new Ticket("T"+ticketNumber, "Confirm"));
				bookedTicket += "T"+ticketNumber+", ";
				State.ticketNumber++;
			}
			return;
		case RAC:
			bookedTicket = "";
			for (int i = 0; i < ticket; i++) {
				State.RACTicket.add(new Ticket("T"+ticketNumber, "RAC"));
				bookedTicket += "T"+ticketNumber+", ";
				State.ticketNumber++;
			}
			return;
		case WAITINGLIST:
			bookedTicket = "";
			for (int i = 0; i < ticket; i++) {
				State.waitingListTicket.add(new Ticket("T"+ticketNumber, "Waiting"));
				bookedTicket += "T"+ticketNumber+", ";
				State.ticketNumber++;
			}
			return;
		}
		return;
	}

}

class Confirmed extends State {
	void nextEvent() {
		System.out.println(bookedTicket + " ticket(s) booked\n");
		
		System.out.println("1. Cancel ticket");
		System.out.println("2. Not Booked");
		System.out.println("3. Exit");
		prev = Confirmed;
		Scanner s = new Scanner(System.in);
		String input = s.next();
		switch (input) {
		case "1":
			current = Cancelled;
			return;
		case "2":
			current = NotBooked;
			return;
		case "3":
			System.out.println("Exited\n\n");
			System.exit(0);
			return;
		default:
			System.out.println("Invalid option");
			current = NotBooked;
			return;
		}
	}
}

class Cancelled extends State {
	void nextEvent() {
		prev = Cancelled;
		System.out.println("Enter the ticket number to be cancelled");
		Scanner s = new Scanner(System.in);
		String ticket = s.next();
		
		Ticket remove = onCancel(ticket);
		if(remove == null) {
			System.out.println("Invalid ticket number");
			current = Cancelled;
			return;
		}
			
		System.out.println(remove.getTicketType() + " - " +remove.getTicketNumber() + " was cancelled.");
		
		System.out.println("1. Not Booked");
		System.out.println("2. Exit");

		String input = s.next();
		switch (input) {
		case "1":
			current = NotBooked;
			return;
		case "2":
			System.out.println("Exited\n\n");
			System.exit(0);
			return;
		default:
			System.out.println("Invalid option");
			current = NotBooked;
			return;
		}
	}
	
	Ticket onCancel(String ticket) {
		Ticket remove = null;
		for(Ticket t : State.confirmedTicket) {
			if(ticket.equals(t.getTicketNumber())){
				remove = t;
				break;
			}
		}
		if(remove != null) {
			State.confirmedTicket.remove(remove);
			if(State.RACTicket.size()>0) {
				Ticket swap = State.RACTicket.get(0);
				swap.setTicketType("Confirm");
				System.out.println("Ticket " + swap.getTicketNumber() +" has been moved to Confirmed state");
				State.confirmedTicket.add(swap);
				State.RACTicket.remove(swap);
			}
		}
		for(Ticket t : State.RACTicket) {
			if(ticket.equals(t.getTicketNumber())){
				remove = t;
				break;
			}
		}
		if(remove != null) {
			State.RACTicket.remove(remove);
			if(State.waitingListTicket.size()>0) {
				Ticket swap = State.waitingListTicket.get(0);
				swap.setTicketType("RAC");
				System.out.println("Ticket " + swap.getTicketNumber() +" has been moved to RAC state");
				State.RACTicket.add(swap);
				State.waitingListTicket.remove(swap);
			}
		}
		
		for(Ticket t : State.waitingListTicket) {
			if(ticket.equals(t.getTicketNumber())){
				remove = t;
				break;
			}
		}
		if(remove != null) {
			State.waitingListTicket.remove(remove);
		}
		return remove;
	}
}

class RAC extends State {
	void nextEvent() {
		System.out.println(bookedTicket + " RAC ticket(s) booked\n");
		
		System.out.println("1. Cancel ticket`");
		System.out.println("2. Not Booked");
		System.out.println("3. Exit");
		prev = RAC;
		Scanner s = new Scanner(System.in);
		String input = s.next();
		switch (input) {
		case "1":
			current = Cancelled;
			return;
		case "2":
			current = NotBooked;
			return;
		case "3":
			System.out.println("Exited\n\n");
			System.exit(0);
			return;
		default:
			System.out.println("Invalid option");
			current = NotBooked;
			return;
		}
	}
}

class WaitingList extends State {
	void nextEvent() {
		System.out.println(bookedTicket + " Waiting list ticket(s) booked \n");
		System.out.println("1. Cancel ticket(s)");
		System.out.println("2. Not Booked");
		System.out.println("3. Exit");
		prev = WaitingList;
		Scanner s = new Scanner(System.in);
		String input = s.next();
		switch (input) {
		case "1":
			current = Cancelled;
			return;
		case "2":
			current = NotBooked;
			return;
		case "3":
			System.out.println("Exited\n\n");
			System.exit(0);
			return;
		default:
			System.out.println("Invalid option");
			current = NotBooked;
			return;
		}
	}
}

public class TrainTicket {

	public static void main(String[] args) {
		State.NotBooked = new NotBooked();
		State.Confirmed = new Confirmed();
		State.Cancelled = new Cancelled();
		State.RAC = new RAC();
		State.WaitingList = new WaitingList();
		State.current = State.NotBooked;
		while (true) {
			State.current.getState();
			State.current.nextEvent();
		}
	}
}