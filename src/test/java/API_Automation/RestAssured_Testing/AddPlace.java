package API_Automation.RestAssured_Testing;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Files.Payload;

public class AddPlace {
	
	public static void main(String[] args) {
		
		//Validate if Add Place API is working as excepted
		
		//given - all input details
		//when - Submit the API - Resource and HTTP method
		//then - validate the response
		
		//Add place -> Update place with new Address -> Get Place to validate if New address is present in response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().
		queryParam("key", "qaclick123").header("Content-type","application/json").body(Payload.Addplace()).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", 
				 "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		JsonPath js=new JsonPath(response); //for parsing Json
		String Placeid=js.getString("place_id");
		System.out.println(Placeid);
		System.out.println(Placeid+"place is1");
		System.out.println(Placeid+"place is1");
		System.out.println(Placeid+"place is32");
		
	}

}
