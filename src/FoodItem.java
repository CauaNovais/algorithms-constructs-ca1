import java.time.LocalDate; //(For the use of dates)
import java.time.LocalDateTime; //(For the use of dates and time good for log)

// Represents one food tray and its storage details.
// FoodItem is a child class of FoodProduct.
// It inherits the food name and weight from the parent class.
public class FoodItem extends FoodProduct {

    // These details are specific to each food item.
    private final LocalDate bestBefore;
    private final LocalDateTime storedAt;

    // Constructor receives the food details when a new item is created.
    public FoodItem(String name, double weightGrams,
                    LocalDate bestBefore) {

        // super calls the parent constructor.
        // This also validates and stores the name and weight.
        super(name, weightGrams);

        // Get the cleaned name from the parent class.
        String cleanName = getName();

        // Only these five food types are accepted by our program.
        // equalsIgnoreCase allows uppercase and lowercase letters.
        boolean validName = cleanName.equalsIgnoreCase("Burger")
                || cleanName.equalsIgnoreCase("Pizza")
                || cleanName.equalsIgnoreCase("Fries")
                || cleanName.equalsIgnoreCase("Sandwich")
                || cleanName.equalsIgnoreCase("Hotdog");

        // If the name does not match any of the options, show an error.
        if (!validName) {
            throw new IllegalArgumentException(
                    "Choose Burger, Pizza, Fries, Sandwich or Hotdog.");
        }

        // Get the current date and time when the item is created.
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();

        // The best-before date cannot be in the past or more than 14 days ahead.
        if (bestBefore == null
                || bestBefore.isBefore(today)
                || bestBefore.isAfter(today.plusDays(14))) {

            throw new IllegalArgumentException(
                    "Best-before date must be from today to 14 days ahead.");
        }

        // Store the validated best-before date and the time the item was added.
        this.bestBefore = bestBefore;
        this.storedAt = now;
    }

    // Returns the best-before date of the food.
    public LocalDate getBestBefore() {
        return bestBefore;
    }

    // Returns the date and time when the food was added.
    public LocalDateTime getStoredAt() {
        return storedAt;
    }

    // This method controls how the food item appears when printed.
    // It also uses the inherited name and weight from FoodProduct.
    @Override
    public String toString() {
        return getName() + " | " + getWeightGrams() + " g"
                + " | Best before: " + bestBefore
                + " | Stored at: " + storedAt;
    }
}
