package edu.umb.cs680.hw13;

import java.util.ArrayList;



public class Car {

    private String make;
    private String model;
    private int mileage;
    private int year;
    private int dominationCount;
    private float price;

    public Car(String make, String model, int mileage, int year,  float price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public float getPrice() {
        return price;
    }

    public void setDominationCount(ArrayList<Car> cars) {
        int count = 0;
        for (Car car : cars) {
            if (!car.equals(this)) {
                if ((this.getYear() >= car.getYear()) && (this.getMileage() <= car.getMileage()) && (this.getPrice() <= car.getPrice())) {
                    if ((this.getYear() > car.getYear()) || (this.getMileage() < car.getMileage()) || (this.getPrice() < car.getPrice())) {
                        count++;
                    }
                }
            }
        }
        this.dominationCount = count;
    }

    public int getDominationCount() {
        return this.dominationCount;
    }

    public static void main(String[] args) {
        Car car = new Car("Maserati", "Ghibili", 22, 2019, 78000);
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Mileage: " + car.getMileage());
        System.out.println("Year: " + car.getYear());
        System.out.println("Price: " + car.getPrice());

    }

}