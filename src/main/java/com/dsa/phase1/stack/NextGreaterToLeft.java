package com.dsa.phase1.stack;

import java.util.LinkedList;
import java.util.Stack;

public class NextGreaterToLeft {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7, 5, 9, 6, 8, 10};
        //          -1,-1, 4,-1, 7,-1, 9, 9, -1
        LinkedList<Integer> sol = solve(arr, arr.length);
        LinkedList<Integer> sol2 = solve(arr);

        System.out.println("Solution : " + sol);
        System.out.println("Solution2 : " + sol2);
    }

    public static LinkedList<Integer> solve(int[] arr) {
        Stack<Integer> tempStack = new Stack<>();
        LinkedList<Integer> sol = new LinkedList<>();

        for (int value : arr) {
            while (!tempStack.isEmpty() && value >= tempStack.peek()) {
                tempStack.pop();
            }
            if (tempStack.isEmpty()) {
                sol.add(-1);
            } else {
                sol.add(tempStack.peek());
            }
            tempStack.push(value);
        }
        return sol;
    }

    private static LinkedList<Integer> solve(int[] arr, int length) {
        Stack<Integer> tempStack = new Stack<>();
        LinkedList<Integer> sol = new LinkedList<>();
        for (int i = 0; i <= length - 1; i++) {
            if (tempStack.empty()) {
                sol.add(-1);

            } else if (arr[i] < tempStack.peek()) {
                sol.add(tempStack.peek());

            } else if (arr[i] >= tempStack.peek()) {
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
