package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw05.Escalator;
import edu.umb.cs680.hw05.Operating;
import edu.umb.cs680.hw05.StandBy;
import edu.umb.cs680.hw05.Stopped;

class OperatingTest {
	private static Escalator e;

	public static void beforeclassexception() throws Exception {
		e = Escalator.getInstance();
	}

	public void statechangeexception() throws Exception {
		e.changeState(Operating.getInstance());
	}


	public void checkinstanceisnotempty() {
		assertNotNull(Operating.getInstance());
	}


	public void checkinstanceissame() {
		Operating o1 = Operating.getInstance();
		Operating o2 = Operating.getInstance();
		assertSame(o1, o2);
	}

}