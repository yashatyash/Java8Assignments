package com.yash.java8assignments.Ques1;

//WAP to find out average marks from the list of the marks,user will enter the marks through the input box, and you need to fetch them and calculate the marks.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Marks
{
    double marks;

    public Marks(double marks) {
        this.marks = marks;
    }
}

public class Ques1 {
    public static void main(String[] args) {
        //creating list of marks
        List<Marks> marksList = new ArrayList<>();
        double m;

        //taking input from the user
        System.out.println("Enter the count of marks your want to add: ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        //scanner.nextLine();
        for (int counter = 0;counter<length;counter++)
        {
            System.out.println("Enter marks "+(counter+1)+": ");
            m = scanner.nextDouble();
            marksList.add(new Marks(m));
        }

        //calculating the average
        double avgMarks = marksList.stream().collect(Collectors.averagingDouble(s->s.marks));
        System.out.println("Average marks is :"+avgMarks);

        //calculating the total marks
        double totalMarks = marksList.stream().mapToDouble(s -> s.marks).sum();
        System.out.println("Total marks is: "+totalMarks);
    }
}