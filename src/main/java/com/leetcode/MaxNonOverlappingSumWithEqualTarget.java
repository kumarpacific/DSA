package com.leetcode;

//1546. Maximum Number of Non-Overlapping Subarrays With Sum Equals Target
//https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/description/

import java.util.HashMap;

public class MaxNonOverlappingSumWithEqualTarget {
    public static void main(String[] args) {
        int arr[] = {-1, 3, 5, 1, 4, 2, -9};
        //           -1, 2, 7, 8, 12,14, 5
        int target = 6;
        int noOfSubArrays = maxNonOverlapping(arr, target);
        System.out.println("Numbers of Sub-arrays exist which sum are equal to target " + noOfSubArrays);
    }

    public static int maxNonOverlapping(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int count = 0;
        int prefixSum = 0;
        int previouslyRightMostIndexUsed = -1;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (hm.containsKey(prefixSum - target) && hm.get(prefixSum - target) >= previouslyRightMostIndexUsed) {
                count++;
                previouslyRightMostIndexUsed = i;
            }
            hm.put(prefixSum, i);
        }
        return count;
    }
}
