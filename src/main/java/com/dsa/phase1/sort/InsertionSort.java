package com.dsa.phase1.sort;

public class InsertionSort {
    public static void main(String[] args) {
        int arr [] = {4,8,2,5,9,1,3};
        int sol [] = InsertionSort(arr);
        print(arr);
    }

    private static int[] InsertionSort(int[] arr) {
        for(int i=1; i<arr.length; i++){
            int key = arr[i];
            int j = i-1;

            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
        return arr;
    }


    private static void print(int[] arr) {
        System.out.println("------START--------");
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
        System.out.println("-------END-------");
    }
}
