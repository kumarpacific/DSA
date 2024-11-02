package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class TestCode {

    public static void main(String[] args) {

        int a = 10;
        int b = 0;

        // This will not throw an exception because b != 0 is never evaluated
        if (a > 0 || (b != 0 && a / b > 1)) {
            System.out.println("Condition is true.");
        }
        int[] nums = {2, 7, 11, 15};
        int target = 17;
        int[] tn = twoSum(nums, target);
        System.out.println(tn[0] + " and "+tn[1]);

        int mileage = 100;
        int nbikes = 100;
        double kmsdrive = getKms(mileage, nbikes);
        System.out.println("Kms drives :"+kmsdrive);
        TestCode tc = new TestCode();
        TestCode ts = new TestCode();
        System.out.println(System.identityHashCode(tc));
        System.out.println(System.identityHashCode(ts));
    }

    private static double getKms(int mileage, int nbikes) {

        double kmsdrive =0;
        while(nbikes > 0){
            kmsdrive += (double)mileage / nbikes;
            nbikes--;
        }
        return kmsdrive;
    }

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> cset = new HashMap<>();
        for (int n : nums){
            int diff = target - n;
            if(cset.containsKey(diff)){
                return new int[]{diff,n};
            }
            cset.put(n, n);
        }
        return new int[]{};
    }


}
