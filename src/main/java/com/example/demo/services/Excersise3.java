package com.example.demo.services;
class Employee{
    private String name;
    private int salary;
    private int commission;

    public Employee(String name, int salary, int commission) {
        this.name = name;
        this.salary = salary;
        this.commission = commission;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    public int getCommission() {
        return commission;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", commission=" + commission +
                '}';
    }
}
public class Excersise3 {
    //Exercise 3 - employees and departments
    //Implement a method with the following functionality:
    //An employee can never receive a higher commission than their base salary
    //The method receives an employee object and returns true if the salary is valid
    //The method returns false if the salary is not valid
    //Unit-test the code
    public boolean employeeControl(Employee person){
        int salary = person.getSalary();
        int commission = person.getCommission();
        if(commission>salary){
            return false;
        }else{
            return true;
        }
    }
}
