package statuses;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.RestUtilities;
import constants.EndPoints;
import constants.Path;
import static org.hamcrest.Matchers.hasItem;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;

public class TestSendEndUserForm {

	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	
	@BeforeClass
	public void setup() {
		
		reqSpec = RestUtilities.getRequestSpecification();
		// add here the updatereqSpec for exception checking
		resSpec = RestUtilities.getResponseSpecification();
		
	}
	@Test
	public void sendEndUserFormOrder(){
		given()
			.spec(reqSpec)
		.when()
			.post(EndPoints.STATUSES_SEND_END_USER_FORM)
		.then()
			.log().all();
			

			
				
			
	}
	
	
}



/*
 * 
 	"order_id":"M16A7A07BCAB"
 	
 	
{
    "status": 400,
     "error": {
  	"code": 404,
     "message": "order has been previously cancelled."
     }
}*/