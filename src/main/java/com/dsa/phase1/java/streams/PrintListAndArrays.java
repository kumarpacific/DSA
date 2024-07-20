package com.dsa.phase1.java.streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PrintListAndArrays {
    public static void main(String[] args) {
//        float[] list = new float[5];
        Double[] list = new Double[5];
        list[0] = Double.valueOf('a');
        list[1] = Double.valueOf(123);
        list[2] = Double.valueOf(010101);
        list[3] = Double.valueOf(233l);
        list[4] = Double.valueOf(23.5f);
//        for(int i = 0; i<list.length; i++){
//            System.out.println(list[i]);
//        }
//        Arrays.stream(list).forEach(System.out::println);

        // will print reference since double does not have toString method in-built.
        System.out.println(list);
        //so to print any array, we need to wrap the list with Arrays.toString().
        System.out.println(Arrays.toString(list));

        IntStream.range(0, list.length).forEach(i -> System.out.println(list[i]));

        // Iterate with stream
//        IntStream.range(0, list.length).forEach(i -> System.out.println(list[i]));
    }
}
