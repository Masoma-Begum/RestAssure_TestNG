package chaining;
//I have to manually import this three
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;
public class GetUser {
	@Test
	void tesUser(ITestContext context) {
		int id = (int) context.getAttribute("user_id");// This will get when will run by suite 
		
	//int id = (int) context.getSuite().getAttribute("user_id");// This will get when will run by suite for "Chaintest.xml" 
		
		given()
		 .pathParam("id", id)
		 .when()
		 .get("https://reqres.in/api/users/{id}")
		 .then()
		 .statusCode(200)
		 .log().all();
	}

}
