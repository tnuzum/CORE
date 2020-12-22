package enrollmentService;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.EnrollmentServicePL;
import resources.ReusableMethods;
import resources.base;

public class GetClass extends base{
	
	static String companyId;
	static String dateTime;
	
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test(priority = 1)
	public void GetVirtualClass() {
		
		String customerId = prop.getProperty("enrollmentCustomerId1");
		String classId= prop.getProperty("virtualEnrollmentClassId");
		String tomorrowsDate = ReusableMethods.getTomorrowsDate();
		dateTime = tomorrowsDate+"T05:00:00Z";
		
		
		  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/GetClass","Content-Type","text/xml; charset=utf-8") .and()
		  .body(EnrollmentServicePL.GetClass_Virtual(companyId, customerId, classId, dateTime)) 
		  .when()
		  .post("/ClassesAndCourses/EnrollmentService.svc") 
		  .then() 
//		  .log().all()
		  .statusCode(200) .extract().response();
		  
		  XmlPath js = ReusableMethods.rawToXML(res);
		  	  
		  Assert.assertTrue(res.getTime() >= 60L); 
		  String text = js.getString("Envelope.Body.GetClassResponse.GetClassResult.IsVirtual");
		  System.out.println("text = "+text);
		  Assert.assertEquals(text, "true"); 
		
		  
}
	
	@Test(priority = 2)
	public void GetNonVirtualClass() {
		
		String customerId = prop.getProperty("enrollmentCustomerId1");
		String classId= prop.getProperty("enrollmentClassId");
		String tomorrowsDate = ReusableMethods.getTomorrowsDate();
		dateTime = tomorrowsDate+"T22:00:00Z";
					
		  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/GetClass","Content-Type","text/xml; charset=utf-8") .and()
		  .body(EnrollmentServicePL.GetClass_Virtual(companyId, customerId, classId, dateTime)) 
		  .when()
		  .post("/ClassesAndCourses/EnrollmentService.svc") 
		  .then() 
//		  .log().all()
		  .statusCode(200) .extract().response();
		  
		  XmlPath js = ReusableMethods.rawToXML(res);
		  	  
		  Assert.assertTrue(res.getTime() >= 60L); 
		  String text = js.getString("Envelope.Body.GetClassResponse.GetClassResult.IsVirtual");
		  Assert.assertEquals(text, "false"); 
		
		  
}
	
	@Test(priority = 3)
	public void GetNonVirtualClassWithOverrideUrls() {
		
		String customerId = prop.getProperty("enrollmentCustomerId1");
		String classId= prop.getProperty("NonVirtualWithOverrideClassId");
		String tomorrowsDate = ReusableMethods.getTomorrowsDate();
		dateTime = tomorrowsDate+"T18:30:00Z";
					
		  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/GetClass","Content-Type","text/xml; charset=utf-8") .and()
		  .body(EnrollmentServicePL.GetClass_Virtual(companyId, customerId, classId, dateTime)) 
		  .when()
		  .post("/ClassesAndCourses/EnrollmentService.svc") 
		  .then() 
//		  .log().all()
		  .statusCode(200) .extract().response();
		  
		  XmlPath js = ReusableMethods.rawToXML(res);
		  	  
		  Assert.assertTrue(res.getTime() >= 60L); 
		  String text = js.getString("Envelope.Body.GetClassResponse.GetClassResult.IsVirtual");
		  Assert.assertEquals(text, "false"); 
		
		  
}

}
