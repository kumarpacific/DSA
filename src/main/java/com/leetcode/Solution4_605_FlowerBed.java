package com.leetcode;


// 605 - https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75
public class Solution4_605_FlowerBed {
    public static void main(String[] args) {
        int arr[] = {1, 0, 0, 0, 0, 1};
        int n = 1;
        boolean f = canPlaceFlowers(arr, n);
        System.out.println("can place flowerbed :: " + f);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            boolean left = i == 0 || flowerbed[i - 1] == 0;
            boolean right = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;

            if (right && left && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                --n;
            }
        }
        return n <= 0;
    }
}


/*
Notes :
At element check if element itself, left side and right side have already a plant. if No then plant it or else move on.

Why it will not give ArrayIndexOutOfBoundException on the edges - because of short circuit operators.
             || and && are short circuit operator.
             || - if first statement is true then second will not get executed.
             && - if first statement is false then second will not get executed.
 */
