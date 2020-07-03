package com.stepdefinition;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import com.requestModel.PetStore;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class PetStoreSteps {
	
	static RequestSpecification requestSpecification;
	static Response response;
	
	@Given("^User launches URI$")
	public void user_launches_URI() throws Throwable {
		
		 requestSpecification = RestAssured.with();
		 requestSpecification = requestSpecification.given().contentType(ContentType.JSON).baseUri("https://petstore.swagger.io/v2");
		
		 
	    
	}

	@When("^The user makes the post call to the endpoint \"([^\"]*)\" with \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_makes_the_post_call_to_the_endpoint_with_and(String endPoint, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
	    
		  
		  Map<String,String> headers = new HashMap<String, String>();
		  headers.put("ContentType", "application/json");
		  
		  PetStore pet = new PetStore();
		  pet.setId(Integer.parseInt(arg2));
		  pet.setPetId(Long.parseLong(arg3));
		  pet.setQuantity(Integer.parseInt(arg4));
		  pet.setShipDate(arg5);
		  pet.setStatus(arg6);
		  pet.setComplete(Boolean.parseBoolean(arg7));
		  
		  response = requestSpecification.body(pet).headers(headers).post(endPoint);
		  
		  
		  
		 
		
	}

	@Then("^user need to get a response code: (\\d+)$")
	public void user_need_to_get_a_response_code(int arg1) throws Throwable {
		
		int statusCode = response.getStatusCode();
		System.out.println("status code is :"+statusCode);
		Assert.assertEquals(arg1, statusCode);
	    
	}
	
	static int id;
	
	@Then("^The user validates the \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_validates_the_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
	    
		
		PetStore pet = response.as(PetStore.class);
		System.out.println(arg1);
		 id = pet.getId();
		System.out.println(pet.getId());
		System.out.println(pet.getPetId());
		System.out.println(pet.getQuantity());
		System.out.println(pet.getShipDate());
		System.out.println(pet.getStatus());
		System.out.println(pet.getComplete());
		Assert.assertEquals(Integer.parseInt(arg1), pet.getId());
		
	}
	
	@When("^The user makes a GET call to the resource \"([^\"]*)\"$")
	public void the_user_makes_a_GET_call_to_the_resource(String arg1) throws Throwable {
		
		 Map<String,String> headers = new HashMap<String, String>();
		 headers.put("ContentType", "application/json");
		 
		  response = requestSpecification.headers(headers).get(arg1+String.valueOf(id));
	    
		
		
	}

}
