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

public class GetMemberAccessibleClubs extends base {
	
	@BeforeTest
	public void getData() throws IOException {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}
	
	@Test (testName="Clubs Found")
	public void clubsFound(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetMemberAccessibleClubs","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getMemberAccessibleClubs(223))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.GetMemberAccessibleClubsResponse.GetMemberAccessibleClubsResult.ClubListDto[0].Id", not(empty()))
				.body("Envelope.Body.GetMemberAccessibleClubsResponse.GetMemberAccessibleClubsResult.ClubListDto[0].Name", not(empty()))
				;    
	}
	@Test (testName="Family Member Not Found")
	public void familyMemberNotFound(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetMemberAccessibleClubs","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getMemberAccessibleClubs(22300))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.body("Envelope.Body.GetMemberAccessibleClubsResponse.GetMemberAccessibleClubsResult", not(hasKey("ClubListDto")))
				;    
	}
}
