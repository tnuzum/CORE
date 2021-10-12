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

public class GetAvailableClass extends base{

	
	static String companyId;

	@BeforeTest
	public void getData()
	{
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		companyId = prop.getProperty("X-CompanyId");
	}
	

@Test(priority = 1, testName="available Courses")
public void GetAvailableClassforMember() {
	String customerId = prop.getProperty("MemberId");	
	//String startDateTime = "2021-01-18T00:00:00";
	//String endDateTime = "2021-02-18T00:00:00";
	
	String DateTime="2021-01-18T00:00:00.393Z";
	//String clubId = prop.getProperty("X-Club1Id");
	String classBarcodeId = "BARREF5p";

	Response res =	 given()

		  	.headers("SOAPAction", "http://tempuri.org/IClassCourseServices/GetAvailableClass","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(ClassCourseServicesPL.GetAvailableClass(companyId, customerId, classBarcodeId, DateTime))
		  	.when()
		  	.post("/ClassesAndCourses/ClassCourseServices.svc")
		  	.then()
		 .log().all()
		   .statusCode(200)
		  // .time(lessThan(60L),TimeUnit.SECONDS)
		   	.extract().response();
			XmlPath js = ReusableMethods.rawToXML(res);
			Assert.assertTrue(res.getTime() >= 60L);
}
}