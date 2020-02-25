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

public class GetFamilyMembersForTest extends base {
	
	@BeforeTest
	public void getData() throws IOException {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}
	
	@Test (testName="Family Member Found")
	public void familyMemberFound(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetFamilyMembersFor","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getFamilyMembersFor(223))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].BarcodeId", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].DisplayName", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].EmailAddress", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].FirstName", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].HeadOfHousehold", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].Id", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].LastName", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].PreferredName", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].BarcodeId", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].DisplayName", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].EmailAddress", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].FirstName", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].HeadOfHousehold", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].Id", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].LastName", not(empty()))
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].PreferredName", not(empty()))
				;    
	}
	
	@Test (testName="Family Member Not Found")
	public void familyMemberNotFound(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetFamilyMembersFor","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getFamilyMembersFor(231))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult", not(hasKey("FamilyMemberResponse")))
				;    
	}
}
