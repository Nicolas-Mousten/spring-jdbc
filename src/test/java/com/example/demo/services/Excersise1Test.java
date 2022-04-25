package com.example.demo.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Excersise1Test {

    @Test
    void politeGreeting() {
        //Arrange
        Excersise1 ex = new Excersise1();
        String expectedMorning = "Morning";
        String expectedNight = "Night";
        String expectedEvening = "Evening";

        //Act
        String expectedMorningResult = ex.politeGreeting(6);
        String expectedNightResult = ex.politeGreeting(3);
        String expectedEveningResult = ex.politeGreeting(17);



        //Assert
        assertEquals(expectedMorning,expectedMorningResult);
        assertEquals(expectedEvening,expectedEveningResult);
        assertEquals(expectedNight,expectedNightResult);
    }
}