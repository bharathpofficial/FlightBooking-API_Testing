package com.FlightBookingSystem.PassengerService;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import com.FlightBookingSystem.configs.ConfigLoader;


public class PassengerServiceClient {

    private static final String BASE_URL = ConfigLoader.get("passenger_base_url"); // from properties file

    private RequestSpecification requestSpec;

    public PassengerServiceClient(String token) {
        requestSpec = new RequestSpecBuilder()
            .setBaseUri(BASE_URL)
            .addHeader("Authorization", "Bearer " + token)
            .addHeader("Accept", "application/json")
            .build();
    }

    /**
     * Add Passenger - POST /addPassenger
     * @author Divya
     */
    public Response addPassenger(Passenger passenger) {
        return given()
            .spec(requestSpec)
            .contentType("application/x-www-form-urlencoded")
            .formParam("passengerId", passenger.getPassengerId())
            .formParam("passengerName", passenger.getPassengerName())
            .formParam("passengerMobile", passenger.getPassengerMobile())
            .formParam("passengerGender", passenger.getPassengerGender())
            .formParam("passengerAadhaarNumber", passenger.getPassengerAadhaarNumber())
            .formParam("passengerAddress", passenger.getPassengerAddress())
            .when()
            .post("/addPassenger")
            .then()
            .extract()
            .response();
    }

    /**
     * View Passenger by Id - GET /viewPassengerById/{passengerId}
     * @author adamya
     */
    public Response getPassengerById(int passengerId) {
        return given()
            .spec(requestSpec)
            .when()
            .get("/viewPassengerById/" + passengerId)
            .then()
            .extract()
            .response();
    }

    /**
     * View Passenger List - GET /viewPassengerList
     * @author windass
     */
    public Response getPassengerList() {
        return given()
            .spec(requestSpec)
            .when()
            .get("/viewPassengerList")
            .then()
            .extract()
            .response();
    }

    /**
     * View Passenger by Name and Mobile - GET /viewPassengerByNameMobile/{passengerName}/{passengerMobile}
     * @author Divya
     */
    public Response getPassengerByNameMobile(String passengerName, String passengerMobile) {
        return given()
            .spec(requestSpec)
            .when()
            .get("/viewPassengerByNameMobile/" + passengerName + "/" + passengerMobile)
            .then()
            .extract()
            .response();
    }

    /**
     * Delete Passenger by Id - DELETE /deletePassengerById/{passengerId}
     * @author adamya
     */
    public Response deletePassengerById(int passengerId) {
        return given()
            .spec(requestSpec)
            .when()
            .delete("/deletePassengerById/" + passengerId)
            .then()
            .extract()
            .response();
    }
}
