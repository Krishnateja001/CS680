package edu.umb.cs680.hw05;

public class Stopped implements State{
	private static Stopped instance = null;
	private static Escalator escalator;
	
	private Stopped() {}
	
	public static Stopped getInstance() {
		if (instance == null) {
			instance = new Stopped();
		}
		return instance;
	}
	
	public static void setEscalator(Escalator escalator) {
		Stopped.escalator = escalator;
	}
	
	public void startButtonPushed() {
		escalator.enableSensor();
		escalator.changeState(StandBy.getInstance());
	}
	
	public void stopButtonPushed() {}
	
	public void motionDetected() {}
	
	public void motionNotDetected() {}

}