package com.dsa.phase1.stack;

import java.util.*;
import java.util.stream.Collectors;


public class NGRPractice {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7, 5, 9, 6, 8, 10};
        // [4, 7, 7, 9, 9, 10, 8, 10, -1]
        List<Integer> solution = solve(arr, arr.length);
//        Collections.reverse(solution);
        System.out.println(solution);
    }

    private static List<Integer> solve(int[] arr, int length) {

        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = length-1; i>=0; i--){
            if(stack.isEmpty()){
                list.push(-1);
            }
            else if(!stack.isEmpty() && stack.peek() >= arr[i]){
                list.push(stack.peek());
            }else if(!stack.isEmpty() && stack.peek() <=arr[i]){
                while(!stack.isEmpty() && stack.peek() <=arr[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    list.push(-1);
                }else{
                    list.push(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        return list;
    }
}

/**
 * Foot Notes:
 * how to convert int[] to List<Integer>?
 *
 * Arrays.asList(int[]) creates a fixed-size list that directly references the original array.
 * Modifications to the list will affect the array and vice versa.
 * It's generally not recommended for most cases.
 *
 * --> Arrays.stream(arr).boxed().collect(Collectors.toList());
 */