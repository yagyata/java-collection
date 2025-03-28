package com.bridgelabz.extraProjects;
import java.util.*;

class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private Map<String, Double> cartByInsertion = new LinkedHashMap<>();
    private TreeMap<Double, List<String>> cartByPrice = new TreeMap<>();

    public void addProduct(String name, double price) {
        productPrices.put(name, price);
    }

    public void addToCart(String product) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }
        double price = productPrices.get(product);
        cartByInsertion.put(product, price);

        cartByPrice.putIfAbsent(price, new ArrayList<>());
        cartByPrice.get(price).add(product);
    }

    public void removeFromCart(String product) {
        if (!cartByInsertion.containsKey(product)) {
            System.out.println("Product not in cart: " + product);
            return;
        }
        double price = cartByInsertion.remove(product);
        cartByPrice.get(price).remove(product);
        if (cartByPrice.get(price).isEmpty()) {
            cartByPrice.remove(price);
        }
    }

    // Calculate total cost
    public double getTotalCost() {
        double total = 0;
        for (double price : cartByInsertion.values()) {
            total += price;
        }
        return total;
    }

    public void displayCartByInsertion() {
        System.out.println("Cart (Insertion Order): " + cartByInsertion);
    }

    public void displayCartByPrice() {
        System.out.println("Cart (Sorted by Price): " + cartByPrice);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 60000);
        cart.addProduct("Camera", 40000);
        cart.addProduct("Phone", 25000);
        cart.addProduct("Speaker", 3000);
        cart.addProduct("Mouse", 900);

        cart.addToCart("Phone");
        cart.addToCart("Laptop");
        cart.addToCart("Mouse");
        cart.addToCart("Camera");

        cart.displayCartByInsertion();
        cart.displayCartByPrice();

        System.out.println("Total Cost: " + cart.getTotalCost());

        cart.removeFromCart("Camera");

        cart.displayCartByInsertion();
        cart.displayCartByPrice();
        System.out.println("Updated Total Cost: " + cart.getTotalCost());
    }
}

