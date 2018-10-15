package com.hellofresh.steps;


import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import net.thucydides.core.annotations.Step;
import static io.restassured.RestAssured.*;

public class UserPostCountrySteps {
	
	@Step
	public void registerNewCountry(String countryName, String alpha2Code, String alpha3Code) {
		
		
		RestAssured.baseURI = "http://services.groupkt.com/country";
		RestAssured.basePath = "/post/";
		
		Map<String, String> map = new HashMap<>();
		map.put("name", countryName);
		map.put("alpha2_code", alpha2Code);
		map.put("alpha3_code", alpha3Code);
		given()
		.contentType("application/json")
		.body(map)
		.when()
		.post()
		.then()
		.statusCode(201);
        
        
	}
}
