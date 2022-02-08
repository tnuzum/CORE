package scheduling;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.SchedulingPL;
import resources.ReusableMethods;
import resources.base;

public class GetPrimarySelectableResourceType extends base{

	static String companyId;
	@BeforeTest
	public void getData()
	{
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		companyId= prop.getProperty("X-CompanyId");
	}
	@Test(priority = 1, testName=" Partcipant Count")
	public void VerifyGetPrimarySelectableResourceType()
	{
		String productId = prop.getProperty("ProductId1");
		String clubID = prop.getProperty("club1Id");
		
		Response res =	 given()
			 	.headers("SOAPAction", "http://tempuri.org/IScheduling/GetPrimarySelectableResourceType","Content-Type", "text/xml; charset=utf-8")
			  	.and()
			  	.body(SchedulingPL.GetPrimarySelectableResourceType(companyId,clubID,productId ))
			  	.when()
			  	.post("/Visits/Scheduling.svc")
			  	.then()
			 .log().all()
			   .statusCode(200)
			  // .time(lessThan(60L),TimeUnit.SECONDS)
			   	.extract().response();
				XmlPath js = ReusableMethods.rawToXML(res);
				Assert.assertTrue(res.getTime() >= 60L);
				Assert.assertEquals(js.getString("Envelope.Body.GetPrimarySelectableResourceTypeResponse.GetPrimarySelectableResourceTypeResult.ItemHasSelectableResourceTypes"), "true");
				Assert.assertNotNull(js.getString("Envelope.Body.GetPrimarySelectableResourceTypeResponse.GetPrimarySelectableResourceTypeResult.ItemHasSelectableResourceTypes.PrimarySelectableResourceType.Books.BookDto.ID"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPrimarySelectableResourceTypeResponse.GetPrimarySelectableResourceTypeResult.ItemHasSelectableResourceTypes.PrimarySelectableResourceType.Books.BookDto.Name"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPrimarySelectableResourceTypeResponse.GetPrimarySelectableResourceTypeResult.ItemHasSelectableResourceTypes.PrimarySelectableResourceType.ID.Name"));
				
				}
}
