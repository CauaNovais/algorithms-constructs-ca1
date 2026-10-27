import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

// Console interface for managing food storage.
// FoodStack handles storage operations; FoodItem validates food details.
public class Main {
    public static void main(String[] args) {
        FoodStack storage = new FoodStack();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        // Keep showing the menu until the user exits or input ends.
        while (running) {
            System.out.println("\nFood Storage — " + storage.size() + "/8");
            System.out.println("1. Add food");
            System.out.println("2. Remove top food");
            System.out.println("3. View top food");
            System.out.println("4. Display all food");
            System.out.println("5. Search by name");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            // End gracefully if no more console input is available.
            if (!scanner.hasNextLine()) {
                break;
            }

            // Reading text allows invalid menu choices to be handled safely.
            String choice = scanner.nextLine().trim();

            // Handle invalid input and return to the menu.
            try {
                switch (choice) {
                    case "1":
                        // Check capacity before asking for food details.
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

                        // Convert the entered text to a numeric weight.
                        double weight = Double.parseDouble(
                                scanner.nextLine().trim());

                        System.out.print("Best-before date (YYYY-MM-DD): ");

                        if (!scanner.hasNextLine()) {
                            running = false;
                            break;
                        }

                        // Parse the date; invalid dates are handled below.
                        LocalDate date = LocalDate.parse(
                                scanner.nextLine().trim());

                        // FoodItem validates the values and records the time.
                        FoodItem item = new FoodItem(name, weight, date);

                        if (storage.push(item)) {
                            System.out.println("Added: " + item);
                        } else {
                            System.out.println("Storage is full.");
                        }
                        break;

                    case "2":
                        // LIFO: remove the most recently added tray.
                        FoodItem removed = storage.pop();

                        System.out.println(removed == null
                                ? "Storage is empty."
                                : "Removed: " + removed);
                        break;

                    case "3":
                        // View the top tray without removing it.
                        FoodItem top = storage.peek();

                        System.out.println(top == null
                                ? "Storage is empty."
                                : "Top: " + top);
                        break;

                    case "4":
                        // Display every tray from top to bottom.
                        storage.display();
                        break;

                    case "5":
                        // Search by name without changing stack order.
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
                        // Stop the menu loop.
                        running = false;
                        break;

                    default:
                        System.out.println("Choose 0, 1, 2, 3, 4 or 5.");
                }
            } catch (NumberFormatException e) {
                // The weight input could not be converted to a number.
                System.out.println("Enter a valid number for weight.");
            } catch (DateTimeParseException e) {
                // The date format or calendar date is invalid.
                System.out.println(
                        "Enter a real date in YYYY-MM-DD format.");
            } catch (IllegalArgumentException e) {
                // Show validation errors from FoodItem or the search method.
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }
}