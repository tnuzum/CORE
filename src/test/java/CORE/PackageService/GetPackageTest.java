package CORE.PackageService;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.PackageServicePL;
import resources.base;

public class GetPackageTest extends base {
	
	String customerId;
	String clubId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		customerId = prop.getProperty("availableId");
		clubId = prop.getProperty("club1Id");
	}
	
	@Test (testName="Training Package Found")
	public void trainingPackageFound(){
		
		String packageId = prop.getProperty("paidTId");

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackage","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackage(customerId, packageId, clubId))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
             	.log().all()
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
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.StartRange", not(empty()));    
	}
	
	@Test (testName="Service Package Found")
	public void servicePackageFound(){
		
		String packageId = prop.getProperty("paidServiceVId");

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackage","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackage(customerId, packageId, clubId))
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
				.body("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto.StartRange", not(empty()));    
	}
}
