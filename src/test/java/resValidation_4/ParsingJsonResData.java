package resValidation_4;



import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test.*;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParsingJsonResData {
	
	@Test
	void jsonResParse() {
		
		Response res= given()
		
		               .when()
		                  .get("http://localhost:3000/store");
		
//		Assert.assertEquals(res.getStatusCode(), 200);
//		String auther = res.jsonPath().get("book[2].author").toString();
//		System.out.println("auther = "+auther);
//		
		JSONObject jo=new JSONObject(res.asString());
		boolean status=false;
		
		for (int i=0 ; i<jo.getJSONArray("book").length(); i++) {
			
			String author = jo.getJSONArray("book").getJSONObject(i).get("author").toString();
			
			if (author.equals("Herman Melville")) {
	
				status=true;
				break;
			}
		}
		if (status) {
			System.out.println("author is prwesent");
		}
		
		Assert.assertEquals(status, true);

		
	}
	
	
	
	

}
























