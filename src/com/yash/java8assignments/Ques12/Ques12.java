package com.yash.java8assignments.Ques12;

//WAP to find maximum of 5 no , pass array to lambda expression , and return the maximum using lambda expression. dont use nested if else.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Maxable
{
    Integer max(Integer[] arr);
}

public class Ques12 {
    public static void main(String[] args) {

        Integer[] array = {50,45,62,110,98};
        List<Integer> list = new ArrayList<>();
        Maxable maxable = (Integer[] arr)->
        {
            list.addAll(Arrays.asList(arr));
            return list.stream().max(Integer::compare).get();
        };

        System.out.println("Maximum num in the array is: "+maxable.max(array));
    }
}
