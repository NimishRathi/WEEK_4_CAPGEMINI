package com.capgeminitraining.day1;

// Base class for Product Categories
class ProductCategory {
    // A base class that can be extended by specific categories.
}

// Example category classes
class BookCategory extends ProductCategory {
    private String genre;

    public BookCategory(String genre) {
        this.genre = genre;
    }
}

class ClothingCategory extends ProductCategory {
    private String size;

    public ClothingCategory(String size) {
        this.size = size;
    }
}
// Generic Product class
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    // Constructor
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Method to apply discount
    public void applyDiscount(double percentage) {
        price -= price * (percentage / 100);
    }

    @Override
    public String toString() {
        return name + " (" + category.getClass().getSimpleName() + ") - $" + price;
    }
}

// A utility class for applying discounts
class DiscountUtility {

    // Generic method to apply a discount
    public static <T extends ProductCategory> void applyDiscount(Product<T> product, double percentage) {
        product.applyDiscount(percentage);
    }
}

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        // Create products from different categories
        Product<BookCategory> book = new Product<>("Java Programming Book", 50.00, new BookCategory("Programming"));
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 20.00, new ClothingCategory("M"));

        // Print products before discount
        System.out.println("Before Discount:");
        System.out.println(book);
        System.out.println(shirt);

        // Apply discounts
        DiscountUtility.applyDiscount(book, 10.0); // 10% discount on book
        DiscountUtility.applyDiscount(shirt, 15.0); // 15% discount on shirt

        // Print products after discount
        System.out.println("\nAfter Discount:");
        System.out.println(book);
        System.out.println(shirt);
    }
}
