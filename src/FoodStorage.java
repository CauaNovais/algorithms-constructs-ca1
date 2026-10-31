//Defines the operations required by any food storage unit.
//Applies abstraction by separating what the storage does from
//how it is implemented. Classes such as FoodStack implement this
//contract, and Main refers only to this type, so a different
//structure (e.g. stack or queue) could be used without changing
//the console menu.
public interface FoodStorage {

    // Adds an item; returns false if the storage is full.
    boolean add(FoodItem item);
    
    // Removes and returns the next item; returns null if empty.
    FoodItem remove();
    
    // Returns the next item without removing it, or null if empty.
    FoodItem peek();
    
    // Displays all stored items without changing the storage.
    void display();
    
    // Returns the first item matching the name, or null.
    FoodItem search(String name);
    
    // Returns true if no items are stored.
    boolean isEmpty();
    
    // Returns true if the storage has reached its capacity.
    boolean isFull();
    
    // Returns the number of items currently stored.
    int size();
    
    // Returns the maximum number of items the storage can hold.
    int getCapacity();
    
}