package com.stepdefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.requestModel.Category;
import com.requestModel.PetDetails;
import com.requestModel.Tags;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;


public class PetDetailsSteps {
	
	static String petId;
	static int ID;
	
	@When("^user make POST call on the pet status endpoint for available pets \"([^\"]*)\"$")
	public void user_make_POST_call_on_the_pet_status_endpoint_for_available_pets(String arg1, DataTable arg2) throws Throwable {
	    
		 Map<String,String> headers = new HashMap<String, String>();
		  headers.put("ContentType", "application/json");
		  
		  List<String> datas = arg2.asList(String.class);
		  
		  petId = datas.get(0);
		  
		  PetDetails pet = new PetDetails();
		  pet.setId(Integer.parseInt(datas.get(0)));
		  
		  Category category = new Category();
		  category.setId(Integer.parseInt(datas.get(1)));
		  category.setName(datas.get(2));
		  pet.setCategory(category);
		  
		  pet.setName(datas.get(3));
		  
		  List<String> li = new ArrayList<String>();
		  li.add(datas.get(4));
		  li.add(datas.get(5));
		  pet.setPhotoUrls(li);
		  
		  
		  List<Tags> tagList = new ArrayList<Tags>();
		  Tags tags= new Tags();
		  tags.setId(Integer.parseInt(datas.get(6)));
		  tags.setName(datas.get(7));
		  
		  Tags tags1= new Tags();
		  tags1.setId(Integer.parseInt(datas.get(8)));
		  tags1.setName(datas.get(9));
		  
		  tagList.add(tags);
		  tagList.add(tags1);
			  
		  pet.setTags(tagList);
		  
		  pet.setStatus(datas.get(10));
		  
		  PetStoreSteps.response = PetStoreSteps.requestSpecification.body(pet).headers(headers).post(arg1);
		  
		  
		  
	}

	@Then("^User validates the response of pets$")
	public void user_validates_the_response_of_pets() throws Throwable {
		
		PetDetails pet = PetStoreSteps.response.as(PetDetails.class);
		System.out.println(pet.getId());
		ID = pet.getId();
		Assert.assertEquals(pet.getId(), Integer.parseInt(petId));
		System.out.println(pet.getCategory().getId());
		System.out.println(pet.getCategory().getName());
		System.out.println(pet.getName());
		System.out.println(pet.getPhotoUrls().get(0));
		System.out.println(pet.getPhotoUrls().get(1));
		System.out.println(pet.getTags().get(0).getId());
		System.out.println(pet.getTags().get(0).getName());
		System.out.println(pet.getTags().get(1).getId());
		System.out.println(pet.getTags().get(1).getName());
		System.out.println(pet.getStatus());
		
	    
	}

	@When("^The user makes a GET call to the resources \"([^\"]*)\"$")
	public void the_user_makes_a_GET_call_to_the_resources(String arg1) throws Throwable {
		
		 Map<String,String> headers = new HashMap<String, String>();
		 headers.put("ContentType", "application/json");
		 
		 PetStoreSteps.response = PetStoreSteps.requestSpecification.headers(headers).get(arg1+ID);
		
	    
	}

}
