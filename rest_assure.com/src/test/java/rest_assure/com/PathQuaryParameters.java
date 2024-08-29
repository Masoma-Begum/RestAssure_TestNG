package rest_assure.com;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class PathQuaryParameters {
	//https://reqres.in/api/users?page=2&id=5
	@Test
	void tesQuaryPathParam() {
		given()
			.pathParam("quaryPath", "users")
			.queryParam("page", 2)
			.queryParam("id", 5)
		.when()
			.get("https://reqres.in/api/{quaryPath}")
		.then()
			.statusCode(200)
			.log().all();
		
	}

}
