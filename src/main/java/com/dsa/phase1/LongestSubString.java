package com.dsa.phase1;

/**
 * Longest SubString in a Array with sum of 5
 * <p>
 * Arr : 4 1 1 1 2 3 5
 * i j
 * k : 5
 */
public class LongestSubString {
    public static void main(String[] args) {
        int[] arr = {4, 1, 1, 1,1,1, 2, 3, 5};
        int sum = 6;

        int sol = getLengthOfLongestSubString(arr, sum);
        System.out.println("Solution : " + sol);
    }

    private static int getLengthOfLongestSubString(int[] arr, int sum) {
        int i = 0, j = 0;
        int sol = 0;
        int tempSum = 0;
        String str;
        while (j < arr.length) {
            //Calculation
            tempSum = tempSum + arr[j];

            if (tempSum < sum) {
                j++;
            }
             else if (tempSum == sum) {
                sol = Math.max(j - i + 1, sol);
                str = i + " : "+ j + " : " + (j - i + 1);
                System.out.println(str);
                j++;
            }
             else if (tempSum > sum) {
                while (tempSum >= sum) {
                    if(tempSum == sum) {
                        sol = Math.max(sol, j - i + 1);
                        str = i + " : "+ j + " : " + (j - i + 1);
                        System.out.println(str);
                    }

                    tempSum = tempSum - arr[i];
                    i++;
                }
                j++;
            }
        }

        return sol;
    }
}
