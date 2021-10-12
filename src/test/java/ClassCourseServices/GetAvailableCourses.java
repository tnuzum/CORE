package ClassCourseServices;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.ClassCourseServicesPL;
import resources.ReusableMethods;
import resources.base;

public class GetAvailableCourses extends base{
	static String companyId;

	@BeforeTest
	public void getData()
	{
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		companyId = prop.getProperty("X-CompanyId");
	}
	

@Test(priority = 1, testName="available Courses")
public void GetAvailableCoursesforMember() {
	String customerId = prop.getProperty("MemberId");	
	String startDateTime = "2021-01-18T00:00:00";
	String endDateTime = "2021-02-18T00:00:00";
	String clubId = prop.getProperty("X-Club1Id");

	Response res =	 given()

		  	.headers("SOAPAction", "http://tempuri.org/IClassCourseServices/GetAvailableCourses","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(ClassCourseServicesPL.GetAvailableCourses(companyId, customerId, clubId, startDateTime, endDateTime))
		  	.when()
		  	.post("/ClassesAndCourses/ClassCourseServices.svc")
		  	.then()
		 //.log().all()
		   .statusCode(200)
		  // .time(lessThan(60L),TimeUnit.SECONDS)
		   	.extract().response();
			XmlPath js = ReusableMethods.rawToXML(res);
			Assert.assertTrue(res.getTime() >= 60L);
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.AllowEnrollment"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.AllowServiceDueEnrollment"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.CancellationFee"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.CategoryDescription"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.ChargeCancellationFee"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.ClassCapacity"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.ClubName"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.ClubNumber"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.DurationInMinutes"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.EnrollmentCount"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.EnrollmentPaymentType"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.InstructorBarcodeId"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.InstructorName"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.ItemBarcodeId"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.ItemDescription"));
			
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.ItemId"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.LongDescription"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.MemberEnrollmentStatus"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.PackageEnrollmentAvailable"));
			
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.PackageName"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.Price"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.PunchesRemaining"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.PunchesRequired"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.RefundableAmount"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.RefundablePunchAmount"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.ServiceVisitId"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.StandbyCount"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.StandbyEnrollmentOnly"));
			
			
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.UnenrollmentOperation"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.EndDate.DateTime"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.EndDate.OffsetMinutes"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.StandbyEnrollmentOnly"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableCoursesResponse.GetAvailableCoursesResult.AvailableCourseDto.StandbyEnrollmentOnly"));
			
			
			
			
			
}
}
