package com.capgeminitraining.day1;

import java.util.ArrayList;
import java.util.List;

// Abstract base class for warehouse items
abstract class WarehouseItem {
    private String name;
    private double price;

    // Constructor
    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayDetails();
}

// Concrete class for Electronics
class Electronics extends WarehouseItem {
    private String brand;

    public Electronics(String name, double price, String brand) {
        super(name, price);
        this.brand = brand;
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronics Item: " + getName() + ", Price: " + getPrice() + ", Brand: " + brand);
    }
}

// Concrete class for Groceries
class Groceries extends WarehouseItem {
    private String category;

    public Groceries(String name, double price, String category) {
        super(name, price);
        this.category = category;
    }

    @Override
    public void displayDetails() {
        System.out.println("Grocery Item: " + getName() + ", Price: " + getPrice() + ", Category: " + category);
    }
}

// Concrete class for Furniture
class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    @Override
    public void displayDetails() {
        System.out.println("Furniture Item: " + getName() + ", Price: " + getPrice() + ", Material: " + material);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items;

    // Constructor
    public Storage() {
        items = new ArrayList<>();
    }

    // Add item to storage
    public void addItem(T item) {
        items.add(item);
    }

    // Retrieve item from storage
    public T getItem(int index) {
        return items.get(index);
    }

    // Get all items in the storage
    public List<T> getAllItems() {
        return items;
    }

    // Display all items using wildcards
    public void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayDetails();
        }
    }
}

// Main class to test the Smart Warehouse System
public class SmartWarehouseSystem {
    public static void main(String[] args) {
        // Create some items
        Electronics phone = new Electronics("Smartphone", 699.99, "BrandX");
        Groceries apple = new Groceries("Apple", 0.99, "Fruit");
        Furniture chair = new Furniture("Chair", 49.99, "Wood");

        // Create a Storage instance for WarehouseItems
        Storage<WarehouseItem> storage = new Storage<>();

        // Add items to storage
        storage.addItem(phone);
        storage.addItem(apple);
        storage.addItem(chair);

        // Display all items in storage using wildcards
        System.out.println("Items in Storage:");
        storage.displayAllItems(storage.getAllItems());
    }
}
