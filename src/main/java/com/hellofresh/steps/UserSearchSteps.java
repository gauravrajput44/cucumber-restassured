package com.hellofresh.steps;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import org.junit.Assert;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;

public class UserSearchSteps {

	private RequestSpecification request;
	private Response response;

	@Step
	public void constructRequestQueryParam(String queryParam, String code) {
		request = given().param("q", "" + queryParam + ":" + code);

	}

	@Step
	public void constructRequestPathParam(String pathParam, String code) {
		request = given().pathParam("pathParam", code);

	}

	@Step
	public void searchByCode(String codeSearch) {
		response = request.when().get(codeSearch);

	}

	@Step
	public void searchIsExecutedSuccesfully(int statusCode) {
		response.then().statusCode(statusCode);
	}

	@Step
	public void iShouldFindResponse(String expected) {
		response.then().body("RestResponse.result.name", is(expected));
	}
	
	@Step
	public void iShouldFindNoMatchResponse(String expected) {
		ResponseBody body = response.getBody();
		String bodyStringValue = body.asString();
		Assert.assertTrue(bodyStringValue.contains(expected));
	}

}