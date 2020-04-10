package CORE.CorporateInfo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.CorporateInfoPL;
import resources.base;

public class GetGoogleAnalyticsId extends base {
	
	String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		
	}
	
	@Test (testName="Get Google Analytics Id - JOL")
	public void getGoogleAnalyticsId() {
		
		String appFilter = "JOL";
		
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetGoogleAnalyticsId","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.GetGoogleAnalyticsId(companyId, appFilter))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
			.statusCode(200);
	
	}
	
}


