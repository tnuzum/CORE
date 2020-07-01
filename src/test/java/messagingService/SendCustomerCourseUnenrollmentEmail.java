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
	static String customerId1;
	static String itemId;
	static String startTime;
	static String startTimeOffset;
	static String endTime;
	static String endTimeOffset;
	static String enrollmentOccurrenceTime;
	static String enrollmentOccurrenceTimeOffset;
	
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
		
		String output[] = ReusableMethods.deleteEnrollment(companyId, enrollmentId); //Delete Enrollment (Unenroll)
		
		
		 customerId1 =  output[0];
		 itemId = output[1];
		 startTime = output[2];
		 startTimeOffset = output[3];
		 endTime = output[4];
		 endTimeOffset = output[5];
		 enrollmentOccurrenceTime = output[6];
		 enrollmentOccurrenceTimeOffset = output[7];
		 System.out.println(enrollmentId);
		
		System.out.println(enrollmentId);
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IMessagingService/SendCustomerClassUnenrollmentEmail","Content-Type","text/xml; charset=utf-8") 
				 .and()
				  .body(MessagingServicePL.SendCustomerCourseUnenrollmentEmail( companyId,  customerId1,  itemId,  startTime,  startTimeOffset,  endTime,  endTimeOffset,  enrollmentOccurrenceTime,  enrollmentOccurrenceTimeOffset))
				  .when()
				  .post("/Messaging/MessagingService.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  String text = js.getString("Envelope.Body.SendCustomerClassUnenrollmentEmailResponse");
				  Assert.assertNotNull(text);
				  
				  Assert.assertTrue(res.getTime() >= 60L); 
				 
				  
	}
	
	@Test(priority = 2)
	public void InvalidCustomerId() {
		
		
	 String customerId2 =  "822222";
	 
	
	System.out.println(enrollmentId);
	
	 Response res = given() .headers("SOAPAction", "http://tempuri.org/IMessagingService/SendCustomerClassUnenrollmentEmail","Content-Type","text/xml; charset=utf-8") 
			 .and()
			  .body(MessagingServicePL.SendCustomerCourseUnenrollmentEmail( companyId,  customerId2,  itemId,  startTime,  startTimeOffset,  endTime,  endTimeOffset,  enrollmentOccurrenceTime,  enrollmentOccurrenceTimeOffset))
			  .when()
			  .post("/Messaging/MessagingService.svc") 
			  .then() 
//			  .log().all()
			  .statusCode(400) .extract().response();
			  
			  XmlPath js = ReusableMethods.rawToXML(res);
			  String text =
					  js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message");
			  Assert.assertEquals(text, "CustomerId: 822222 is invalid.");
}
	
	@Test(priority = 3)
	public void InvalidItemId() {
			
		
		 String itemId1 =  "363333";
		 
		
		System.out.println(enrollmentId);
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IMessagingService/SendCustomerClassUnenrollmentEmail","Content-Type","text/xml; charset=utf-8") 
				 .and()
				  .body(MessagingServicePL.SendCustomerClassUnenrollmentEmail( companyId,  customerId1,  itemId1,  startTime,  startTimeOffset,  endTime,  endTimeOffset,  enrollmentOccurrenceTime,  enrollmentOccurrenceTimeOffset))
				  .when()
				  .post("/Messaging/MessagingService.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(400) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  String text =
						  js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message");
				  Assert.assertEquals(text, "ItemId: 363333 is invalid.");
	}
	
	@Test(priority = 4)
	public void sendCourseIdForClassId() {
		
		 String itemId2 = prop.getProperty("enrollmentClassId"); ;
		 
		
		System.out.println(enrollmentId);
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IMessagingService/SendCustomerClassUnenrollmentEmail","Content-Type","text/xml; charset=utf-8") 
				 .and()
				  .body(MessagingServicePL.SendCustomerClassUnenrollmentEmail( companyId,  customerId1,  itemId2,  startTime,  startTimeOffset,  endTime,  endTimeOffset,  enrollmentOccurrenceTime,  enrollmentOccurrenceTimeOffset))
				  .when()
				  .post("/Messaging/MessagingService.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(400) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  String text =
						  js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message");
				  Assert.assertEquals(text, "ItemId: "+itemId2+" is not a course enrollment.");
	}
}
