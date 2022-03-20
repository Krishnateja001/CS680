package edu.umb.cs680.hw05;

public class StandBy implements State{
	private static StandBy instance = null;
	private Escalator escalator = Escalator.getInstance();

	private StandBy() {}
	
	public static StandBy getInstance() {
		if (instance == null) {
			instance = new StandBy();
		}
		return instance;
	}
	
	public void startButtonPushed() {
		escalator.moveSteps();
		escalator.changeState(Operating.getInstance());
	}
	
	public void stopButtonPushed() {
		escalator.disableSensor();
		escalator.changeState(Stopped.getInstance());
	}
	
	public void motionDetected() {
		escalator.moveSteps();
		escalator.changeState(Operating.getInstance());
	}
	
	public void motionNotDetected() {}

}