package com.dsa.phase1.dp;

import java.util.Arrays;

public class Q2_EqualSumPartition {
    public static void main(String[] args) {
        int[] items = {2, 3, 5, 6, 6, 16};

        boolean isExist = isEqualPartitionExist(items);
        System.out.println("Is equal partition exist : " + isExist);
    }

    private static boolean isEqualPartitionExist(int[] items) {
        int sum = 0;
//        sum = Arrays.stream(items).reduce(0, Integer::sum);     // another way to do sum of an array
        sum = Arrays.stream(items).sum();
        if (sum % 2 != 0) {
            return false;
        }

        int n = items.length;
        int eps = sum / 2; // equalPartitionSum
        boolean[][] dp = new boolean[n + 1][eps + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= eps; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= eps; j++) {
                if (items[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - items[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][eps];
    }
}
