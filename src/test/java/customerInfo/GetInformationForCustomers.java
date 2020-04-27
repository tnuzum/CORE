package customerInfo;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CustomerInfoPL;
import resources.ReusableMethods;
import resources.base;

public class GetInformationForCustomers extends base {
	
	String companyId;
	
	@BeforeTest
	public void getData(){
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Member Found")
	public void memberFound(){
		
		String customerId = prop.getProperty("availableId");
		
	       Response res =  given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetInformationForCustomers","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getInformationForCustomers(companyId, customerId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		
	       		Assert.assertTrue(res.getTime() >= 60L);
	       
				Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.AddressLine1"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.AddressLine2"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.City"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.Country"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.PostalCode"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.StateProvince"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].DateOfBirth"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].DriversLicenseNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmailAddress"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmailContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactPhoneNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactPhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactPhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactPhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HeadOfHousehold"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomeClubNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomePhoneContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomePhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomePhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomePhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Interests"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MemberExpireDate"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MemberID"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MobilePhoneContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MobilePhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MobilePhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MobilePhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.DisplayName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.FirstName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.LastName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.MiddleInitial"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.PreferredName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].PreferredPhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].PreferredPhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].PreferredPhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].PreferredPhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].RestrictMemberFromSearch"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].ValidBarcode"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneNumber.PhoneType"));    

			    Assert.assertEquals(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MemberType"), "Member");

	}
	
	
	@Test (testName="Prospect Found")
	public void prospectFound(){
		
		String customerId = prop.getProperty("prospectId");
		
	       Response res =  given()
//	    		   .log().all()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetInformationForCustomers","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getInformationForCustomers(companyId, customerId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//            	.log().all()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		
				Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.AddressLine1"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.AddressLine2"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.City"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.Country"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.PostalCode"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.StateProvince"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].DateOfBirth"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].DriversLicenseNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmailAddress"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmailContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactPhoneNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactPhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactPhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactPhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HeadOfHousehold"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomeClubNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomePhoneContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomePhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomePhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomePhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Interests"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MemberExpireDate"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MemberID"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MobilePhoneContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MobilePhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MobilePhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MobilePhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.DisplayName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.FirstName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.LastName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.MiddleInitial"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.PreferredName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].PreferredPhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].PreferredPhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].PreferredPhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].PreferredPhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].RestrictMemberFromSearch"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].ValidBarcode"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneNumber.PhoneType"));
	       		
			    Assert.assertEquals(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MemberType"), "Prospect");    
	}

	@Test (testName="Member InCollections Found")
	public void memberInCollectionsFound(){
		
		String customerId = prop.getProperty("collectionsId");
		
	       Response res =  given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetInformationForCustomers","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getInformationForCustomers(companyId, customerId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//            	.log().all()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		
				Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.AddressLine1"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.AddressLine2"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.City"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.Country"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.PostalCode"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Address.StateProvince"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].DateOfBirth"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].DriversLicenseNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmailAddress"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmailContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactPhoneNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactPhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactPhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].EmergencyContactPhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HeadOfHousehold"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomeClubNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomePhoneContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomePhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomePhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].HomePhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Interests"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MemberExpireDate"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MemberID"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MobilePhoneContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MobilePhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MobilePhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MobilePhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.DisplayName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.FirstName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.LastName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.MiddleInitial"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].Name.PreferredName"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].PreferredPhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].PreferredPhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].PreferredPhoneNumber.PhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].PreferredPhoneType"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].RestrictMemberFromSearch"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].ValidBarcode"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneContactConsent"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneNumber"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneNumber.Extension"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneNumber.Number"));
			    Assert.assertNotNull(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].WorkPhoneNumber.PhoneType"));
	       		
			    Assert.assertEquals(js.getString("Envelope.Body.GetInformationForCustomersResponse.GetInformationForCustomersResult.CustomerInfoForOutstandingInvoicesDto[0].MemberType"), "InCollections");    
	}

	
	
	
	
	
	
	
	
	
	
}
