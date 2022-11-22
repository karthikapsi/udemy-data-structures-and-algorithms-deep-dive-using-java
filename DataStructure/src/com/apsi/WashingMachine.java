package com.apsi;

import java.util.Scanner;

public class WashingMachine {

	public static void main(String[] args) {
		StateMachine.machineReady = new MachineReady();
		StateMachine.modeSelected = new ModeSelected();
		StateMachine.running = new Running();
		StateMachine.paused = new Paused();
		StateMachine.stopped = new Stopped();
		StateMachine.completed = new Completed();
		StateMachine.current = StateMachine.machineReady;

		while (true) {
			StateMachine.current.getState();
			StateMachine.current.getBehavior();
			StateMachine.current.nextEvent(displayEvents());
		}

	}

	static StateMachine.events displayEvents() {
		System.out.println("1. Select Mode");
		System.out.println("2. Start Washing");
		System.out.println("3. Pause Washing");
		System.out.println("4. Stop Washing");
		System.out.println("5. Time Up");
		Scanner in = new Scanner(System.in);
		return getEvent(in.next());
	}

	static StateMachine.events getEvent(String value) {
		switch (value) {
		case "1":
			return StateMachine.events.SELECT_MODE;
		case "2":
			return StateMachine.events.START_WASHING;
		case "3":
			return StateMachine.events.PAUSE_WASHING;
		case "4":
			return StateMachine.events.STOP_WASHING;
		case "5":
			return StateMachine.events.TIME_UP;
		default:
			return null;
		}
	}

}
