package resValidation_4;


import org.testng.annotations.Test;
import org.testng.annotations.Test.*;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class JsonRespoanseVal {
	
	@Test
	void jsonResVal() {
		
		given()
		  .contentType("application/json")
		 
		.when()
		  .get("http://localhost:3000/store")
		
		
		.then()
		  .statusCode(200)
		  .body("book[1].title", equalTo("Sword of Honour"))
		  .body("book[2].author", equalTo("Herman Melville"))
		  .header("Content-Type", "application/json")
		  .log().all();
		
	}
	

}










