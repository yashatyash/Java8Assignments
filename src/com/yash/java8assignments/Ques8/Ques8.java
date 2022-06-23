package com.yash.java8assignments.Ques8;

//WAP to implement predicate to check given no is even or not

import java.util.function.IntPredicate;

public class Ques8 {
    public static void main(String[] args) {

        IntPredicate isEven = a -> a % 2 == 0;

        //checking num if even or not
        System.out.println(isEven.test(9));
        System.out.println(isEven.test(10));
    }
}
