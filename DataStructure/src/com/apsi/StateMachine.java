package com.apsi;

public abstract class StateMachine {

	static StateMachine machineReady, modeSelected, running, stopped, paused, completed, current;

	static enum events {
		SELECT_MODE("1"), START_WASHING("2"), PAUSE_WASHING("3"), STOP_WASHING("4"), TIME_UP("5");

		private String value;

		public String getValue() {
			return value;
		}

		private events(String value) {
			this.value = value;
		}

	}

	void nextEvent(StateMachine.events event) {
	}

	void getBehavior() {
	}

	void getState() {
		System.out.print(
				"Now in the " + StateMachine.current.getClass().getName().replace("com.apsi.", "") + " state \n");
	}
}
