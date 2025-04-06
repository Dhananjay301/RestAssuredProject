package day1;

import org.testng.annotations.Test;
import org.testng.annotations.Test.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HttpsMethos {

//	@Test
//	void getUser() {
//
//		     given()
//
//			.when()
//			   .get("https://reqres.in/api/users?page=2")
//
//			.then()
//			   .statusCode(200)
//			   .body("page", equalTo(2))
//			   .log().all();
//
//	}
	
	@Test
	void createUser() {
		HashMap mp=new HashMap<>();
		mp.put("name", "morpheus");
		mp.put("job", "leader");
		
		given()
		  .contentType("application/json")
		  .body(mp)
		  
		.when()
		  .post("https://reqres.in/api/users")   

		.then()
		  .statusCode(201)
		  .log().all();
		
	}
	

}
