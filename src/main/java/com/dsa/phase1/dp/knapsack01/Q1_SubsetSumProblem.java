package com.dsa.phase1.dp.knapsack01;

public class Q1_SubsetSumProblem {

    // check if subset sum exist of not
    public static void main(String[] args) {
        int[] arr = {2, 6, 7, 8, 10};
        int sum = 11;

        boolean result = isSubsetSumExist(arr, sum, arr.length);
        System.out.println("Is subset sum Exist :" + result);
    }

    private static boolean isSubsetSumExist(int[] arr, int sum, int n) {

        boolean[][] dp = new boolean[n + 1][sum + 1];

        // initialization
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

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}


