package edu.umb.cs680.hw01_5;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class PrimeGeneratorTest {

	@Test
	public void generatePrime_1to30() throws Exception {
		PrimeGenerator prime = new PrimeGenerator(1, 30);
		prime.generatePrimes();
		Long[] expectedNum = { 2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L };
		assertArrayEquals(expectedNum, prime.getPrimes().toArray());

	}

	@Test
	public void primeGenerate_30To1() throws Exception {
		try {
			PrimeGenerator prime = new PrimeGenerator(30, 1);

		} catch (RuntimeException ex) {
			assertEquals("Wrong input values: from=30 to=1", ex.getMessage());
		}

	}

	@Test
	public void primeGenerate_negativeTo1() throws Exception {
		try {
			PrimeGenerator prime = new PrimeGenerator(-20, 1);

		} catch (RuntimeException ex) {
			assertEquals("Wrong input values: from=-20 to=1", ex.getMessage());
		}

	}

	@Test
	public void primeGenerate_negativeTonegative() throws Exception {
		try {
			PrimeGenerator prime = new PrimeGenerator(-30, -1);

		} catch (RuntimeException ex) {
			assertEquals("Wrong input values: from=-30 to=-1", ex.getMessage());
		}

	}

	@Test
	public void primeGenerate_zeroTozero() throws Exception {
		try {
			PrimeGenerator prime = new PrimeGenerator(0, 0);

		} catch (RuntimeException ex) {
			assertEquals("Wrong input values: from=0 to=0", ex.getMessage());
		}

	}

}