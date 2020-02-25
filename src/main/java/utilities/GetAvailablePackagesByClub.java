package utilities;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.PackageServicePL;
import resources.base;

public class GetAvailablePackagesByClub extends base {
	
	@BeforeTest
	public void getData() throws IOException {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}
	
	@Test (testName="Packages Found")
	public void packagesFound(){

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetAvailablePackagesByClub","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getAvailablePackagesByClub(244, 1))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
             	.log().all();
	         
	}

}
