package com.dsa.phase1.dp.longestCommonSubsequence;

import java.util.Arrays;

// Memoized Code
public class LongestCommonSubsequence {
    private static int[][] dp;
    public static void main(String[] args) {
        String str1 = "adfg";
        String str2 = "abdcf";
        // ans will be adf so 3

        dp = new int[5][6];
        dp = Arrays.stream(dp).map(row -> Arrays.stream(row).map(el -> -1).toArray()).toArray(int[][]::new);

        int res = lcs(str1, str2, str1.length(), str2.length());
        System.out.println("LCS is of length :" + res);
    }

    private static int lcs(String str1, String str2, int n, int m) {
        //base condition
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = 1 + lcs(str1, str2, n - 1, m - 1);
        } else {
            return dp[n][m] = Math.max(lcs(str1, str2, n, m - 1), lcs(str1, str2, n - 1, m));
        }
    }
}
