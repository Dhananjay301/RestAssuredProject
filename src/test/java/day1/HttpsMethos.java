package day1;

import org.testng.annotations.Test;
import org.testng.annotations.Test.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HttpsMethos {
	
	int id;

	@Test(priority=1)
	void getUser() {

		     given()

			.when()
			   .get("https://reqres.in/api/users?page=2")

			.then()
			   .statusCode(200)
			   .body("page", equalTo(2))
			   .log().all();

	}
	
	@Test(priority=2)
	void createUser() {
		HashMap mp=new HashMap<>();
		mp.put("name", "morpheus");
		mp.put("job", "leader");
		
		id=given()
		  .contentType("application/json")
		  .body(mp)
		  
		 .when()
		   .post("https://reqres.in/api/users")
		   .jsonPath().getInt("id");

//		.then()
//		  .statusCode(201)
//		  .log().all();
//		
	}
	
	@Test(priority=3, dependsOnMethods= {"createUser"})
	void updateUser()  {
		HashMap data=new HashMap<>();
		data.put("name", "Dhananjay");
		data.put("job", "QA");
		
		given()
		  .contentType("application/json")
		  .body(data)
		  
		 .when()
		   .post("https://reqres.in/api/users/"+id)
		   
		 .then()
		   .statusCode(201)
		   .log().all()
		   .log().body();
		
	}
	

}
