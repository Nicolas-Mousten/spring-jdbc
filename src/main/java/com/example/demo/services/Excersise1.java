package com.example.demo.services;
//Exercise 1
//Implement a method with the following functionality:
//If the method receives:
//5-12 return "morning"
//12-16 return "afternoon"
//16-22 return "evening"
//22-5 return "night"
//Identify equivalence partitions
//Unit-test the code
public class Excersise1 {
    public String politeGreeting(int time){
        String output = "";
        output = time>=5 && time<12 ? "Morning":output;
        output = time>=12 && time<16 ? "Afternoon":output;
        output = time>=16 && time<22 ? "Evening":output;

        output = time>=22 && time<24 ? "Night":output;
        output = time>=0 && time<5 ? "Night":output;
        return output;
    }
}
