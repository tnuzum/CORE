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

public class GetExternalLinks extends base {
	
	String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");

	}
	
	@Test (testName="Get External Links - Single Link")
	public void getExternalLinksSingleLink() {
		
		String clubId = prop.getProperty("X-Club1Id");
		
		Response res = given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetExternalLinks","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.GetExternalLinks(companyId, clubId))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertEquals(js.getString("Envelope.Body.GetExternalLinksResponse.GetExternalLinksResult.ExternalLinkDto[0].DisplayText"), "Lose it Calorie Tracker");
			Assert.assertEquals(js.getString("Envelope.Body.GetExternalLinksResponse.GetExternalLinksResult.ExternalLinkDto[0].Link"), "https://www.loseit.com/");
	
	}
	
	@Test (testName="Get External Links - Multiple Links")
	public void getExternalLinksMultipleLinks() {
		
		String clubId = prop.getProperty("X-Club4Id");
		
		Response res = given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetExternalLinks","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.GetExternalLinks(companyId, clubId))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			Assert.assertEquals(js.getString("Envelope.Body.GetExternalLinksResponse.GetExternalLinksResult.ExternalLinkDto[0].DisplayText"), "Jonas Fitness Website");
			Assert.assertEquals(js.getString("Envelope.Body.GetExternalLinksResponse.GetExternalLinksResult.ExternalLinkDto[0].Link"), "http://jonasfitness.com/");
			Assert.assertEquals(js.getString("Envelope.Body.GetExternalLinksResponse.GetExternalLinksResult.ExternalLinkDto[1].DisplayText"), "Lose it Calorie Tracker");
			Assert.assertEquals(js.getString("Envelope.Body.GetExternalLinksResponse.GetExternalLinksResult.ExternalLinkDto[1].Link"), "https://www.loseit.com/");
	
	}
	
}


