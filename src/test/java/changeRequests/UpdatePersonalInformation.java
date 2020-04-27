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

public class UpdatePersonalInformation extends base {
	
	String companyId;
	String clubId;
	String customerId;
	String submissionReason;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		clubId = prop.getProperty("club1Id");
		customerId = prop.getProperty("changeMemberId");
		submissionReason = prop.getProperty("submissionReason");
	}
	
	@Test (testName="Update Address 1")
	public void updateAddress1(){
		
		String fieldName = "Address1";
		String newValue = "1000 1st St.";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);	
				
				Assert.assertTrue(res.getTime() >= 60L);
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");	
				
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
}
	
	@Test (testName="Update Address 2")
	public void updateAddress2(){
		
		String fieldName = "Address2";
		String newValue = "Apt. B";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
				
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}

	@Test (testName="Update AllowOnlineSearch to True")
	public void updateAllowOnlineSearchTrue(){
		
		String fieldName = "AllowOnlineSearch";
		String newValue = "true";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update AllowOnlineSearch to False")
	public void updateAllowOnlineSearchFalse(){
		
		String fieldName = "AllowOnlineSearch";
		String newValue = "false";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update BarcodeId")
	public void updateBarcodeId(){
		
		String fieldName = "BarcodeId";
		String newValue = "1141121";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
				
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update City")
	public void updateCity(){
		
		String fieldName = "City";
		String newValue = "Worthington";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}

	@Test (testName="Update Date of Birth", enabled = false)
	public void updateDateOfBirth(){
		
		// this is not updating record
		
		String fieldName = "DateOfBirth";
		String newValue = "1980-01-01";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}

	@Test (testName="Update Drivers License", enabled = false)
	public void updateDriversLicense(){
		
		// this is not updating record
		
		String fieldName = "Drivers License Number";
		String newValue = "OH123456789";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}

	@Test (testName="Update Email", enabled = true)
	public void updateEmail(){
				
		String fieldName = "EmailAddress";
		String newValue = "compete-test@jonasfitness.com";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, "Email", newValue));
				}

	@Test (testName="Update Email Contact Consent", enabled = true)
	public void updateEmailContactConsent(){
				
		String fieldName = "EmailContactConsent";
		String newValue = "true";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Emergency Contact Name", enabled = false)
	public void updateEmergencyContactName(){
				
		String fieldName = "EmergencyContactName";
		String newValue = "Spouse Name";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Emergency Contact Phone Number", enabled = false)
	public void updateEmergencyContactPhoneNumber(){
				
		String fieldName = "EmergencyContactPhoneNumber";
		String newValue = "6140001111";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
				
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update First Name", enabled = true)
	public void updateFirstName(){
				
		String fieldName = "FirstName";
		String newValue = "Change";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update HomeClubNumber", enabled = false)
	public void updateHomeClubNumber(){
		
		// 500 - Sequence contains more than one element
				
		String fieldName = "Home Club Number";
		String newValue = "2";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Home Phone", enabled = true)
	public void updateHomePhone(){
				
		String fieldName = "HomePhone";
		String newValue = "6141001000";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
 //            	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Home Phone Contact Consent", enabled = true)
	public void updateHomePhoneContactConsent(){
				
		String fieldName = "HomePhoneContactConsent";
		String newValue = "true";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Last Name", enabled = true)
	public void updateLastName(){
				
		String fieldName = "LastName";
		String newValue = "Auto";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Middle Initial", enabled = false)
	public void updateMiddleInitial(){
				
		String fieldName = "MiddleInitial";
		String newValue = "T";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Mobile Phone", enabled = true)
	public void updateMobilePhone(){
				
		String fieldName = "MobilePhone";
		String newValue = "6142001000";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Mobile Phone Contact Consent", enabled = true)
	public void mobilePhoneContactConsent(){
				
		String fieldName = "MobilePhoneContactConsent";
		String newValue = "true";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Preferred Phone", enabled = true)
	public void updatePreferredPhone(){
				
		String fieldName = "PreferredPhone";
		String newValue = "Home";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Restrict Member From Search", enabled = true)
	public void updateRestrictMemberFromSearch(){
				
		String fieldName = "RestrictMemberFromSearch";
		String newValue = "false";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Salesperson Barcode Id", enabled = false)
	public void updateSalespersonBarcodeId(){
				
		String fieldName = "SalespersonBarcodeId";
		String newValue = "1112222";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Social Security Number", enabled = false)
	public void updateSocialSecurityNumber(){
				
		String fieldName = "SocialSecurityNumber";
		String newValue = "111223333";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update State", enabled = true)
	public void updateState(){
				
		String fieldName = "State";
		String newValue = "OH";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Trainer Barcode Id", enabled = false)
	public void updateTrainerBarcodeId(){
		
		// this is disabled because it's returning a boolean instead of an Id; but has been written up
				
		String fieldName = "TrainerBarcodeId";
		String newValue = "1112222";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Work Ext", enabled = false)
	public void updateWorkExt(){
				
		String fieldName = "WorkPhoneExt";
		String newValue = "111";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
	    		  .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Work Phone", enabled = true)
	public void updateWorkPhone(){
				
		String fieldName = "WorkPhone";
		String newValue = "61430001000";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update ZipCode", enabled = true)
	public void updateZipCode(){
				
		String fieldName = "ZipCode";
		String newValue = "43015";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
		
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Restrict Member From Multi-Member Search to True", enabled = true)
	public void updateRestrictMemberFromMultiMemberSearchTrue(){
				
		String fieldName = "RestrictMemberFromSearch";
		String newValue = "true";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res1 =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
 //            	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js1 = ReusableMethods.rawToXML(res1);		
				
				Assert.assertNotNull(js1.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js1.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
	
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	
	@Test (testName="Update Restrict Member From Multi-Member Search to False", enabled = true)
	public void updateRestrictMemberFromMultiMemberSearchFalse(){
				
		String fieldName = "RestrictMemberFromSearch";
		String newValue = "false";
		String submissionReasonDetail = "Test Submission Reason Details";

	      Response res1 =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdatePersonalInformation",
 					"Content-Type", "text/xml; charset=utf-8")
	        .and()
	        .body(ChangeRequestsPL.updatePersonalInformationNoFamily(companyId, customerId, fieldName, newValue, submissionReason, submissionReasonDetail))
	        .when()
	        .post("/ChangeRequests/ChangeRequest.svc")
	        .then()
 //            	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js1 = ReusableMethods.rawToXML(res1);		
				
				Assert.assertNotNull(js1.getInt("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.AutoApprovedConfirmationNumber"));
				Assert.assertEquals(js1.getString("Envelope.Body.UpdatePersonalInformationResponse.UpdatePersonalInformationResult.ErrorMessages"), "None");		
	
				// ** Validate field was updated correctly
				Assert.assertTrue(ReusableMethods.validatePersonalInfoNewValue(companyId, customerId, fieldName, newValue));
				}
	


}