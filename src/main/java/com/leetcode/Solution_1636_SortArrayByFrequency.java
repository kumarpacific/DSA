package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_1636_SortArrayByFrequency {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3, 3, 3};
        HashMap<Integer, Integer> map = new HashMap<>();
        // creating frequency map
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // Because comparator does not work with primitives, need to convert to boxed type.
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        // Sort based on frequency or else decreasing values.
        Arrays.parallelSort(arr, (a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return map.get(a) - map.get(b);
            } else {
                return b - a;
            }
        });
        // Boxed to primitive
        // Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(Arrays.stream(arr).mapToInt(Integer::intValue).toArray()));
    }
}
