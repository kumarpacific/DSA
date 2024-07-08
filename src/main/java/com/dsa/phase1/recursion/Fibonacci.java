package com.dsa.phase1.recursion;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the count of series: ");
        int n = sc.nextInt();
        printFibonacciSeries(a,b,n);

    }

    private static void printFibonacciSeries(int a, int b, int n) {

        // Base condition
        if(n == 0) {
            return;
        }

        // print the series, before part will print in ascending.
        System.out.println(a);

        // swapping the values of a and b with the fibonacci series.
        int c = a+b;
        a=b;
        b=c;
        printFibonacciSeries(a,b,n-1); // recursion call.
    }



}
