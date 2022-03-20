package edu.umb.cs680.hw05;

public interface State {
	
	public abstract void startButtonPushed();
	public abstract void stopButtonPushed();
	public abstract void motionDetected();
	public abstract void motionNotDetected();
}