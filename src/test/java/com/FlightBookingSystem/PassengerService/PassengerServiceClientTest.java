package com.FlightBookingSystem.PassengerService;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

import com.FlightBookingSystem.Authentication.TokenManager;

import io.restassured.response.Response;

public class PassengerServiceClientTest {
	
	String token = TokenManager.generateToken();  // Or however you get your token
	PassengerServiceClient passengerServiceClient = new PassengerServiceClient(token);

    @Test
    public void testGetPassengerList_ValidatesJsonSchema() {
        Response response = passengerServiceClient.getPassengerList();

        response.then()
                .statusCode(200)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("passengerListSchema.json"));
    }
}
