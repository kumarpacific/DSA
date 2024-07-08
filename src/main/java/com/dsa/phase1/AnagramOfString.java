package com.dsa.phase1;

import java.util.HashMap;
import java.util.Map;

public class AnagramOfString {
    public static void main(String[] args) {
        String str = "aabacbaaba";
        String ang = "aba";

        /**
         *      a - 2
         *      b - 1
         */

        int solution = 0;

        char[] strChar = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        int count = populateMap(map, ang);

        int i = 0, j = 0;

        while (j < str.length()) {
            if (map.containsKey(strChar[j])) {
                Integer ind = map.get(strChar[j]);
                if(ind > 0){
                    map.put(strChar[j], --ind);
                }
                if(ind == 0){
                    --count;
                }

            }
            if (j - i + 1 < ang.length()) {
                j++;
            } else if (j - i + 1 == ang.length()) {
                if(count == 0){
                    ++solution;
                }
                if(map.containsKey(strChar[i])){
                    int ind = map.get(strChar[i]);
                    map.put(strChar[i], ++ind);
                }else {
                    map.put(strChar[i], 1);
                }
                i++;
                j++;
            }
        }

        System.out.println("Solution :: " + solution);

    }

    private static int populateMap(Map<Character, Integer> map, String ang) {
        char[] angChar = ang.toCharArray();
        int count = 0;
        for (int i = 0; i < angChar.length; i++) {
            if (map.containsKey(angChar[i])) {
                int ind = map.get(angChar[i]);
                map.put(angChar[i], ++ind);
            } else {
                count++;
                map.put(angChar[i], 1);
            }
        }
        return count;
    }


}
