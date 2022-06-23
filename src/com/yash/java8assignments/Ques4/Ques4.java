package com.yash.java8assignments.Ques4;

//WAP to find maximum from array of numbers with the help of stream api.

import java.util.Arrays;
import java.util.List;

public class Ques4 {
    public static void main(String[] args) {

        List<Integer> arrayList = Arrays.asList(10,50,22,34,2,65,41,98,75);
        int max = arrayList.stream().max(Integer::compare).get();
        System.out.println("Maximum number is: "+max);
    }
}
