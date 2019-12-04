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

public class PackageService_GetPackageDetails extends base {
	
	static String projectPath = System.getenv("CORE_HOME");
	
	@BeforeTest
	public void getData() throws IOException {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}
	
	@Test (testName="Package Found")
	public void packageFound() throws Exception {
			
	        FileInputStream fileInputStream = new FileInputStream(new File(projectPath+"\\src\\main\\java\\requestFiles\\PackageService_GetPackageDetails.xml"));

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(IOUtils.toString(fileInputStream,"UTF-8"))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
 //            	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.AssociatedSessionDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice", equalTo("15.00"))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.CategoryDescription", equalTo("Tennis Lessons"))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration", equalTo("0"))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId", equalTo("TennisBM"))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription", equalTo("Ball Machine"))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId", equalTo("36"))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.LongDescription", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDto", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange", not(empty()))
				.body("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs", not(empty()))
//				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.AddressLine1", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.AddressLine2", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.City", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.Country", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.PostalCode", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Address.StateProvince", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.DateOfBirth", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.DriversLicenseNumber", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmailAddress", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmailContactConsent", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactName", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactPhoneNumber", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactPhoneNumber.Extension", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactPhoneNumber.Number", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.EmergencyContactPhoneNumber.PhoneType", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HeadOfHousehold", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomeClubNumber", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomePhoneContactConsent", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomePhoneNumber.Extension", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomePhoneNumber.Number", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.HomePhoneNumber.PhoneType", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Interests", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MemberExpireDate", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MemberID", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MobilePhoneContactConsent", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MobilePhoneNumber.Extension", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MobilePhoneNumber.Number", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.MobilePhoneNumber.PhoneType", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.DisplayName", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.FirstName", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.LastName", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.MiddleInitial", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.PreferredName", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneNumber.Extension", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneNumber.Number", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneNumber.PhoneType", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneType", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.RestrictMemberFromSearch", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.ValidBarcode", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneContactConsent", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneNumber", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneNumber.Extension", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneNumber.Number", not(empty()))
//			    .body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.WorkPhoneNumber.PhoneType", not(empty()))
			    ;    
	}

}
