package com.apsi;

public class Running extends StateMachine {
	
	void getBehavior() {
		System.out.println("Machine is Started to wash");
	}

	void nextEvent(StateMachine.events event) {

		switch (event) {
		case PAUSE_WASHING:
			StateMachine.current = StateMachine.paused;
			return;
		case STOP_WASHING:
			StateMachine.current = StateMachine.stopped;
			return;
		case TIME_UP:
			StateMachine.current = StateMachine.completed;
			return;
		default:
			System.out.println("Invalid : Running state cannot accept this event");
			return;
		}
	}
}
