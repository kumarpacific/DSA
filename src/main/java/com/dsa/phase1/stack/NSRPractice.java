package com.dsa.phase1.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NSRPractice {

    public static void main(String[] args) {

        int[] arr = {3, 4, 2, 7, 5, 9, 6, 8, 10};
        //     op = {2, 2,-1, 5,-1, 6,-1,-1, -1}

        List<Integer> list = solve(arr, arr.length);

        System.out.println(list);

    }
    private static List<Integer> solve(int[] arr, int length) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();


        for(int i = length-1; i>=0; i--){
            if(stack.isEmpty()){
                list.push(-1);
            }
            else if(!stack.isEmpty() && stack.peek() <= arr[i]){
                list.push(stack.peek());
            }else if(!stack.isEmpty() && stack.peek() >= arr[i]){
                while(!stack.isEmpty() && stack.peek() >= arr[i]){
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
