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

public class GetAvailableClasses extends base{

	
	static String companyId;

	@BeforeTest
	public void getData()
	{
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		companyId = prop.getProperty("X-CompanyId");
	}
	

@Test(priority = 1, testName="available Classes")
public void GetAvailableClassesforMember() {
	String customerId = prop.getProperty("MemberId");	
	String startDateTime = "2021-01-18T00:00:00";
	String endDateTime = "2021-02-18T00:00:00";
	String clubId = prop.getProperty("X-Club1Id");

	Response res =	 given()

		  	.headers("SOAPAction", "http://tempuri.org/IClassCourseServices/GetAvailableClasses","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(ClassCourseServicesPL.GetAvailableClasses(companyId, customerId, clubId, startDateTime, endDateTime))
		  	.when()
		  	.post("/ClassesAndCourses/ClassCourseServices.svc")
		  	.then()
		//  .log().all()
		   .statusCode(200)
		  // .time(lessThan(60L),TimeUnit.SECONDS)
		   	.extract().response();
			XmlPath js = ReusableMethods.rawToXML(res);
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.AllowEnrollment"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.AllowServiceDueEnrollment"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.CancellationFee"));			
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.CategoryDescription"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.ChargeCancellationFee"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.ClassCapacity"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.ClubName"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.ClubNumber"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.DurationInMinutes"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.EnrollmentCount"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.EnrollmentPaymentType"));
			
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.InstructorBarcodeId"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.InstructorName"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.ItemBarcodeId"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.ItemDescription"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.ItemId"));
			
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.MemberEnrollmentStatus"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.PackageEnrollmentAvailable"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.Price"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.StartDateTime.DateTime"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.StartDateTime.OffsetMinutes"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.SubstituteInstructorBarcodeId"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailableClassesResponse.GetAvailableClassesResult.AvailableClassDto.SubstituteInstructorName"));
			
			
}
}
