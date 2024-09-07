package chaining;

//I have to manually import this three
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	@Test
   void deleteUser(ITestContext context) {
		int id = (int) context.getAttribute("user_id");// This will get when will run by suite 
	//int id = (int) context.getSuite().getAttribute("user_id");// This will get when will run by suite for "Chaintest.xml"

	   
	   given()
	   .pathParam("if", id)
	   
	   .when()
	   .delete("https://api.escuelajs.co/api/v1/users/{id}")
	   .then()
	   .statusCode(204);
	   
   }
}
