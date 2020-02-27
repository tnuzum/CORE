package CORE.CustomerInfo;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.CustomerInfoPL;
import resources.base;

public class GetFullFamilyForTest extends base {
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}
	
	@Test (testName="Family Found")
	public void familyFound(){
		
		String customerId = prop.getProperty("availableId");
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetFullFamilyFor","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getFullFamilyFor(customerId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].BarcodeId", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].DisplayName", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].EmailAddress", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].FirstName", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].HeadOfHousehold", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].Id", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].LastName", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].PreferredName", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].BarcodeId", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].DisplayName", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].EmailAddress", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].FirstName", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].HeadOfHousehold", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].Id", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].LastName", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].PreferredName", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].BarcodeId", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].DisplayName", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].EmailAddress", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].FirstName", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].HeadOfHousehold", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].Id", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].LastName", not(empty()))
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].PreferredName", not(empty()))
				;    
	}
	@Test (testName="Family Member Not Found")
	public void familyMemberNotFound(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetFullFamilyFor","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getFullFamilyFor("231"))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult", not(hasKey("FamilyMemberResponse")))
				;    
	}
}
