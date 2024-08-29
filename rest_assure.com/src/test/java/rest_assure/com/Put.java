package rest_assure.com;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class Put {
	@Test
	public void putTest() {
		JSONObject jo = new JSONObject();
		jo.put("name", "sss");
		jo.put("job", "ddd");
		given()
		    .header("content", "applicaion/json")
		    .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
			.body(jo.toString())
			.when()
			.put("https://reqres.in/api/users/2")
			.then()
			.statusCode(200)
		.log().all();
		
	}
	
	@Test
	public void patchTest() {
		JSONObject jo = new JSONObject();
		jo.put("name", "sss");
		jo.put("job", "ddd");
		given()
		    .header("content", "applicaion/json")
		    .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
			.body(jo.toString())
			.when()
			.patch("https://reqres.in/api/users/2")
			.then()
			.statusCode(200)
		.log().all();
		
	}
	
	public void deleteTest() {
			when()
			.delete("https://reqres.in/api/users/2")
			.then()
			.statusCode(204);
		     
		
	}

}
