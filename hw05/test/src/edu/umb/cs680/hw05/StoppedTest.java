package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw05.Escalator;
import edu.umb.cs680.hw05.StandBy;
import edu.umb.cs680.hw05.Stopped;

class StoppedTest {
	private static Escalator auto_steps;

	public static void beforeclassexception() throws Exception {
		auto_steps = Escalator.getInstance();
	}

	public void statechangeexception() throws Exception {
		auto_steps.changeState(Stopped.getInstance());
	}

	public void checkinstanceisnotempty() {
		assertNotNull(Stopped.getInstance());
	}

	public void checkinstanceissame() {
		Stopped s1 = Stopped.getInstance();
		Stopped s2 = Stopped.getInstance();
		assertSame(s1, s2);
	}

}