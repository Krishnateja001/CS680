package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void verify_MakeTest() {
        Car car = new Car("Maserati", "Ghibli", 22, 2019, 780000);
        String actual = car.getMake();
        String expected = "Maserati";
        assertEquals(actual, expected);
    }

    @Test
    public void verify_ModelTest() {
        Car car = new Car("Maserati", "Ghibli", 22, 2019, 780000);
        String actual = car.getModel();
        String expected = "Ghibli";
        assertEquals(actual, expected);
    }


    @Test
    public void verify_MileageTest() {
        Car car = new Car("Maserati", "Ghibli", 22, 2019, 780000);
        int actual = car.getMileage();
        int expected = 22;
        assertEquals(actual, expected);
    }

    @Test
    public void verify_YearTest() {
        Car car = new Car("Maserati", "Ghibli", 22, 2019, 780000);
        int actual = car.getYear();
        int expected = 2019;
        assertEquals(actual, expected);
    }

    @Test
    public void verify_PriceTest() {
        Car car = new Car("Maserati", "Ghibli", 22, 2019, 780000);
        float actual = car.getPrice();
        float expected = 780000;
        assertEquals(actual, expected);
    }

}