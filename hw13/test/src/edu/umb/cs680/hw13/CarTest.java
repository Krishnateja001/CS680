package edu.umb.cs680.hw13;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;


import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    ArrayList<Car> ListOfCars = new ArrayList<Car>();

    @Test
    public void verify_ParetoComparator() {
        ListOfCars.add(new Car("MarutiSuzuki", "Swift", 18, 2015, 10000));
        ListOfCars.add(new Car("KIA", "Soul", 19, 2016, 12000));

        for (Car car : ListOfCars) {
            car.setDominationCount(ListOfCars);
        }

        Collections.sort(ListOfCars, (Car car1, Car car2) -> car1.getDominationCount() - car2.getDominationCount());

        assertEquals(10000, ListOfCars.get(0).getPrice());
        assertEquals(12000, ListOfCars.get(1).getPrice());

    }



    @Test
    public void verify_MileageComparator() {


        ListOfCars.add(new Car("Maserati", "Ghibli", 22, 2019, 78000));
        ListOfCars.add(new Car("Ford", "MustangGT", 21, 2018, 34000));


        Collections.sort(ListOfCars,(Car car1, Car car2) -> car1.getMileage()-car2.getMileage());


        assertEquals(21,ListOfCars.get(0).getMileage());
        assertEquals(22, ListOfCars.get(1).getMileage());

    }



    @Test
    public void verify_MileageComparator_2() {

        ListOfCars.add(new Car("Ford", "MustangGT", 21, 2018, 34000));
        ListOfCars.add(new Car("Maserati", "Ghibli", 22, 2019, 78000));


        Collections.sort(ListOfCars,(Car car1, Car car2) -> (int) (car1.getPrice() - car2.getPrice()));


        assertEquals(34000,ListOfCars.get(0).getPrice());
        assertEquals(78000, ListOfCars.get(1).getPrice());
    }


    @Test
    public void verify_MileageComparator_3() {
        ListOfCars.add(new Car("MarutiSuzuki", "Swift", 18, 2015, 10000));
        ListOfCars.add(new Car("KIA", "Soul", 19, 2016, 12000));



        Collections.sort(ListOfCars,(Car car1, Car car2) -> car1.getYear() - car2.getYear());

        assertEquals(2015, ListOfCars.get(0).getYear());
        assertEquals(2016, ListOfCars.get(1).getYear());

    }


}