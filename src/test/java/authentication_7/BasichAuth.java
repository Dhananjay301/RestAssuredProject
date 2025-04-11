package authentication_7;

import org.testng.annotations.Test;
import org.testng.annotations.Test.*;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class BasichAuth {
	
//	@Test
	 void basicAuthTest() {
		given()
		  .auth().basic("postman","password_1")
		  .pathParam("myParam", "basic-auth")
		  .log().all()
		
		.when()
		  .get("https://postman-echo.com/{myParam}")
	
//		  authorised usename and passord correct
//		.then()
//		  .statusCode(200)
//		  .body("authenticated", is(true))
//		  .header("Content-Type", "application/json; charset=utf-8")
//		  .log().body();
		
//		Unathorised - 401 make password wrong
		.then()
		  .statusCode(401)
		  .header("Transfer-Encoding", "chunked")
		  .log().all();
		
	}
	
//	digestAuth --> same as basic auth only auth().digest alogorithm change
	@Test
	void digestAuth() {
		
		given()
		  .auth().digest("postman", "password")
		  .pathParam("myParam", "basic-auth")
		  .log().all()
		
		.when()
		  .get("https://postman-echo.com/{myParam}")
		
		.then()
		  .statusCode(200)
		  .log().all();
		  
	}

}

















