package com.dsa.phase1.stack;

import java.util.Stack;

public class MaxAreaOfHistogram_optimized {
    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Maximum area in the histogram is: " + getMaxArea(arr));
    }

    private static int getMaxArea(int[] arr) {
        int n = arr.length;
        int[] nsr = nextSmallerToRight(arr, n);
        int[] nsl = nextSmallerToLeft(arr, n);
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int area = width * arr[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    private static int[] nextSmallerToLeft(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] solution = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            solution[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return solution;
    }

    private static int[] nextSmallerToRight(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] solution = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            solution[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return solution;
    }
}
