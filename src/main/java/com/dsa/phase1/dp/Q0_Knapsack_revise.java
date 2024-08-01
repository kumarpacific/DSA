package com.dsa.phase1.dp;

import java.util.Arrays;

public class Q0_Knapsack_revise {

    static int t[][];

    public static void main(String[] args) {
        int wt[] = {4, 5, 8, 9, 1};
        int v[] = {2, 4, 6, 4, 5};
        int w = 7;
        int n = wt.length;

        t = Arrays.stream(new int[n+1][w+1]).map(row -> Arrays.stream(row).map(e-> -1).toArray()).toArray(int[][]::new);
        int maxProfit = knapsack_recursive(wt,v,n,w);
        int maxProfit_matrix = knapsack_iterative(wt, v,n,w);
        System.out.println("recursive :"+ maxProfit);
        System.out.println("iterative :"+ maxProfit_matrix);
    }

    private static int knapsack_iterative(int[] wt, int[] v, int n, int w) {

        int [][] dp = new int[n+1][w+1];

        for(int i = 0; i<=n; i++){
            for(int j= 0; j<=w; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }else if(wt[i-1] <= j){
                    dp[i][j] = Math.max(v[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];

    }

    private static int knapsack_recursive(int[] wt, int[] v, int n, int w) {
        if(n == 0 || w == 0){
            return 0;
        }
        if(t[n][w] != -1){
            return t[n][w];
        }

        if(wt[n-1] <= w){
             t[n][w] = Math.max(v[n-1] + knapsack_recursive(wt, v, n-1, w- wt[n-1]) , knapsack_recursive(wt, v, n-1, w));
        }
        else{
             t[n][w] = knapsack_recursive(wt, v, n-1,w);
        }

        return t[n][w];
    }
}
