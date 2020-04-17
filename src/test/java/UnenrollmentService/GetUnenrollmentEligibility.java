//FOR	THIS TEST, SOME IDS HAVE TO BE UPDATED AFTER MAY 2020
package UnenrollmentService;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.UnenrollmentServicePL;
import resources.ReusableMethods;
import resources.base;

public class GetUnenrollmentEligibility extends base {
				
		static String companyId;
		

			@BeforeTest
			public void getData() {
				base.getPropertyData();
				RestAssured.baseURI = prop.getProperty("baseURI");
				
				companyId = prop.getProperty("X-CompanyId");
			}
			
			@Test (priority = 1, testName="Get Unenrollment Eligibility_Eligible_Course In Future")
			public void GetCourseUnenrollmentEligibility_Eligible_CourseInFuture() {
				
				String courseEnrollmentId_Eligible_CourseInFuture = prop.getProperty("courseEnrollmentId_Eligible_CourseInFuture");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, courseEnrollmentId_Eligible_CourseInFuture))
				.when()
					.post("/ClassesAndCourses/UnenrollmentService.svc")
				.then()
//					.log().all()
					.statusCode(200)
					.extract().response();  
					
					XmlPath js = ReusableMethods.rawToXML(res);
							
					Assert.assertTrue(res.getTime() >= 60L);
					String text = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.IsUnenrollmentAllowed");
					Assert.assertEquals(text, "true");
			}
			
			@Test (priority = 2, testName="Get Unenrollment Eligibility_NotEligible_Within Cannot Cancel Window")
			public void GetCourseUnenrollmentEligibility_NotEligible_WithinCannotCancelWindow() {
				
				String courseEnrollmentId_NotEligible_WithinCannotCancelWindow = prop.getProperty("courseEnrollmentId_NotEligible_WithinCannotCancelWindow");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, courseEnrollmentId_NotEligible_WithinCannotCancelWindow))
				.when()
					.post("/ClassesAndCourses/UnenrollmentService.svc")
				.then()
//					.log().all()
					.statusCode(200)
					.extract().response();  
					
					XmlPath js = ReusableMethods.rawToXML(res);
							
					Assert.assertTrue(res.getTime() >= 60L);
					String text = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.IsUnenrollmentAllowed");
					Assert.assertEquals(text, "false");
			}
			
			@Test (priority = 3, testName="Get Unenrollment Eligibility_NotEligible_Course Started")
			public void GetCourseUnenrollmentEligibility_NotEligible_CourseStarted() {
				
				String courseEnrollmentId_NotEligible_CourseStarted = prop.getProperty("courseEnrollmentId_NotEligible_CourseStarted");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, courseEnrollmentId_NotEligible_CourseStarted))
				.when()
					.post("/ClassesAndCourses/UnenrollmentService.svc")
				.then()
//					.log().all()
					.statusCode(200)
					.extract().response();  
					
					XmlPath js = ReusableMethods.rawToXML(res);
							
					Assert.assertTrue(res.getTime() >= 60L);
					String text = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.IsUnenrollmentAllowed");
					Assert.assertEquals(text, "false");
			}
			
			@Test (priority = 4, testName="Get Unenrollment Eligibility_Eligible_Class In Future")
			public void GetClassUnenrollmentEligibility_Eligible_ClassInFuture() {
				
				String classEnrollmentId_Eligible_ClassInFuture = prop.getProperty("classEnrollmentId_Eligible_ClassInFuture");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, classEnrollmentId_Eligible_ClassInFuture))
				.when()
					.post("/ClassesAndCourses/UnenrollmentService.svc")
				.then()
//					.log().all()
					.statusCode(200)
					.extract().response();  
					
					XmlPath js = ReusableMethods.rawToXML(res);
							
					Assert.assertTrue(res.getTime() >= 60L);
					String text = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.IsUnenrollmentAllowed");
					Assert.assertEquals(text, "true");
			}
			
			@Test (priority = 5, testName="Get Unenrollment Eligibility_NotEligible_Class In Past")
			public void GetClassUnenrollmentEligibility_NotEligible_ClassInPast() {
				
				String classEnrollmentId_NotEligible_ClassInPast = prop.getProperty("classEnrollmentId_NotEligible_ClassInPast");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, classEnrollmentId_NotEligible_ClassInPast))
				.when()
					.post("/ClassesAndCourses/UnenrollmentService.svc")
				.then()
//					.log().all()
					.statusCode(200)
					.extract().response();  
					
					XmlPath js = ReusableMethods.rawToXML(res);
							
					Assert.assertTrue(res.getTime() >= 60L);
					String text = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.IsUnenrollmentAllowed");
					Assert.assertEquals(text, "false");
			}
			
			@Test (priority = 6, testName="Get Unenrollment Eligibility_NotEligible_Within Cannot Cancel Window")
			public void GetClassUnenrollmentEligibility_NotEligible_WithinCannotCancelWindow() {
				
				String classEnrollmentId_NotEligible_WithinCannotCancelWindow = prop.getProperty("classEnrollmentId_NotEligible_WithinCannotCancelWindow");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, classEnrollmentId_NotEligible_WithinCannotCancelWindow))
				.when()
					.post("/ClassesAndCourses/UnenrollmentService.svc")
				.then()
//					.log().all()
					.statusCode(200)
					.extract().response();  
					
					XmlPath js = ReusableMethods.rawToXML(res);
							
					Assert.assertTrue(res.getTime() >= 60L);
					String text = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.IsUnenrollmentAllowed");
					Assert.assertEquals(text, "false");
			}
			
			@Test (priority = 7, testName="Invalid EnrollmentId")
			public void GetClassUnenrollmentEligibility_InvalidEnrollmentId() {
				
				String InvalidEnrollmentId = prop.getProperty("InvalidEnrollmentId");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, InvalidEnrollmentId))
				.when()
					.post("/ClassesAndCourses/UnenrollmentService.svc")
				.then()
//					.log().all()
					.statusCode(400)
					.extract().response();  
					
					XmlPath js = ReusableMethods.rawToXML(res);
							
					Assert.assertTrue(res.getTime() >= 60L);
					String text = js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message");
					Assert.assertEquals(text, "EnrollmentId: 3661412 is invalid.");
			}
			

}
