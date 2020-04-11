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

public class SendFamilyClassEnrollmentConfirmationEmailTest extends base {
	
static String companyId;
static String customerid = "667";
static String customerid1 = "66777";
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (priority = 1, testName="Send Family ClassEnrollment Confirmation Email - Both Enrollment and Standby")
	public void SendFamilyClassEnrollmentConfirmationEmail() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendFamilyClassEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.SendFamilyClassEnrollmentAndStandbyConfirmationEmail(companyId, customerid))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
	}
	
	@Test (priority = 2,testName="Send Family ClassEnrollment Confirmation Email - Only Enrollment ")
	public void SendFamilyClassEnrollmentOnlyConfirmationEmail() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendFamilyClassEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.SendFamilyClassEnrollmentOnlyConfirmationEmail(companyId, customerid))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
	}
	
	@Test (priority = 3,testName="Send Family ClassEnrollment Confirmation Email - Only Standby ")
	public void SendFamilyClassStandbyOnlyConfirmationEmail() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendFamilyClassEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.SendFamilyClassStandbyOnlyConfirmationEmail(companyId, customerid))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
	}
	
	@Test (priority = 4,testName="Send Family ClassEnrollment Confirmation Email - Hoh is not enrolled ")
	public void SendFamilyClassEnrollmentAndStandbyNoHohConfirmationEmail() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendFamilyClassEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.SendFamilyClassEnrollmentAndStandbyNoHohConfirmationEmail(companyId, customerid))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
	}
			
	@Test (priority = 5,testName="Send Family ClassEnrollment Confirmation Email - Invalid CustomerId ")
	public void InvalidCustomerId() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendFamilyClassEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.InvalidCustomerId(companyId, customerid1))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
//			.log().all()
			.statusCode(400)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertEquals(js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message"), "CustomerId: 66777 is invalid.");
	}
	
	@Test (priority = 6,testName="Send Family ClassEnrollment Confirmation Email - Invalid EnrollmentId ")
	public void InvalidEnrollmentId() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendFamilyClassEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.InvalidEnrollmentId(companyId, customerid))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
//			.log().all()
			.statusCode(400)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
			Assert.assertEquals(js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message"), "EnrollmentIds: 3307555 were not found.");
	}

}
