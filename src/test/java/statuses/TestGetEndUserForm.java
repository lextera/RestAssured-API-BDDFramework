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

public class TestGetEndUserForm {

	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	
	@BeforeClass
	public void setup() {
		
		reqSpec = RestUtilities.getRequestSpecification();
		// add here the updatereqSpec for exception checking
		resSpec = RestUtilities.getResponseSpecification();
		
	}
	@Test
	public void getEndUserForm(){
		given()
			.spec(reqSpec)
		.when()
			.post(EndPoints.STATUSES_GET_END_USER_FORM)
		.then()
			.log().all()
			.spec(resSpec)
			.body("end_user_form.order_id", equalTo("M16B2E9DBCFC"))
			.body("end_user_form.jpPhonicCharForName", equalToIgnoringCase("TEST TEST"));
			
				
			
	}
	
	
}//
/*
 * test negative scenarios 
 * test 400 series
 * update specbuilder 200 to input type
 * setBody for incorrect cookie
 * set expectStatusCode for exception testing
 * 
 * **/
