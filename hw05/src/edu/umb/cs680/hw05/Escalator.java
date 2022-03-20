package edu.umb.cs680.hw05;

public class Escalator {
	private static Escalator instance = null;
	private State state = Stopped.getInstance();

	private Escalator() {}

	public static Escalator getInstance() {
		if (instance == null) {
			instance = new Escalator();
			Stopped.setEscalator(instance);
		}
		return instance;
	}

	public State getState() {
		return state;
	}

	public void changeState(State newState) {
		state = newState;
	}

	public void startButtonPushed() {
		state.startButtonPushed();
	}

	public void stopButtonPushed() {
		state.stopButtonPushed();
	}

	public void motionDetected() {
		state.motionDetected();
	}

	public void motionNotDetected() {
		state.motionNotDetected();
	}

	public void moveSteps() {
		System.out.println("stairs movement started");
	}

	public void stopSteps() {
		System.out.println("stairs movement halted");
	}

	public void enableSensor() {
		System.out.println("sensor enabled!");
	}

	public void disableSensor() {
		System.out.println("sensor disabled!");
	}

}