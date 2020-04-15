package corporateInfo;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.CorporateInfoPL;
import resources.base;

public class GetBrandingLogo extends base {
	
	String companyId;
	String clubId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		clubId = prop.getProperty("club1Id");
	}
	
	@Test (testName="Get EME Branding Logo")
	public void getEMEBrandingLogo() {
		
		String brandingFilter = "MSS";
		
		given()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetBrandingLogo","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.GetBrandingLogo(companyId, clubId, brandingFilter))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
			.statusCode(200);
	}	
	
	@Test (testName="Get JOL Branding Logo")
	public void getJOLBrandingLogo() {
		
		String brandingFilter = "JOL";
		
		given()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetBrandingLogo","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.GetBrandingLogo(companyId, clubId, brandingFilter))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
			.statusCode(200);
	}
	
	
	
	
	
	
}


