package CORE.CustomerInfo;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.CustomerInfoPL;
import resources.base;

public class UpdateHeadOfHousehold extends base {
	
	@BeforeTest
	public void getData() throws IOException {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}

	@Test (priority=1, testName="Head Of Household Updated 1")
	public void headOfHouseholdUpdated1(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/UpdateHeadOfHousehold","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.updateHeadOfHousehold(244, 1))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.UpdateHeadOfHouseholdResponse.UpdateHeadOfHouseholdResult", equalTo("true"));    
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetCustomerInfo","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getCustomerInfo(244))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//	         .log().all()
	            .statusCode(200)
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HeadOfHousehold", equalTo("true"));

	}

//** CHANGING HEAD OF HOUSEHOLD BACK TO WHAT IT WAS BEFORE THIS TEST WAS RUN
	
	@Test (priority=2,testName="Head Of Household Updated2")
	public void headOfHouseholdUpdated2(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/UpdateHeadOfHousehold","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.updateHeadOfHousehold(244, 0))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.UpdateHeadOfHouseholdResponse.UpdateHeadOfHouseholdResult", equalTo("true"));    
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetCustomerInfo","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getCustomerInfo(244))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//	         .log().all()
	            .statusCode(200)
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HeadOfHousehold", equalTo("false"));

	}
	
	@Test (priority=3,testName="Head Of Household Not Updated")
	public void headOfHouseholdNotUpdated(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/UpdateHeadOfHousehold","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.updateHeadOfHousehold(244000, 0))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.UpdateHeadOfHouseholdResponse.UpdateHeadOfHouseholdResult", equalTo("false"));    

	}
	
	
}
