package com.dsa.phase1.recursion;

public class RecursiveLoop {
    public static void main(String[] args) {
        int n = 10;
        recLoop(n);
    }

    private static void recLoop(int n) {
        if (n == 0){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        recLoop(--n);
    }
}
