package com.apsi;

public class Stopped extends StateMachine {
	
	void getBehavior() {
		System.out.println("Machine is Stopped");
	}
	
	void nextEvent(StateMachine.events event) {

		switch (event) {
		case SELECT_MODE:
			StateMachine.current = StateMachine.modeSelected;
			return;
		default:
			System.out.println("Invalid : Stopped state cannot accept this event");
			return;
		}
	}
}
