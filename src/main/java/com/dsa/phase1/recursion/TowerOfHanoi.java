package com.dsa.phase1.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        String s = "SOURCE";
        String h = "HELPER";
        String d = "DESTINATION";
        int noOfDiscs = 3;

        solveToh(s, d, h, noOfDiscs);

    }

    public static void solveToh(String s, String d, String h, int n){
        if(n == 1){
            System.out.println("moving disc "+n+" from  "+s+" to "+d+"");
          return;
        }

        solveToh(s, h, d, n-1);
        System.out.println("moving disc "+n+" from  "+s+" to "+d+"");
        solveToh(h, d, s, n-1);

    }
}
