package edu.umb.cs680.hw05;

public class Operating implements State {
	private static Operating instance = null;
	private Escalator escalator = Escalator.getInstance();

	private Operating() {}

	public static Operating getInstance() {
		if (instance == null) {
			instance = new Operating();
		}
		return instance;
	}

	public void startButtonPushed() {}

	public void stopButtonPushed() {
		escalator.stopSteps();
		escalator.disableSensor();
		escalator.changeState(Stopped.getInstance());
	}

	public void motionDetected() {}

	public void motionNotDetected() {
		escalator.stopSteps();
		escalator.changeState(StandBy.getInstance());
	}

}