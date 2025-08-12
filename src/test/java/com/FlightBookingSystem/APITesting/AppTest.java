package com.FlightBookingSystem.APITesting;

import org.testng.TestNG;

public class AppTest {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        
        // Specify the fully qualified names of your test classes
        testng.setTestClasses(new Class[] {
            com.FlightBookingSystem.PassengerService.PassengerServiceClientTest.class,
            com.FlightBookingSystem.Authentication.TokenManagerTest.class
        });
        
        // Optionally, you can add TestNG listeners like Extent Reports listener here if needed.
        // For example:
         testng.addListener(new com.FlightBookingSystem.Listeners.ExtentTestNGListener());

        // Run the tests
        testng.run();
    }
}
