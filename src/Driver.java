import java.util.ArrayList;
import java.util.Scanner;

class Driver {
    String name;
    int age;
    int drivingExperience;

    public Driver(String name, int age, int drivingExperience) {
        this.name = name;
        this.age = age;
        this.drivingExperience = drivingExperience;
    }
}

class Car {
    String brand;
    int enginePower;
    Driver driver;
    double price;
    int year;

    public Car(String brand, int enginePower, Driver driver, double price, int year) {
        this.brand = brand;
        this.enginePower = enginePower;
        this.driver = driver;
        this.price = price;
        this.year = year;
    }

    public void increasePowerAndPrice(double powerIncreasePercentage, double priceIncreasePercentage) {
        this.enginePower *= (1 + powerIncreasePercentage);
        this.price *= (1 + priceIncreasePercentage);
    }
}