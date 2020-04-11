package CORE.CorporateInfo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.CorporateInfoPL;
import resources.base;

public class CompanyHasModuleGrant extends base {
	
	String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Company Has Module Grant")
	public void companyHasModuleGrant() {
		
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/CompanyHasModuleGrant","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.companyHasModuleGrant(companyId))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
			.statusCode(200);	
	}
	
}


