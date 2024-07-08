package com.dsa.phase1.array.slidingwindow;

import java.util.*;

public class FirstNegativeIntegerInEveryWindowOfSizeK {
    public static void printFirstNegativeInteger(int[] arr, int n, int k) {
        Deque<Integer> Di = new LinkedList<>();
        int i;

        // Initialize the deque for the first k elements
        for (i = 0; i < k; i++) {
            if (arr[i] < 0) {
                Di.add(i);
            }
        }

        // Process the remaining elements
        for (; i < n; i++) {
            // Print the first negative integer in the current window
            if (!Di.isEmpty()) {
                System.out.print(arr[Di.peek()] + " ");
            } else {
                System.out.print("0 ");
            }

            // Remove elements that are out of the current window
            while (!Di.isEmpty() && Di.peek() < (i - k + 1)) {
                Di.poll();
            }

            // Add the current element to the deque if it is negative
            if (arr[i] < 0) {
                Di.add(i);
            }
        }

        // Print the first negative integer for the last window
        if (!Di.isEmpty()) {
            System.out.print(arr[Di.peek()] + " ");
        } else {
            System.out.print("0 ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int n = arr.length;
        int k = 3;
        printFirstNegativeInteger(arr, n, k);
    }
}
