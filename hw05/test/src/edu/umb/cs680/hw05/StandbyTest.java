package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw05.Escalator;
import edu.umb.cs680.hw05.Operating;
import edu.umb.cs680.hw05.StandBy;
import edu.umb.cs680.hw05.Stopped;

class StandByTest {
	private static Escalator e;

	public static void beforeclassexception() throws Exception {
		e = Escalator.getInstance();
	}

	public void statechangeexception() throws Exception {
		e.changeState(StandBy.getInstance());
	}

	public void checkinstanceisnotempty() {
		assertNotNull(StandBy.getInstance());
	}

	public void checkinstanceissame() {
		StandBy s1 = StandBy.getInstance();
		StandBy s2 = StandBy.getInstance();
		assertSame(s1, s2);
	}
}