package changeRequests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.ChangeRequestsPL;
import resources.ReusableMethods;
import resources.base;

public class GetPersonalInformation extends base {
	
	String companyId;
	String customerId;
	String clubId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Get Personal Information")
	public void getPersonalInformation(){
		
		//String customerId = prop.getProperty("passwordChangeId");
		String customerId = prop.getProperty("changeMemberId");
		

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/GetPersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.getPersonalInformation(companyId, customerId))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);	
				
				Assert.assertTrue(res.getTime() >= 60L);
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.Address1.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.Address1.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.Address2.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.AllowOnlineSearch.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.AllowOnlineSearch.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.BarcodeId.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.BarcodeId.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.City.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.City.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.DateOfBirth.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.DriversLicenseNumber.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.Email.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.EmailContactConsent.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.EmailContactConsent.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.EmergencyContactName.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.EmergencyContactPhoneNumber.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.FirstName.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.FirstName.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.HomeClubNumber.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.HomeClubNumber.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.HomeClubNumber.HomePhone"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.HomePhone.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.HomePhoneContactConsent.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.HomePhoneContactConsent.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.LastName.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.LastName.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.MiddleInitial.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.MiddleInitial.MobilePhone"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.MobilePhoneContactConsent.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.MobilePhoneContactConsent.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.PreferredPhone.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.PreferredPhone.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.RestrictMemberFromSearch.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.RestrictMemberFromSearch.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.SalespersonBarcodeId.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.SocialSecurityNumber.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.State.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.State.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.TrainerBarcodeId.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.WorkExt.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.WorkPhone.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.WorkPhoneContactConsent.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.WorkPhoneContactConsent.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.ZipCode.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.ZipCode.PendingChange"));
				
				Assert.assertEquals(js.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult.Id"), customerId);
	}
}