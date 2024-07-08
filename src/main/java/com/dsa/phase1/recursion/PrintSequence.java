package com.dsa.phase1.recursion;

public class PrintSequence {

    public static void main(String[] args) {
        int i = 5;
        print(i);
        reversePrint(i);
    }

    private static void print(int i) {
        if(i==0) return;

        print(i-1);
        System.out.println(i);
    }

    private static void reversePrint(int i) {

        //Base case - this is needed to end the recursion.
        if(i==0) return;

        System.out.println(i);
        //Before section, this area will be executed before new stack creation.
        reversePrint(i-1);
        //After section, this area will be executed after method execution.
    }
}
