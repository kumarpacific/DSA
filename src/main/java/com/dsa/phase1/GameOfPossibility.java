package com.dsa.phase1;


import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * Game of possibility
 * Rule - 1000 Games will be played and 1000 times to check the possibility of cumulative profit and loss.
 * with Heads, we add 1 (+1)
 * with Tails, we subtract 1 (-1)
 * This is to check the bias-ness of random numbers class in Java.
 *
 * End result - count how many times we got the positive and negative.
 * ->  generate the ratio
 */
public class GameOfPossibility {
    static Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many times simulation should be running?");
        int times = sc.nextInt();

        int profitLoss = 0;
        System.out.println("*************   Running the similation "+times+" times each time making 10000 tosses ***********************");
        do {
            int tosses = 10000;
            Integer result = 0;

            for (int i = 0; i < tosses; i++) {

                int r = flipCoin(random);
                if(r == 0){
                    result +=1;
                }
                else{
                    result-=1;
                }
            }

            if(result>0) profitLoss++;
            else profitLoss--;

            times = times -1;
        }
        while(times>0);


        System.out.println("Result :" + profitLoss);
        System.out.println("************************************");

    }

    private static int flipCoin(Random random) {
        int r = random.nextInt(2);
        if(r==0) return 0;
        else return 1;
    }
}
