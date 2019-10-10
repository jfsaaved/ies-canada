package com.jfsaaved.solutions;

public class Day3Solutions {

    public Day3Solutions(){

    }

    public int[] bubbleSort(int[] input) {
        for(int i = 0 ; i < input.length; i ++) {
            for(int j = 0 ; j < input.length; j++) {
                if(input[i] < input[j]){
                    int tmp = input[i];
                    input[i] = input[j];
                    input[j] = tmp;
                }
            }
        }
        return input;
    }

    public int[] mergeSort(int[] unsortedArr) {



        return new int[] {0};
    }

    public int[] mergeSort(int[] unsortedArr, int l, int r) {
        return new int[] {0};
    }

    public void quickSort(int[] unsortedArr) {

    }

    private boolean isSorted(int[] input){
        boolean result = true;
        int[] sortedArr = bubbleSort(input);
        for(int i = 0 ; i < input.length && result; i ++){
            if(input[i] != sortedArr[i]) result = false;
        }
        return result;
    }

    public int binarySearch(int[] sortedArr, int input) {

        int top = sortedArr.length-1;
        int bottom = 0;

        if(!isSorted(sortedArr)) {
            System.out.println(this.getClass() + " binarySearch(int], int) : Array not sorted");
            return -1;
        }

        if(input < sortedArr[bottom] || input > sortedArr[top]) {
            System.out.println(this.getClass() + " binarySearch(int], int) : Not found");
            return -2;
        }

        boolean doesNotExist = false;
        int result = (sortedArr.length/2 + sortedArr.length%2) - 1;
        // 0 1 2 3 4  5  6
        // 1 3 5 8 10 15 18, index of 14?
        for(int i = result; !doesNotExist && sortedArr[i] != input; ) {
            if(input > sortedArr[i]) {
                if(input < sortedArr[i+1]) doesNotExist = true; // If input is in between middle and its immediate right
                else {
                    bottom = i+1; // Change top
                    i = ((i+1) + (top)) / 2; // Change middle
                }
            }
            else if (input < sortedArr[i]) {
                if(input > sortedArr[i-1]) doesNotExist = true; // If input is in between middle and to its immediate left
                else {
                    top = (i-1); // Change top
                    i = (bottom + (i - 1)) / 2; // Chane middle
                }
            }
            result = i;
        }

        if(doesNotExist) {
            System.out.println(this.getClass() + " binarySearch(int], int) : Not found");
            return -2;
        }

        else return result;

    }

    public int binarySearchRecursive(int[] sortedArr, int input)  {

        return 0;
    }

}
