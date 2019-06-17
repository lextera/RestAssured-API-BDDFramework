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

public class TestAcceptOrder {

	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	
	@BeforeClass
	public void setup() {
		
		reqSpec = RestUtilities.getRequestSpecification();
		// add here the updatereqSpec for exception checking
		resSpec = RestUtilities.getResponseSpecification();
		
	}
	@Test
	public void acceptOrder(){
		given()
			.spec(reqSpec)
		.when()
			.post(EndPoints.STATUSES_ACCEPT_ORDER)
		.then()
			.log().ifError()
			.spec(resSpec);

			
				
			
	}
	
	
}

/**
 * 
 * chek other response code
 * /


/*
"order_id":"M16A7D89722B" --> 

{
"status": 400,
 "error": {
	"code": 403,
 "message": "order has been previously accepted."
 }
}*/