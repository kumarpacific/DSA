package com.dsa.phase1.sort;


// with each iteration find the lowest number's index and swap it with i index.
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4,6,1,2,7,5,3,8};
        int sol[] = selectionSort(arr);
        print(sol);
        System.out.println();
    }

    private static void print(int[] sol) {
        for(int i: sol){
            System.out.print(i+" ");
        }
    }

    private static int[] selectionSort(int[] arr) {

        for(int i=0; i<arr.length; i++){
            int lowestIndex = i;

            // with this loop, we try to find the lowest number's index in the array.
            for(int j=i+1; j<arr.length; j++) {
                // smallest item
                if (arr[j] < arr[lowestIndex]) {
                    lowestIndex = j;
                }
            }

                //swap to the initial index i.e 0 in 1st pass and 1 in 2nd pass.
                if(i!=lowestIndex){
                    int temp = arr[i];
                    arr[i] = arr[lowestIndex];
                    arr[lowestIndex] = temp;
                }

        }
        return arr;
    }
}
