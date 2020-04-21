package packageService;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.PackageServicePL;
import resources.ReusableMethods;
import resources.base;

public class GetPackageDetails extends base {
	
	String companyId;
	String customerId;
	String clubId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		customerId = prop.getProperty("availableId");
		clubId = prop.getProperty("club1Id");
	}
	
	@Test (testName="Service Found - Restrict=True")
	public void serviceFoundRestrictTrue(){
		
		String packageId = prop.getProperty("paidServiceVId");

	      Response res =  given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(companyId, customerId, packageId, clubId, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);	
				
				Assert.assertTrue(res.getTime() >= 60L);
				
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].EndRange"));
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].PricePerUnit"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].StartRange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs"));
						
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"), 15.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"), 5);
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"), "paidSV");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"), "Paid ServiceV");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"), packageId);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].EndRange"), 5);
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].PricePerUnit"), 15.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].StartRange"), 1);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[1].EndRange"), 10);
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[1].PricePerUnit"), 10.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[1].StartRange"), 6);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[2].EndRange"), 20);
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[2].PricePerUnit"), 8.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[2].StartRange"), 11);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[3].EndRange"), 999);
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[3].PricePerUnit"), 5.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[3].StartRange"), 21);
	}
	
	@Test (testName="Service Not Found - Inactive - Restrict=True")
	public void serviceNotFoundInactiveRestrictTrue(){
		
			String packageId = prop.getProperty("inactiveServiceId");

	        given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(companyId, customerId, packageId, clubId, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200);
	        }
	
	@Test (testName="Service Not Found - Not Allowed Online - Restrict=True")
	public void serviceNotFoundNotAllowedOnlineRestrictTrue(){
		
			String packageId = prop.getProperty("noWebServiceId");

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(companyId, customerId, packageId, clubId, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200);
	        }
	
	@Test (testName="Service Found - Restrict=False")
	public void serviceFoundRestrictFalse(){
		
			String packageId = prop.getProperty("paidServiceVId");

	       Response res = given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(companyId, customerId, packageId, clubId, false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.extract().response();
		      
				XmlPath js = ReusableMethods.rawToXML(res);	
				
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].EndRange"));
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].PricePerUnit"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].StartRange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs"));
						
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"), 15.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"), 5);
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"), "paidSV");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"), "Paid ServiceV");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"), packageId);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].EndRange"), 5);
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].PricePerUnit"), 15.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].StartRange"), 1);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[1].EndRange"), 10);
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[1].PricePerUnit"), 10.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[1].StartRange"), 6);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[2].EndRange"), 20);
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[2].PricePerUnit"), 8.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[2].StartRange"), 11);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[3].EndRange"), 999);
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[3].PricePerUnit"), 5.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[3].StartRange"), 21);
	}
	
	@Test (testName="Service Not Found - Inactive - Restrict=False")
	public void serviceNotFoundInactiveRestrictFalse(){
		
			String packageId = prop.getProperty("inactiveServiceId");

	        Response res = given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(companyId, customerId, packageId, clubId, false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
 //            	.log().all()
	            .statusCode(200)
				.extract().response();
		      
				XmlPath js = ReusableMethods.rawToXML(res);	
				
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].EndRange"));
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].PricePerUnit"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].StartRange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs"));
						
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"), 0.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"), 0);
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"), "inactiveS");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"), "inactiveServiceV");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"), packageId);
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.LongDescription"), "used for testing inactive Service-V ");
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].EndRange"), 999);
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].PricePerUnit"), 0.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto[0].StartRange"), 1); 	
	        }
	
	@Test (testName="Service Not Found - Not Allowed Online - Restrict=False")
	public void serviceNotFoundNotAllowedOnlineRestrictFalse(){
		
			String packageId = prop.getProperty("noWebServiceId");

	       Response res = given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(companyId, customerId, packageId, clubId, false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//            	.log().all()
	            .statusCode(200)
				.extract().response();
		      
				XmlPath js = ReusableMethods.rawToXML(res);	
				
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs"));
						
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"), 10.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"), 0);
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"), "noWebSv");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"), "No Web ServiceV");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"), packageId);  
	        }
	
	@Test (testName="Training Found - Restrict=True")
	public void trainingFoundRestrictTrue(){
		
			String packageId = prop.getProperty("paidTId");

	       Response res = given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(companyId, customerId, packageId, clubId, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.extract().response();
		      
				XmlPath js = ReusableMethods.rawToXML(res);	
				
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange"));
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs"));
						
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"), 10.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"), 0);
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"), "paidT");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"), "Paid Training");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"), packageId);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange"), 999);
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit"), 10.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange"), 1);
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs"), "Jonas Sports-Plex");      
	}
	
	@Test (testName="Training Not Found - Inactive - Restrict=True")
	public void trainingNotFoundInactiveRestrictTrue(){
		
			String packageId = prop.getProperty("inactiveTrainingId");

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(companyId, customerId, packageId, clubId, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200);
	        }
	
	@Test (testName="Training Not Found - Not Allowed Online - Restrict=True")
	public void trainingNotFoundNotAllowedOnlineRestrictTrue(){
		
			String packageId = prop.getProperty("noOnlineTId");

	        given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(companyId, customerId, packageId, clubId, true))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(500);
	        }
	
	@Test (testName="Training Found - Restrict=False")
	public void trainingFoundRestrictFalse(){
		
			String packageId = prop.getProperty("paidTId");

	      Response res =  given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(companyId, customerId, packageId, clubId, false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.extract().response();
		      
				XmlPath js = ReusableMethods.rawToXML(res);	
				
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange"));
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs"));
						
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"), 10.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"), 0);
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"), "paidT");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"), "Paid Training");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"), packageId);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange"), 999);
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit"), 10.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange"), 1);
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs"), "Jonas Sports-Plex");         
	}
	
	@Test (testName="Training Found - Inactive - Restrict=False")
	public void trainingFoundInactiveRestrictFalse(){
		
			String packageId = prop.getProperty("inactiveTrainingId");

	       Response res = given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(companyId, customerId,packageId,clubId,false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//            	.log().all()
             	.assertThat()
	            .statusCode(200)
				.extract().response();
		      
				XmlPath js = ReusableMethods.rawToXML(res);	
				
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange"));
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs"));
						
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"), 0.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"), 0);
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"), "inactiveT");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"), "inactiveTraining");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"), packageId);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange"), 999);
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit"), 0.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange"), 1);
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs"), "Jonas Sports-Plex");  
	        }
	
	@Test (testName="Training Found - Not Allowed Online - Restrict=False")
	public void trainingFoundNotAllowedOnlineRestrictFalse(){
		
			String packageId = prop.getProperty("noWebTId");

	       Response res = given()
	                .headers("SOAPAction", "http://tempuri.org/IPackageService/GetPackageDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(PackageServicePL.getPackageDetails(companyId, customerId, packageId, clubId, false))
	         .when()
	            .post("/Packages/PackageService.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.extract().response();
		      
				XmlPath js = ReusableMethods.rawToXML(res);	
				
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange"));
				Assert.assertNotNull(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs"));
						
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.BasePrice"), 0.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.DaysUntilExpiration"), 0);
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemBarcodeId"), "offlineT");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemDescription"), "Training Not Available Online");
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.ItemId"), packageId);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.EndRange"), 1);
				Assert.assertEquals(js.getDouble("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.PricePerUnit"), 0.00);
				Assert.assertEquals(js.getInt("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.PriceRangeDtos.PriceRangeDto.StartRange"), 1);
				Assert.assertEquals(js.getString("Envelope.Body.GetPackageDetailsResponse.GetPackageDetailsResult.RedeemableClubs"), "Jonas Sports-Plex"); 
	        }
}
