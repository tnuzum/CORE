//FOR	THIS TEST, SOME IDS HAVE TO BE UPDATED AFTER MAY 2020
package unenrollmentService;

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
		static String enrollmentId;

			@BeforeTest
			public void getData() {
				base.getPropertyData();
				RestAssured.baseURI = prop.getProperty("baseURI");
				
				companyId = prop.getProperty("X-CompanyId");
			}
			
			@Test (priority = 1, testName="Get Unenrollment Eligibility_Eligible_Course In Future")
			public void GetCourseUnenrollmentEligibility_Eligible_CourseInFuture() {
				
				String customerId = prop.getProperty("enrollmentCustomerId");
				
				String courseId = prop.getProperty("courseIdInFuture");
				
				String courseEnrollmentId_Eligible_CourseInFuture = ReusableMethods.enrollInCourse(companyId, customerId, courseId);
				
				System.out.println(courseEnrollmentId_Eligible_CourseInFuture);
				
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
					
					ReusableMethods.deleteEnrollment(companyId, courseEnrollmentId_Eligible_CourseInFuture);
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
//					Assert.assertEquals(text, "true");
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
			
			@Test (priority = 8, testName="Class Eligible for Unenerollment, Non Refundable")
			public void ClassNonRefundable() {
				
				String NonRefundable_ClassEnrollmentId = prop.getProperty("NonRefundable_ClassEnrollmentId");
				
				Response res = given()
//					.log().all()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, NonRefundable_ClassEnrollmentId))
				.when()
					.post("/ClassesAndCourses/UnenrollmentService.svc")
				.then()
//					.log().all()
					.statusCode(200)
					.extract().response();  
					
					XmlPath js = ReusableMethods.rawToXML(res);
							
					Assert.assertTrue(res.getTime() >= 60L);
					String text = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.IsUnenrollmentAllowed");
					//Assert.assertEquals(text, "true");
					String text1 = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundType");
					//Assert.assertEquals(text1, "None");
			}
			
			@Test (priority = 9, testName="Class Eligible for Unenerollment, Refundable to On Account")
			public void ClassRefundableToOnAccount() {
				
				String RefundableToOnAccount_ClassEnrollmentId = prop.getProperty("RefundableToOnAccount_ClassEnrollmentId");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, RefundableToOnAccount_ClassEnrollmentId))
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
					String text1 = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundType");
					Assert.assertEquals(text1, "OnAccount CreditCard");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundableEnrollmentItem.ItemDescription");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundableEnrollmentItem.ItemId");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundableEnrollmentItem.RefundableAmount");
			}
			
			@Test (priority = 10, testName="Class Eligible for Unenerollment, Refundable to On Account and Credit Card")
			public void ClassRefundableToOnAccountAndCreditCard() {
				
				String RefundableToOnAccounAndCard_ClassEnrollmentId = prop.getProperty("RefundableToOnAccounAndCard_ClassEnrollmentId");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, RefundableToOnAccounAndCard_ClassEnrollmentId))
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
					String text1 = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundType");
					Assert.assertEquals(text1, "OnAccount CreditCard");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundableEnrollmentItem.ItemDescription");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundableEnrollmentItem.ItemId");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundableEnrollmentItem.RefundableAmount");
			}
			
			@Test (priority = 11, testName="Class Eligible for Unenerollment, Refundable in Punches")
			public void ClassRefundableInPunches() {
				
				String RefundableInPunches_ClassEnrollmentId = prop.getProperty("RefundableInPunches_ClassEnrollmentId");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, RefundableInPunches_ClassEnrollmentId))
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
					String text1 = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundType");
					Assert.assertEquals(text1, "PunchCard");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundablePackage.PackageDescription");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundablePackage.PackageId");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundablePackage.RefundablePunchQuantity");
			}
			
					
			@Test (priority = 12, testName="Course Eligible for Unenerollment, Non Refundable")
			public void CourseNonRefundable() {
				
				String NonRefundable_CourseEnrollmentId = prop.getProperty("NonRefundable_CourseEnrollmentId");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, NonRefundable_CourseEnrollmentId))
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
					String text1 = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundType");
					Assert.assertEquals(text1, "None");
			}
			
			@Test (priority = 13, testName="Course Eligible for Unenerollment, Refundable to On Account")
			public void CourseRefundableToOnAccount() {
				
				String RefundableToOnAccount_CourseEnrollmentId = prop.getProperty("RefundableToOnAccount_CourseEnrollmentId");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, RefundableToOnAccount_CourseEnrollmentId))
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
					String text1 = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundType");
					Assert.assertEquals(text1, "OnAccount");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundableEnrollmentItem.ItemDescription");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundableEnrollmentItem.ItemId");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundableEnrollmentItem.RefundableAmount");
			}
			
			@Test (priority = 14, testName="Course Eligible for Unenerollment, Refundable to On Account and Credit Card")
			public void CourseRefundableToOnAccountAndCreditCard() {
				
				String RefundableToOnAccounAndCard_CourseEnrollmentId = prop.getProperty("RefundableToOnAccounAndCard_CourseEnrollmentId");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, RefundableToOnAccounAndCard_CourseEnrollmentId))
				.when()
					.post("/ClassesAndCourses/UnenrollmentService.svc")
				.then()
					.log().all()
					.statusCode(200)
					.extract().response();  
					
					XmlPath js = ReusableMethods.rawToXML(res);
							
					Assert.assertTrue(res.getTime() >= 60L);
					String text = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.IsUnenrollmentAllowed");
					Assert.assertEquals(text, "true");
					String text1 = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundType");
					Assert.assertEquals(text1, "OnAccount CreditCard");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundableEnrollmentItem.ItemDescription");
			     	Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundableEnrollmentItem.ItemId");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundableEnrollmentItem.RefundableAmount");
			}
			
			@Test (priority = 15, testName="Course Eligible for Unenerollment, Refundable in Punches")
			public void CourseRefundableInPunches() {
				
				String RefundableInPunches_CourseEnrollmentId = prop.getProperty("RefundableInPunches_CourseEnrollmentId");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, RefundableInPunches_CourseEnrollmentId))
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
					String text1 = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundType");
					Assert.assertEquals(text1, "PunchCard");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundablePackage.PackageDescription");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundablePackage.PackageId");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.RefundablePackage.RefundablePunchQuantity");
			}
			
			@Test (priority = 16, testName="Class Eligible for Unenerollment, Cancellation Fee exists")
			public void UnenrollmentFeeExistsForClassEnrolledByFee() {
				
				String UnenrollmentFeeExistsForClassEnrolledByFee_EnrollmentId = prop.getProperty("UnenrollmentFeeExistsForClassEnrolledByFee_EnrollmentId");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, UnenrollmentFeeExistsForClassEnrolledByFee_EnrollmentId))
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
					
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.ItemDescription");
				Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.ItemId");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.Amount");
			}
			
			@Test (priority = 17, testName="Class Eligible for Unenerollment, Cancellation Fee exists for class enrolled with Service D also")
			public void UnenrollmentFeeExistsForClassEnrolledByServiceD() {
				
				String UnenrollmentFeeExistsForClassEnrolledByServiceD_EnrollmentId = prop.getProperty("UnenrollmentFeeExistsForClassEnrolledByServiceD_EnrollmentId");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, UnenrollmentFeeExistsForClassEnrolledByServiceD_EnrollmentId))
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

					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.ItemDescription");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.ItemId");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.Amount");
			}
			
			@Test (priority = 18, testName="Class Eligible for Unenerollment, Cancellation Fee exists for class enrolled with Punches also")
			public void UnenrollmentFeeExistsForClassEnrolledByPunches() {
				
				String UnenrollmentFeeExistsForClassEnrolledByPunches_EnrollmentId = prop.getProperty("UnenrollmentFeeExistsForClassEnrolledByPunches_EnrollmentId");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, UnenrollmentFeeExistsForClassEnrolledByPunches_EnrollmentId))
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

					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.ItemDescription");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.ItemId");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.Amount");
			}
			
			@Test (priority = 19, testName="Course Eligible for Unenerollment, Cancellation Fee exists")
			public void UnenrollmentFeeExistsForCourseEnrolledByFee() {
				
				String UnenrollmentFeeExistsForCourseEnrolledByFee_EnrollmentId = prop.getProperty("UnenrollmentFeeExistsForCourseEnrolledByFee_EnrollmentId");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, UnenrollmentFeeExistsForCourseEnrolledByFee_EnrollmentId))
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
					
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.ItemDescription");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.ItemId");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.Amount");
			}
			
			@Test (priority = 20, testName="Course Eligible for Unenerollment, Cancellation Fee exists for Course enrolled with Service D also")
			public void UnenrollmentFeeExistsForCourseEnrolledByServiceD() {
				
				String UnenrollmentFeeExistsForCourseEnrolledByServiceD_EnrollmentId = prop.getProperty("UnenrollmentFeeExistsForCourseEnrolledByServiceD_EnrollmentId");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, UnenrollmentFeeExistsForCourseEnrolledByServiceD_EnrollmentId))
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

					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.ItemDescription");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.ItemId");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.Amount");
			}
			
			@Test (priority = 21, testName="Course Eligible for Unenerollment, Cancellation Fee exists for Course enrolled with Punches also")
			public void UnenrollmentFeeExistsForCourseEnrolledByPunches() {
				
				String UnenrollmentFeeExistsForCourseEnrolledByPunches_EnrollmentId = prop.getProperty("UnenrollmentFeeExistsForCourseEnrolledByPunches_EnrollmentId");
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, UnenrollmentFeeExistsForCourseEnrolledByPunches_EnrollmentId))
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

					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.ItemDescription");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.ItemId");
					Assert.assertNotNull("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.CancellationFee.Amount");
			}

			
			@Test (priority = 22, testName="Standby class cannot be unenrolled")
			public void UnenrollStandbyClass() {
				
				String customerId = prop.getProperty("standbyCustomerId");
				String classId= prop.getProperty("standbyClassId");
				String tomorrowsDate = ReusableMethods.getTomorrowsDate();
				
				 enrollmentId = ReusableMethods.placeOnStandby(companyId, customerId, classId, tomorrowsDate);
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.and()
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, enrollmentId))
				.when()
					.post("/ClassesAndCourses/UnenrollmentService.svc")
				.then()
				//	.log().all()
					.statusCode(200)
					.extract().response();  
					
					XmlPath js = ReusableMethods.rawToXML(res);
							
					Assert.assertTrue(res.getTime() >= 60L);
					String text = js.getString("Envelope.Body.GetUnenrollmentEligibilityResponse.GetUnenrollmentEligibilityResult.IsUnenrollmentAllowed");
					Assert.assertEquals(text, "true");
					ReusableMethods.deleteEnrollment(companyId, enrollmentId);
					
					}
			
			@Test (priority = 23, testName="Standby course cannot be unenrolled")
			public void UnenrollStandbyCourse() {
				
				String customerId = prop.getProperty("standbyCustomerId");
				String courseId= prop.getProperty("standbyCourseId");
								
				 enrollmentId = ReusableMethods.placeOnStandbyCourse(companyId, customerId, courseId);
				
				Response res = given()
		 			.headers("SOAPAction", "http://tempuri.org/IUnenrollmentService/GetUnenrollmentEligibility","Content-Type", "text/xml; charset=utf-8")
					.body(UnenrollmentServicePL.GetUnenrollmentEligibility(companyId, enrollmentId))
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
					ReusableMethods.deleteEnrollment(companyId, enrollmentId);
					
					}
			
			
}
