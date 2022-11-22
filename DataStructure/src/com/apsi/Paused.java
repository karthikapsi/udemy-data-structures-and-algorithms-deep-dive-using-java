package com.apsi;

public class Paused extends StateMachine {

	void getBehavior() {
		System.out.println("Machine is Paused");
	}
	
	void nextEvent(StateMachine.events event) {

		switch (event) {
		case START_WASHING:
			StateMachine.current = StateMachine.running;
			return;
		case STOP_WASHING:
			StateMachine.current = StateMachine.stopped;
			return;
		default:
			System.out.println("Invalid : Paused state cannot accept this event");
			return;
		}
	}
}
