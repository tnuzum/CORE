package messagingService;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.MessagingServicePL;
import resources.ReusableMethods;
import resources.base;

public class SendCustomerCourseUnenrollmentEmail extends base {
	static String companyId;
	static String enrollmentId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	@Test(priority = 1)
	public void sendCourseUnenrollmentEmailToCustomer() {
		
		String customerId = prop.getProperty("enrollmentCustomerId");
		String courseId= prop.getProperty("enrollmentCourseId");
				
		enrollmentId = ReusableMethods.enrollInCourse(companyId, customerId, courseId); // Place customer On Standby
		
		System.out.println(enrollmentId);
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IMessagingService/SendCustomerCourseUnenrollmentEmail","Content-Type","text/xml; charset=utf-8") 
				 .and()
				  .body(MessagingServicePL.SendCustomerCourseUnenrollmentEmail(companyId, enrollmentId)) 
				  .when()
				  .post("/Messaging/MessagingService.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  String text = js.getString("Envelope.Body.SendCustomerCourseUnenrollmentEmailResponse");
				  Assert.assertNotNull(text);
				  
				  Assert.assertTrue(res.getTime() >= 60L); 
				 
				  ReusableMethods.deleteEnrollment(companyId, enrollmentId); //Delete Enrollment
	}
	
	@Test(priority = 2)
	public void InvalidEnrollmentId() {
			
		
		enrollmentId = "38554333";
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IMessagingService/SendCustomerCourseUnenrollmentEmail","Content-Type","text/xml; charset=utf-8") 
				 .and()
				  .body(MessagingServicePL.SendCustomerCourseUnenrollmentEmail(companyId, enrollmentId)) 
				  .when()
				  .post("/Messaging/MessagingService.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(400) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  String text = js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message");
				  Assert.assertEquals(text, "enrollmentId: 38554333 is invalid.");
	}
	
	@Test(priority = 3)
	public void sendCourseIdForClassId() {
		
		String customerId = prop.getProperty("enrollmentCustomerId");
		String classId= prop.getProperty("enrollmentClassId");
		String tomorrowsDate = ReusableMethods.getTomorrowsDate();
		
		
		enrollmentId = ReusableMethods.enrollInClass(companyId, customerId, classId, tomorrowsDate); // Place customer On Standby
	
		System.out.println(enrollmentId);
		
		
		  Response res = given() .headers("SOAPAction","http://tempuri.org/IMessagingService/SendCustomerCourseUnenrollmentEmail","Content-Type","text/xml; charset=utf-8") 
				  .and()
		  .body(MessagingServicePL.SendCustomerCourseUnenrollmentEmail(companyId, enrollmentId)) 
		  .when() .post("/Messaging/MessagingService.svc") .then()
//		  .log().all() 
		  .statusCode(400) 
		  .extract().response();
		  
		  XmlPath js = ReusableMethods.rawToXML(res); String text =
		  js.getString("Envelope.Body.SendCustomerCourseUnenrollmentEmailResponse");
		  Assert.assertNotNull(text);
		  
		  Assert.assertTrue(res.getTime() >= 60L); String text1 =
		  js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message");
		  Assert.assertEquals(text1,
		  "enrollmentId: "+enrollmentId+" is not a class enrollment.");
		  ReusableMethods.deleteEnrollment(companyId, enrollmentId);
		 
		
	}
}
