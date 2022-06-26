package com.yash.java8assignments.Ques17;

//User will enter employee detail like emp name, date of birth , date of joining, date of resign, work location, department, salary. Now we will check following details.
//a. Employee in a particular department.
//b. Average salary of each department.
//c. Highest and lowest salary of each department.
//d. Department with the highest no of employee and lowest no of employee.
//e. Total number of years of experience of each employee.
//f. Upcoming birthday and job anniversary in current month from current date to last date of month.

import com.yash.java8assignments.Ques16.DateOperations;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

class Employee
{
    private String empName;
    private double empSalary,empExperiance;
    private LocalDate dateofBirth,dateOfJoining,dateOfExit;

    private String departmentName,workLocation;

    public Employee(String empName, double empSalary, double empExperiance, LocalDate dateOfJoining, LocalDate dateOfExit, String departmentName, String workLocation,LocalDate dateofBirth) {
        this.empName = empName;
        this.empSalary = empSalary;
        this.empExperiance = empExperiance;
        this.dateOfJoining = dateOfJoining;
        this.dateOfExit = dateOfExit;
        this.departmentName = departmentName;
        this.workLocation = workLocation;
        this.dateofBirth = dateofBirth;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public LocalDate getDateOfExit() {
        return dateOfExit;
    }

    public void setDateOfExit(LocalDate dateOfExit) {
        this.dateOfExit = dateOfExit;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public double getEmpExperiance() {
        return empExperiance;
    }

    public void setEmpExperiance(double empExperiance) {
        this.empExperiance = empExperiance;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }
}

public class Ques17 {
    String empName;
    double empSalary,empExperiance;
    String dateofBirth,dateOfJoining,dateOfExit,departmentName,workLocation;

    static List<Employee> employeeList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int options;
        while (true) {
            System.out.println("""
                    Enter 1 to add new employee.
                    Enter 2 to check employee department-wise.
                    Enter 3 to check the average salary of each department.
                    Enter 4 to check the highest and the lowest salary of each department.
                    Enter 5 to check Department with the highest no of employee and lowest no of employee.
                    Enter 6 to check Total number of years of experience of each employee.
                    Enter 7 to check Upcoming birthday and job anniversary in current month from current date to last date of month.
                    Enter 8 to Exit.""");
            options = scanner.nextInt();
            scanner.nextLine();
            switch (options) {
                case 1->
                {
                    new Ques17().addEmployee();
                }
                case 2->
                {
                    new Ques17().checkEmpByDepartment();
                }
                case 3->
                {
                    new Ques17().checkAvgSalaryByDepartment();
                }
                case 4->
                {
                    new Ques17().checkHnLSalary();
                }
                case 5->
                {
                    new Ques17().checkHnLEmp();
                }
                case 6->
                {
                    new Ques17().checkExpofEmp();
                }
                case 7->
                {
                    new Ques17().checkBirth();
                }
                case 8->
                {
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid Entry");
            }
        }
    }

    private void addEmployee()
    {
        System.out.println("Enter employee name: ");
        empName = scanner.nextLine();
        System.out.println("Enter employee salary: ");
        empSalary = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Enter employee Date of Birth: ");
        dateofBirth = scanner.nextLine();
        try {
            dateofBirth = new DateOperations().dateConversion(dateofBirth);
        } catch (Exception e) {
            System.out.println("Invalid entry");
            throw new RuntimeException(e);
        }
        System.out.println("Enter employee Date of Joining: ");
        dateOfJoining = scanner.nextLine();
        try {
            dateOfJoining = new DateOperations().dateConversion(dateOfJoining);
        } catch (Exception e) {
            System.out.println("Invalid entry");
            throw new RuntimeException(e);
        }
        System.out.println("Is this employee working with us ? \nPress 'Y' for Yes or 'N' of No");
        String ch = scanner.nextLine();
        if (ch.equalsIgnoreCase("N"))
        {
            System.out.println("Enter employee Date of Joining: ");
            dateOfExit = scanner.nextLine();
            try {
                dateOfExit = new DateOperations().dateConversion(dateOfExit);
            } catch (Exception e) {
                System.out.println("Invalid entry");
                throw new RuntimeException(e);
            }
        }
        System.out.println("Enter department name: ");
        departmentName = scanner.nextLine();
        System.out.println("Enter work location: ");
        workLocation = scanner.nextLine();
        System.out.println("Enter employee experience: ");
        empExperiance = scanner.nextDouble();

        //adding dynamic employee to list
        employeeList.add(new Employee(empName, empSalary, empExperiance, new DateOperations().stringToDate(dateOfJoining), new DateOperations().stringToDate(dateOfExit), departmentName,
                workLocation, new DateOperations().stringToDate(dateofBirth)));

//        //some static data for testing
//        //employee 1
//        employeeList.add(new Employee("Yash",35000.0,2.5,LocalDate.of(2022, Month.APRIL, 18),null,"Development","Pune",LocalDate.of(1995, Month.MARCH, 5)));
//        //employee 2
//        employeeList.add(new Employee("Akash",75000.0,3,LocalDate.of(2018, 6, 26),null,"Development","Pune",LocalDate.of(1996, 5, 29)));
//        //employee 3
//        employeeList.add(new Employee("Abhishek",32000.0,0.6,LocalDate.of(2020, 6, 26),null,"Development","Delhi",LocalDate.of(1997, 6, 26)));
//        //employee 4
//        employeeList.add(new Employee("Payal",47000.0,6.8,LocalDate.of(2016, 11, 20),null,"Sales","Hyderabad",LocalDate.of(1992, 10, 15)));

        System.out.println("Item added successfully");
        System.out.println();
    }

    //a. Employee in a particular department.
    private void checkEmpByDepartment()
    {
        //checking if list is empty
        if (employeeList.size()!=0)
        {
            System.out.println("Enter the Department name you want to search: ");
            departmentName = scanner.nextLine();
            List<String> list = employeeList.stream().filter(depratment->depratment.getDepartmentName().equalsIgnoreCase(departmentName)).map(Employee::getEmpName).collect(Collectors.toList());
            System.out.println("Employee(s) working in the department - "+departmentName.toUpperCase()+" are: ");
            for (String s:list)
                System.out.println(s);
            System.out.println();
        }
        else
            System.out.println("No employee in the record");
    }

    //b. Average salary of each department.
    private void checkAvgSalaryByDepartment()
    {
        //checking if list is empty
        if (employeeList.size()!=0)
        {
            List<String> depName = employeeList.stream().filter(employee -> employee.getDepartmentName()!=null).map(Employee::getDepartmentName).distinct().collect(Collectors.toList());
            //System.out.println(depName);
            Iterator<String> iterator = depName.iterator();
            while (iterator.hasNext())
            {
                String dpName = iterator.next();
                OptionalDouble avgsal =
                        employeeList.stream().filter(employee -> employee.getDepartmentName().equals(dpName)).mapToDouble(Employee::getEmpSalary).average();
                System.out.println("Average Salary of Department "+dpName.toUpperCase()+" is: "+avgsal.getAsDouble());
            }
            System.out.println();
        }
        else
            System.out.println("No employee in the record");
    }

    //c. Highest and lowest salary of each department.
    private void checkHnLSalary()
    {
        //checking if list is empty
        if (employeeList.size()!=0)
        {
            List<String> depName = employeeList.stream().filter(employee -> employee.getDepartmentName()!=null).map(Employee::getDepartmentName).distinct().collect(Collectors.toList());
            Iterator<String> iterator = depName.iterator();
            while (iterator.hasNext())
            {
                String dpName = iterator.next();
                OptionalDouble maxSalary = employeeList.stream().filter(employee -> employee.getDepartmentName().equals(dpName)).mapToDouble(Employee::getEmpSalary).max();
                OptionalDouble minSalary = employeeList.stream().filter(employee -> employee.getDepartmentName().equals(dpName)).mapToDouble(Employee::getEmpSalary).min();
                System.out.println("Maximum Salary of Department "+dpName+" is: "+maxSalary.getAsDouble());
                System.out.println("Minimum Salary of Department "+dpName+" is: "+minSalary.getAsDouble());
            }
            System.out.println();
        }
        else
            System.out.println("No employee in the record");
    }

    //d. Department with the highest no of employee and lowest no of employee.
    private void checkHnLEmp()
    {
        //checking if list is empty
        if (employeeList.size()!=0)
        {
            List<String> depName = employeeList.stream().filter(employee -> employee.getDepartmentName()!=null).map(Employee::getDepartmentName).distinct().collect(Collectors.toList());
            HashMap<String, Integer> mp = new HashMap<>();
            Iterator<String> iterator = depName.iterator();
            while (iterator.hasNext())
            {
                String dpName = iterator.next();
                Integer empCount = Math.toIntExact(employeeList.stream().filter(employee -> employee.getDepartmentName().equals(dpName)).map(Employee::getEmpName).count());
                mp.put(dpName, empCount);
            }
            //System.out.println(mp);
            //checking for highest employee
            System.out.println("Department with Highest employees:- "+mp.entrySet().stream().max((o1, o2) -> o1.getValue()> o2.getValue()?1:-1).get()+" employee(s)");

            //checking for lowest employee
            System.out.println("Department with Lowest employees:- "+mp.entrySet().stream().min((o1, o2) -> o1.getValue()> o2.getValue()?1:-1).get()+" employee(s)");
            System.out.println();
        }
        else
            System.out.println("No employee in the record");
    }

    //e. Total number of years of experience of each employee.
    private void checkExpofEmp()
    {
        //checking if list is empty
        if (employeeList.size()!=0)
        {
            List<Employee> list = employeeList.stream().filter(employee -> employee.getEmpExperiance()!=0).collect(Collectors.toList());
            for (Employee e:list)
                System.out.println("Total experience of "+e.getEmpName()+" is: "+e.getEmpExperiance());
            System.out.println();
        }
        else
            System.out.println("No employee in the record");
    }

    //f. Upcoming birthday in current month from current date to last date of month.
    private void checkBirth()
    {
        //checking if list is empty
        if (employeeList.size()!=0)
        {
            //creating a variable for no birthday check
            int flag = 0;

            //creating map for employee and birthdate
            Map<String, LocalDate> empBirth = employeeList.stream().collect(Collectors.toMap(Employee::getEmpName,Employee::getDateofBirth));
            for (String s: empBirth.keySet())
            {
                //getting date from DOB
                int date = empBirth.get(s).getDayOfMonth();

                //getting month from DOB
                Month month = empBirth.get(s).getMonth();

                //getting current date and month
                LocalDate current = LocalDate.now();
                int currentDate = current.getDayOfMonth();
                Month currentMonth = current.getMonth();

                //getting last day of month
                int lastDayOfMonth = Calendar.getInstance().getActualMaximum(Calendar.DATE);

                //checking if the current date is the birthdate
                if (date==currentDate && month==currentMonth)
                {
                    flag = 1;
                    System.out.println("Happy Birthday, " + s + " !!");
                    System.out.println();
                }
                //Upcoming birthday in current month from current date to last date of month.
                else if ((currentDate<=date && date<=lastDayOfMonth ) && month==currentMonth)
                {
                    int diff = date-currentDate;
                    flag = 1;
                    System.out.println("Upcoming Birthday of employee "+s+" in "+diff+" days.");
                    System.out.println();
                }
            }
            if (flag!=1)
            {
                System.out.println("There is no birthday in this month.");
                System.out.println();
            }
            new Ques17().checkAnni();
        }
        else
            System.out.println("No employee in the record");
    }
    //f. Upcoming job anniversary in current month from current date to last date of month.
    private void checkAnni()
    {
        if (employeeList.size()!=0) {
            //creating a variable for no anniversary check
            int flag = 0;

            //creating map for employee and joining date
            Map<String, LocalDate> empJoin = employeeList.stream().collect(Collectors.toMap(Employee::getEmpName, Employee::getDateOfJoining));
            for (String s : empJoin.keySet()) {
                //getting date from DOJ
                int date = empJoin.get(s).getDayOfMonth();

                //getting month from DOJ
                Month month = empJoin.get(s).getMonth();

                //getting current date and month
                LocalDate current = LocalDate.now();
                int currentDate = current.getDayOfMonth();
                Month currentMonth = current.getMonth();

                //getting the number of years of this employee in the organization
                long year = ChronoUnit.YEARS.between(empJoin.get(s), current);

                //getting last day of month
                int lastDayOfMonth = Calendar.getInstance().getActualMaximum(Calendar.DATE);

                //checking if the current date is the birthdate
                if (date == currentDate && month == currentMonth && year >= 1) {
                    flag = 1;
                    System.out.println("Congratulations, " + s + " !! You have successfully completed " + year + " year(s) in the organization.");
                    System.out.println();
                }
                //Upcoming anniversary in current month from current date to last date of month.
                else if ((currentDate <= date && date <= lastDayOfMonth) && month == currentMonth) {
                    int diff = date - currentDate;
                    flag = 1;
                    System.out.println("Upcoming Anniversary of employee " + s + " in " + diff + " days.");
                    System.out.println();
                }
            }
            if (flag != 1)
            {
                System.out.println("There is no Anniversary in this month.");
                System.out.println();
            }
        }
    }
}