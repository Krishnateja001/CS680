package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DistanceTest {
	private static List<Double> p1, p2, p3, p4, p5;
	private static List<List<Double>> pointsList = new LinkedList<>();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		p1 = Arrays.asList(3.0, 4.0, 6.0);
		p2 = Arrays.asList(3.0, 6.0, 7.0);
		p3 = Arrays.asList(4.0, 5.0, 9.0);
		p4 = Arrays.asList(5.0, 3.0, 2.0);
		p5 = Arrays.asList(6.0, 6.0, 7.0);
		pointsList.add(p1);
		pointsList.add(p2);
		pointsList.add(p3);
		pointsList.add(p4);
		pointsList.add(p5);
	}

	@Test
	public void checkTwoVal() {
		double expected = Math.sqrt(5.0);
		double actual = Distance.get(p1, p2);
		assertEquals(expected, actual);
	}

	@Test
	public void checkTwoValAndEuclidean() {
		double expected = Math.sqrt(5.0);
		double actual = Distance.get(p1, p2, new Euclidean());
		assertEquals(expected, actual);
	}

	@Test
	public void checkTwoValAndManhattan() {
		double expected = 3.0;
		double actual = Distance.get(p1, p2, new Manhattan());
		assertEquals(expected, actual);
	}

	@Test
	public void checkTwoValAndChebyshev() {
		double expected = 2.0;
		double actual = Distance.get(p1, p2, new Chebyshev());
		assertEquals(expected, actual);
	}

	@Test
	public void defaultMatrixWithPointsList() {
		Double[][] expected = { { 0.0, Math.sqrt(5.0), Math.sqrt(11.0), Math.sqrt(21.0), Math.sqrt(14.0) },
				{ Math.sqrt(5.0), 0.0, Math.sqrt(6.0), Math.sqrt(38.0), 3.0 },
				{ Math.sqrt(11.0), Math.sqrt(6.0), 0.0, Math.sqrt(54.0), 3.0 },
				{ Math.sqrt(21.0), Math.sqrt(38.0), Math.sqrt(54.0), 0.0, Math.sqrt(35.0) },
				{ Math.sqrt(14.0), 3.0, 3.0, Math.sqrt(35.0), 0.0 } };
		List<List<Double>> actual = Distance.matrix(pointsList);
		for (int i = 0; i < expected.length; i++) {
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}


}