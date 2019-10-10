package com.jfsaaved.solutions;

public class Day2Solutions {

    public Day2Solutions() {

    }

    public String reverseString(String inputString) {
        String result = "";
        int j = 0;
        int evenOrOdd = (inputString.length() % 2);
        int middle = (inputString.length() / 2) + evenOrOdd;
        /*
        SAAVEDRA = 8, middle IS 4 which is E
        EV 4 - 43
        DA 5 - 5432
        RA 6 - 654321
        AS 7 - 76543210

        SAAVDRA = 7, middle is 4 which is D
        V 4 - 3
        DA 5 - 432
        RA 6 - 54321
        AS 7 - 6543210
         */
        for(int i = middle ; i < inputString.length() + evenOrOdd; i++) {
            if(i == middle) { // On first iteration
                if(evenOrOdd == 0) result = inputString.charAt(middle) + "" + inputString.charAt(middle - 1); // If it's even, we add to elements in the middle
                else result += inputString.charAt(middle - 1); // If it's odd, we add an element in the middle
            } else result = inputString.charAt(middle + j - evenOrOdd) + result + inputString.charAt(middle - j - 1);
            j++;
        }

        return result;
    }

    public boolean isEquals(String s1, String s2) {
        boolean result = true;
        if(s1.length() != s2.length())
            result = false;
        for(int i = 0 ; i < s1.length() && result; i++){
            for(int j = 0 ; j < s2.length() && result; j++){
                if(s1.charAt(i) != s2.charAt(j))
                    result = false;
            }
        }
        return  result;
    }

    public boolean isPalindrome(String inputString) {
        boolean result = true;
        int middle = (inputString.length()/2) + (inputString.length()%2);
        int evenOrOdd = inputString.length()%2;
        int j = 0;

        for(int i = middle; i < (inputString.length() + evenOrOdd) && result; i ++) {
            // At first iteration, if it's an even number, check both characters
            if(i == middle && evenOrOdd == 0 && inputString.charAt(middle) != inputString.charAt(middle - 1)) result = false;
            // Otherwise check the next characters
            else if(inputString.charAt(middle + j - evenOrOdd) != inputString.charAt(middle - j - 1)) result = false;
            j++;
        }

        return result;
    }

    public String[] split(String inputString, char c) {
        /*
            Possible combos
            Y*test : size should be 1
            testY* : size should be 1
            testY*test : 1 set of token, array size of 2
            Y*testY*test : 2 sets of tokens array size of 2
            saavedraYYYsaavedraYYsaa
         */
        //Part 1 Get the size of the array
        int sizeOfResult = 0;
        for(int i = 0; i < inputString.length(); i++) { // Iterate
            if(inputString.charAt(i) != c){ // Non token encounter
                sizeOfResult++; // For every start of non-token, we increase size of array
                i = inputString.indexOf(c, i); // Skip to the next index of token
                if(i == -1) i = inputString.length() + 1; // Token at the end or no tokens left, exit the loop
            }
        }

        //Part 2
        String[] result = new String[sizeOfResult];
        int index = 0; // Index of result array
        for(int j = 0 ; j < inputString.length() ; j ++){ // Iterate
            if(inputString.charAt(j) != c) { // For every start of non-token, get the substring from this index until the next token
                if(inputString.indexOf(c,j) != -1) { // Check if there is still a token
                    result[index] = inputString.substring(j, inputString.indexOf(c, j));
                    j = inputString.indexOf(c, j);
                    index++;
                }
                else { // Means no more token, we have reached the end, add the final substring
                    result[index] = inputString.substring(j);
                    j = inputString.length() + 1; // End the loop
                }
            }
        }

        return result;
    }

    public String[] splitPattern(String inputString, String c) {

        int sizeOfArray = 0;
        String[] splitBySpace = split(inputString, ' ');
        for(int i = 0 ; i < splitBySpace.length ; i ++) {
            if (!splitBySpace[i].equals(c)) // For patterns testY* and Y*test, we increment sizeOfArray
                if(i == 0 || splitBySpace[i-1].equals(c))
                    sizeOfArray++;
        }

        // yyz
        // julian yyz yyz yyz saavedra saavedra yyz
        int index = -1;
        boolean switched = true;
        String[] result = new String[sizeOfArray];
        for(int i = 0; i < splitBySpace.length; i++){ // Go through the whole array
            if(!splitBySpace[i].equals(c)) { // If the current entry is not similar to the pattern
                if(switched) { // Check if we are at the beginning / recently encountered the pattern
                    index++; // Increase by 1
                    switched = false; // Switch off to avoid increasing index
                }
                if(result[index] == null) result[index] = splitBySpace[i];
                else result[index] = result[index] + " " + splitBySpace[i];
            } else { // We have encountered the pattern
                switched = true;
            }
        }
        return result;
    }

}
