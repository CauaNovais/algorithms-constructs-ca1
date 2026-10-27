import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FoodStack storage = new FoodStack();

        FoodItem burger = new FoodItem(
                "Burger", 250, LocalDate.now().plusDays(7)
        );

        FoodItem pizza = new FoodItem(
                "Pizza", 500, LocalDate.now().plusDays(3)
        );

        storage.push(burger);
        storage.push(pizza);

        System.out.println("Size: " + storage.size());
        System.out.println("Top: " + storage.peek().getName());

        FoodItem removed = storage.pop();
        System.out.println("Removed: " + removed.getName());
        System.out.println("Top after removal: "
                + storage.peek().getName());

        storage.pop();

        System.out.println("Empty: " + storage.isEmpty());
        System.out.println("Pop from empty: " + storage.pop());
        System.out.println("Peek from empty: " + storage.peek());
    }
}