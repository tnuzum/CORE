package CORE.MessagingService;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CorporateInfoPL;
import payloads.MessagingServicePL;
import resources.ReusableMethods;
import resources.base;

public class SendFamilyCourseEnrollmentConfirmationEmailTest extends base {
	
static String companyId;
static String customerid = "667";
static String customerid1 = "66777";
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (priority = 1, testName="Send Family CourseEnrollment Confirmation Email - Both Enrollment and Standby")
	public void SendFamilyCourseEnrollmentConfirmationEmail() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendFamilyCourseEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.SendFamilyCourseEnrollmentAndStandbyConfirmationEmail(companyId, customerid))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
	}
	
	@Test (priority = 2,testName="Send Family CourseEnrollment Confirmation Email - Only Enrollment ")
	public void SendFamilyCourseEnrollmentOnlyConfirmationEmail() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendFamilyCourseEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.SendFamilyCourseEnrollmentOnlyConfirmationEmail(companyId, customerid))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
	}
	
	@Test (priority = 3,testName="Send Family CourseEnrollment Confirmation Email - Only Standby ")
	public void SendFamilyCourseStandbyOnlyConfirmationEmail() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendFamilyCourseEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.SendFamilyCourseStandbyOnlyConfirmationEmail(companyId, customerid))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
	}
	
	@Test (priority = 4,testName="Send Family CourseEnrollment Confirmation Email - Hoh is not enrolled ")
	public void SendFamilyCourseEnrollmentAndStandbyNoHohConfirmationEmail() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendFamilyCourseEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.SendFamilyCourseEnrollmentAndStandbyNoHohConfirmationEmail(companyId, customerid))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
	}
			
	@Test (priority = 5,testName="Send Family CourseEnrollment Confirmation Email - Invalid CustomerId ")
	public void InvalidCustomerId() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendFamilyCourseEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.InvalidCourseCustomerId(companyId, customerid1))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
			.log().all()
			.statusCode(400)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertEquals(js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message"), "CustomerId: 66777 is invalid.");
	}
	
	@Test (priority = 6,testName="Send Family CourseEnrollment Confirmation Email - Invalid EnrollmentId ")
	public void InvalidEnrollmentId() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendFamilyCourseEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.InvalidCourseEnrollmentId(companyId, customerid))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
			.log().all()
			.statusCode(400)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
			Assert.assertEquals(js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message"), "EnrollmentIds: 3308611 were not found.");
	}

}
