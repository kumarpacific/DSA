package com.dsa.phase1.basics;

import java.util.*;

/**
 * In the popular game of Bingo, a player has a card represented by a matrix mat of size n x m
 * that contains all of the numbers from the range 1 to n x m.
 * The numbers are called out from an array arr of all the numbers from 1 to n x m in sequential
 * order starting from the first element. When a number is called out, the player marks the corresponding
 * number on the game card.
 *
 * Find the first number in the sequence at which either a row or a column is completely marked.
 * Example:
 * Let, mat = [[3, 1, 8],
 *             [4, 6, 21,
 *             [7, 5, 91] and
 * arr = [5, 4, 8, 7, 6, 1, 9, 2, 31.
 * Answer::
 * res = 1
 */
public class BingoNumber {

    public static void main(String[] args) {
        List<List<Integer>> mat = Arrays.asList(
                Arrays.asList(3, 1, 8),
                Arrays.asList(4, 6, 2),
                Arrays.asList(7, 5, 9)
        );

        List<Integer> arr = Arrays.asList(5, 4, 8, 7, 6, 1, 9, 2, 3);

        int result = findBingoNumber(mat, arr);
        System.out.println("First Bingo Number: " + result); // Output should be 1
    }


    public static int findBingoNumber(List<List<Integer>> mat, List<Integer> arr) {
        int n = mat.size(); // number of rows
        int m = mat.get(0).size(); // number of columns

        // Map to store the position of each number in the matrix
        Map<Integer, int[]> positionMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                positionMap.put(mat.get(i).get(j), new int[]{i, j});
            }
        }

        // Arrays to keep track of the number of marks in each row and column
        int[] rowCount = new int[n];
        int[] colCount = new int[m];

        // Go through each number in arr and mark it on the Bingo card
        for (int number : arr) {
            if (positionMap.containsKey(number)) {
                int[] pos = positionMap.get(number);
                int row = pos[0];
                int col = pos[1];

                rowCount[row]++;
                colCount[col]++;

                // Check if this row or column is fully marked
                if (rowCount[row] == m || colCount[col] == n) {
                    return number;
                }
            }
        }

        // If no row or column is completely marked
        return -1; // return -1 to indicate no Bingo
    }

}

