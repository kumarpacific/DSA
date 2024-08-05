package com.dsa.phase1.dp;

import java.util.Arrays;

public class Q4_MinimumSubsetSumDifference {
    public static void main(String[] args) {
        int[] items = {1, 2, 7};

        int sol = getMinimumSubsetSumDifference(items);
        System.out.println("Minimum Subset Sum Difference : " + sol);
    }

    private static int getMinimumSubsetSumDifference(int[] items) {
        int min = Integer.MAX_VALUE;
        int n = items.length;
        int sum = Arrays.stream(items).sum();
        boolean[][] dp = new boolean[n + 1][sum + 1];
        int[] subsetSums = new int[sum/2];

        // initialization for sum =0 and no items in array
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        // Fill matrix for cases - if a subset exist for that sum
        for (int i = 1; i <= n; i++) {   // starting from 1 since 0 is already initialised
            for (int j = 1; j <= sum; j++) {   // starting from 1 since 0 is already initialised
                if (items[i - 1] <= j) {  // first index is 0 for items array, hence i-1
                    dp[i][j] = dp[i - 1][j - items[i - 1]] || dp[i - 1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        // Get the possible subset sum - based on that we will calculate subset sum
        for(int i=0; i<sum/2; i++){
            subsetSums[i] = dp[n][i] ? i : 0;
            min = Integer.min(min, sum - subsetSums[i] *2);
        }

        return min;
    }
}
