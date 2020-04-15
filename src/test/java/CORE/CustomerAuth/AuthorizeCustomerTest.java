package CORE.CustomerAuth;

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
	static String customerid = "666";
	static String CannotCclasses = "259";
	static String CantnrollClass = "262";
	static String CantCcourses = "264";
	static String CantnrollCourse = "265";
	static String customeridPayOnlineNotAllowed = "744";
	static String collections_PayOnlineNotAllowed ="227";
	static String collections_PayOnlineAllowed = "735";
	
	
		@BeforeTest
		public void getData() {
			base.getPropertyData();
			RestAssured.baseURI = prop.getProperty("baseURI");
			
			companyId = prop.getProperty("X-CompanyId");
		}
		
		@Test (priority = 1, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_AllPermissions() {
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, customerid))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String Text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertTrue(Text.contains("EditPersonalInformation"));
				Assert.assertTrue(Text.contains("RealTimePayments"));
				Assert.assertTrue(Text.contains("ViewFormOfPayment"));
				Assert.assertTrue(Text.contains("EditBillingInformation"));
				Assert.assertTrue(Text.contains("AllowAddCC"));
				Assert.assertTrue(Text.contains("AllowAddACH"));
				Assert.assertTrue(Text.contains("AddAndEditClassEnrollments"));
				Assert.assertTrue(Text.contains("ViewAppointments"));
				Assert.assertTrue(Text.contains("ScheduleAppointments"));
				Assert.assertTrue(Text.contains("DisplayActivityMeter"));
				Assert.assertTrue(Text.contains("DisplayClassesWidget"));
				Assert.assertTrue(Text.contains("DisplayAppointmentsWidget"));
				Assert.assertTrue(Text.contains("BookingsPunchcardOnly"));
				Assert.assertTrue(Text.contains("DisplayCoursesWidget"));
				Assert.assertTrue(Text.contains("AddAndEditCourseEnrollments"));
				Assert.assertTrue(Text.contains("ViewClasses"));
				Assert.assertTrue(Text.contains("ViewCourses"));
				Assert.assertTrue(Text.contains("ViewFamilyClasses"));
				Assert.assertTrue(Text.contains("ViewFamilyCourses"));
				
				
		}
		
		@Test (priority = 2, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_CannotCclasses() {
			
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
				String Text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertFalse(Text.contains("ViewClasses"));


}
		
		@Test (priority = 3, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_CantnrollClass() {
			
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
				String Text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertFalse(Text.contains("AddAndEditClassEnrollments"));


}
		
		@Test (priority = 4, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_CantCcourses() {
			
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
				String Text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertFalse(Text.contains("ViewCourses"));


}
		
		@Test (priority = 5, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_CantnrollCourse () {
			
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
				String Text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertFalse(Text.contains("AddAndEditCourseEnrollments"));


}
		
		@Test (priority = 6, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_NotCollectionsMember_PayOnlineAllowed() {
			
			Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthorizeCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthorizeCustomer(companyId, customerid))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String Text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertTrue(Text.contains("RealTimePayments"));
				
		}
		
		@Test (priority = 7, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_NotCollectionsMember_PayOnlineNotAllowed() {
			
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
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				String Text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertFalse(Text.contains("RealTimePayments"));
				
		}
		
		
		@Test (priority = 8, testName="Get Customer Authorizations")
		public void AuthorizeCustomer_CollectionsMember_PayOnlineNotAllowed() {
			
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
				String Text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertTrue(Text.contains("None"));
				Assert.assertFalse(Text.contains("RealTimePayments"));
				
		}
		
	
		
		@Test (priority = 9, testName="Get Customer Authorizations", enabled = true)
		public void AuthorizeCustomer_CollectionsMember_PayOnlineAllowed() {
			
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
				String Text = js.getString("Envelope.Body.AuthorizeCustomerResponse.AuthorizeCustomerResult.Permissions");
				Assert.assertTrue(Text.contains("RealTimePayments"));
				
		}
		
	
}
