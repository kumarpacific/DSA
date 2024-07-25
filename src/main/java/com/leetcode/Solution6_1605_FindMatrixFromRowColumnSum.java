package com.leetcode;

import java.util.Arrays;

public class Solution6_1605_FindMatrixFromRowColumnSum {

    public static void main(String[] args) {
        int[] rowSum = {5, 7, 10};
        int[] colSum = {8, 6, 8};
        int[][] solution = restoreMatrix(rowSum, colSum);

        for(int[] sol: solution){
            for(int val: sol){
                System.out.print(val+" ");
            }
            System.out.println();
        }
    }

    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int solution[][] = new int[rowSum.length][colSum.length];
        int i = 0, j = 0;

        while (i < rowSum.length && j < colSum.length) {
            int val = Math.min(rowSum[i], colSum[j]);
            solution[i][j] = val;
            rowSum[i] -= val;
            colSum[j] -= val;

            if(rowSum[i]==0){
                i++;
            }
            if(colSum[j]==0){
                j++;
            }
        }
        return solution;
    }
}
