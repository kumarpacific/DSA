package com.dsa.phase1.recursion;

public class TOH {

    public static void main(String[] args) {
        String s = "SOURCE";
        String h = "HELPER";
        String d = "DESTINATION";
        int noOfDiscs = 3;

        solveToh(s, d, h, noOfDiscs);

    }

    private static void solveToh(String s, String d, String h, int noOfDiscs) {
        if (noOfDiscs == 0) {
            return;
        }
        solveToh(s, h, d, noOfDiscs - 1);
        System.out.println("Move disk "+ noOfDiscs+" from "+s+" to "+ d);
        solveToh(h,d,s, noOfDiscs-1);
    }
}

/**
 * Moving disk 1 from SOURCE to DESTINATION using HELPER
 * Moving disk 2 from SOURCE to HELPER using DESTINATION
 * Moving disk 1 from DESTINATION to HELPER using SOURCE
 * Moving disk 3 from SOURCE to DESTINATION using HELPER
 * Moving disk 1 from HELPER to SOURCE using DESTINATION
 * Moving disk 2 from HELPER to DESTINATION using SOURCE
 * Moving disk 1 from SOURCE to DESTINATION using HELPER
 */