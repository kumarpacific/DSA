package com.dsa.phase1.sort;


// with each iteration, swap two elements one by one if first is greater than second
public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = {4,3,5,6,7,1,2};
        print(arr);

        int [] sol = bubblesort(arr);
        System.out.println();
        print(sol);

//        int [] sol2 = bubblesortSlighlyimproved(arr, arr.length-1);
//        System.out.println("with WHILE loop Bubblesort");
//        print(sol2);
    }

    /**
     * Here, with each iteration we are reducing the size of input array as maximum items we come from right to left
     *
     * 4 3 5 6 7 1 2
     *
     * 3 4 5 6 1 2 7
     *
     * 3 4 5 1 2 6 7
     *
     * 3 4 1 2 5 6 7
     *
     * 3 1 2 4 5 6 7
     *
     * 1 2 3 4 5 6 7

     */
    private static int[] bubblesortSlighlyimproved(int[] arr, int len) {
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            print(arr);
            System.out.println();
            for(int i=0; i<len; i++){
                // with each iteration, we kind of putting max item into the last index.
                if(arr[i]>arr[i+1]){
                    sorted = false;
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            len = len-1;  // since max item is placed in last index we will decrement the size.
        }
        return arr;
    }

    private static void print(int[] arr) {
        for(int a: arr){
            System.out.print(a + " ");
        }
        System.out.println();
    }



    private static int[] bubblesort(int[] arr) {
        int temp;
        boolean flag;
        for(int i=0; i<arr.length-1; i++){
            flag = false;
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }

            //slighly improve
            if(flag == true){
                break;
            }

            System.out.println("- "+i);
            print(arr);
            System.out.println();
        }
        return arr;
    }
}
