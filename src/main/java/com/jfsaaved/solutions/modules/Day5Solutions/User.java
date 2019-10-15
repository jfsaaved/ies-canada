package com.jfsaaved.solutions.modules.Day5Solutions;

public class User {

    private int id;
    private String username;
    private String preferredPayment;
    private ShoppingCart shoppingCart;

    public User(int id, String username, String preferredPayment) {
        this.id = id;
        this.username = username;
        this.preferredPayment = preferredPayment;
        this.shoppingCart = new ShoppingCart(this);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPreferredPayment() {
        return preferredPayment;
    }

    public void setPreferredPayment(String preferredPayment) {
        this.preferredPayment = preferredPayment;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

}
