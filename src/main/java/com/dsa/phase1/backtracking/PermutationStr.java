package com.dsa.phase1.backtracking;

import java.util.Scanner;

public class PermutationStr {

    public static void main(String[] args) {

        System.out.println("Enter any String to create its permutations:");
        Scanner scr = new Scanner(System.in);
        String str = scr.nextLine();
        permute(str,"");
    }

    private static void permute(String str, String asf) {

        if(str.length()==0){
            System.out.println(asf);
            return;
        }

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            String lside = str.substring(0,i);
            String rside = str.substring(i+1);
            String restOfStr = lside + rside;
            permute(restOfStr,asf+ch);
        }
    }
}
