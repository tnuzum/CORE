package ChangeRequests;

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

public class Draft_AddStoredBankAccount extends base {
	
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
		
		/* !!! validate change is pending with GetPersonalInfo call > pendingchange = true;
		 * maybe make reusableMethod and pass value of change field
		 * 
		 */
		
		String packageId = prop.getProperty("paidTId");

	      Response res =  given()
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
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);	
 
//				examples only -- needs updated		
//				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageResponse.GetPackageResult.BasePrice"));
//				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageResponse.GetPackageResult.DaysUntilExpiration"));
//				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageResponse.GetPackageResult.ItemBarcodeId"));
//				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageResponse.GetPackageResult.ItemDescription"));
//				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageResponse.GetPackageResult.ItemId"));
//				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageResponse.GetPackageResult.PriceRangeDtos.PriceRangeDto.EndRange"));
//				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageResponse.GetPackageResult.PriceRangeDtos.PriceRangeDto.PricePerUnit"));
//				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageResponse.GetPackageResult.PriceRangeDtos.PriceRangeDto.StartRange"));
//				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageResponse.GetPackageResult.RedeemableClubs"));
//				
//				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageResponse.GetPackageResult.BasePrice"), 10.00);
//				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageResponse.GetPackageResult.DaysUntilExpiration"), 0);
//				Assert.assertEquals(js.getString("Envelope.Body.GetPackageResponse.GetPackageResult.ItemBarcodeId"), "paidT");
//				Assert.assertEquals(js.getString("Envelope.Body.GetPackageResponse.GetPackageResult.ItemDescription"), "Paid Training");
//				Assert.assertEquals(js.getString("Envelope.Body.GetPackageResponse.GetPackageResult.ItemId"), packageId);
//				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageResponse.GetPackageResult.PriceRangeDtos.PriceRangeDto.EndRange"), 999);
//				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageResponse.GetPackageResult.PriceRangeDtos.PriceRangeDto.PricePerUnit"), 10.00);
//				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageResponse.GetPackageResult.PriceRangeDtos.PriceRangeDto.StartRange"), 1);
//				Assert.assertEquals(js.getString("Envelope.Body.GetPackageResponse.GetPackageResult.RedeemableClubs"), "Jonas Sports-Plex");   
	}
}