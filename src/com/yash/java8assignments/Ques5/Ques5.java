package com.yash.java8assignments.Ques5;

//WAP to find the maximum length of given string without using any length function use stream api.

import java.util.ArrayList;
import java.util.List;

public class Ques5 {
    public static void main(String[] args) {

        String[] array = {"Australia","London","Sweden","Denmark","Philippines"};
        List<Integer> count = new ArrayList<>();
        for (String s:array)
        {
            int i =0;
            char[] arr = s.toCharArray();
            for (char ch : arr)
                i++;
            count.add(i);
        }
        Integer length = count.stream().max((e1,e2)->e1>e2?1:-1).get();
        System.out.println("Maximum length of the string in array is: "+length);
    }
}
