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

public class GetPackageDetailsTest extends base {
	
	@BeforeTest
	public void getData() throws IOException {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}
	
	@Test (testName="Service Found - Restrict=True")
	public void serviceFoundRestrictTrue(){

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(223, 36, 1, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.AssociatedSessionDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.CategoryDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.LongDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDto", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs", not(empty()));    
	}
	@Test (testName="Service Not Found - Inactive - Restrict=True")
	public void serviceNotFoundInactiveRestrictTrue(){

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(223, 217, 1, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(500);
	        }
	@Test (testName="Service Not Found - Not Allowed Online - Restrict=True")
	public void serviceNotFoundNotAllowedOnlineRestrictTrue(){

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(223, 13, 1, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(500);
	        }
	@Test (testName="Service Found - Restrict=False")
	public void serviceFoundRestrictFalse(){

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(223, 36, 1, false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.AssociatedSessionDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.CategoryDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.LongDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDto", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs", not(empty()));    
	}
	@Test (testName="Service Not Found - Inactive - Restrict=False")
	public void serviceNotFoundInactiveRestrictFalse(){

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(223, 217, 1, false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.AssociatedSessionDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.CategoryDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.LongDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDto", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs", not(empty()));    
	
	        }
	@Test (testName="Service Not Found - Not Allowed Online - Restrict=False")
	public void serviceNotFoundNotAllowedOnlineRestrictFalse(){

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(223, 13, 1, false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.AssociatedSessionDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.CategoryDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.LongDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDto", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs", not(empty()));    
	        }
	
	@Test (testName="Training Found - Restrict=True")
	public void trainingFoundRestrictTrue(){

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(223, 23, 1, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.AssociatedSessionDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.CategoryDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.LongDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDto", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs", not(empty()));    
	}
	@Test (testName="Training Not Found - Inactive - Restrict=True")
	public void trainingNotFoundInactiveRestrictTrue(){

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(223, 218, 1, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(500);
	        }
	@Test (testName="Training Not Found - Not Allowed Online - Restrict=True")
	public void trainingNotFoundNotAllowedOnlineRestrictTrue(){

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(223, 75, 1, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(500);
	        }
	@Test (testName="Training Found - Restrict=False")
	public void trainingFoundRestrictFalse(){

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(223, 23, 1, false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.AssociatedSessionDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.CategoryDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.LongDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDto", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs", not(empty()));    
	}
	@Test (testName="Training Not Found - Inactive - Restrict=False")
	public void trainingNotFoundInactiveRestrictFalse(){

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(223,218,1,false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.AssociatedSessionDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.CategoryDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.LongDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDto", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs", not(empty()));    
	
	        }
	@Test (testName="Training Not Found - Not Allowed Online - Restrict=False")
	public void trainingNotFoundNotAllowedOnlineRestrictFalse(){

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(223, 75, 1, false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.AssociatedSessionDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.CategoryDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.LongDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDto", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs", not(empty()));    
	        }
}
