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

public class GetCourse extends base{
	
	static String companyId;
	
	
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test(priority = 1)
	public void GetVirtualCourse() {
		
		String customerId = prop.getProperty("enrollmentCustomerId1");
		String courseId= prop.getProperty("virtualEnrollmentCourseId");
		
		  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/GetCourse","Content-Type","text/xml; charset=utf-8") .and()
		  .body(EnrollmentServicePL.GetCourse_Virtual(companyId, customerId, courseId)) 
		  .when()
		  .post("/ClassesAndCourses/EnrollmentService.svc") 
		  .then() 
//		  .log().all()
		  .statusCode(200) .extract().response();
		  
		  XmlPath js = ReusableMethods.rawToXML(res);
		  	  
		  Assert.assertTrue(res.getTime() >= 60L); 
		  String text = js.getString("Envelope.Body.GetCourseResponse.GetCourseResult.IsVirtual");
		  Assert.assertEquals(text, "true"); 
		
		  
}
	
	@Test(priority = 2)
	public void GetNonVirtualCourse() {
		
		String customerId = prop.getProperty("enrollmentCustomerId1");
		String courseId= prop.getProperty("enrollmentCourseId");
		
					
		  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/GetCourse","Content-Type","text/xml; charset=utf-8") .and()
		  .body(EnrollmentServicePL.GetCourse_Virtual(companyId, customerId, courseId)) 
		  .when()
		  .post("/ClassesAndCourses/EnrollmentService.svc") 
		  .then() 
//		  .log().all()
		  .statusCode(200) .extract().response();
		  
		  XmlPath js = ReusableMethods.rawToXML(res);
		  	  
		  Assert.assertTrue(res.getTime() >= 60L); 
		  String text = js.getString("Envelope.Body.GetCourseResponse.GetCourseResult.IsVirtual");
		  Assert.assertEquals(text, "false"); 
		
		  
}
	
	@Test(priority = 3)
	public void GetNonVirtualCourseWithOverrideUrls() {
		
		String customerId = prop.getProperty("enrollmentCustomerId1");
		String courseId= prop.getProperty("NonVirtualWithOverrideCourseId");
		
					
		  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/GetCourse","Content-Type","text/xml; charset=utf-8") .and()
		  .body(EnrollmentServicePL.GetCourse_Virtual(companyId, customerId, courseId)) 
		  .when()
		  .post("/ClassesAndCourses/EnrollmentService.svc") 
		  .then() 
//		  .log().all()
		  .statusCode(200) .extract().response();
		  
		  XmlPath js = ReusableMethods.rawToXML(res);
		  	  
		  Assert.assertTrue(res.getTime() >= 60L); 
		  String text = js.getString("Envelope.Body.GetCourseResponse.GetCourseResult.IsVirtual");
		  Assert.assertEquals(text, "false"); 
		
		  
}

}
