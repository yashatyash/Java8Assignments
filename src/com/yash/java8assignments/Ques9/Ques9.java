package com.yash.java8assignments.Ques9;

//WAP to implement predicate to check given list of array contain how many even and odd nos.

import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Ques9 {
    public static void main(String[] args) {

        IntPredicate isOdd = a -> a % 2 == 1;
        IntPredicate isEven = a -> a % 2 == 0;

        //List<Integer> list = Arrays.asList(1, 5, 6, 8, 9, 2, 15, 20, 31, 25, 95, 85, 74, 36);

        //IntStream list = IntStream.of(1, 5, 6, 8, 9, 2, 15, 20, 31, 25, 95, 85, 74, 36);

        //creating predicates
        List<Integer> oddList = IntStream.of(1, 5, 6, 8, 9, 2, 15, 20, 31, 25, 95, 85, 74, 36).filter(isOdd).boxed().toList();
        List<Integer> evenList = IntStream.of(1, 5, 6, 8, 9, 2, 15, 20, 31, 25, 95, 85, 74, 36).filter(isEven).boxed().toList();

        //printing odd numbers data
        System.out.println("No. of odd items: "+oddList.size());
        System.out.println("Odd nos of the list are: ");
        oddList.forEach(System.out::println);

        //printing even numbers data
        System.out.println("No. of even items: "+evenList.size());
        System.out.println("Even nos of the list are: ");
        evenList.forEach(System.out::println);
    }
}
