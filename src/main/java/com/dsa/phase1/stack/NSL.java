package com.dsa.phase1.stack;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NSL {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7, 5, 9, 6, 8, 10};
        //   op =    {-1, 3, -1, 2, 2, 5, 6, 8}

        List<Integer> list = solve(arr, arr.length);
        System.out.println(list);
    }

    private static List<Integer> solve(int[] arr, int length) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0; i< length; i++){
            if(stack.isEmpty()){
                list.add(-1);
            }
            else if(!stack.isEmpty() && stack.peek() <= arr[i]){
                list.add(stack.peek());
            }
            else if(!stack.isEmpty() && stack.peek() >= arr[i]){
                while(!stack.isEmpty() && stack.peek() >= arr[i]){
                    stack.pop();
                }

                if(stack.isEmpty()){
                    list.add(-1);
                }else{
                    list.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        return list;
    }
}
