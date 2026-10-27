import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FoodStack storage = new FoodStack();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\nFood Storage — " + storage.size() + "/8");
            System.out.println("1. Add food");
            System.out.println("2. Remove top food");
            System.out.println("3. View top food");
            System.out.println("4. Display all food");
            System.out.println("5. Search by name");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            if (!scanner.hasNextLine()) {
                break;
            }

            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        if (storage.isFull()) {
                            System.out.println("Storage is full.");
                            break;
                        }

                        System.out.print(
                                "Name (Burger/Pizza/Fries/Sandwich/Hotdog): ");
                        if (!scanner.hasNextLine()) {
                            running = false;
                            break;
                        }
                        String name = scanner.nextLine();

                        System.out.print("Weight in grams: ");
                        if (!scanner.hasNextLine()) {
                            running = false;
                            break;
                        }
                        double weight = Double.parseDouble(
                                scanner.nextLine().trim());

                        System.out.print("Best-before date (YYYY-MM-DD): ");
                        if (!scanner.hasNextLine()) {
                            running = false;
                            break;
                        }
                        LocalDate date = LocalDate.parse(
                                scanner.nextLine().trim());

                        FoodItem item = new FoodItem(name, weight, date);

                        if (storage.push(item)) {
                            System.out.println("Added: " + item);
                        } else {
                            System.out.println("Storage is full.");
                        }
                        break;

                    case "2":
                        FoodItem removed = storage.pop();
                        System.out.println(removed == null
                                ? "Storage is empty."
                                : "Removed: " + removed);
                        break;

                    case "3":
                        FoodItem top = storage.peek();
                        System.out.println(top == null
                                ? "Storage is empty."
                                : "Top: " + top);
                        break;

                    case "4":
                        storage.display();
                        break;

                    case "5":
                        System.out.print("Food name to search: ");
                        if (!scanner.hasNextLine()) {
                            running = false;
                            break;
                        }
                        FoodItem found = storage.search(scanner.nextLine());
                        System.out.println(found == null
                                ? "Food not found."
                                : "Found: " + found);
                        break;

                    case "0":
                        running = false;
                        break;

                    default:
                        System.out.println("Choose 0, 1, 2, 3, 4 or 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid number for weight.");
            } catch (DateTimeParseException e) {
                System.out.println(
                        "Enter a real date in YYYY-MM-DD format.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }
}