# Fast Food Storage System

Java consolte application developed for the Algorithms and Constructs CA 1 at CCT college Dubling. 
It manages up to eight food trays in a fast-food restaurant storage unit.

## Data Structure

The storage is implemented at a fixe-size, array-based stack.
Trays are added and removed through the same opening, following the Last In, First Out (LIFO) principle.
Add, remove and peek run in o(1) time; display runs in O(n); 
search runs in o(1) in the best case and O(n) in the worst case.

##Features

- Add a food item with name, weight and best-before date
- Remove the top item
- View the top item without removing it
- Display all items from top to bottom
- Search for an item by name, ignoring letter case
- Input validation for names, weights, dates and menu options

## Class structure

- `FoodStorage`: interface defining the storage operations
- `FoodStack`: stack implementation of FoodStorage
- `FoodProduct`: abstract parent class holding the name weight
- `FoodItem`: child class adding the best-before date and storage time
- `Main`: console menu that interacts with the user

# How to run
Open the project in Apache Netbeans and run it (F6).

## Testing

Manual test results are documented in [TESTING.md](TESTING.md).

## Team

- Caua Novais da Silva
- Tilek Ulan Uulu
- Yasmin Luize Nogueira Moura