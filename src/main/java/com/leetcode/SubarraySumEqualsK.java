package com.leetcode;

import java.util.HashMap;

// 560. Subarray Sum Equals K
// https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int items[] = {1, 2, 1, 2, 1};
        int k = 3;
        int solution = subarraySumEqualsK(items, k);
        System.out.println("Subarray Sum Equals K " + solution);
    }

    private static int subarraySumEqualsK(int[] items, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1); // 0 sum occurrence is 1
        int count = 0;
        int sum = 0;
        for (int i = 0; i < items.length; i++) {
            sum += items[i];
            if (hm.containsKey(sum - k)) {
                count += hm.get(sum -k);   // keeping track of all occurrences including overlapping.
            }
            hm.put(sum, hm.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
