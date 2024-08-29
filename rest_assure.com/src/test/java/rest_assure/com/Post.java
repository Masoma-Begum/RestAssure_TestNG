package rest_assure.com;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
public class Post {
	@Test
	public void postTest() {
		
		/*Map<String, Object>map = new HashMap<String, Object>();
		map.put("name", "sss");
		map.put("job", "ddd");
		given()
		.body(map.toString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201);*/
		
		//Another way
		JSONObject jo = new JSONObject();
		jo.put("name", "sss");
		jo.put("job", "ddd");
		given()
		    .header("content", "applicaion/json")
		    .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
			.body(jo.toString())
			.when()
			.post("https://reqres.in/api/users")
			.then()
			.statusCode(201);
		
		
	}
	
	
	 public void providingData(String username, String userjob) {
		 JSONObject jo = new JSONObject();
			jo.put("name", username);
			jo.put("job", userjob);
			baseURI = "https://reqres.in/api";
			given()
			    .header("content", "applicaion/json")
			    .contentType(ContentType.JSON)
			    .accept(ContentType.JSON)
				.body(jo.toString())
				.when()
				.post("/users")
				.then()
				.statusCode(201);
			
	 }

}
