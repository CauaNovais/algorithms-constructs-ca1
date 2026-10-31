/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author cauan
 */

// This is the parent class for our food products.
// It contains information that every food product should have.
public class FoodProduct {

    // These variables store the basic information about the food.
    // Private means they cannot be accessed directly from other classes.
    private final String name;
    private final double weightGrams;

    // Constructor: this runs when we create a new food product.
    public FoodProduct(String name, double weightGrams) {

        // Check that the user has entered a food name.
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Food name is required.");
        }

        // Weight must be greater than zero and must be a valid number.
        if (!Double.isFinite(weightGrams) || weightGrams <= 0) {
            throw new IllegalArgumentException(
                    "Weight must be a positive finite number.");
        }

        // Save the values after removing any extra spaces from the name.
        this.name = name.trim();
        this.weightGrams = weightGrams;
    }

    // Getter to allow child classes and other classes to read the name.
    public String getName() {
        return name;
    }

    // Getter to access the food weight.
    public double getWeightGrams() {
        return weightGrams;
    }
}