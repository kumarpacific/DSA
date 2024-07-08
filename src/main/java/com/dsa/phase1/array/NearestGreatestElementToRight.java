package com.dsa.phase1.array;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;
import java.util.List;

public class NearestGreatestElementToRight {

    private static int size;

    public static void main(String[] args) {
        Integer[] arr = {4, 6, 9, 1, 5, 8, 2, 7, 10};
        // sol :        [6, 9, 10, 5, 8, 10, 7, 10, -1]

//        Integer[] sol2 = bruteForceMethod(arr);
//        System.out.println("Solution :::" + Arrays.toString(sol2));
        List<Integer> sol = getGreatestElementToRightArr(arr);

        System.out.println("Solution :::" + sol);
    }

    // O(n^2)
    private static Integer[] bruteForceMethod(Integer[] arr) {
        LinkedList<Integer> sol = new LinkedList<>();
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            temp = -1;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[j] > arr[i]) {
                    temp = arr[j];
                    break;
                }
            }
            sol.add(temp);
        }
        return sol.toArray(new Integer[0]);
    }

    // O(n log n)
    private static List<Integer> getGreatestElementToRightArr(Integer[] arr) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        int size = arr.length;
        for (int i = size - 1; i >= 0; i--) {
            if (stack.empty()) {  //  case when stack is empty add -1
                list.add(-1);
            } else if (stack.peek() > arr[i]) {  // case when element is smaller than curr max. means it will be the sol
                list.add(stack.peek());
            } else if (stack.peek() <= arr[i]) {  // case when e is greater than curr max, we will pop and check next max
                while (!stack.empty() && stack.peek() <= arr[i]) {  // pop till stack empty, or we don't get next max
                    stack.pop();
                }
                if (stack.empty()) {    // case if stack gets empty add -1
                    list.add(-1);
                } else {
                    list.add(stack.peek());  // case when we get the greater element in stack
                }
            }
            stack.push(arr[i]);    // add the element to stack for further comparison.
        }
        Collections.reverse(list);   // since we started iterating from last, hence reverse.

        return list;
    }
}
