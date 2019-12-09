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

public class SearchMembers extends base {
	
	@BeforeTest
	public void getData() throws IOException {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}
	
	@Test (testName="Members Found")
	public void membersFound(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/SearchMembers","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.searchMembers("Auto", "6141001000", "robert.auto@home.com"))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.Address.AddressLine1", not(empty()))
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.Address.AddressLine2", not(empty()))
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.Address.City", not(empty()))
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.Address.PostalCode", not(empty()))
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.Address.StateProvince", not(empty()))
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.BarcodeId", not(empty()))
//				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.HomePhone.Extension", nullValue())
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.HomePhone.Number", not(empty()))
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.HomePhone.PhoneType", not(empty()))
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.Id", not(empty()))
//				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.MobilePhone.Extension", nullValue())
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.MobilePhone.Number", not(empty()))
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.MobilePhone.PhoneType", not(empty()))
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.Name.DisplayName", not(empty()))
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.Name.FirstName", not(empty()))
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.Name.LastName", not(empty()))
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.Name.PreferredName", not(empty()))
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.PreferredPhone", not(empty()))
//				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.WorkPhone.Extension", nullValue())
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.WorkPhone.Number", not(empty()))
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult.APIMemberDto.WorkPhone.PhoneType", not(empty()))
;    
	}
	@Test (testName="Members Not Found")
	public void membersNotFound(){

	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/SearchMembers","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.searchMembers("NotAuto", "", ""))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//	         .log().all()
	            .statusCode(200)
				.body("Envelope.Body.SearchMembersResponse.SearchMembersResult", not(hasKey("APIMemberDto")))
//				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.DateOfBirth", equalTo("0001-01-01T00:00:00"))
//				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomeClubNumber", equalTo("0"))
//				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.ValidBarcode", equalTo("BarcodeNotFound"))
				
				;     

	}

}
