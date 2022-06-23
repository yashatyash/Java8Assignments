package com.yash.java8assignments.Ques10;

//WAP to create 10 objects of employee class, add all object to arraylist and from arraylist we need to convert this to map and set using stream api.

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Employee
{
    int empId;
    String empName;

    public Employee(int empId, String empName) {
        this.empId = empId;
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}

public class Ques10 {
    public static void main(String[] args) {

        //creating list of employee
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"A"));
        employeeList.add(new Employee(2,"B"));
        employeeList.add(new Employee(3,"C"));
        employeeList.add(new Employee(4,"D"));
        employeeList.add(new Employee(5,"E"));
        employeeList.add(new Employee(6,"F"));
        employeeList.add(new Employee(7,"G"));
        employeeList.add(new Employee(8,"H"));
        employeeList.add(new Employee(9,"I"));
        employeeList.add(new Employee(10,"J"));

        //converting list to map
        Map<Integer, String> employeeMap = employeeList.stream().collect(Collectors.toMap(Employee::getEmpId,
                Employee::getEmpName));
        System.out.println(employeeMap);

        //converting list to set
        Set<Employee> employeeSet = employeeList.stream().collect(Collectors.toSet());
        for (Employee emp:employeeSet)
            System.out.println("Emp id: "+emp.empId+" Emp name: "+emp.empName);
    }
}
