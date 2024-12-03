package com.dsa.phase1.dp.longestCommonSubsequence;

import java.util.Arrays;

public class LongestCommonSubstring_TopDown {
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
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(sb);
        int res = Arrays.stream(dp).flatMapToInt(Arrays::stream).max()
                .orElseThrow(()-> new IllegalArgumentException("array is empty"));
        return res;
    }

    private static String getLCSString(int[][] dp, String s1, String s2){
        int i=s1.length(), j=s2.length();
        StringBuilder sb = new StringBuilder();
        while(i>0 || j>0){
            if (s1.charAt(i) == s2.charAt(j)){
                i--;
                j--;
                sb.append(dp[i][j]);
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){

                }
            }
        }
        return "";
    }
}
