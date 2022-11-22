package com.apsi;

public class Completed extends StateMachine{

	void getBehavior() {
		System.out.println("Machine is Completed");
	}
	
	void nextEvent(StateMachine.events event) {

		switch (event) {
		case SELECT_MODE:
			StateMachine.current = StateMachine.modeSelected;
			return;
		default:
			System.out.println("Invalid : Completed state cannot accept this event");
			return;
		}
	}
	
}
