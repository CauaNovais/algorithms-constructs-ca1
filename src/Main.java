import java.time.LocalDate; // Importing because it will allows us to use Year Month and day without storing time or timezone
// it will suit well for the bestBefore info)
import java.time.format.DateTimeParseException; // Handle invalid date for exception handling, follow format YYYY-MM-DD
import java.util.Scanner; // Reads the user's input from the console.

// Console interface for managing food storage.
// FoodStack handles storage operations; FoodItem validates food details.
public class Main {
    public static void main(String[] args) {
        
        // Refer to the storage through the interface;
        // Foodstack provides the stack behaviour.
        FoodStorage storage = new FoodStack();
        
        // Reads menu choices and food details typed by the user.
        Scanner scanner = new Scanner(System.in);

        // Create the loop for the menu, while true it keeps running. When choice 0, running becomes false, loop menu finishes.
        boolean running = true; 

        // Keep showing the menu until the user exits or input ends.
        while (running) {
            
            // Display the current number of stored trays and the capacity.
            System.out.println("\nFood Storage: " + storage.size() + "/" + storage.getCapacity() + "\n");
            
            // Display the menu options.
            System.out.println("1. Add food");
            System.out.println("2. Remove top food");
            System.out.println("3. View top food");
            System.out.println("4. Display all food");
            System.out.println("5. Search by name");
            System.out.println("0. Exit\n");
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
                        
                        // Ask for the food name; FoodItem validates it later.
                        System.out.print(
                                "Name (Burger/Pizza/Fries/Sandwich/Hotdog): ");

                        // Stop stafely if the console input has ended.
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

                        if (storage.add(item)) {
                            System.out.println("Added: " + item);
                        } else {
                            System.out.println("Storage is full.");
                        }
                        break;

                    case "2":
                        // LIFO: remove the most recently added tray.
                        FoodItem removed = storage.remove();
                        
                        //Checking if the item was removed properly, if it is already empty “Storage is empty” else “removed”
                        System.out.println(removed == null
                                ? "Storage is empty."
                                : "Removed: " + removed);
                        break;

                    case "3":
                        // View the top tray without removing it.
                        FoodItem top = storage.peek();

                        //Checking if the top is empty, else show the top
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

                        // The search function is defined in FoodStorage and implemented in FoodStack.
                        FoodItem found = storage.search(scanner.nextLine());

                        //Checking if the search was match with the item wanted, if null “Not found” else it shows it was found. 
                        System.out.println(found == null
                                ? "Food not found."
                                : "Found: " + found);
                        break;

                    case "0":
                        // Stop the menu loop.
                        running = false;
                        break;

                    // Any other input is not a valid menu option.
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

        // Release the input resource before program ends.
        scanner.close();
        System.out.println("Goodbye!");
    }
}
