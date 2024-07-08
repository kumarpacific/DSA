package com.dsa.phase1.stack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class NextGreaterToRight {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7, 5, 9, 6, 8, 10};
        LinkedList<Integer> sol = solve(arr, arr.length);
        LinkedList<Integer> sol2 = solve(arr);
        Collections.reverse(sol);
        System.out.println("Solution : " + sol);
        System.out.println("Solution2 : " + sol2);
    }

    public static LinkedList<Integer> solve(int[] arr) {
        Stack<Integer> tempStack = new Stack<>();
        LinkedList<Integer> sol = new LinkedList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!tempStack.isEmpty() && arr[i] >= tempStack.peek()) {
                tempStack.pop();
            }
            if (tempStack.isEmpty()) {
                sol.addFirst(-1); // Add to the front to maintain the correct order
            } else {
                sol.addFirst(tempStack.peek()); // Add to the front to maintain the correct order
            }
            tempStack.push(arr[i]);
        }
        return sol;
    }

    private static LinkedList<Integer> solve(int[] arr, int length) {
        Stack<Integer> tempStack = new Stack<>();
        LinkedList<Integer> sol = new LinkedList<>();
        for (int i = length - 1; i >= 0; i--) {
            if (tempStack.empty()) {
                sol.add(-1);

            } else if (tempStack.size() > 0 && arr[i] < tempStack.peek()) {
                sol.add(tempStack.peek());

            } else if (tempStack.size() > 0 && arr[i] >= tempStack.peek()) {
                while (tempStack.size() > 0 && arr[i] >= tempStack.peek()) {
                    tempStack.pop();
                }
                if (tempStack.empty()) {
                    sol.add(-1);
                } else {
                    sol.add(tempStack.peek());

                }
            }
            tempStack.add(arr[i]);
        }
        return sol;
    }
}
