package com.dsa.phase1.dp.knapsack01;


import java.util.Arrays;

// Find how many subsets are possible with given difference
public class Q5_CountSubsetWithGivenDifference {
    public static void main(String[] args) {
        int[] items = {1, 1, 2, 3};
        int diff = 1;
        int result = getCountSubsetWithGivenDifference(items, diff); // here result should be 3
        System.out.println("Result : "+ result);
    }

    public static int getCountSubsetWithGivenDifference(int[] items, int diff) {
//        s1 - s2 = diff
//        s1 = diff + s2
//        s2 = (sum - diff)/2   => we need to find count of this one of the subset(s2 or s1) sum exist.

        int n = items.length;
        int sum = Arrays.stream(items).reduce(0, Integer::sum);
        int s2 = (sum + diff) / 2;
        int[][] dp = new int[n + 1][s2 + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= s2; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                }
                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s2; j++) {
                if (items[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - items[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][s2];
    }
}
