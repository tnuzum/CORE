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

public class DeleteEnrollment extends base {
	static String companyId;
	static String enrollmentId;
	

	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	@Test(priority = 1)
	public void deleteEnrollment() {
		String customerId = prop.getProperty("standbyCustomerId");
		String classId= prop.getProperty("standbyClassId");
		String tomorrowsDate = ReusableMethods.getTomorrowsDate()+"T21:00:00Z";
		
		//"2020-06-25T21:00:00Z";
		
		 enrollmentId = ReusableMethods.enrollInClass(companyId, customerId, classId, tomorrowsDate);
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/DeleteEnrollment","Content-Type","text/xml; charset=utf-8") .and()
				  .body(EnrollmentServicePL.DeleteEnrollment(companyId, enrollmentId)) .when()
				  .post("/ClassesAndCourses/EnrollmentService.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  
				  Assert.assertTrue(res.getTime() >= 60L); 
				  Assert.assertNotNull(js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.CustomerId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.ItemId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.StartDate.DateTime"));
				  Assert.assertNotNull(js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.StartDate.OffsetMinutes"));
				  Assert.assertNotNull(js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.EndDate.DateTime"));
				  Assert.assertNotNull(js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.EndDate.OffsetMinutes"));
				  Assert.assertNotNull(js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.EnrollmentOccurredOn.DateTime"));
				  Assert.assertNotNull(js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.EnrollmentOccurredOn.OffsetMinutes"));
				 
	}
	
	@Test(priority = 2)
	public void invalidEnrollmentId() {
			
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/DeleteEnrollment","Content-Type","text/xml; charset=utf-8") .and()
				  .body(EnrollmentServicePL.DeleteEnrollment(companyId, enrollmentId)) .when()
				  .post("/ClassesAndCourses/EnrollmentService.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(400) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  
				  Assert.assertTrue(res.getTime() >= 60L); 
				  String text = js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message");
				  Assert.assertEquals("enrollmentId: "+enrollmentId+" is invalid.", text);
	}


}
