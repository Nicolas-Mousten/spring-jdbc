package com.example.demo.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Excersise3Test {

    @Test
    void employeeControl() {
        //Arrange
        Excersise3 ex = new Excersise3();
        boolean expectedFalse = false;
        boolean expectedTrue = true;

        //Act
        boolean expectedFalseResult = ex.employeeControl(new Employee("Nicolas",1000,2000));
        boolean expectedTrueResult = ex.employeeControl(new Employee("Adam",2000,1000));




        //Assert
        assertEquals(expectedFalse,expectedFalseResult);
        assertEquals(expectedTrue,expectedTrueResult);

    }
}