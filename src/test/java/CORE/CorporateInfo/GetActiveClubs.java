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

public class GetActiveClubs extends base {
	
	String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Get Active Clubs")
	public void getActiveClubs() {
		
			String c1 = prop.getProperty("club1Id");
		int club1Id = Integer.parseInt(c1);
		String club1Name = prop.getProperty("club1Name");
			String c2 = prop.getProperty("club2Id");
		int club2Id = Integer.parseInt(c2);
		String club2Name = prop.getProperty("club2Name");
			String c3 = prop.getProperty("club3Id");
		int club3Id = Integer.parseInt(c3);
		String club3Name = prop.getProperty("club3Name");
			String c4 = prop.getProperty("club4Id");
		int club4Id = Integer.parseInt(c4);
		String club4Name = prop.getProperty("club4Name");
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetActiveClubs","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.GetActiveClubs(companyId))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertEquals(js.getInt("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto[0].Id"), club1Id);
			Assert.assertEquals(js.getString("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto[0].Name"), club1Name);
			Assert.assertEquals(js.getInt("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto[1].Id"), club2Id);
			Assert.assertEquals(js.getString("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto[1].Name"), club2Name);
			Assert.assertEquals(js.getInt("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto[2].Id"), club3Id);
			Assert.assertEquals(js.getString("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto[2].Name"), club3Name);
			Assert.assertEquals(js.getInt("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto[3].Id"), club4Id);
			Assert.assertEquals(js.getString("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto[3].Name"), club4Name);
}			
	}


