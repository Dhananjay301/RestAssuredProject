package reqBody_2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import org.testng.annotations.Test.*;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class createReqJsonFile {
	
//	Create request paylod by using external json file
	
	String id;
	
	@Test(priority=1)
	void getUser() {
		
		given()
		
		.when()
		  .get("http://localhost:3000/Shop")
		
		.then()
		  .statusCode(200)
		  .log().all();	
	}
	
	@Test(priority=2)
	void createUser() throws FileNotFoundException {
		
		File fl=new File("src/test/resources/json/externaljson.json");
		FileReader fr=new FileReader(fl);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject jo=new JSONObject(jt);
		
		id=given()
		   .contentType("application/json")
		   .body(jo.toString())
		  
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





