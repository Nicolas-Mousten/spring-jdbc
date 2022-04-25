package com.example.demo.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Excersise2Test {

    @Test
    void validDepartmentNumber() {
        //Arrange
        Excersise2 ex = new Excersise2();
        boolean expectedFalse = false;
        boolean expectedTrue = true;
        boolean expectedFalseRest = false;
        boolean expectedTrueRest = true;

        //Act
        boolean expectedFalseResult = ex.validDepartmentNumber(2444);
        boolean expectedTrueResult = ex.validDepartmentNumber(230);
        boolean expectedFalseRestResult = ex.validDepartmentNumber(23);
        boolean expectedTrueRestResult = ex.validDepartmentNumber(200);





        //Assert
        assertEquals(expectedFalse,expectedFalseResult);
        assertEquals(expectedTrue,expectedTrueResult);
        assertEquals(expectedFalseRest,expectedFalseRestResult);
        assertEquals(expectedTrueRest,expectedTrueRestResult);


    }
}