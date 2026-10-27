import java.time.LocalDate;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FoodStack storage = new FoodStack();

        storage.push(new FoodItem(
                "Burger", 250, LocalDate.now().plusDays(7)));
        storage.push(new FoodItem(
                "Pizza", 500, LocalDate.now().plusDays(3)));

        storage.display();

        FoodItem found = storage.search("burger");
        System.out.println("Search burger: "
                + (found == null ? "Not found" : found.getName()));

        FoodItem missing = storage.search("Fries");
        System.out.println("Search Fries: "
                + (missing == null ? "Not found" : missing.getName()));

        System.out.println("Size after search: " + storage.size());
        System.out.println("Top after search: "
                + storage.peek().getName());
    }
}