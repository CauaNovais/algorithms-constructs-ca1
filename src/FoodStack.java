// Stores up to 8 food trays using LIFO:
// the last tray added is the first one removed.
//Implements the FoodStorage interface.
public class FoodStack implements FoodStorage {
    private static final int CAPACITY = 8;
    private final FoodItem[] items = new FoodItem[CAPACITY];

    // Index of the top tray; -1 indicates an empty stack.
    private int top = -1;

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
    
    @Override
    public boolean isFull() {
        return top == CAPACITY - 1;
    }

    @Override    
    public int size() {
        return top + 1;
    }

    // Push operation: adds a tray to the top in O(1) time.
    // Returns false if all 8 storage positions are occupied.
    public boolean add (FoodItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Food item is required.");
        }

        if (isFull()) {
            return false;
        }

        items[++top] = item;
        return true;
    }

    // Pop operation: removes and returns the top tray in O(1) time.
    // Returns null when storage is empty.
    @Override
    public FoodItem remove() {
        if (isEmpty()) {
            return null;
        }

        FoodItem removed = items[top];

        // Release the reference to the removed tray.
        items[top] = null;
        top--;

        return removed;
    }

    // Returns the top tray without removing it. Time complexity: O(1).
    // Returns null when storage is empty.
    @Override
    public FoodItem peek() {
        if (isEmpty()) {
            return null;
        }

        return items[top];
    }

    // Displays all trays from top to bottom without changing the stack.
    // Time complexity: O(n), where n is the number of stored trays.
    @Override
    public void display() {
        if (isEmpty()) {
            System.out.println("Storage is empty.");
            return;
        }

        System.out.println("Storage contents (top to bottom):");

        for (int i = top; i >= 0; i--) {
            System.out.println(items[i]);
        }
    }

    // Searches from top to bottom, ignoring letter case.
    // Returns the first matching tray, or null if none is found.
    // Best case: O(1). Worst case: O(n).    
    @Override 
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