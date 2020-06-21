package main.java.model;

import java.util.Comparator;

public class Employee {

    private String name;
    private Double salary;

    // This is the constructor of the class Employee
    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, double salary) {
        this(name);
        this.salary = salary;
    }

    /* Assign the salary to the variable salary.*/
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /* Print the Employee details */
    public void print() {
        System.out.println("Name:"+ name);
        System.out.println("Salary:" + salary);
    }

    public static final Comparator<Employee> comparatorByName = (a, b) -> a.name.compareTo(b.name);
    public static final Comparator<Employee> comparatorBySalary = (a, b) -> a.salary.compareTo(b.salary);
}
