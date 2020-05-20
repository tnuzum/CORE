package enrollmentService;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.EnrollmentServicePL;
import resources.ReusableMethods;
import resources.base;

public class PromoteStandbyEnrollmentsForCourse extends base{
	
static String companyId;
static String enrollmentId1;
static String enrollmentId2;
static String enrollmentId3;
static String enrollmentId4;
static String enrollmentId5;


@BeforeTest
public void getData() {
	base.getPropertyData();
	RestAssured.baseURI = prop.getProperty("baseURI");
	
	companyId = prop.getProperty("X-CompanyId");
}

@Test(priority = 1)
public void PromoteFromStandbyToEnroll() {
	
	String customerId = prop.getProperty("standbyCustomerId");
	String courseId= prop.getProperty("standbyCourseId");
		
	enrollmentId1 = ReusableMethods.placeOnStandbyCourse(companyId, customerId, courseId);
	
	
	  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/PromoteStandbyEnrollmentsForCourse","Content-Type","text/xml; charset=utf-8") .and()
	  .body(EnrollmentServicePL.PromoteStandbyEnrollmentsForCourse(companyId, courseId)) 
	  .when()
	  .post("/ClassesAndCourses/EnrollmentService.svc") 
	  .then() 
//	  .log().all()
	  .statusCode(200) .extract().response();
	  
	  XmlPath js = ReusableMethods.rawToXML(res);
	  
	  Assert.assertTrue(res.getTime() >= 60L); 
	  enrollmentId2 = js.getString("Envelope.Body.PromoteStandbyEnrollmentsForCourseResponse.PromoteStandbyEnrollmentsForCourseResult.int");
	  Assert.assertNotNull(enrollmentId2);
	  Assert.assertEquals(enrollmentId2, enrollmentId1);
	 
	  ReusableMethods.deleteEnrollment(companyId, enrollmentId1);
	  
}

@Test(priority = 2)
public void PromoteMultipleFromStandbyToEnroll() {
	
	String customerId = prop.getProperty("standbyCustomerId");
	String courseId= prop.getProperty("standbyCourseId");
	
	enrollmentId1 = ReusableMethods.placeOnStandbyCourse(companyId, customerId, courseId);
	enrollmentId2 = ReusableMethods.placeOnStandbyCourse(companyId, customerId, courseId);
	enrollmentId3 = ReusableMethods.placeOnStandbyCourse(companyId, customerId, courseId);
	
	ArrayList<String> a=new ArrayList<String>();
	
	a.add(enrollmentId1);
	a.add(enrollmentId2);
	a.add(enrollmentId3);
	
	
	
	  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/PromoteStandbyEnrollmentsForCourse","Content-Type","text/xml; charset=utf-8") .and()
	  .body(EnrollmentServicePL.PromoteStandbyEnrollmentsForCourse(companyId, courseId)) 
	  .when()
	  .post("/ClassesAndCourses/EnrollmentService.svc") 
	  .then() 
//	  .log().all()
	  .statusCode(200) .extract().response();
	  
	  XmlPath js = ReusableMethods.rawToXML(res);
	  
	  Assert.assertTrue(res.getTime() >= 60L); 
	  enrollmentId4 = js.getString("Envelope.Body.PromoteStandbyEnrollmentsForCourseResponse.PromoteStandbyEnrollmentsForCourseResult.int[0]");
	  enrollmentId5 = js.getString("Envelope.Body.PromoteStandbyEnrollmentsForCourseResponse.PromoteStandbyEnrollmentsForCourseResult.int[1]");
	  Assert.assertNotNull(enrollmentId4);
	  Assert.assertNotNull(enrollmentId5);
	  Assert.assertTrue(a.contains(enrollmentId4));
	  Assert.assertTrue(a.contains(enrollmentId5));
	 	 
	 
	  ReusableMethods.deleteEnrollment(companyId, enrollmentId1);
	  ReusableMethods.deleteEnrollment(companyId, enrollmentId2);
	  ReusableMethods.deleteEnrollment(companyId, enrollmentId3);
	  
}

@Test(priority = 3)
public void NoPromotionWhenCourseIsFull() {
	
	String customerId = prop.getProperty("standbyCustomerId");
	String customerId1 = prop.getProperty("enrollmentCustomerId1");
	String customerId2 = prop.getProperty("enrollmentCustomerId2");
	String courseId= prop.getProperty("standbyCourseId");
		
	enrollmentId1 = ReusableMethods.enrollInCourse(companyId, customerId1, courseId);
	enrollmentId2 = ReusableMethods.enrollInCourse(companyId, customerId2, courseId);
	enrollmentId3 = ReusableMethods.placeOnStandbyCourse(companyId, customerId, courseId);
		
	
	  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/PromoteStandbyEnrollmentsForCourse","Content-Type","text/xml; charset=utf-8") .and()
	  .body(EnrollmentServicePL.PromoteStandbyEnrollmentsForCourse(companyId, courseId)) 
	  .when()
	  .post("/ClassesAndCourses/EnrollmentService.svc") 
	  .then() 
//	  .log().all()
	  .statusCode(200) .extract().response();
	  
	  XmlPath js = ReusableMethods.rawToXML(res);
	  
	  Assert.assertTrue(res.getTime() >= 60L); 
	  
	  Assert.assertTrue(js.getString("Envelope.Body.PromoteStandbyEnrollmentsForCourseResponse.PromoteStandbyEnrollmentsForCourseResult").isEmpty());
	 	 	System.out.println(enrollmentId1); 
	 	 	System.out.println(enrollmentId2);
	 	 	System.out.println(enrollmentId3);
	 
	  ReusableMethods.deleteEnrollment(companyId, enrollmentId1);
	  ReusableMethods.deleteEnrollment(companyId, enrollmentId2);
	  ReusableMethods.deleteEnrollment(companyId, enrollmentId3);
	  
}

@Test(priority = 4)
public void InvalidCourseId() {
	
		String invalidCourseId= "363770000";
	
	
	  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/PromoteStandbyEnrollmentsForCourse","Content-Type","text/xml; charset=utf-8") .and()
	  .body(EnrollmentServicePL.PromoteStandbyEnrollmentsForCourse(companyId, invalidCourseId)) 
	  .when()
	  .post("/ClassesAndCourses/EnrollmentService.svc") 
	  .then() 
//	  .log().all()
	  .statusCode(400) .extract().response();
	  
	  XmlPath js = ReusableMethods.rawToXML(res);
	  
	  Assert.assertTrue(res.getTime() >= 60L); 
	  String text = js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message");
	  Assert.assertEquals(text, "ItemId: 363770000 is invalid.");
	  
	   
}

@Test(priority = 5)
public void sendClassIdForCourseId() {
	
	  String courseId= prop.getProperty("standbyClassId");
		
	  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/PromoteStandbyEnrollmentsForCourse","Content-Type","text/xml; charset=utf-8") .and()
	  .body(EnrollmentServicePL.PromoteStandbyEnrollmentsForCourse(companyId, courseId)) 
	  .when()
	  .post("/ClassesAndCourses/EnrollmentService.svc") 
	  .then() 
//	  .log().all()
	  .statusCode(400) .extract().response();
	  
	  XmlPath js = ReusableMethods.rawToXML(res);
	  
	  Assert.assertTrue(res.getTime() >= 60L); 
	  String text = js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message");
	  Assert.assertEquals(text, "itemId: "+courseId+" is not a course item.");
	  
}

}


