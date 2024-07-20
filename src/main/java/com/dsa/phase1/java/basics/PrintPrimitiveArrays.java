package com.dsa.phase1.java.basics;
import java.util.Arrays;

public class PrintPrimitiveArrays {
    public static void main(String[] args){
//        float[] list = new float[5];
        double [] list = new double[5];
        list[0] = 'a';
        list[1] = 123;
        list[2] = 010101;
        list[3] = 233l;
        list[4] = 23.5f;
//        for(int i = 0; i<list.length; i++){
//            System.out.println(list[i]);
//        }
//        Arrays.stream(list).forEach(System.out::println);

        // will print reference since primitives does not have toString method in-built.
        System.out.println(list);
        //so to print any array, we need to wrap the list with Arrays.toString().
        System.out.println(Arrays.toString(list));

        // Iterate with stream
//        IntStream.range(0, list.length).forEach(i -> System.out.println(list[i]));
    }
}
