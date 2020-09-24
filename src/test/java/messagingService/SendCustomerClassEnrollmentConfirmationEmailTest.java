package messagingService;

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

public class SendCustomerClassEnrollmentConfirmationEmailTest extends base {
	
static String companyId;

	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (priority = 1, testName="Send Customer ClassEnrollment Confirmation Email")
	public void SendCustomerClassEnrollmentConfirmationEmail() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendCustomerClassEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.SendCustomerClassEnrollmentConfirmationEmail(companyId))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
	}
	
	@Test (priority = 2,testName="Invalid EnrollmentId")
	public void InvalidEnrollmentId() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendCustomerClassEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.SendCustomerClassEnrollmentConfirmationEmail_InvalidEnrlmntId(companyId))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
//			.log().all()
			.statusCode(400)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
			Assert.assertEquals(js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message"), "enrollmentId: 330777 is invalid.");
	}
	
	@Test (priority = 3, testName="Send Customer VirtualClassEnrollment Confirmation Email")
	public void SendVirtualCustomerClassEnrollmentConfirmationEmail() {
		
		String customerId = prop.getProperty("enrollmentCustomerId");
		String classId= prop.getProperty("virtualEnrollmentClassId");
		String tomorrowsDate = ReusableMethods.getTomorrowsDate();
		
		String enrollmentId = ReusableMethods.enrollInClass(companyId, customerId, classId, tomorrowsDate); // Place customer On Standby
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendCustomerClassEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.SendVirtualCustomerClassEnrollmentConfirmationEmail(companyId, enrollmentId))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
			 ReusableMethods.deleteEnrollment(companyId, enrollmentId);
	}
	
	
}
