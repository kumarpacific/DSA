package com.dsa.phase1.set;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetExamples {

    public static void main(String[] args) {
        SortedSet<Integer> ts = new TreeSet<>();

        TreeSet tss = new TreeSet();
//        tss.add("India");
//        tss.add("Australia");
//        tss.add("USA");
//        tss.add("Russia");

        tss.add(new StringBuffer("A"));
        tss.add(new StringBuffer("Z"));
        tss.add(new StringBuffer("L"));
        tss.add(new StringBuffer("B"));
        tss.add(new StringBuffer("C"));
        System.out.println(tss);
    }
}
