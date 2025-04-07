package day2;

import org.testng.annotations.Test;
import org.testng.annotations.Test.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class createReqHashmap {
	
//	ways to create request bodies

//	1 By using Hashmap
	
	String id; // to capture id from created data and use for future ref

	@Test(priority = 1)
	void getReq() {

		given()
			.contentType("application/json")

			.when()
			.get("http://localhost:3000/Shop?id=2")

			.then()
			.statusCode(200)
			.log()
			.all();
	}

	@Test(priority = 2)
	void createUser() {

		HashMap data = new HashMap();
		data.put("name", "Item Four");
		data.put("category", "Computer");
		data.put("price", "400.00");
		data.put("name", "Item Four");

		String tagsArr[] = { "Tech", "swim", "Ride" };
		data.put("tags", tagsArr);

		id = given()
			.contentType("application/json")
			.body(data)

			.when()
			.post("http://localhost:3000/Shop")
			.jsonPath().getString("id");

//		.then()
//		  .statusCode(201)
//		  .log().all();

	}
	
	@Test(priority=3)
	void deleteUser() {
		
		given()
		
		.when()
		  .delete("http://localhost:3000/Shop/"+id)
		
		.then()
		.statusCode(200)
		.log().all();
		
	}

}


















