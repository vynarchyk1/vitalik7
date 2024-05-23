import java.util.ArrayList;
import java.util.Scanner;

public class TaxiService {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.println("Впишіть дані авто та дані водія:");
            System.out.print("Бренд автомобіля: ");
            String brand = scanner.nextLine();
            System.out.print("Потужність двигуна: ");
            int power = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Ім'я водія: ");
            String driverName = scanner.nextLine();
            System.out.print("Вік водія: ");
            int driverAge = scanner.nextInt();
            System.out.print("Досвід керування автомобілем: ");
            int drivingExp = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Ціна автомобіля: ");
            double price = scanner.nextDouble();
            System.out.print("Рік випуску: ");
            int year = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Driver driver = new Driver(driverName, driverAge, drivingExp);
            Car car = new Car(brand, power, driver, price, year);
            cars.add(car);
        }

        // Repair half of the fleet
        for (int i = 0; i < cars.size() / 2; i++) {
            Car car = cars.get(i);
            car.enginePower *= 1.1; // Increase engine power by 10%
            car.driver = new Driver("Новий Водій", 30, 5); // Assigning new driver
        }

        // Increase power and price of every second car
        for (int i = 0; i < cars.size(); i += 2) {
            Car car = cars.get(i);
            car.increasePowerAndPrice(0.1, 0.05); // Increase power by 10% and price by 5%
        }

        // Check and upgrade driver experience
        for (Car car : cars) {
            if (car.driver.drivingExperience < 5 && car.driver.age > 25) {
                car.driver.drivingExperience++;
            }
        }

        System.out.println("Випадковий автомобіль:");
        Car randomCar = getRandomCar(cars);
        System.out.println("Бренд автомобіля: " + randomCar.brand + ", Водій: " + randomCar.driver.name);
    }

    public static Car getRandomCar(ArrayList<Car> cars) {
        return cars.get((int) (Math.random() * cars.size()));
    }
}