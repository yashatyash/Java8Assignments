package com.yash.java8assignments.Ques3;

//WAP to take name of employee, sort all employee name using stream and print only unique name from it.

import java.util.*;
import java.util.stream.Collectors;

//class Employee
//{
//    String empName;
//
//    public Employee(String empName) {
//        this.empName = empName;
//    }
//}

public class Ques3 {
    public static void main(String[] args) {

        //creating list of employee
        List<String> employees = new ArrayList<>();
        String s;

        //taking input from the user
        System.out.println("Enter the count of names your want to add: ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        for (int counter = 0;counter<length;counter++)
        {
            System.out.println("Enter name "+(counter+1)+": ");
            s = scanner.next();
            employees.add(s);
        }

        //System.out.println(employees);
        HashSet<String> employeeSet = new HashSet<>(employees);
        //employeeSet.stream().sorted().forEach(System.out::println);
        employeeSet = employeeSet.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        for (String s1:employeeSet)
        {
            System.out.println(s1);
        }
    }
}
