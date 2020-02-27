package CORE.PackageService;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.PackageServicePL;
import resources.base;

public class GetAvailablePackagesByClubTest extends base {
	
	String customerId;
	String clubId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		customerId = prop.getProperty("availableId");
		clubId = prop.getProperty("club1Id");
	}
	
	@Test (testName="Packages Found")
	public void packagesFound(){

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetAvailablePackagesByClub","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getAvailablePackagesByClub(customerId, clubId))
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
	
	@Test (testName="Customer Not Found")
	public void customerNotFound(){

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetAvailablePackagesByClub","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getAvailablePackagesByClub("244000", "1"))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
 //            	.log().all()
	            .statusCode(500)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.Fault.detail.ExceptionDetail.Message", equalTo("Customer Not Found"));
	}

}
