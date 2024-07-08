package com.dsa.phase1.dp;

/**
 * 0-1 Knapsack using recursion
 */
public class Knapsack01 {
    public static void main(String[] args) {
        int wt[] = {4, 5, 8, 9, 1};
        int v[] = {2, 4, 6, 4, 5};
        int w = 7;
        int n = wt.length;
        int maxProfit = solve(wt, v, w, n);
    }

    private static int solve(int[] wt, int[] v, int w, int n) {
        if (w == 0 || n == 0) {
            return 0;
        }

        return 0;
    }
}
