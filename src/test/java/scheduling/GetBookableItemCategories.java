package scheduling;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.ClassCourseServicesPL;
import payloads.SchedulingPL;
import resources.ReusableMethods;
import resources.base;

public class GetBookableItemCategories extends base {
	static String companyId;
	@BeforeTest
	public void getData()
	{
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		companyId= prop.getProperty("X-CompanyId");
	}
	
	@Test(priority = 1, testName="Bookable ItemCategories")
	public void GetBookableItemCategoriesformember()
	{
		String customerId = prop.getProperty("MemberId");
		String clubId = prop.getProperty("X-Club1Id");
		Response res =	 given()
			 	.headers("SOAPAction", "http://tempuri.org/IScheduling/GetBookableItemCategories","Content-Type", "text/xml; charset=utf-8")
			  	.and()
			  	.body(SchedulingPL.GetBookableItemCategories(companyId, customerId, clubId))
			  	.when()
			  	.post("/Visits/Scheduling.svc")
			  	.then()
			 .log().all()
			   .statusCode(200)
			  // .time(lessThan(60L),TimeUnit.SECONDS)
			   	.extract().response();
				XmlPath js = ReusableMethods.rawToXML(res);
				Assert.assertTrue(res.getTime() >= 60L);
				
				Assert.assertNotNull(js.get("Envelope.Body.GetBookableItemCategoriesResponse.GetBookableItemCategoriesResult.ItemCategoryDto.Description"));
				Assert.assertNotNull(js.get("Envelope.Body.GetBookableItemCategoriesResponse.GetBookableItemCategoriesResult.ItemCategoryDto.Id"));
	}

}
