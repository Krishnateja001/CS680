package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw05.Escalator;

class EscalatorTest {

	@Test
	public void checkinstanceisnotempty() {
		assertNotNull(Escalator.getInstance());
	}

	@Test
	public void getInstanceReturnIdenticalInstance() {
		Escalator auto1 = Escalator.getInstance();
		Escalator auto2 = Escalator.getInstance();
//		Escalator auto3 = Escalator.getInstance();
		assertSame(auto1, auto2);
	}

}