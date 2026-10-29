//Defines the operations required by any food storage unit.
//Applies abstraction by separating what the storage does from
//how it is implemented. Classes such as FoodStack implement this
//contract, and Main refers only to this type, so a different
//structure (e.g stack or queue) coould be used without changing
//the console menu.

public interface FoodStorage {

    //Adds an item; returns false if the storage is full.
    boolean add (FoodItem item);
    
    //Removes and returns the next item; returns null if empty.
    FoodItem remove();
    
    //Returns the next item without removing it; null if empty.
    FoodItem peek();
    
    //Displays all store items without changing the storage.
    void display();
    
    //Returns the first item matching the name, or null.
    FoodItem search (String name);
    
    boolean isEmpty();
    
    boolean isFull();
    
    int size();
   
}