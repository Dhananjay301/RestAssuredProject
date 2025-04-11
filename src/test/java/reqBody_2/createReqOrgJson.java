package reqBody_2;

import java.util.HashMap;

import org.json.JSONObject;

public class createReqOrgJson {


	void reqBodyByJsonLib() {
		
//		same as Hashmap 
		
		JSONObject data=new JSONObject();
		data.put("name", "Item Four");
		data.put("category", "Computer");
		data.put("price", "400.00");
		data.put("name", "Item Four");
		
//		follow the Hashmap flow only differance  while passing data into given body to convert into to string
		
//		 .body(data.toString)
		
	}

}
