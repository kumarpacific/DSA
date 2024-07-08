package com.leetcode;

public class Solution5_ReverseVowelsOfString {
    public static void main(String[] args) {
        String word = "leetcode";
        reverseVowels(word);
        System.out.println(word);
    }

    public static String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int i = 0, j = s.length() - 1;

        while (i < j) {
            while (i < s.length() - 1 && !isVowel(word[i])) {
                i++;
            }
            while (j >= 0 && !isVowel(word[j])) {
                j--;
            }
            if (i < j) {
                swap(word, i++, j--);
            }
        }

        return new String(word);
    }

    private static void swap(char[] word, int i, int j) {
        char temp = word[i];
        word[i] = word[j];
        word[j] = temp;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
