package com.apsi;

public class ModeSelected extends StateMachine {

	void getBehavior() {
		System.out.println("Machine is Ready to Wash");
	}

	void nextEvent(StateMachine.events event) {
		switch (event) {
		case START_WASHING:
			StateMachine.current = StateMachine.running;
			return;
		default:
			System.out.println("Invalid : Mode selected state cannot accept this event");
			return;
		}
	}
}
