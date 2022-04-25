package com.example.demo.services;

public class Excersise2 {
    //Exercise 2
    //Implement a method with the following functionality:
    //A valid department number has:
    //2 or 3 digits
    //Is divisible by 10 (meaning that 21 is not valid where 20 is valid)
    //Unit-test the code

    public boolean validDepartmentNumber(int number){
        int numberOfDigits = String.valueOf(number).length();
        int rest = number%10;

        if(numberOfDigits==2 && rest==0 || numberOfDigits==3 && rest==0){
            return true;
        }
        else{
            return false;
        }
    }
}
