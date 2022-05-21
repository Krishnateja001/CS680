package edu.umb.cs680.hw11;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;


import org.junit.jupiter.api.Test;

class ParetoComparatorTest {
    ArrayList<Car> ListOfCars = new ArrayList<Car>();

    @Test
    public void verify_ParetoComparator() {
        ListOfCars.add(new Car("MarutiSuzuki", "Swift", 18, 2015, 10000));
        ListOfCars.add(new Car("KIA", "Soul", 19, 2016, 12000));
        ListOfCars.add(new Car("Ford", "MustangGT", 21, 2018, 34000));
        ListOfCars.add(new Car("Maserati", "Ghibli", 22, 2019, 78000));

        for (Car car : ListOfCars) {
            car.setDominationCount(ListOfCars);
        }

        Collections.sort(ListOfCars, new ParetoComparator());

        assertEquals(10000, ListOfCars.get(0).getPrice());
        assertEquals(12000, ListOfCars.get(1).getPrice());
        assertEquals(34000, ListOfCars.get(2).getPrice());
        assertEquals(78000, ListOfCars.get(3).getPrice());

    }
}