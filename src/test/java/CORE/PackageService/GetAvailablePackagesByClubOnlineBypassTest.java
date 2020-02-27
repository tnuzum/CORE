package CORE.PackageService;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.PackageServicePL;
import resources.base;

public class GetAvailablePackagesByClubOnlineBypassTest extends base {
	
	@BeforeTest
	public void getData() throws IOException {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}
	
	@Test (testName="Packages Found Using Online Bypass", description = "PBI: 144305")
	public void packagesFoundOnlineBypass(){

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetAvailablePackagesByClubOnlineBypass","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getAvailablePackagesByClubOnlineBypass(244, 1, false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body(containsString("AssociatedSessionDtos"))
				.body(containsString("BasePrice"))
				.body(containsString("CategoryDescription"))
				.body(containsString("DaysUntilExpiration"))
				.body(containsString("ItemBarcodeId"))
				.body(containsString("ItemDescription"))
				.body(containsString("ItemId"))
				.body(containsString("LongDescription"))
				.body(containsString("PriceRangeDtos"))
				.body(containsString("PriceRangeDto"))
				.body(containsString("EndRange"))
				.body(containsString("PricePerUnit"))
				.body(containsString("StartRange"))
				.body(containsString("RedeemableClubs"))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.BasePrice", not(empty()))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.DaysUntilExpiration", not(empty()))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.ItemBarcodeId", not(empty()))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.ItemDescription", not(empty()))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.ItemId", not(empty()))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.EndRange", not(empty()))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.PricePerUnit", not(empty()))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.StartRange", not(empty()))
				.body(containsString("train001"))// Course that is available for online purchase
				.body(containsString("offlineT"))// Course that is NOT available for online purchase, and is returned because returnOnlinePackagesOnly=false
				;    
	}
	
	@Test (testName="Packages Found Not Using Online Bypass", description = "PBI: 144305")
	public void packagesFoundNoOnlineBypass(){

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetAvailablePackagesByClubOnlineBypass","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getAvailablePackagesByClubOnlineBypass(244, 1, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body(containsString("AssociatedSessionDtos"))
				.body(containsString("BasePrice"))
				.body(containsString("CategoryDescription"))
				.body(containsString("DaysUntilExpiration"))
				.body(containsString("ItemBarcodeId"))
				.body(containsString("ItemDescription"))
				.body(containsString("ItemId"))
				.body(containsString("LongDescription"))
				.body(containsString("PriceRangeDtos"))
				.body(containsString("PriceRangeDto"))
				.body(containsString("EndRange"))
				.body(containsString("PricePerUnit"))
				.body(containsString("StartRange"))
				.body(containsString("RedeemableClubs"))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.BasePrice", not(empty()))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.DaysUntilExpiration", not(empty()))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.ItemBarcodeId", not(empty()))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.ItemDescription", not(empty()))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.ItemId", not(empty()))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.EndRange", not(empty()))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.PricePerUnit", not(empty()))
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.StartRange", not(empty()))
				.body(containsString("train001"))// Course that is available for online purchase
				.body(not(containsString("offlineT")));// Course that is NOT available for online purchase, and is NOT returned because returnOnlinePackagesOnly=true    
	}

}
