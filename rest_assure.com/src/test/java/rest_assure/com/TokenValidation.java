package rest_assure.com;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;

public class TokenValidation {
	String token = "";
	@BeforeTest
	public void setToken() {
		//Register member
		JSONObject jo = new JSONObject();
		jo.put("email", "john@mail.com");
		jo.put("password", "changeme");
		given()
		    .contentType(ContentType.JSON)
		    .accept(ContentType.JSON)
			.body(jo.toString())
			.when()
			.post("https://api.escuelajs.co/api/v1/auth/signin")
			.then()
			.assertThat()
			.statusCode(HttpStatus.SC_OK);
		// Generate Token
		token = given()
				
		.contentType(ContentType.JSON)
		.body(jo.toString())
		.when()
		.post("https://api.escuelajs.co/api/v1/auth/authenticate")
		.jsonPath()
		.getString(token);
	}
	
	public void withToken() {
		Map<String, String> apiheaders = new HashMap<String, String>();
		apiheaders.put("", "");
		apiheaders.put("", "");
		
			given()
			.headers(apiheaders)
			.when()
			.get("login link")
			.then()
			.assertThat()
			.statusCode(HttpStatus.SC_OK);		
		
	
	}
	
	public void withoutToken() {
		Map<String, String> apiheaders = new HashMap<String, String>();
		apiheaders.put("", "");
		
			given()
			.headers(apiheaders)
			.when()
			.get("login link")
			.then()
			.assertThat()
			.statusCode(HttpStatus.SC_UNAUTHORIZED);		
		
	
	}

	

}
