package com.leetcode;

// 1071 - https://leetcode.com/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
public class Solution2_1071_GCDofString implements AutoCloseable{

    public static void main(String[] args) {
        String str1 = "ABCDEABCDE";
        String str2 = "ABCDE";
        String sol = gcdOfStrings(str1, str2);
        System.out.println(sol);
    }

    public static String gcdOfStrings(String str1, String str2) {
        if((str1+str2).equals(str2+str1)){
            return str1.substring(0, gcd(str1.length(), str2.length()));
        }else{
           return "";
        }

    }

    private static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a%b);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Do the cleanup here...");
    }
}
