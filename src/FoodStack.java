public class FoodStack {
    private static final int CAPACITY = 8;
    private final FoodItem[] items = new FoodItem[CAPACITY];
    private int top = -1;

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == CAPACITY - 1;
    }

    public int size() {
        return top + 1;
    }

    public boolean push(FoodItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Food item is required.");
        }

        if (isFull()) {
            return false;
        }

        items[++top] = item;
        return true;
    }

    public FoodItem pop() {
        if (isEmpty()) {
            return null;
        }

        FoodItem removed = items[top];
        items[top] = null;
        top--;
        return removed;
    }

    public FoodItem peek() {
        if (isEmpty()) {
            return null;
        }

        return items[top];
    }    public void display() {
        if (isEmpty()) {
            System.out.println("Storage is empty.");
            return;
        }

        System.out.println("Storage contents (top to bottom):");

        for (int i = top; i >= 0; i--) {
            System.out.println(items[i]);
        }
    }

    public FoodItem search(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Search name is required.");
        }

        String searchName = name.trim();

        for (int i = top; i >= 0; i--) {
            if (items[i].getName().equalsIgnoreCase(searchName)) {
                return items[i];
            }
        }

        return null;
    }
}