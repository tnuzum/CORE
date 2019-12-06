package CORE;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import resources.base;
import resources.payload;

public class _example_using_xml_request_file extends base {
	
	static String projectPath = System.getenv("CORE_HOME");
	
	@BeforeTest
	public void getData() throws IOException {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}
	
	@Test (testName="Package Found")
	public void packageFound() throws Exception {
			
//	        FileInputStream fileInputStream = new FileInputStream(new File(projectPath+"\\src\\main\\java\\requestFiles\\PackageService_GetPackageDetails.xml"));

	        given()
	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
//	                .body(IOUtils.toString(fileInputStream,"UTF-8"))
	                .body(payload.RestrictFalseServiceFound())
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
  //           	.log().all()
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
