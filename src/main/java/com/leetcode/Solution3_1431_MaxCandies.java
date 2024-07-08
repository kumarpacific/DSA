package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 1431 - https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75
public class Solution3_1431_MaxCandies {

    public static void main(String[] args) {
        int arr[] = {2,3,5,1,3};
        int extraCandies = 3;

        List<Boolean> bool = kidsWithCandies(arr, extraCandies);
        System.out.println(bool);
        //[true,true,true,false,true]
    }
        public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int max = 0;
            int size = candies.length;
            List<Boolean> solution = new ArrayList<>();
            for(int i=0; i<size; i++){
                if(candies[i] > max) max = candies[i];
            }
            for(int i=0; i<size; i++){
                solution.add((candies[i] + extraCandies) >= max ? true : false);
            }
            return solution;
        }
}
