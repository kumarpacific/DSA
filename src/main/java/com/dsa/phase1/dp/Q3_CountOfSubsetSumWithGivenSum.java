package com.dsa.phase1.dp;

// how many subsets are there, which sum are equal to the given sum.
public class Q3_CountOfSubsetSumWithGivenSum {
    public static void main(String[] args) {
        int[] items = {2, 3, 5, 6, 8, 10, 4};
        int sum = 10;
        // {2,3,5}{2,8}{10} = 3

        int result = getCountOfSubsetSumWithGivenSum(items, sum);
        System.out.println("Count Of Subset Sum With Given Sum : " + result);
    }

    private static int getCountOfSubsetSumWithGivenSum(int[] items, int sum) {
        int n = items.length;
        int dp[][] = new int[n + 1][sum + 1];

        //initialization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                // sum=0, and with
                if (i == 0) {
                    dp[i][j] = 0;
                }
                // for sum = 0, empty subset is possible so 1
                if (j == 0) {
                    dp[i][j] = 1;
                }
            }
        }

        // Populate the dp matrix, it will store the sub problems solution and refer later.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (items[i - 1] <= j) {
                    // include + exclude
                    dp[i][j] = dp[i - 1][j - items[i - 1]] + dp[i - 1][j];
                } else {
                    // exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
