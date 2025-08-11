package com.FlightBookingSystem.Authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TokenManagerTest {
	
	/**
	 * @author windass
	 * */

    @Test
    public void testAccessToken() {
        // Call the method to generate the token
        String token = TokenManager.generateToken();

        // Validate that the token is not null or empty
        Assert.assertNotNull(token, "Access token should not be null");
        Assert.assertFalse(token.isEmpty(), "Access token should not be empty");

        // Optional: further validation can be done by making a request using this token
        // to a protected resource endpoint if available, to verify token validity.
    }
}
