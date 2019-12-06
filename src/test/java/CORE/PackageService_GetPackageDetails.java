package CORE;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import resources.base;
import resources.Payload_PackageService_GetPackageDetails;

public class PackageService_GetPackageDetails extends base {
	
	static String projectPath = System.getenv("CORE_HOME");
	
	@BeforeTest
	public void getData() throws IOException {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}
	
	@Test (testName="Service Found - Restrict=True")
	public void serviceFoundRestrictTrue() throws Exception {

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(Payload_PackageService_GetPackageDetails.RestrictTrueServiceFound())
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
	public void serviceNotFoundInactiveRestrictTrue() throws Exception {

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(Payload_PackageService_GetPackageDetails.RestrictTrueInactiveService())
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(500);
	        }
	@Test (testName="Service Not Found - Not Allowed Online - Restrict=True")
	public void serviceNotFoundNotAllowedOnlineRestrictTrue() throws Exception {

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(Payload_PackageService_GetPackageDetails.RestrictTrueServiceNotAllowedOnline())
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(500);
	        }
	@Test (testName="Service Found - Restrict=False")
	public void serviceFoundRestrictFalse() throws Exception {

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(Payload_PackageService_GetPackageDetails.RestrictFalseServiceFound())
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
	public void serviceNotFoundInactiveRestrictFalse() throws Exception {

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(Payload_PackageService_GetPackageDetails.RestrictFalseInactiveService())
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
	public void serviceNotFoundNotAllowedOnlineRestrictFalse() throws Exception {

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(Payload_PackageService_GetPackageDetails.RestrictFalseServiceNotAllowedOnline())
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
	public void trainingFoundRestrictTrue() throws Exception {

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(Payload_PackageService_GetPackageDetails.RestrictTrueTrainingFound())
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
	public void trainingNotFoundInactiveRestrictTrue() throws Exception {

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(Payload_PackageService_GetPackageDetails.RestrictTrueInactiveTraining())
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(500);
	        }
	@Test (testName="Training Not Found - Not Allowed Online - Restrict=True")
	public void trainingNotFoundNotAllowedOnlineRestrictTrue() throws Exception {

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(Payload_PackageService_GetPackageDetails.RestrictTrueTrainingNotAllowedOnline())
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(500);
	        }
	@Test (testName="Training Found - Restrict=False")
	public void trainingFoundRestrictFalse() throws Exception {

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(Payload_PackageService_GetPackageDetails.RestrictFalseTrainingFound())
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
	public void trainingNotFoundInactiveRestrictFalse() throws Exception {

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(Payload_PackageService_GetPackageDetails.RestrictFalseInactiveTraining())
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
	public void trainingNotFoundNotAllowedOnlineRestrictFalse() throws Exception {

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(Payload_PackageService_GetPackageDetails.RestrictFalseTrainingNotAllowedOnline())
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
