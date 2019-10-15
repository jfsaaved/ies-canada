package com.jfsaaved.solutions;

import org.springframework.jdbc.core.metadata.HsqlTableMetaDataProvider;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

public class Day4Solutions {

    public Day4Solutions () {

    }

    public void solveCubicEquation(String equation) {
        ArrayList<String> equationArr = new ArrayList<String>();
        Stack<String> rpn = new Stack<>();
        ArrayList<Character> operands = new ArrayList<>();
        String cur = "";

        // Add in the multiplications
        for(int i = 0; i < equation.length() ; i++) {
            if(Character.isDigit(equation.charAt(i))) cur = cur + equation.charAt(i); // If character at the index is a digit
            // we add it to cur, so that we accumulate double or more digits
            else { // if it's a letter
                if(!cur.equals("")){ // if cur (the digits) is not empty
                    equationArr.add(cur); // we add it to the equation
                    cur = ""; // reset it
                    if(Character.isLetter(equation.charAt(i))) equationArr.add("*"); // add the multiplication sign
                }
                equationArr.add((equation.charAt(i) + "")); // add the letter
            }
            if((i+1) == equation.length()) equationArr.add(cur); // add the left over cur at the end
        }

        // Translate to reverse polish notation
        for(String s : equationArr) {
            if(!isOperand(s.charAt(0))) { // if its a digit
                rpn.push(s); // push it to the stack
            } else { // otherwise (operand)
                operands.add(s.charAt(0)); // add it to operand list
                if(s.charAt(0) == '+'){ // if it's a plus sign
                    operands = arrangeOperands(operands); // arrange it
                    for(Character item : operands)
                        rpn.push(item + ""); // push the arranged operands to the end of the stack
                    operands = new ArrayList<>(); // reset operands list
                }
            }
        }

        Stack<String> result = calculate(rpn,2);

    }

    private boolean isOperand(char c) {
        if(c == '+' || c == '-' || c == '*' || c == '^' || c == '(' || c == ')')
            return true;
        else
            return false;
    }

    private  Stack<String> calculate(Stack<String> originalEquation, int x) {
        Stack<String> equation = new Stack<String>();
        while(!originalEquation.empty()) {
            equation.push(originalEquation.pop());
        }
        Stack<String> rpnCalculator = new Stack<>();
        int result = 0;
        while(!equation.empty()) {
            rpnCalculator.push(equation.pop());
            System.out.println(rpnCalculator);
            if(rpnCalculator.peek().equals("x")) {
                rpnCalculator.pop();
                rpnCalculator.push(x + "");
            }
            if(rpnCalculator.peek().equals("^")){
                rpnCalculator.pop();
                int base = Integer.parseInt(rpnCalculator.pop());
                int power = Integer.parseInt(rpnCalculator.pop());
                result = (int) Math.pow(power, base);
                rpnCalculator.push(result + "");
            }
            if(rpnCalculator.peek().equals("*")){
                rpnCalculator.pop();
                int first = Integer.parseInt(rpnCalculator.pop());
                int second = Integer.parseInt(rpnCalculator.pop());
                result = (int) first * second;
                rpnCalculator.push(result + "");
            }
        }
        return rpnCalculator;
    }

    private ArrayList<Character> arrangeOperands(ArrayList<Character> operands){
        ArrayList<Character> result = new ArrayList<>();
        boolean hasPlus = false;
        boolean hasMultiply = false;
        boolean hasPOW = false;
        for(Character c : operands ) {
            if(c == '^') hasPOW = true;
            if(c == '*') hasMultiply = true;
            if(c == '+') hasPlus = true;
        }
        if(hasPOW) result.add('^');
        if(hasMultiply) result.add('*');
        if(hasPlus) result.add('+');
        return result;
    }

}
