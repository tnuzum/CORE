package packageService;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.PackageServicePL;
import resources.ReusableMethods;
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

	       Response res = given()
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
				.extract().response();
			       
	       		XmlPath js = ReusableMethods.rawToXML(res);	
	       		
	       		Assert.assertNotNull(js.getDouble("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto[0].BasePrice"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto[0].CategoryDescription"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto[0].DaysUntilExpiration"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto[0].ItemBarcodeId"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto[0].ItemDescription"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto[0].ItemId"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto[0].RedeemableClubs"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto[0].AssociatedSessionDtos.SessionDto[0].BasePrice"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto[0].AssociatedSessionDtos.SessionDto[0].ClubName"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto[0].AssociatedSessionDtos.SessionDto[0].ItemBarcodeId"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto[0].AssociatedSessionDtos.SessionDto[0].ItemDescription"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto[0].AssociatedSessionDtos.SessionDto[0].SessionType"));

	       		Assert.assertEquals(js.getDouble("Envelope.Body.GetAvailablePackagesByClubResponse.GetAvailablePackagesByClubResult.PackageDto[0].AssociatedSessionDtos.SessionDto[0].BasePrice"), 65.00);   
	}
	
	@Test (testName="Customer Not Found")
	public void customerNotFound(){

	        given()
                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetAvailablePackagesByClub","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(PackageServicePL.getAvailablePackagesByClub("99999", "1"))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//            	.log().all()
	            .statusCode(500)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.Fault.detail.InternalServerErrorFaultDto.Message", equalTo("Customer Not Found"));
	}

}
