package com.dsa.phase1.dp.longestCommonSubsequence;

import java.util.Arrays;

public class LCS_DP_TopDown {
    static int dp[][];

    public static void main(String[] args) {
        String str1 = "abdcfg";
        String str2 = "abedcf";

        int len = lcs(str1, str2, str1.length(), str2.length());
        System.out.println("Length :: " + len);
    }

    private static int lcs(String str1, String str2, int m, int n) {
        dp = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    sb.append(str1.charAt(i-1));
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        System.out.println(sb);

        return dp[m][n];
    }
}
