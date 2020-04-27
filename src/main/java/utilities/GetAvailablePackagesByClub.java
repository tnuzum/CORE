package utilities;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.PackageServicePL;
import resources.base;

public class GetAvailablePackagesByClub extends base {
	
	String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Packages Found")
	public void packagesFound(){

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetAvailablePackagesByClub","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getAvailablePackagesByClub(companyId, "244", "1"))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
             	.log().all();
	         
	}

}
