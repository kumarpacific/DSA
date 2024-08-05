package com.dsa.phase1.dp;

// This is exactly same question as Q5 - count, words has been altered to make it look complex.
public class Q6_TargetSum {
    public static void main(String[] args) {
        int[] items = {1,1,2,3};
        int sum = 1;
        // result = 3, in 3 ways we can assign signs among elements to make sum = 1
        // +1 -1 -2 +3 = 1 assign sign in such a way that it equals to given sum
        // s1(1+3) - s2(1+2) = 1 :: same as previous, just saying 'diff' as 'sum'

        int res = getTargetSum(items, sum);
        System.out.println("Result : "+res);
    }

    private static int getTargetSum(int[] items, int sum) {
        return Q5_CountSubsetWithGivenDifference.getCountSubsetWithGivenDifference(items, sum);
    }


}
