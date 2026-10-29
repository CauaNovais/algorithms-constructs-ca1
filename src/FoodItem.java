import java.time.LocalDate; //(For the use of dates)
import java.time.LocalDateTime; //(For the use of dates and time good for log)

// Represents one food tray and its storage details.
// Fields cannot be changed after the object is created.
public class FoodItem {
    private final String name;
    private final double weightGrams;
    private final LocalDate bestBefore;
    private final LocalDateTime storedAt;

    // Validate the supplied details before creating a food item.
    public FoodItem(String name, double weightGrams,
                    LocalDate bestBefore) {
        if (name == null) {
            throw new IllegalArgumentException("Food name is required.");
        }

        // Remove surrounding spaces and accept names regardless of case.
        String cleanName = name.trim();

        //Checking the clean name ignoring the case, if they match with the 5 options of food
        boolean validName = cleanName.equalsIgnoreCase("Burger")
                || cleanName.equalsIgnoreCase("Pizza")
                || cleanName.equalsIgnoreCase("Fries")
                || cleanName.equalsIgnoreCase("Sandwich")
                || cleanName.equalsIgnoreCase("Hotdog");

        //If it does not match
        if (!validName) {
            throw new IllegalArgumentException(
                    "Choose Burger, Pizza, Fries, Sandwich or Hotdog.");
        }

        // Reject zero, negative values, NaN and infinity.
        if (!Double.isFinite(weightGrams) || weightGrams <= 0) {
            throw new IllegalArgumentException(
                    "Weight must be a positive finite number.");
        }

        // Use one timestamp for both date validation and storage time.
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();

        // Accept dates from today through 14 days ahead, inclusive.
        if (bestBefore == null
                || bestBefore.isBefore(today)
                || bestBefore.isAfter(today.plusDays(14))) {
            throw new IllegalArgumentException(
                    "Best-before date must be from today to 14 days ahead.");
        }

        this.name = cleanName;
        this.weightGrams = weightGrams;
        this.bestBefore = bestBefore;
        this.storedAt = now;
    }

    // Provide read access while keeping the fields private.
    public String getName() {
        return name;
    }

    public double getWeightGrams() {
        return weightGrams;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public LocalDateTime getStoredAt() {
        return storedAt;
    }

    // Produce a readable description for console output.
    @Override
    public String toString() {
        return name + " | " + weightGrams + " g"
                + " | Best before: " + bestBefore
                + " | Stored at: " + storedAt;
    }
}
