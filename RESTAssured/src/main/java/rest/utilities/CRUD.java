package rest.utilities;

import java.io.IOException;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;



public class CRUD {
	
	
	
	public static void postCall() throws IOException {
		String inputJson= DataUtils.getConstantFileFromInput("map", "json");		
		RestAssured.baseURI=DataUtils.baseDataGet("URI");
		
		String response=given().body(inputJson).when().post().then().extract().response().asString();
		
		
		
	}

}
