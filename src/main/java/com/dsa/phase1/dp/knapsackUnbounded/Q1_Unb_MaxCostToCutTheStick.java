package com.dsa.phase1.dp.knapsackUnbounded;

public class Q1_Unb_MaxCostToCutTheStick {
    public static void main(String[] args) {
        int[] cuts = {1, 3, 4, 5};
        int[] price = {2, 4, 4, 6};
        int w = 8;

        int maxProfit = getMaxProfit(cuts, price, cuts.length, w);
        System.out.println("Max Profit :: " + maxProfit); // Ans :16 if we cut 1 pieces 8 times and sell for 2 each.
    }

    private static int getMaxProfit(int[] cuts, int[] prices, int n, int w) {
        int dp[][] = new int[n + 1][w + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (cuts[i - 1] <= j) {
                    dp[i][j] = Math.max(prices[i - 1] + dp[i][j - cuts[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][w];
    }
}
