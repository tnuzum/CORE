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
static String InvoiceId = "36722";
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Send Family ClassEnrollment Confirmation Email")
	public void SendFamilyClassEnrollmentConfirmationEmail() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IMessagingService/SendFamilyClassEnrollmentConfirmationEmail","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(MessagingServicePL.SendFamilyClassEnrollmentConfirmationEmail(companyId, InvoiceId))
		.when()
			.post("/Messaging/MessagingService.svc")
		.then()
			.log().all()
			.statusCode(400)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
					
			Assert.assertTrue(res.getTime() >= 60L);
	}
			

}
