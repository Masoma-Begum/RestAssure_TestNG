package rest_assure.com;

import static io.restassured.RestAssured.*;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.http.Cookies;

public class CookiesTest {
	//private static final Response RestAssured = null;

	//@Test(priority = 1)
	void testCookies() {
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.cookie("AEC","AVYB7crp-plFCcD_ytNV6xPPK-aSGN_Xbjsf4QET_0VaBX9As5eIbcXuZ44")
			.log().all();
	}
	
@Test
	public void getCookie() {
		
	   //Way to get single cookie
        Map< String, String> cookies = get("https://www.google.com/").getCookies();
        String cookie = cookies.get("AEC");
        System.out.println("AEC: "+cookie);
        
      //Way to get cookie details
      Cookies cookieDetails = get("https://www.google.com/").getDetailedCookies();
     String value =  cookieDetails.getValue(cookie);
     System.out.println("AEC value: "+ value);
     
     //Get all cookies
      for(String cok:cookies.keySet()) {
    	  String ck = cookies.get(cok);
    	  System.out.println(cok+"   "+ck);
      };
		
	}
}
