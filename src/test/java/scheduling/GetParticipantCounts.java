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

public class GetParticipantCounts extends base{
	static String companyId;
	@BeforeTest
	public void getData()
	{
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		companyId= prop.getProperty("X-CompanyId");
	}
	@Test(priority = 1, testName=" Partcipant Count")
	public void ParticipantcountsforProduct()
	{
		String productId = prop.getProperty("ProductId1");
		
		Response res =	 given()
			 	.headers("SOAPAction", "http://tempuri.org/IScheduling/GetParticipantCounts","Content-Type", "text/xml; charset=utf-8")
			  	.and()
			  	.body(SchedulingPL.GetParticipantCounts(companyId,productId ))
			  	.when()
			  	.post("/Visits/Scheduling.svc")
			  	.then()
			 .log().all()
			   .statusCode(200)
			  // .time(lessThan(60L),TimeUnit.SECONDS)
			   	.extract().response();
				XmlPath js = ReusableMethods.rawToXML(res);
				Assert.assertTrue(res.getTime() >= 60L);
				
				
				Assert.assertNotNull(js.get("Envelope.Body.GetParticipantCountsResponse.GetParticipantCountsResult.GetProductParticipantCountsResponse.MaxParticipantCount"));
				Assert.assertNotNull(js.get("Envelope.Body.GetParticipantCountsResponse.GetParticipantCountsResult.GetProductParticipantCountsResponse.MinParticipantCount"));
	}

}
