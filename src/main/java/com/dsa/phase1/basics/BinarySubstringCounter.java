package com.dsa.phase1.basics;

/**
 * A binary string is a string consisting only of 0s and 1s. A substring is a
 * contiguous group of characters within a string.
 * Given a binary string, find the number of substrings that contain an equal
 * number of 0s and 1s and all the 0s and 1s are grouped together. Note that
 * duplicate substrings are also counted in the answer. For example, '0011' has
 * two overlapping substrings that meet the criteria:
 * '0011' and '01'.
 * Example
 * 5 = "011001"
 * The substrings "01", "10", "1100",
 * and "01" have equal numbers of Os and 1s with all Os and 1s grouped consecutively.
 *
 * Hence, the answer is 4.
 * Note that the substring "0110" has an equal number of Os and 1s but is not counted
 * because not all Os and 1s are grouped together.
 */
public class BinarySubstringCounter {

    public static void main(String[] args) {
        String s = "011001";
        int result = getSubstringCount(s);
        System.out.println("The number of valid substrings is: " + result); // Output should be 4
    }

    public static int getSubstringCount(String s) {
        int count = 0;
        int prevGroupLength = 0;
        int currGroupLength = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroupLength++;
            } else {
                count += Math.min(prevGroupLength, currGroupLength);
                prevGroupLength = currGroupLength;
                currGroupLength = 1;
            }
        }

        count += Math.min(prevGroupLength, currGroupLength);

        return count;
    }
}
