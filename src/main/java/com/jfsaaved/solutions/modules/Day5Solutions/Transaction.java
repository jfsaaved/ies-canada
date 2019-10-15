package com.jfsaaved.solutions.modules.Day5Solutions;

public class Transaction {

    private int id;
    private User user;
    private Item item;
    private String paymentMethod;

    public Transaction(int id, User user, Item item) {
        this.user = user;
        this.item = item;
        this.paymentMethod = user.getPreferredPayment();
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
