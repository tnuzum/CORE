package corporateInfo;

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

public class GetInterestConfiguration extends base {
	
	String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");

	}
	
	@Test (testName="Get Interest Configuration")
	public void getInterestConfiguration() {
		
		Response res = given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetInterestConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.GetInterestConfiguration(companyId))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertEquals(js.getString("Envelope.Body.GetInterestConfigurationResponse.GetInterestConfigurationResult.string[0]"), "Build Muscle/Strength");
			Assert.assertEquals(js.getString("Envelope.Body.GetInterestConfigurationResponse.GetInterestConfigurationResult.string[1]"), "Group Fitness");
			Assert.assertEquals(js.getString("Envelope.Body.GetInterestConfigurationResponse.GetInterestConfigurationResult.string[2]"), "Maintain Health");
			Assert.assertEquals(js.getString("Envelope.Body.GetInterestConfigurationResponse.GetInterestConfigurationResult.string[3]"), "Sports Performance");
			Assert.assertEquals(js.getString("Envelope.Body.GetInterestConfigurationResponse.GetInterestConfigurationResult.string[4]"), "Weight Loss");
	}	
}


