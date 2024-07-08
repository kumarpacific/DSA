package com.leetcode;

// 1768 - https://leetcode.com/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
public class Solution1_1768_MergeString {

    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "pq";

        String s = mergeAlternately(word1, word2);
        System.out.println(s);
    }

    public static String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        char[] arr = new char[n + m];
        int index = 0, i = 0, j = 0;
        while (i < n && j < m) {
            arr[index++] = word1.charAt(i++);
            arr[index++] = word2.charAt(j++);
        }
        while (i < n) arr[index++] = word1.charAt(i++);
        while (j < m) arr[index++] = word2.charAt(j++);
        return new String(arr);
    }

/*
 This also works :D Not proud of it :P
 public static String mergeAlternately(String word1, String word2) {
            char[] w1 = word1.toCharArray();
            char[] w2 = word2.toCharArray();
            int length = word1.length() + word2.length();
            char[] res = new char[length];
            int j =0, k=0;

            for(int i = 0; i < length; i++){
                if(i%2 == 0 && j< word1.length()){
                    res[i] = w1[j++];
                }else if(k<word2.length()){
                    res[i] = w2[k++];
                }else{
                    res[i] = w1[j++];
                }
            }
            return new String(res);
        }
 */

}
