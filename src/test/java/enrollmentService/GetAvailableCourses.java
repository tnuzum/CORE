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

public class GetAvailableCourses extends base{
	
	static String companyId;
	
	
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test(priority = 1)
	public void GetAvailableCourses_VerifyVirtualFlag() {
		
		String customerId = prop.getProperty("enrollmentCustomerId1");
				
		  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/GetAvailableCourses","Content-Type","text/xml; charset=utf-8") .and()
		  .body(EnrollmentServicePL.GetAvailableCourses_Virtual(companyId, customerId)) 
		  .when()
		  .post("/ClassesAndCourses/EnrollmentService.svc") 
		  .then() 
//		  .log().all()
		  .statusCode(200) .extract().response();
		  
		  XmlPath js = ReusableMethods.rawToXML(res);
		  	  
		  Assert.assertTrue(res.getTime() >= 60L); 
		 		 
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].BarcodeId"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].Capacity"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].Category.Description"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].Category.Id"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].ClubId"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].Description"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].Duration"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].EnrolledCount"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].EnrollmentEligibilities.EnrollmentEligibilityDto.CanEnrollUsingPunches"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].EnrollmentEligibilities.EnrollmentEligibilityDto.CanEnrollUsingServiceDue"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].EnrollmentEligibilities.EnrollmentEligibilityDto.CustomerDisplayName"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].EnrollmentEligibilities.EnrollmentEligibilityDto.CustomerId"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].EnrollmentEligibilities.EnrollmentEligibilityDto.CustomerPunchCountForPackageItem"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].EnrollmentEligibilities.EnrollmentEligibilityDto.EnrollmentEligibilityStatus"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].EnrollmentEligibilities.EnrollmentEligibilityDto.EnrollmentStatus"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].EnrollmentEligibilities.EnrollmentEligibilityDto.Price"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].Instructor.BarcodeId"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].Instructor.DisplayName"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].Instructor.EmployeeId"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].IsFull"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].IsVirtual"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].ItemEnrollmentEligibility"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].ItemId"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].Name"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].Occurrence.DateTime"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].Occurrence.OffsetMinutes"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].PackagePaymentConfiguration.PackageId"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].PackagePaymentConfiguration.PackageName"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].PackagePaymentConfiguration.PunchesRequired"));
		  Assert.assertNotNull(js.getString("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.CourseDto[0].SubstituteInstructor"));
		
		  
}
	
	
}
