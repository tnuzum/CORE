package CORE.PackageService;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.PackageServicePL;
import resources.base;

public class GetPackageDetailsTest extends base {
	
	String customerId;
	String clubId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		customerId = prop.getProperty("availableId");
		clubId = prop.getProperty("club1Id");
	}
	
	@Test (testName="Service Found - Restrict=True")
	public void serviceFoundRestrictTrue(){
		
//		String packageId = prop.getProperty("paidServiceVId");
		String packageId = prop.getProperty("inactiveServiceId");

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(customerId, packageId, clubId, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
             	.log().all()
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
		
			String packageId = prop.getProperty("inactiveServiceId");

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(customerId, packageId, clubId, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(500);
	        }
	
	@Test (testName="Service Not Found - Not Allowed Online - Restrict=True")
	public void serviceNotFoundNotAllowedOnlineRestrictTrue(){
		
			String packageId = prop.getProperty("noWebServiceId");

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(customerId, packageId, clubId, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(500);
	        }
	
	@Test (testName="Service Found - Restrict=False")
	public void serviceFoundRestrictFalse(){
		
			String packageId = prop.getProperty("paidServiceVId");

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(customerId, packageId, clubId, false))
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
		
			String packageId = prop.getProperty("inactiveServiceId");

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(customerId, packageId, clubId, false))
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
		
			String packageId = prop.getProperty("noWebServiceId");

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(customerId, packageId, clubId, false))
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
		
			String packageId = prop.getProperty("paidTId");

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(customerId, packageId, clubId, true))
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
		
			String packageId = prop.getProperty("inactiveTrainingId");

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(customerId, packageId, clubId, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(500);
	        }
	
	@Test (testName="Training Not Found - Not Allowed Online - Restrict=True")
	public void trainingNotFoundNotAllowedOnlineRestrictTrue(){
		
			String packageId = prop.getProperty("noOnlineTId");

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(customerId, packageId, clubId, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
             	.log().all()
	            .statusCode(500);
	        }
	
	@Test (testName="Training Found - Restrict=False")
	public void trainingFoundRestrictFalse(){
		
			String packageId = prop.getProperty("paidTId");

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(customerId, packageId, clubId, false))
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
		
			String packageId = prop.getProperty("freeClId");

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(customerId,packageId,clubId,false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
             	.log().all()
             	.assertThat()
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
		
			String packageId = prop.getProperty("noOnlineTId");

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(customerId, packageId, clubId, false))
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
