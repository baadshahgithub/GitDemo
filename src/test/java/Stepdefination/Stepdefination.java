package Stepdefination;

import static org.junit.Assert.assertEquals;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

import groovyjarjarantlr.Utils;

import static io.restassured.RestAssured.given;  

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Addplace;
import pojo.location;
import pojo.types;
import resources.APIResource;
import resources.APIResource;
import resources.Testdata;
import resources.Utils_data;

public class Stepdefination extends Utils_data {
	static RequestSpecification req;
	public static Response res;
	
public static String placeId;

	Testdata td = new Testdata();	
	JsonPath js;
	// ==============================
	// GIVEN - Build Request & Payload
	// ==============================
	@Given("Add place Payload {string} {string} {string}")
	public void add_place_payload(String name, String address, String language)
	        throws IOException {

	    req = given()
	            .spec(requestSpecification())
	            .body(td.addplacePayload(name, address, language));
	}

	// WHEN - Call API

	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resource,String method) {

		APIResource apiResource = APIResource.valueOf(resource);

	    String resourceAPI = apiResource.getResource();
		
		 if(method.equalsIgnoreCase("POST")) {
		        res = given().spec(req).when().post(resourceAPI);
		    }
		    else if(method.equalsIgnoreCase("GET")) {
		        res = given().spec(req).when().get(resourceAPI);
		    }
		    else if(method.equalsIgnoreCase("DELETE")) {
		        res = given().spec(req).when().delete(resourceAPI);
		    }
		 
		 String payload = res.asPrettyString();
		 System.out.println(payload);
		 
	}

	// THEN - Validate Status Code

	@Then("then API call is sucess with status code {int}")
	public void then_api_call_is_sucess_with_status_code(Integer statusCode) {

		assertEquals(statusCode.intValue(), res.getStatusCode());
		System.out.println(res.getStatusCode());
		
	}

	// ==============================
	// AND - Validate Response Body
	// ==============================
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedValue) {

		if (res == null) {
			System.out.println("RESQUEST IS NULL ");
			throw new RuntimeException("RESQUEST object is null");
		} else {

		}

		String actualValue = res.jsonPath().getString(key);
		

		assertEquals(getJsonpath(res, key), actualValue);
	}
	
	@Then("verify place_Id created maps to {string} using {string}")

	public void verify_place_id_created_maps_to_using(String string, String resorucename) throws IOException {

	    // Write code here that turns the phrase above into concrete actions
		 placeId = getJsonpath(res, "place_id");
		
		 req = given()
		            .spec(requestSpecification()).queryParam("place_id", placeId);
		 user_calls_with_post_http_request(resorucename, "GET");
	  }
	@Given("Add deletePlace payload")
	public void add_delete_place_payload() throws IOException {
		 req = given()
		            .spec(requestSpecification()).body(td.deletePayload(placeId));
		         
	
	}


}