package com.jfsaaved.solutions.modules.Day5Solutions;

import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Item> items;
    private User user;

    public ShoppingCart(User user) {
        this.user = user;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item itemToRemove) {
        for(Item item : items) {
            if(item.getId() == itemToRemove.getId())
                items.remove(item);
        }
    }

    public ArrayList<Transaction> checkOut(){
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        int id = 0;
        for(Item item : items) {
            Transaction transaction = new Transaction(id, user, item);
            id++;
            transactions.add(transaction);
        }
        this.empty();
        return transactions;
    }

    public void empty(){
        items = new ArrayList<Item>();
    }

    public int getTotal() {
        return items.size();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public User getUser(){
        return this.user;
    }

}
