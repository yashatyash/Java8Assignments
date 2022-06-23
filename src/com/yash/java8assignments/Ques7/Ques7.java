package com.yash.java8assignments.Ques7;

//WAP to print only those price which are even from the given item list.

import java.util.Arrays;
import java.util.List;

public class Ques7 {
    public static void main(String[] args) {

        List<Integer> priceList = Arrays.asList(10,25,74,85,67,32,41,20);

        //printing even prices from the list
        priceList.stream().filter(p->p % 2 == 0).sorted().forEach(System.out::println);
    }
}
