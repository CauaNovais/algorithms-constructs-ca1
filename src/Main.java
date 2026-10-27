import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Food Storage Application");

        FoodItem burger = new FoodItem(
                "Burger", 250, LocalDate.now().plusDays(7)
        );
        System.out.println(burger);

        try {
            FoodItem invalidFood = new FoodItem(
                    "Pizza", -100, LocalDate.now().plusDays(7)
            );
            System.out.println("FAIL: Invalid weight was accepted.");
        } catch (IllegalArgumentException e) {
            System.out.println("Validation: " + e.getMessage());
        }
    }
}