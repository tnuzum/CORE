package CORE.CustomerInfo;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CustomerInfoPL;
import resources.ReusableMethods;
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
		
	       Response res =  given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetCustomerInfo","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getCustomerInfo(customerId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
 //            	.log().all()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		
	       		Assert.assertTrue(res.getTime() >= 60L);
	       
				Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.AddressLine1"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.AddressLine2"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.City"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.Country"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.PostalCode"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.StateProvince"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.DateOfBirth"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.DriversLicenseNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmailAddress"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmailContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactPhoneNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactPhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactPhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactPhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HeadOfHousehold"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomeClubNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomePhoneContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomePhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomePhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomePhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Interests"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MemberExpireDate"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MemberID"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MobilePhoneContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MobilePhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MobilePhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MobilePhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.DisplayName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.FirstName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.LastName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.MiddleInitial"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.PreferredName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.RestrictMemberFromSearch"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.ValidBarcode"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneNumber.PhoneType"));    
	}
	
	@Test (testName="Customer Not Found")
	public void customerNotFound(){

	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetCustomerInfo","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getCustomerInfo("99999"))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//	         .log().all()
	            .statusCode(200)
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.DateOfBirth", equalTo("0001-01-01T00:00:00"))
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomeClubNumber", equalTo("0"))
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.ValidBarcode", equalTo("BarcodeNotFound"))
				
				;     

	}

}
