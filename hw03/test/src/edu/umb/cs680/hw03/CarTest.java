package edu.umb.cs680.hw03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

	private String[] carToStringArray(Car car) {
		String[] carInfo = {car.getMake(),car.getModel(),Integer.toString(car.getYear())};
		return carInfo;
	}
	
	@Test
	void verifyCarEqualityWithMakeModelYear() throws Exception{
		Car actual = new Car("Ferrari","Bentley",12,2011,62000);
		String[] expected = {"Ferrari","Bentley","2011"};
		assertArrayEquals(expected,carToStringArray(actual));
	}

}
