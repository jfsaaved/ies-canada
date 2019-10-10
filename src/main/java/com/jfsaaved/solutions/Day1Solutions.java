package com.jfsaaved.solutions;

import java.util.HashMap;


public class Day1Solutions {

    private HashMap<String, String> firstSet;
    private HashMap<String, String> secondSet;

    public Day1Solutions(){
        String s = "Amanda Chui";
        firstSet = new HashMap<String, String>();
        firstSet.put("(a) s.charAt(3)",s.charAt(3) + "");
        firstSet.put("(b) s.substring(8)",s.substring(8));
        firstSet.put("(c) s.length()",s.length() + "");
        firstSet.put("(d) s.indexOf('a')",s.indexOf('a') + "");
        firstSet.put("(e) s.charAt(0)",s.charAt(0) + "");
        firstSet.put("(f) s.substring(1,4)",s.substring(1,4));
        firstSet.put("(g) s.substring(1)",s.substring(1));
        firstSet.put("(h) s.indexOf('m',4)",s.indexOf('m',4) + "");
        firstSet.put("(i) s.charAt(4)",s.charAt(4) + "");
        firstSet.put("(j) s.substring(4,5)",s.substring(4,5));

        String name = "Avi Laurie";
        secondSet = new HashMap<String, String>();
        secondSet.put("(a) name.toLowerCase().indexOf(’a’)", name.toLowerCase().indexOf('a') + "");
        secondSet.put("(b) name.toUpperCase().charAt(5)", name.toUpperCase().charAt(5) + "");
        secondSet.put("(c) name.substring(3).indexOf(’i’)", name.substring(3).indexOf('i') + "");
        secondSet.put("(d) name.substring(2).toUpperCase()" , name.substring(2).toUpperCase());
        secondSet.put("(e) name.toUpperCase().indexOf(’A’,1)", name.toUpperCase().indexOf('A',1) + "");
        secondSet.put("(f) name.substring(name.indexOf(’ ’)+1).length()", name.substring(name.indexOf(' ')+1).length() + "");
    }

    public HashMap<String, String> getQ1Answers() {
        return firstSet;
    }

    public HashMap<String, String> getQ2Answers() {
        return secondSet;
    }

    public int count(char c, String s) {
        int counter = 0;
        for(char character : s.toCharArray()){
            if(character == c)
                counter++;
        }
        return counter;
    }

    public String replace(String s, char oldChar, char newChar) {
        StringBuilder sb = new StringBuilder();
        for(char character : s.toCharArray()) {
            if(character == oldChar)
                sb.append(newChar);
            else
                sb.append(character);
        }
        return sb.toString();
    }

    public boolean isHeteroPair(String s1, String s2) {
        boolean result = true;
        for(int i = 0; i < s1.length() && result; i++){
            for(int j = 0; j < s2.length() && result; j++){
                if(s1.charAt(i) == s2.charAt(j))
                    result = false;
            }
        }
        return result;
    }
}
