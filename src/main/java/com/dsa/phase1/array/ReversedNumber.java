package com.dsa.phase1.array;

public class ReversedNumber {

    public static void main(String[] args) {
        int number = 987654;

        ExtReverse rn = new ExtReverse();
        int[] reversedNumber = rn.reverseIt(number);
        for (int i : reversedNumber){

            System.out.print(i);
        }
    }

    public int[] reverseIt(int number) {

        int[] arr = new int[6];
        int i=0;
        while(number != 0){
            int t = number % 10;
            number = number /10;
            arr[i++] = t;
        }

        return arr;

    }
}

class ExtReverse extends ReversedNumber{

    public int[] reverseIt(int number) {
        int[] arr = new int[6];
        int i=0;
        while(number != 0){
            int t = number % 10;
            number = number /10;
            arr[i++] = 0;
        }

        return arr;

    }
}
