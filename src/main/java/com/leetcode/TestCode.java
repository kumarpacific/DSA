package com.leetcode;

public class TestCode {

    public static void main(String[] args) {

        int a = 10;
        int b = 0;

        // This will not throw an exception because b != 0 is never evaluated
        if (a > 0 || (b != 0 && a / b > 1)) {
            System.out.println("Condition is true.");
        }

    }
}
