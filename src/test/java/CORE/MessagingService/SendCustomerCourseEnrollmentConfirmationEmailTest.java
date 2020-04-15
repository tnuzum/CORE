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

public class SendCustomerCourseEnrollmentConfirmationEmailTest extends base {
	
static String companyId;

	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (priority = 1, testName="Send Customer CourseEnrollment Confirmation Email")
	public void SendCustomerCourseEnrollmentConfirmationEmail() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendCustomerCourseEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.SendCustomerCourseEnrollmentConfirmationEmail(companyId))
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
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendCustomerCourseEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.SendCustomerCourseEnrollmentConfirmationEmail_InvalidEnrlmntId(companyId))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
//			.log().all()
			.statusCode(500)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
			Assert.assertEquals(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto.Message"), "Sequence contains no elements");
	}
	
	
}
