package CORE.CorporateInfo;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CorporateInfoPL;
import resources.ReusableMethods;
import resources.base;

public class GetActiveClubsTest extends base {
	
	static String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Get Active Clubs")
	public void getActiveClubs() {
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetActiveClubs","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.GetActiveClubs(companyId))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertNotNull(js.getInt("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto[0].Id"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto[0].Name"));
			Assert.assertNotNull(js.getInt("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto[1].Id"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto[1].Name"));
			Assert.assertNotNull(js.getInt("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto[2].Id"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto[2].Name"));
}			
	}


