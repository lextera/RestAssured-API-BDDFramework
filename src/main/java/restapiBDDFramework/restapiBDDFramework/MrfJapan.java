package restapiBDDFramework.restapiBDDFramework;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class MrfJapan {
	
	//RestAssured.baseURI = "https://mrf.minicircuits.com";
	public static void main(String[] args){
		
		
		RestAssured.baseURI = "https://mrf.minicircuits.com";
		RestAssured.basePath = "/WebStore";
		
		given().
			contentType("application/json").
			
			//header("Content-Type","application/json").
			param("cookie_id", "93A64060B1A84BF3B287FF0B72136BBA:Lex:4EC72ED6ABEC3F4F4D868D871B2BB30C").
			param("order_id", "M16B045A0120").
		when().post("/order_detail").
		then()
		.assertThat().statusCode(200);
		
		
		
	}


}
