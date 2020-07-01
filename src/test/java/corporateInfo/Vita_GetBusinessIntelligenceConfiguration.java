package corporateInfo;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CorporateInfoPL;
import resources.ReusableMethods;
import resources.base;

public class Vita_GetBusinessIntelligenceConfiguration extends base {
	
			static String companyId;
			static String clubId;
			static String clubName;
			static String isSelected;
			static String bICompanyId;
			static String timeFrame;
			static String timeFrameUnits;
			static String isActivated;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		clubId = prop.getProperty("X-Club1Id");
		clubName = prop.getProperty("club1Name");
		isSelected = "true";
		bICompanyId = prop.getProperty("X-CompanyId");
		timeFrame = "1";
		timeFrameUnits = "1";
		isActivated = "true";

	}
	
	@Test (testName="Get Business Intelligence Configuration", description = "PBI: 164977")
	public void getBusinessIntelligenceConfiguration() {
				
		Response res = 
		
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.GetBusinessIntelligenceConfiguration(companyId))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
			.time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.extract().response();	
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertNotNull(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].ClubId"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].ClubName"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].IsSelected"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.DataStorageTimeframe"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.DataStorageTimeframeUnits"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.IsActivated"));
		}	
}


