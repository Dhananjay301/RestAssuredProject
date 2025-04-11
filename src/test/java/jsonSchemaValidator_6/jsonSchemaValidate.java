package jsonSchemaValidator_6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class jsonSchemaValidate {
	
@Test
	void testJsonSchema() {
		
		given()
		 .contentType("application/json")

		.when()
		  .get("http://localhost:3000/store")

		.then()
		  .statusCode(200)
		  .body("book[1].price", equalTo(100))
		  .header("Content-Type", "application/json")
		  .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchemaValidate.json"))
		  .log().all();

	}
	
	

}



















