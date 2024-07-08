package com;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Product {
    double price;
}
public class Test1 {

    public void updatePrice(Product product, double price){
        price = price *2;
        product.price = product.price + price;
    }

    public static void main(String[] args) {
        Product prt = new Product();
        prt.price = 200;
        double newPrice = 100;

        Test1 t = new Test1();
        t.updatePrice(prt, newPrice);
        System.out.println(prt.price + " : "+ newPrice);


//        String date = LocalDate.parse("2011-12-03T10:15:30+01:00[Europe/Paris]").format(DateTimeFormatter.ISO_DATE_TIME);
//        System.out.println(date);


        System.out.println("empty sb comparison: "+ new StringBuilder(5).toString().equals(""));
    }
}
