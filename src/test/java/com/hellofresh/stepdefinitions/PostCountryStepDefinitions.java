package com.hellofresh.stepdefinitions;

import com.hellofresh.steps.UserPostCountrySteps;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;

public class PostCountryStepDefinitions {

	@Steps
	UserPostCountrySteps userPostCountrySteps;

	@Given("^I send an insert country request to the server \\\"([^\\\"]*)\\\" \\\"([^\\\"]*)\\\" \\\"([^\\\"]*)\"$")
	public void i_send_insert_country_request_to_the_server (String countryName, String alpha2Code, String alpha3Code) {
		userPostCountrySteps.registerNewCountry(countryName, alpha2Code, alpha3Code);
	}
}
