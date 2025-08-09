package com.FlightBookingSystem.Authentication;

import com.FlightBookingSystem.configs.ConfigLoader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TokenManager {
	
    private static String accessToken;

    
    /**
     * generateToken() is implemented with singleton design, later, can be changed if required.
     * @return String accessToken used for Further actions such as POST, PUT, GET etc.
     * */
    public static String generateToken() {
    	
    	String clientId = ConfigLoader.get("client_id");
    	String clientSecret = ConfigLoader.get("client_secret");
    	String authUrl = ConfigLoader.get("auth_url");

        if (accessToken == null) {
        	
            Response response = RestAssured.given()
            	.baseUri(authUrl)
            	.accept(ContentType.JSON)
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", clientId)
                .formParam("client_secret", clientSecret)
                .post("/token");

            response.then().statusCode(200);

            accessToken = response.jsonPath().getString("access_token");
        }
        
        return accessToken;
    }
}
