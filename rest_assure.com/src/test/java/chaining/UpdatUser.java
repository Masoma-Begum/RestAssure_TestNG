package chaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdatUser {
	@Test
	void updateUser(ITestContext context) {
Faker faker = new Faker();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", faker.name().firstName());
		jsonObject.put("role", "client");
		jsonObject.put("avatar", "http://testupdate.api/com");
		
		int id = (int) context.getAttribute("user_id");// This will get when will run by suite 
		//int id = (int) context.getSuite().getAttribute("user_id");// This will get when will run by suite for "Chaintest.xml" 

		 given()
		.contentType("application/json")
	    .body(jsonObject.toString())
	    .pathParam("id", id)
	    
		.when()
		.put("https://api.escuelajs.co/api/v1/users/{id}")
		.then()
		.statusCode(200)
		.log().all();
		
		
	}

}
