package com.dsa.phase1;

import java.util.LinkedList;

public class MaxNumInAWindow {
    public static void main(String[] args) {
        int[] arr = {4, 5, 9, 2, 6, 10, 7, 12};

        /**
         * We can keep track of max and second max.
         *
         * 4,5,9 -> 9
         * 5,9,2 -> 9
         * 9,2,6 -> 9
         * 2,6,10 -> 10
         * 6,10,7 -> 10
         * 10,7,12 -> 12
         */
        int w = 3;
        LinkedList<Integer> sol = new LinkedList<>();

        solution(arr, w, sol);

        System.out.println( "Solution :" + sol);
    }

    private static void solution(int[] arr, int w, LinkedList<Integer> sol) {
        int i = 0, j = 0;
        int max = 0;
        int max2 = 0;
        while (j < arr.length) {
            if (arr[j] > max) {
                max2 = max;
                max = arr[j];
            }
            if (j - i + 1 < w) {
                j++;
            } else if (j - i + 1 == w) {
                sol.add(max);

                if(arr[i] == max){
                    max = max2;
                }

                i++;
                j++;
            }
        }
    }
}
