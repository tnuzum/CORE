package packageService;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.PackageServicePL;
import resources.ReusableMethods;
import resources.base;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class GetAvailablePackagesByClubOnlineBypass extends base {
	
	String companyId;
	String customerId;
	String clubId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		customerId = prop.getProperty("availableId");
		clubId = prop.getProperty("club1Id");
	}
	
	@Test (testName="Packages Found Using Online Bypass", description = "PBI: 144305")
	public void packagesFoundOnlineBypass(){

	       Response res = given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetAvailablePackagesByClubOnlineBypass","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getAvailablePackagesByClubOnlineBypass(companyId, customerId, clubId, false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
	            .body(containsString(prop.getProperty("notPackageBarcodeId"))) // Course that is available for online purchase
	            .body(containsString(prop.getProperty("noWebTBarcodeId")))// Course that is NOT available for online purchase, and is returned because returnOnlinePackagesOnly=false
				.extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);	
	       		
	       		Assert.assertTrue(res.getTime() >= 60L);
	       		
	       		Assert.assertNotNull(js.getDouble("Envelope.Body.GetAvailablePackagesByClubOnlineBypassResponse.GetAvailablePackagesByClubOnlineBypassResult.PackageDto[0].BasePrice"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubOnlineBypassResponse.GetAvailablePackagesByClubOnlineBypassResult.PackageDto[0].CategoryDescription"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubOnlineBypassResponse.GetAvailablePackagesByClubOnlineBypassResult.PackageDto[0].DaysUntilExpiration"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubOnlineBypassResponse.GetAvailablePackagesByClubOnlineBypassResult.PackageDto[0].ItemBarcodeId"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubOnlineBypassResponse.GetAvailablePackagesByClubOnlineBypassResult.PackageDto[0].ItemDescription"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubOnlineBypassResponse.GetAvailablePackagesByClubOnlineBypassResult.PackageDto[0].ItemId"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubOnlineBypassResponse.GetAvailablePackagesByClubOnlineBypassResult.PackageDto[0].RedeemableClubs"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubOnlineBypassResponse.GetAvailablePackagesByClubOnlineBypassResult.PackageDto[0].AssociatedSessionDtos.SessionDto[0].BasePrice"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubOnlineBypassResponse.GetAvailablePackagesByClubOnlineBypassResult.PackageDto[0].AssociatedSessionDtos.SessionDto[0].ClubName"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubOnlineBypassResponse.GetAvailablePackagesByClubOnlineBypassResult.PackageDto[0].AssociatedSessionDtos.SessionDto[0].ItemBarcodeId"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubOnlineBypassResponse.GetAvailablePackagesByClubOnlineBypassResult.PackageDto[0].AssociatedSessionDtos.SessionDto[0].ItemDescription"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubOnlineBypassResponse.GetAvailablePackagesByClubOnlineBypassResult.PackageDto[0].AssociatedSessionDtos.SessionDto[0].SessionType"));

//	       		Assert.assertEquals(js.getDouble("Envelope.Body.GetAvailablePackagesByClubOnlineBypassResponse.GetAvailablePackagesByClubOnlineBypassResult.PackageDto[0].AssociatedSessionDtos.SessionDto[0].BasePrice"), 65.00);    
	}
	
	@Test (testName="Packages Found Not Using Online Bypass", description = "PBI: 144305")
	public void packagesFoundNoOnlineBypass(){

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetAvailablePackagesByClubOnlineBypass","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getAvailablePackagesByClubOnlineBypass(companyId, customerId, clubId, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
 //            	.log().all()
	            .statusCode(200)
	            .body(containsString(prop.getProperty("notPackageBarcodeId")))// Course that is available for online purchase
	            .body(not(containsString(prop.getProperty("noWebTBarcodeId")))); // Course that is NOT available for online purchase, and is NOT returned because returnOnlinePackagesOnly=true
	        }

}
