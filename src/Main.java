import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Виберіть завдання:");
            System.out.println("1. Сервіс таксі");
            System.out.println("2. Телефонна книга");
            System.out.println("3. Вийти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    runTaxiService();
                    break;
                case 2:
                    runPhoneBook();
                    break;
                case 3:
                    System.out.println("До побачення!");
                    System.exit(0);
                default:
                    System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        }
    }

    public static void runTaxiService() {
        Scanner scanner = new Scanner(System.in);

        // Код для виконання завдання 1: Сервіс таксі
        System.out.println("Ви обрали завдання 1: Сервіс таксі");

        // Ваш код для завдання 1 починається тут


        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
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
        Car randomCar = TaxiService.getRandomCar(cars);
        System.out.println("Бренд автомобіля: " + randomCar.brand + ", Водій: " + randomCar.driver.name);

        // Кінець коду для завдання 1
        System.out.println("Натисніть Enter, щоб повернутися до меню.");
        scanner.nextLine(); // Очікуємо натискання Enter
    }

    public static void runPhoneBook() {
        Scanner scanner = new Scanner(System.in);

        // Код для виконання завдання 2: Телефонна книга
        System.out.println("Ви обрали завдання 2: Телефонна книга");

        // Ваш код для завдання 2 починається тут


        Map<String, String> phoneBook = new HashMap<>();

        // Add some entries to the phone book
        phoneBook.put("Захар Васильченко", "123-456-7890");
        phoneBook.put("Жилін Максим", "987-654-3210");
        phoneBook.put("Михайло задорожній", "555-123-4567");
        phoneBook.put("Віталій Винарчик", "111-222-3333");
        phoneBook.put("Остап Григорський", "444-555-6666");
        phoneBook.put("Корман Юрій", "777-888-9999");
        phoneBook.put("Воронцов Олександр", "666-777-8888");
        phoneBook.put("Станіслав Матейчук", "222-333-4444");
        phoneBook.put("Віталій Грацонь", "888-999-0000");
        phoneBook.put("Комарницеький Олександр", "333-444-5555");

        // Display all entries in the phone book
        System.out.println("Записи телефонної книги:");
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println("Ім'я: " + entry.getKey() + ", Телефон: " + entry.getValue());
        }

        // Search for a phone number by name
        System.out.print("Введіть ім'я абонента: ");
        String searchName = scanner.nextLine();
        if (phoneBook.containsKey(searchName)) {
            System.out.println("Номеер телефону абонента: " + searchName + ": " + phoneBook.get(searchName));
        } else {
            System.out.println("Нічого не знайдено! " + searchName);
        }

        // Remove a random entry from the phone book
        if (!phoneBook.isEmpty()) {
            String[] names = phoneBook.keySet().toArray(new String[0]);
            String randomName = names[(int) (Math.random() * names.length)];
            System.out.println("Видалити абонента: " + randomName);
            phoneBook.remove(randomName);
        }

        // Display the size of the phone book
        System.out.println("Кількість записів у телефонній книзі: " + phoneBook.size());

        // Кінець коду для завдання 2
        System.out.println("Натисніть Enter, щоб повернутися до меню.");
        scanner.nextLine(); // Очікуємо натискання Enter
    }
}
