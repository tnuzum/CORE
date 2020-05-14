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

public class EnrollInCourse extends base {
	
	static String companyId;
	static String enrollmentId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	@Test(priority = 1)
	public void enrollInCourse() {
		
		String customerId = prop.getProperty("enrollmentCustomerId1");
		String courseId= prop.getProperty("enrollmentCourseId");
				
		//System.out.println(ReusableMethods.placeOnStandby(companyId, customerId, classId, tomorrowsDate));
		
		
		  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/EnrollInCourse","Content-Type","text/xml; charset=utf-8") .and()
		  .body(EnrollmentServicePL.EnrollInCourse(companyId, customerId, courseId)) 
		  .when()
		  .post("/ClassesAndCourses/EnrollmentService.svc") 
		  .then() 
//		  .log().all()
		  .statusCode(200) .extract().response();
		  
		  XmlPath js = ReusableMethods.rawToXML(res);
		  	  
		  Assert.assertTrue(res.getTime() >= 60L); 
		  String text = js.getString("Envelope.Body.EnrollInCourseResponse.EnrollInCourseResult.EnrollmentResult");
		  enrollmentId = js.getString("Envelope.Body.EnrollInCourseResponse.EnrollInCourseResult.EnrollmentId");
		  Assert.assertEquals(text, "Success"); 
		  Assert.assertNotNull(enrollmentId);
		  
}
	
	@Test(priority = 2, dependsOnMethods = {"enrollInCourse"})
	public void DeleteEnrollment() {
		
		ReusableMethods.deleteEnrollment(companyId, enrollmentId);
	}
}
