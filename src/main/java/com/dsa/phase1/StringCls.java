package com.dsa.phase1;

public class StringCls {
    public static void main(String[] args) {
        String email = "Sarah.O'brian@gmail.com";
//        String nEmail = email.replace("'", "''");

        boolean ff = email.contains("\'");
        String str = "select id from Contact where Email = " + "\"" + email + "\"";

        System.out.println(str + " - contains apostrophe :" + ff);
    }
}
