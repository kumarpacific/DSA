package com.dsa.phase1.dp;

import java.util.Arrays;

public class Q0_Knapsack01_recursive {

    private static int[][] t;

    public static void main(String[] args) {
        int wt[] = {4, 5, 8, 9, 1};
        int v[] = {2, 4, 6, 4, 5};
        int w = 7;
        int n = wt.length;

        t = new int[n + 1][w + 1];
        t = Arrays.stream(t).map(row -> Arrays.stream(row).map(ele -> -1).toArray()).toArray(int[][]::new);

        // Memoization table: init with -1
//        t = Arrays.stream(new int[n + 1][w + 1])
//                .map(row -> Arrays.stream(row).map(ele -> -1).toArray())
//                .toArray(int[][]::new);

        //initialize array with -1
//        for(int i=0; i < n+1; i++){
//            for(int j=0; j<w+1; j++){
//             t[i][j] = -1;
//            }
//        }
        int maxProfit = knapsack(wt, v, w, n);
        System.out.println("MAX PROFIT: " + maxProfit);
    }

    /**
     * 0-1 Knapsack using recursion
     */
    private static int knapsack(int[] wt, int[] v, int w, int n) {

        // initialization
        // Base case: no items left or no capacity left
        if (n == 0 || w == 0) {
            return 0;
        }
        // Check if the result is already in the memoize t array
        if (t[n][w] != -1) {
            return t[n][w];
        }
        if (w >= wt[n - 1]) {
            // Otherwise, we have two choices:
            // 1. Include the nth item
            // 2. Exclude the nth item
            // we will choose the max among them since we want to maximize the price.
            t[n][w] = Math.max(v[n - 1] + knapsack(wt, v, w - wt[n - 1], n - 1), knapsack(wt, v, w, n - 1));
        } else {
            // If the weight of the nth item is more than the capacity, it cannot be included
            t[n][w] = knapsack(wt, v, w, n - 1);
        }

        return t[n][w];
    }
}
