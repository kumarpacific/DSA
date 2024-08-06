package com.dsa.phase1.dp.knapsack01;

public class Q0_Knapsack01_Iterative {

//    static int t[][];

    public static void main(String[] args) {
        int wt[] = {4, 5, 8, 9, 1};
        int v[] = {2, 4, 6, 4, 5};
        int w = 7;
        int n = wt.length;

//        t = Arrays.stream(new int[n+1][w+1])
//                  .map(row -> Arrays.stream(row)
//                            .map(ele -> -1).toArray())
//                  .toArray(int[][]::new);

        int maxProfit = knapsack(wt, v, w, n);
        System.out.println("Max Profit :"+maxProfit);
    }

    private static int knapsack(int[] wt, int[] v, int w, int n) {
        // Create a 2D array to store the maximum value at each n and capacity
        int[][] t = new int[n + 1][w + 1]; // by default 0

        // Iterate through all items (wt and v)
        for(int i=0; i<=n; i++){
            // Iterate through all capacities from 0 to the given capacity
            for(int j=0; j<=w; j++){
                // Base case: if there are no items or capacity is 0
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
                else if(wt[i-1] <= j){
                    // If the weight of the current item is less than or equal to the current capacity
                    // we can either include it or exclude it
                    t[i][j] = Math.max(v[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
                }
                else{
                    // If the weight of the current item is more than the capacity, exclude it
                    t[i][j] = t[i-1][j];
                }
            }
        }
        // The bottom-right corner of the array contains the maximum value
        return t[n][w];
    }
}
