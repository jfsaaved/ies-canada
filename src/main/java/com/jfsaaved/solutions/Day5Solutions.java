package com.jfsaaved.solutions;

import com.jfsaaved.solutions.modules.Day5Solutions.Item;
import com.jfsaaved.solutions.modules.Day5Solutions.ShoppingCart;
import com.jfsaaved.solutions.modules.Day5Solutions.Transaction;
import com.jfsaaved.solutions.modules.Day5Solutions.User;

import java.util.ArrayList;

public class Day5Solutions {

    private User user;

    public Day5Solutions(User user) {
        this.user = user;
        System.out.println("A user has been created: "+ this.user.getUsername());
        System.out.println("Total items in the shopping cart: " + this.user.getShoppingCart().getTotal());
        System.out.println();
    }

    public void userPutsItemInShoppingCart(Item item){
        this.user.getShoppingCart().addItem(item);
        System.out.println("User puts the following item into the shopping cart: " + item.getName());
        System.out.println("Total items in the shopping cart: " + this.user.getShoppingCart().getTotal());
        System.out.println();
    }

    public void userRemoveItemFromShoppingCart(Item item){
        this.user.getShoppingCart().removeItem(item);
        System.out.println("User removes the following item from the shopping cart: " + item.getName());
        System.out.println("Total items in the shopping cart: " + this.user.getShoppingCart().getTotal());
        System.out.println();
    }

    public void userViewShoppingCart(){
        System.out.println("User views their shopping cart: ");
        for(Item item : this.user.getShoppingCart().getItems()) {
            System.out.println("ID: " + item.getId());
            System.out.println("Item: " + item.getName());
            System.out.println("Price: $" + item.getPrice());
            System.out.println("Description: " + item.getDescription());
        }
        System.out.println("Total items in the shopping cart: " + this.user.getShoppingCart().getTotal());
        System.out.println();
    }

    public void userChecksOut(){
        ArrayList<Transaction> transactions = this.user.getShoppingCart().checkOut();
        System.out.println("User checks out the following items:");
        for(Transaction transaction : transactions) {
            System.out.println(transaction.getItem().getName()
                    + " payed through " + transaction.getPaymentMethod()
                    + " by " + transaction.getUser().getUsername());
        }
        System.out.println("Total items in the shopping cart: " + this.user.getShoppingCart().getTotal());
        System.out.println();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
