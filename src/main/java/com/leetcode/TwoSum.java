package com.leetcode;

import java.util.HashMap;
import java.util.Map;


///practice this more develop your own logic.
// Logic provided below the code.
public class TwoSum {
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = ts.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
    public int[] twoSum(int[] nums, int target) {
        // Step 1: Initialize the HashMap
        Map<Integer, Integer> numToIndex = new HashMap<>();
        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Step 3: Calculate the complement
            int complement = target - nums[i];
            // Step 4: Check if the complement is already in the HashMap
            if (numToIndex.containsKey(complement)) {
                // Step 4a: If it is, return the indices
                return new int[]{numToIndex.get(complement), i};
            }
            // Step 5: Update the HashMap
            numToIndex.put(nums[i], i);
        }
        // Step 6: Handle the case where no solution is found
        throw new IllegalArgumentException("No two sum solution");
    }
}


/**
 * LOGIC:
 * Here is an improved version of the twoSum method. This version improves readability, efficiency, and logic.
 * It uses a HashMap to achieve a time complexity of O(n) rather than the O(n^2) complexity of the original code.
 * <p>
 * Improvements:
 * Use of HashMap:
 * A HashMap is used to store the numbers and their indices as we iterate through the array.
 * This allows for an O(1) average time complexity lookup for the complement.
 * Single Loop:
 * <p>
 * The problem is solved in a single loop, making the solution more efficient (O(n) time complexity).
 * <p>
 * Clearer Logic:
 * The complement of the current number is calculated (target - nums[i]), and we check if this complement exists in the HashMap.
 * If it exists, the indices of the two numbers are returned immediately.
 * If not, the current number and its index are added to the HashMap.
 * <p>
 * Error Handling:
 * An exception is thrown if no solution is found, which helps in debugging and handling edge cases where no two numbers sum up to the target.
 * Example:
 * Given nums = {2, 7, 11, 15} and target = 9, the twoSum method will:
 * <p>
 * Check if 9 - 2 = 7 is in the HashMap (it is not initially).
 * Add 2 to the HashMap with its index 0.
 * Move to the next number 7, check if 9 - 7 = 2 is in the HashMap (it is, with index 0).
 * Return the indices [0, 1] since nums[0] + nums[1] = 9.
 * This method is not only more efficient but also cleaner and easier to understand.
 * <p>
 * <p>
 * ---------------------------------------
 * === THOUGHT PROCESS ===
 * ---------------------------------------
 * Optimizing code involves breaking down the problem and finding more efficient ways to solve it. Here's a step-by-step thought process to optimize the twoSum solution:
 * <p>
 * Step-by-Step Optimization Process
 * Understand the Problem:
 * <p>
 * You need to find two indices in an array such that the numbers at those indices add up to a given target.
 * The simplest way is to check each pair of numbers, but this is not efficient for large arrays.
 * Analyze the Brute Force Approach:
 * <p>
 * A brute force approach would involve nested loops to check all pairs.
 * This results in a time complexity of O(n^2), which is not optimal for large inputs.
 * Identify Redundancies:
 * <p>
 * In the nested loops, you're checking the same pairs multiple times.
 * Each pair is checked twice, once as (i, j) and once as (j, i).
 * Look for Data Structures to Optimize:
 * <p>
 * We need a way to store and quickly look up values we've already seen.
 * A HashMap is ideal for this because it allows O(1) average time complexity for inserts and lookups.
 * Plan the Optimized Approach:
 * <p>
 * Use a single loop to iterate through the array.
 * For each element, calculate the complement (the number needed to reach the target when added to the current element).
 * Check if the complement is already in the HashMap.
 * If it is, you've found the solution. If not, store the current element and its index in the HashMap.
 * Implement the Optimized Solution:
 * <p>
 * Initialize a HashMap to store numbers and their indices.
 * Loop through the array, checking for complements and updating the HashMap as you go.
 * Return the indices as soon as you find a match.
 * Detailed Breakdown
 * Step 1: Initialize the HashMap
 * <p>
 * Create a HashMap to keep track of the numbers and their indices.
 * Step 2: Iterate through the Array
 * <p>
 * Loop through each element in the array.
 * Step 3: Calculate the Complement
 * <p>
 * For the current element nums[i], calculate complement = target - nums[i].
 * Step 4: Check for the Complement
 * <p>
 * Check if the complement exists in the HashMap.
 * If it does, return the current index and the index of the complement.
 * <p>
 * Step 5: Update the HashMap
 * If the complement is not found, add the current element and its index to the HashMap.
 * Step 6: Handle No Solution Case
 * <p>
 * If no two numbers add up to the target, throw an exception or handle it appropriately.
 * <p>
 * Summary
 * Identify the problem and constraints: Understand what needs to be optimized.
 * Analyze the brute force solution: Recognize inefficiencies in the naive approach.
 * Explore alternative data structures: Use appropriate data structures like HashMap to reduce complexity.
 * Plan the optimized approach: Outline steps to leverage the new data structure for efficiency.
 * Implement step-by-step: Translate the plan into code, ensuring clarity and correctness.
 * Handle edge cases: Ensure the solution is robust and handles scenarios where no solution exists.
 * By following this structured approach, you can systematically optimize your code for better performance and readability.
 */