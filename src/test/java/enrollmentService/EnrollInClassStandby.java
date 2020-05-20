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

public class EnrollInClassStandby extends base{
	static String companyId;
	static String enrollmentId;
	

	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	@Test(priority = 1)
	public void PlaceOnStandby() {
		
		String customerId = prop.getProperty("standbyCustomerId");
		String classId= prop.getProperty("standbyClassId");
		String tomorrowsDate = ReusableMethods.getTomorrowsDate();
		
		//System.out.println(ReusableMethods.placeOnStandby(companyId, customerId, classId, tomorrowsDate));
		
		
		  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/EnrollInClassStandby","Content-Type","text/xml; charset=utf-8") .and()
		  .body(EnrollmentServicePL.EnrollInClassStandby(companyId, customerId,classId, tomorrowsDate)) .when()
		  .post("/ClassesAndCourses/EnrollmentService.svc") 
		  .then() 
//		  .log().all()
		  .statusCode(200) .extract().response();
		  
		  XmlPath js = ReusableMethods.rawToXML(res);
		  
		  Assert.assertTrue(res.getTime() >= 60L); 
		  String text = js.getString("Envelope.Body.EnrollInClassStandbyResponse.EnrollInClassStandbyResult.EnrollmentResult"); 
		  enrollmentId = js.getString("Envelope.Body.EnrollInClassStandbyResponse.EnrollInClassStandbyResult.EnrollmentId");
		  
		  Assert.assertEquals(text, "Success"); 
		  Assert.assertNotNull(enrollmentId);
		
		 
	}
	@Test(priority = 2, dependsOnMethods = {"PlaceOnStandby"})
	public void DeleteEnrollment() {
		
		ReusableMethods.deleteEnrollment(companyId, enrollmentId);
	}
}
