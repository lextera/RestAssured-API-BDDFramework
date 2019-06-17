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

public class TestRetrieveOrderDetails {

	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	
	@BeforeClass
	public void setup() {
		//request Spec, parse to build()
		reqSpec = RestUtilities.getRequestSpecification();
		resSpec = RestUtilities.getResponseSpecification();
		
	}
	@Test
	public void getOrderDetails(){
		given()
			.spec(reqSpec)
		.when()
			.post(EndPoints.STATUSES_ORDER_DETAILS)
		.then()
			.log().ifValidationFails()
			.spec(resSpec)
			.body("order.order_id", equalTo("M16B2E9DBCFC"))
			.body("order.currency", equalToIgnoringCase("JPY"))
			.body("order.cart.size()", lessThanOrEqualTo(2));
			
	}
	
	
}
