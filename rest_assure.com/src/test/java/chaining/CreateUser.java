package chaining;

//I have to manually import this three
import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.github.scribejava.core.model.Response;

import io.restassured.path.json.JsonPath;




public class CreateUser {
	
    @Test 
	void createUser(ITestContext context) {//Here ITestContext is used for reference value like here I need "id" as a reference value
		Faker faker = new Faker();
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("email", faker.internet().emailAddress());
		jsonObject.put("name", faker.name().firstName());
		jsonObject.put("password", faker.internet().password());
		jsonObject.put("role", "admin");
		jsonObject.put("avatar", "http://test.api/com");
		
		int userid =  given()
		.contentType("application/json")
	    .body(jsonObject.toString())
		.when()
		.post("https://api.escuelajs.co/api/v1/users")
		.jsonPath().getInt("id");
		System.out.println(userid);
		
	
				
	     context.setAttribute("user_id", userid);//Accessible only suite level for "testng.xml"
		//context.getSuite().setAttribute("user_id", userid); //Accessible for test level for "Chaintest.xml"
		
	        /*String username = given()  
				.contentType("application/json")
			    .body(jsonObject.toString())
				.when()
				.post("https://api.escuelajs.co/api/v1/users")
				.jsonPath().getString("name");
				System.out.println("Name is:" + username);
				*/
	     
	     
		/*JsonPath path = (JsonPath) given()
				.contentType("application/json")
				.body(jsonObject.toString())
				.when()
				.post("https://api.escuelajs.co/api/v1/users");
		       //  .path.getString(DEFAULT_BODY_ROOT_PATH))
		String userMail =  path.getString("email");
		String pass = path.getString("password");
		
		System.out.println("Email:"+userMail+"  Password:"+ pass);*/
				
				
				
				
		
		
	}
	
    

}
