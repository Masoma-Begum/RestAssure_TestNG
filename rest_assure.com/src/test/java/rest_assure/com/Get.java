
package rest_assure.com;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate.Param;
import com.github.scribejava.core.model.Response;

// I have to manually import this three
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

/*
 https://reqres.in/
https://github.com/rest-assured/rest-assured/wiki/GettingStarted
given()
Content type, set cookies, add auth, add param, set headers info
when()
get, post, delete, put
 then()
validate status code, extract response, extract headers cookies & respons body


Get

https://reqres.in/api/users/2

post
https://reqres.in/api/users

{
    "name": "morpheus",
    "job": "leader"
}

put


https://reqres.in/api/users/2
{
    "name": "morpheus",
    "job": "zion resident"
}

delete


https://reqres.in/api/users/userid 201
 */
public class Get {
	Param page;
	@Test
   void getUser() {
	   given()
//	    .header("Content", "application/json")
//	    .param(page, 2)
	   	.get("https://reqres.in/api/users?page=2")
	   	
	   .then()
	   .statusCode(200)
	   .body("data.id[0]", equalTo(7))// If put another number instead of 7 get an exception 
	   .body("data.first_name", hasItems("Michael","Lindsay"))
	   //.body("data.last_name",instanceOf(String.class))
	   //.body("data.id", instanceOf(Integer.class))
	   .body("data.id", not(instanceOf(String.class)))
	  
	   .log().all();
	   //.log().body(); // Will print only response body
	  // .log().cookies(); // will print only response cookies
	   	   
	   
	   	
   }
}
