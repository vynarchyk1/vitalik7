import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
    }
}
