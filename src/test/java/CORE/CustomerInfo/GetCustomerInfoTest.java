package CORE.CustomerInfo;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.CustomerInfoPL;
import resources.base;

public class GetCustomerInfoTest extends base {
	
	@BeforeTest
	public void getData(){
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}
	
	@Test (testName="Customer Found")
	public void customerFound(){
		
		String customerId = prop.getProperty("availableId");
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetCustomerInfo","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getCustomerInfo(customerId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.AddressLine1", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.AddressLine2", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.City", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.Country", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.PostalCode", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.StateProvince", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.DateOfBirth", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.DriversLicenseNumber", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmailAddress", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmailContactConsent", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactName", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactPhoneNumber", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactPhoneNumber.Extension", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactPhoneNumber.Number", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactPhoneNumber.PhoneType", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HeadOfHousehold", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomeClubNumber", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomePhoneContactConsent", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomePhoneNumber.Extension", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomePhoneNumber.Number", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomePhoneNumber.PhoneType", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Interests", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MemberExpireDate", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MemberID", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MobilePhoneContactConsent", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MobilePhoneNumber.Extension", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MobilePhoneNumber.Number", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MobilePhoneNumber.PhoneType", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.DisplayName", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.FirstName", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.LastName", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.MiddleInitial", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.PreferredName", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneNumber.Extension", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneNumber.Number", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneNumber.PhoneType", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneType", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.RestrictMemberFromSearch", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.ValidBarcode", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneContactConsent", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneNumber", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneNumber.Extension", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneNumber.Number", not(empty()))
			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneNumber.PhoneType", not(empty()));    
	}
	
	@Test (testName="Customer Not Found")
	public void customerNotFound(){

	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetCustomerInfo","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getCustomerInfo("22399"))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
	            .statusCode(200)
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.DateOfBirth", equalTo("0001-01-01T00:00:00"))
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomeClubNumber", equalTo("0"))
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.ValidBarcode", equalTo("BarcodeNotFound"))
				
				;     

	}

}
