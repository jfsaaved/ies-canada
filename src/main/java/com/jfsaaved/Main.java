package com.jfsaaved;

import com.jfsaaved.solutions.*;
import com.jfsaaved.solutions.modules.Day5Solutions.Item;
import com.jfsaaved.solutions.modules.Day5Solutions.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;

//@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        //SpringApplication.run(Main.class, args);

        System.out.println("DAY 1 ----------------------------------------------------------------");

        Day1Solutions day1 = new Day1Solutions();
        System.out.println("9.2 1. Given the declaration\n" +
                "String s = \"Amanda Chui\";\n" +
                "find the value of each expression.");
        Iterator day1Q1Iterator = day1
                .getQ1Answers()
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, String>comparingByKey(Comparator.naturalOrder()))
                .iterator();
        while(day1Q1Iterator.hasNext()){
            System.out.println(day1Q1Iterator.next());
        }

        System.out.println("------------------------------------------");

        System.out.println("9.2. 3. Assuming that the string name has the value \"Avi Laurie\", find the value of each expression.");
        Iterator day1Q2Iterator = day1
                .getQ2Answers()
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, String>comparingByKey(Comparator.naturalOrder()))
                .iterator();
        while(day1Q2Iterator.hasNext()){
            System.out.println(day1Q2Iterator.next());
        }

        System.out.println("------------------------------------------");

        System.out.println("9.2. 4. Complete the definition of the method count \n" +
                "so that it returns the number of occurrences of the character c in the string s. \n" +
                "public static int count (char c, String s) \n" +
                "Declaring: count(\'c\',\"Saavedra\")");

        System.out.println(day1.count('a', "Saavedra"));

        System.out.println("------------------------------------------");

        System.out.println("9.2. 5. Complete the definition of the method replace so that it returns\n" +
                "a string in which all occurrences of oldChar in the string s are replaced by newChar.\n" +
                "public static String replace (String s, char oldChar, char newChar)\n" +
                "Declaring: replace(\"Saavedra\",'a','b')");

        System.out.println(day1.replace("Saavedra",'a','b'));

        System.out.println("------------------------------------------");

        System.out.println("9.2 7. A hetero-literal word pair is defined as a pair of words having no letters in common.\n" +
                "As examples, \"TERRY\" and \"FOX\" form a hetero-literal word pair\n" +
                "\"WAYNE\" and \"GRETZKY\" do not (because of the ’E’ and ’Y’ in each word).\n" +
                "Write a method called isHeteroPair that has two String parameters, wordA and wordB. The method should return a boolean value:\n" +
                "true if wordA and wordB form a hetero-literal word pair and false if they do not. You may assume that all characters are uppercase letters.\n" +
                "Declaring: isHeteroPair(\"TERRY\", \"FOX\")");
        System.out.println(day1.isHeteroPair("TERRY", "FOX"));
        System.out.println("------------------------------------------");

        System.out.println("DAY 2 ----------------------------------------------------------------");
        Day2Solutions day2Solutions = new Day2Solutions();
        System.out.println("Write a method that reverses a string \n" +
                "Declaring reverseString(Saavedra)");
        System.out.println(day2Solutions.reverseString("Saavedra"));
        System.out.println("------------------------------------------");
        System.out.println("Write a method that compare 2 strings and return a Boolean (True / False)\n"+
                "Declaring isEquals(Hello World, Hello world)");
        System.out.println(day2Solutions.isEquals("Hello World", "Hello world"));
        System.out.println("------------------------------------------");
        System.out.println("Write a method that identify a palindrome word and return a Boolean (True / False) \n"+
                "Declaring palindrome(racecar)");
        System.out.println(day2Solutions.isPalindrome("racecar"));
        System.out.println("------------------------------------------");
        System.out.println("Write a method that split a string based on a particular Character and return a Strings Array. \n"+
                "Declaring split(test this is a test, ' ')");
        String[] test = day2Solutions.split("test this is a test ", ' ');
        for(String str : test)
            System.out.println(str);
        System.out.println("------------------------------------------");
        System.out.println("Write a method that split a string based on a particular Pattern and return a Strings Array. \n"+
                "Declaring split(is this is a test, 'is')");
       String[] test2 = day2Solutions.splitPattern("is this is a test", "is");
        for(String str : test2)
            System.out.println(str);
        System.out.println("------------------------------------------");

        System.out.println("DAY 3 ----------------------------------------------------------------");
        Day3Solutions day3Solutions = new Day3Solutions();
        int input = 10;
        int[] unsorted = new int[] {1,5,3,4,2,6,10,12,13,18,19,20,22,83,50,44};
        String unsortedString = "";
        int count = 0;
        for(int i : unsorted) {
            unsortedString += count+":[" + i + "] ";
            count++;
        }
        int[] sorted = day3Solutions.bubbleSort(unsorted);
        String sortedString = "";
        count = 0;
        for(int i : sorted) {
            sortedString += count+":[" + i + "] ";
            count++;
        }
        System.out.println("Running bubbleSort with array " + unsortedString);
        System.out.println(sortedString);
        System.out.println("\n------------------------------------------");
        System.out.println("Looking for the index of "+ input +" on array " + sortedString);
        System.out.println(day3Solutions.binarySearch(sorted,input));
        System.out.println("------------------------------------------");

        System.out.println("DAY 4 ----------------------------------------------------------------");
        Day4Solutions day4Solutions = new Day4Solutions();
        day4Solutions.solveCubicEquation("2x^3+3x^2+4x+5");
        System.out.println("------------------------------------------");

        System.out.println("DAY 5 ----------------------------------------------------------------");
        Day5Solutions day5Solutions = new Day5Solutions(new User(0,"Julian Saavedra", "PayPal"));
        Item book = new Item(0,"Book", "A book for reading.", 10.00);
        Item laptop = new Item(1,"Laptop", "An expensive laptop", 1800.00);
        Item proteinShake = new Item(2,"Protein Shake Powder", "Mix with liquid to drink.", 70.00);
        day5Solutions.userPutsItemInShoppingCart(book);
        day5Solutions.userPutsItemInShoppingCart(laptop);
        day5Solutions.userPutsItemInShoppingCart(proteinShake);
        day5Solutions.userViewShoppingCart();
        day5Solutions.userRemoveItemFromShoppingCart(laptop);
        day5Solutions.userChecksOut();

    }

}
