package com.FlightBookingSystem.PassengerService;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.FlightBookingSystem.Authentication.TokenManager;

import io.restassured.response.Response;

public class PassengerServiceClientTest {
	
	String token = TokenManager.generateToken();  // Or however you get your token
	PassengerServiceClient passengerServiceClient = new PassengerServiceClient(token);

    /**
     * Validate that the GET /viewPassengerList endpoint returns a successful response
     * and the response JSON body matches the expected JSON schema (array of passengers).
     */
    @Test
    public void testGetPassengerList_ValidatesJsonSchema() {
        Response response = passengerServiceClient.getPassengerList();

        response.then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("passengerListSchema.json"));
    }
    
    /**
     * Validate that the GET /viewPassengerById/{passengerId} endpoint returns a successful response
     * and the response JSON body matches the expected JSON schema for a single passenger object.
     */
    @Test
    public void testGetPassengerById_ValidatesJsonSchema() {
        int passengerId = 1; // Example passenger ID to test

        Response response = passengerServiceClient.getPassengerById(passengerId);

        response.then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("passengerSchema.json")); // Single passenger schema
    }
    
    /**
     * Validate that the DELETE /deletePassengerById/{passengerId} endpoint successfully deletes
     * the passenger with the given ID. The test asserts the response status code and verifies that
     * the deleted passenger ID is no longer present in the response.
     */
    @Test
    public void testDeletePassengerById_ReturnsSuccess() {
        int passengerIdToDelete = 1; // Use a valid passenger ID you want to test deletion for

        Response response = passengerServiceClient.deletePassengerById(passengerIdToDelete);

        // Assert status code 200 or 204 if no content on successful deletion
        response.then()
                .statusCode(200);

        // Extract the list of passengerIds from the response JSON
        List<Integer> passengerIds = response.jsonPath().getList("passengerId");

        // Assert passengerId 1 is NOT present
        Assert.assertFalse(passengerIds.contains(passengerIdToDelete), "Passenger with ID 1 should not be present");
    }
}

