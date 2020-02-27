package CORE.CustomerInfo;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.CustomerInfoPL;
import resources.base;

public class UpdateCustomerInterests extends base {
	
	String customerId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		customerId = prop.getProperty("MultipleAgreementsWithSingleCardId");
	}
	
	@Test (testName="Interest Added")
	public void interestAdded(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/UpdateCustomerInterests","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.updateCustomerInterests_AddInterest(customerId, "Weight Loss"))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.UpdateCustomerInterestsResponse.UpdateCustomerInterestsResult", equalTo("Succeeded"));    
	}

	@Test (testName="Interest Removed")
	public void interestRemoved(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/UpdateCustomerInterests","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.updateCustomerInterests_RemoveInterest(customerId, "Weight Loss"))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
 //            	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.UpdateCustomerInterestsResponse.UpdateCustomerInterestsResult", equalTo("Succeeded"));    
	}

}
