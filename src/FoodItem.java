import java.time.LocalDate;
import java.time.LocalDateTime;

public class FoodItem {
    private final String name;
    private final double weightGrams;
    private final LocalDate bestBefore;
    private final LocalDateTime storedAt;

    public FoodItem(String name, double weightGrams,
                    LocalDate bestBefore) {
        if (name == null) {
            throw new IllegalArgumentException("Food name is required.");
        }

        String cleanName = name.trim();

        boolean validName = cleanName.equalsIgnoreCase("Burger")
                || cleanName.equalsIgnoreCase("Pizza")
                || cleanName.equalsIgnoreCase("Fries")
                || cleanName.equalsIgnoreCase("Sandwich")
                || cleanName.equalsIgnoreCase("Hotdog");

        if (!validName) {
            throw new IllegalArgumentException(
                    "Choose Burger, Pizza, Fries, Sandwich or Hotdog.");
        }

        if (!Double.isFinite(weightGrams) || weightGrams <= 0) {
            throw new IllegalArgumentException(
                    "Weight must be a positive finite number.");
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();

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

    @Override
    public String toString() {
        return name + " | " + weightGrams + " g"
                + " | Best before: " + bestBefore
                + " | Stored at: " + storedAt;
    }
}