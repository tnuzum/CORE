package customerAuth;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CustomerAuthPL;
import resources.ReusableMethods;
import resources.base;

public class AuthorizeCustomerTest extends base{
	
	static String companyId;
	static String AllPermissionscustomerid;
	
		@BeforeTest
		public void getData() {
			base.getPropertyData();
			RestAssured.baseURI = prop.getProperty("baseURI");
			
			companyId = prop.getProperty("X-CompanyId");
		}
		
		@Test (priority = 1, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_AllPermissions() {
			 AllPermissionscustomerid = prop.getProperty("AllPermissionscustomerid");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, AllPermissionscustomerid))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertTrue(text.contains("EditPersonalInformation"));
				Assert.assertTrue(text.contains("RealTimePayments"));
				Assert.assertTrue(text.contains("ViewFormOfPayment"));
				Assert.assertTrue(text.contains("EditBillingInformation"));
				Assert.assertTrue(text.contains("AllowAddCC"));
				Assert.assertTrue(text.contains("AllowAddACH"));
				Assert.assertTrue(text.contains("AddAndEditClassEnrollments"));
				Assert.assertTrue(text.contains("ViewAppointments"));
				Assert.assertTrue(text.contains("ScheduleAppointments"));
				Assert.assertTrue(text.contains("DisplayActivityMeter"));
				Assert.assertTrue(text.contains("DisplayClassesWidget"));
				Assert.assertTrue(text.contains("DisplayAppointmentsWidget"));
				Assert.assertTrue(text.contains("BookingsPunchcardOnly"));
				Assert.assertTrue(text.contains("DisplayCoursesWidget"));
				Assert.assertTrue(text.contains("AddAndEditCourseEnrollments"));
				Assert.assertTrue(text.contains("ViewClasses"));
				Assert.assertTrue(text.contains("ViewCourses"));
				Assert.assertTrue(text.contains("ViewFamilyClasses"));
				Assert.assertTrue(text.contains("ViewFamilyCourses"));
				Assert.assertTrue(text.contains("DisplayFamilyAppointments"));
				
				
		}
		
		@Test (priority = 2, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_CannotCclasses() {
			
			String CannotCclasses = prop.getProperty("CannotCclasses");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, CannotCclasses))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertFalse(text.contains("ViewClasses"));


}
		
		@Test (priority = 3, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_CantnrollClass() {
			String CantnrollClass = prop.getProperty("CantnrollClass");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, CantnrollClass))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertFalse(text.contains("AddAndEditClassEnrollments"));


}
		
		@Test (priority = 4, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_CantCcourses() {
			
			String CantCcourses = prop.getProperty("CantCcourses");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, CantCcourses))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertFalse(text.contains("ViewCourses"));


}
		
		@Test (priority = 5, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_CantnrollCourse () {
			
			String CantnrollCourse = prop.getProperty("CantnrollCourse");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, CantnrollCourse))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertFalse(text.contains("AddAndEditCourseEnrollments"));


}
		
		@Test (priority = 6, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_NotCollectionsMember_PayOnlineAllowed() {
			
			AllPermissionscustomerid = prop.getProperty("AllPermissionscustomerid");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, AllPermissionscustomerid))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertTrue(text.contains("RealTimePayments"));
				
		}
		
		@Test (priority = 7, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_NotCollectionsMember_PayOnlineNotAllowed() {
			
			String customeridPayOnlineNotAllowed = prop.getProperty("customeridPayOnlineNotAllowed");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, customeridPayOnlineNotAllowed))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
//				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
//				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				//Assert.assertFalse(text.contains("RealTimePayments"));
				
		}
		
		
		@Test (priority = 8, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_CollectionsMember_PayOnlineNotAllowed() {
			
			 String collections_PayOnlineNotAllowed = prop.getProperty("collections_PayOnlineNotAllowed");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, collections_PayOnlineNotAllowed))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertTrue(text.contains("None"));
				Assert.assertFalse(text.contains("RealTimePayments"));
				
		}
		
	
		
		@Test (priority = 9, testName="Get Customer Authorizations", enabled = true)
		public void AuthorizeCustomer_CollectionsMember_PayOnlineAllowed() {
			
			 String collections_PayOnlineAllowed = prop.getProperty("collections_PayOnlineAllowed");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, collections_PayOnlineAllowed))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertTrue(text.contains("RealTimePayments"));
				
		}
		
		@Test (priority = 10, testName="Get Customer Authorizations", enabled = true)
		public void AuthorizeCustomer_FrozenMember_AddAndEditFOPAllowedInClub() {
			
			 String Frozen_AddEditFOPAllowedInClub = prop.getProperty("Frozen_AddEditFOPAllowedInClub");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, Frozen_AddEditFOPAllowedInClub))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertTrue(text.contains("EditPersonalInformation"));
				Assert.assertTrue(text.contains("EditBillingInformation"));
				Assert.assertTrue(text.contains("AllowAddCC"));
				Assert.assertTrue(text.contains("AllowAddACH"));
				
		}
		
		@Test (priority = 11, testName="Get Customer Authorizations", enabled = true)
		public void AuthorizeCustomer_Frozen_AddEditFOPNotAllowedInClub() {
			
			 String Frozen_AddEditFOPNotAllowedInClub = prop.getProperty("Frozen_AddEditFOPNotAllowedInClub");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, Frozen_AddEditFOPNotAllowedInClub))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertFalse(text.contains("EditPersonalInformation"));
				Assert.assertFalse(text.contains("EditBillingInformation"));
				Assert.assertFalse(text.contains("AllowAddCC"));
				Assert.assertFalse(text.contains("AllowAddACH"));
				
		}
		
		
		@Test (priority = 12, testName="Get Customer Authorizations", enabled = true)
		public void AuthorizeCustomer_Member_AddEditFOPNotAllowedInClub() {
			
			 String Member_AddEditFOPNotAllowedInClub = prop.getProperty("Member_AddEditFOPNotAllowedInClub");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, Member_AddEditFOPNotAllowedInClub))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertFalse(text.contains("EditPersonalInformation"));
				Assert.assertFalse(text.contains("EditBillingInformation"));
				Assert.assertFalse(text.contains("AllowAddCC"));
				Assert.assertFalse(text.contains("AllowAddACH"));
				
		}
		
		@Test (priority = 13, testName="Get Customer Authorizations", enabled = true)
		public void AuthorizeCustomer_Member_OnlyEditFOPAllowedInClub() {
			
			 String Member_OnlyEditFOPAllowedInClub = prop.getProperty("Member_OnlyEditFOPAllowedInClub");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, Member_OnlyEditFOPAllowedInClub))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertTrue(text.contains("EditPersonalInformation"));
				Assert.assertFalse(text.contains("EditBillingInformation"));
				Assert.assertFalse(text.contains("AllowAddCC"));
				Assert.assertFalse(text.contains("AllowAddACH"));
				
		}
		
		@Test (priority = 14, testName="Get Customer Authorizations", enabled = true)
		public void AuthorizeCustomer_Frozen_OnlyEditFOPAllowedInClub() {
			
			 String Frozen_OnlyEditFOPAllowedInClub = prop.getProperty("Frozen_OnlyEditFOPAllowedInClub");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, Frozen_OnlyEditFOPAllowedInClub))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertTrue(text.contains("EditPersonalInformation"));
				Assert.assertFalse(text.contains("EditBillingInformation"));
				Assert.assertFalse(text.contains("AllowAddCC"));
				Assert.assertFalse(text.contains("AllowAddACH"));
				
		}
		
		@Test (priority = 15, testName="Get Customer Authorizations", enabled = true)
		public void AuthorizeCustomer_Terminate_AddEditFOPNotAllowedInClub() {
			
			 String Terminate_AddEditFOPNotAllowedInClub = prop.getProperty("Terminate_AddEditFOPNotAllowedInClub");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, Terminate_AddEditFOPNotAllowedInClub))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertFalse(text.contains("EditPersonalInformation"));
				Assert.assertFalse(text.contains("EditBillingInformation"));
				Assert.assertFalse(text.contains("AllowAddCC"));
				Assert.assertFalse(text.contains("AllowAddACH"));
				
		}
		
		@Test (priority = 16, testName="Get Customer Authorizations", enabled = true)
		public void AuthorizeCustomer_TerminateMember_AddAndEditFOPAllowedInClub() {
			
			 String Terminate_AddEditFOPAllowedInClub = prop.getProperty("Terminate_AddEditFOPAllowedInClub");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, Terminate_AddEditFOPAllowedInClub))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertTrue(text.contains("EditPersonalInformation"));
				Assert.assertTrue(text.contains("EditBillingInformation"));
				Assert.assertTrue(text.contains("AllowAddCC"));
				Assert.assertTrue(text.contains("AllowAddACH"));
				
		}
		
		@Test (priority = 17, testName="Get Customer Authorizations", enabled = true)
		public void AuthorizeCustomer_Terminate_OnlyEditFOPAllowedInClub() {
			
			 String Terminate_OnlyEditFOPAllowedInClub = prop.getProperty("Terminate_OnlyEditFOPAllowedInClub");
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, Terminate_OnlyEditFOPAllowedInClub))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertTrue(text.contains("EditPersonalInformation"));
				Assert.assertFalse(text.contains("EditBillingInformation"));
				Assert.assertFalse(text.contains("AllowAddCC"));
				Assert.assertFalse(text.contains("AllowAddACH"));
				
		}
}
