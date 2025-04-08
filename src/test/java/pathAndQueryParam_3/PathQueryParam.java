package pathAndQueryParam_3;

import org.testng.annotations.Test;
import org.testng.annotations.Test.*;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathQueryParam {
	
//	to pass path and query param in request by defining the veariable 
	
	@Test
	void queryPath() {
		
		given()
		  .pathParam("myPath", "api/users")
		  .queryParam("page", 2)
		
		
		.when()
		  .get("https://reqres.in/{myPath}")
		
		.then()
		  .statusCode(200)
		  .log().all();
		
	}
	

}


















