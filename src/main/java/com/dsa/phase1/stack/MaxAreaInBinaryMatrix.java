package com.dsa.phase1.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class MaxAreaInBinaryMatrix {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1, 0},
                       {1, 1, 1, 1},
                       {1, 1, 1, 1},
                       {1, 1, 0, 0}};

        System.out.println("Maximum Area in a binary matrix - " + maiabm(arr));
    }

    private static int maiabm(int[][] arr) {

        int[] temp = new int[arr[0].length];
        int max = 0;

        for (int i = 0; i < arr[0].length; i++) {
            temp[i] = arr[0][i];
        }
        max = mah(temp);
        for (int i = 1; i < arr[1].length; i++) {
            for (int j = 0; j < arr[1].length; j++) {
                if (arr[i][j] == 0) {
                    temp[j] = 0;
                } else {
                    temp[j] = temp[j] + 1;
                }
                max = Math.max(max, mah(temp));
            }
        }

        return max;
    }

    private static int mah(int[] temp) {
        Integer nSR[] = nSR(temp).toArray(new Integer[0]);
        Integer nSL[] = nSL(temp).toArray(new Integer[0]);
        Integer w[] = new Integer[temp.length];
        Integer a[] = new Integer[temp.length];
        int max = 0;
        for (int i = 0; i < temp.length; i++) {
            w[i] = (nSR[i] - nSL[i]) - 1;
            a[i] = w[i] * temp[i];
            max = a[i] > max ? a[i] : max;
        }
        return max;
    }

    private static ArrayList<Integer> nSL(int[] items) {
        ArrayList<Integer> sol = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < items.length; i++) {
            if (stack.isEmpty()) {
                sol.add(-1);
            } else if (!stack.isEmpty() && items[stack.peek()] <= items[i]) {
                sol.add(stack.peek());
            } else if (!stack.isEmpty() && items[stack.peek()] > items[i]) {
                while (!stack.isEmpty() && items[stack.peek()] > items[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    sol.add(-1);
                } else {
                    sol.add(stack.peek());
                }
            }
            stack.push(i);
        }
        return sol;
    }

    private static LinkedList<Integer> nSR(int[] items) {
        LinkedList<Integer> sol = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int psindex = items.length;         //
        for (int i = items.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                sol.push(psindex);
            } else if (!stack.isEmpty() && items[stack.peek()] <= items[i]) {
                sol.push(stack.peek());
            } else if (!stack.isEmpty() && items[stack.peek()] > items[i]) {
                while (!stack.isEmpty() && items[stack.peek()] > items[i]) {
                    stack.pop();
                }
                sol.push(stack.isEmpty() ? -1 : stack.peek());
            }
            stack.push(i);
        }
        return sol;
    }
}
