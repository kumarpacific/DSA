package com.dsa.phase1.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class MaxAreaOfHistogram {
    public static void main(String[] args) {
        int arr[] = {6, 2, 5, 4, 5, 1, 6};

        System.out.println("Maximum area in the histogram is : " + getMaxArea(arr));
    }

    // 1. Calculate NSR and NSL to know the width of histogram.
    // 2. Calculate width[i] = (NSR[i] - NSL[i]) - 1
    // 3. area[i] = width[i] * arr[i]
    // 4. Get the max item in area[i] => answer
    // Note: Assume pseudoIndex for -1 and length
    private static int getMaxArea(int[] arr) {
        Integer[] nsr = nextSmallerToRight(arr);
        Integer[] nsl = nextSmallerToLeft(arr);
        Integer[] width = new Integer[arr.length];
        Integer[] area = new Integer[arr.length];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            width[i] = (nsr[i] - nsl[i]) - 1;
            area[i] = width[i] * arr[i];
            if (area[i] > max) {
                max = area[i];
            }
        }

        return max;
    }

    private static Integer[] nextSmallerToLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> solution = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                solution.add(-1);
            } else if (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                solution.add(stack.peek());
            } else if (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    solution.add(-1);
                } else {
                    solution.add(stack.peek());
                }
            }
            stack.push(i);
        }
        return solution.toArray(new Integer[0]);
    }

    private static Integer[] nextSmallerToRight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> solution = new LinkedList<>();

        int psindex = arr.length;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                solution.push(psindex);
            } else if (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                solution.push(stack.peek());
            } else if (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    solution.push(psindex);
                } else {
                    solution.push(stack.peek());
                }
            }
            stack.push(i);
        }
        return solution.toArray(new Integer[0]);
    }


}
