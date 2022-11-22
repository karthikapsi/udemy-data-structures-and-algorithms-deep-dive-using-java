package com.apsi;

public class MachineReady extends StateMachine {

	void nextEvent(StateMachine.events event) {
		switch (event) {
		case SELECT_MODE:
			StateMachine.current = StateMachine.modeSelected;
			return;
		default:
			System.out.println("Invalid : Machine Ready state cannot accept this event");
			return;
		}

	}

}
