package com.leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class Solution_2191_SortTheJumbledNumbers {
    public static void main(String[] args) {
        int[] mapping = {9,8,7,6,5,4,3,2,1,0};
//        int[] nums = {991,338,38};
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        //[9,8,7,6,5,4,3,2,1,0]
        Map<Integer, Integer> refMap = new HashMap<>();


        for(int i = 0; i<nums.length;i++){
            int n = nums[i];
            int value = 0;
            LinkedList<Integer> list = new LinkedList<>();
            while (n > 0){
                int val = mapping[n%10];
                list.push(val);
                n = n/10;
            }
            for(int a: list){
                value = value *10 + a;
            }
            if(nums[i] == 0){
                refMap.put(nums[i], mapping[nums[i]]);
            }else {
                refMap.put(nums[i], value);
            }
        }

        Integer[] sol = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(sol, (a,b) -> {
            if(!refMap.get(a).equals(refMap.get(b))){
                return refMap.get(a) - refMap.get(b);
            }else{
                return  0;
            }
        });

        System.out.println("Array : "+ Arrays.toString(sol));
    }

}
