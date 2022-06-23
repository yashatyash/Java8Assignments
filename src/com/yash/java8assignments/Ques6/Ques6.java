package com.yash.java8assignments.Ques6;

//WAP to create list of item price whose price is less than avg price of all item.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Price{
    int itemPrice;

    public Price(int itemPrice) {
        this.itemPrice = itemPrice;
    }
}

public class Ques6 {
    public static void main(String[] args) {

        //creating list of item price
        List<Price> priceList = new ArrayList<>();
       //adding elements to list
        priceList.add(new Price(10));
        priceList.add(new Price(100));
        priceList.add(new Price(50));
        priceList.add(new Price(75));
        priceList.add(new Price(20));
        priceList.add(new Price(35));
        priceList.add(new Price(98));

        double avgPrice = priceList.stream().collect(Collectors.averagingInt(s-> s.itemPrice));
        System.out.println("Average is: "+avgPrice);
        List<Integer> list =
                priceList.stream().filter(s->s.itemPrice<avgPrice).map(e->e.itemPrice).collect(Collectors.toList());

        list.forEach(System.out::println);
    }
}
