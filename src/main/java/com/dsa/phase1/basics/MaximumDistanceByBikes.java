package com.dsa.phase1.basics;

public class MaximumDistanceByBikes {

    // Asked in Amazon
    public static void main(String[] args) {
        int n = 100;
        int fuel = 100;

        System.out.println(getMaxDistance(n, fuel));
    }

    private static double getMaxDistance(int n, int fuel) {
        double max_distance = 0;

        while(n>0){
            max_distance += (double)fuel/n;
            n-=1;
        }
        return max_distance;
    }
}
