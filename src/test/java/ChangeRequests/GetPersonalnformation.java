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
import payloads.ChangeRequestsPL;
import resources.ReusableMethods;
import resources.base;

public class GetPersonalnformation extends base {
	
	String companyId;
	String customerId;
	String clubId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
//		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("CompanyId");
	}
	
	@Test (testName="Pending Changes")
	public void pendingChanges(){
		
		String customerId = prop.getProperty("passwordChangeId");

//	      Response res =  
	    		  given()
	        .log().all()
	                .headers("Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
	                		"   <soapenv:Header>\r\n" + 
	                		"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
	                		"   <soapenv:Body>\r\n" + 
	                		"      <tem:GetStoredPaymentAccounts>\r\n" + 
	                		"         <!--Optional:-->\r\n" + 
	                		"         <tem:customerId>233000</tem:customerId>\r\n" + 
	                		"      </tem:GetStoredPaymentAccounts>\r\n" + 
	                		"   </soapenv:Body>\r\n" + 
	                		"</soapenv:Envelope>")
	         .when()
	            .post("http://compete-ws.test-jfisoftware.net:4412/ChangeRequests/ChangeRequest.svc")
	         .then()
             	.log().everything();
//	            .statusCode(200)
//				.time(lessThan(5L),TimeUnit.SECONDS)
//				.extract().response();
//	      
//				XmlPath js = ReusableMethods.rawToXML(res);	
//				
//				Assert.assertNotNull(js.getInt("Envelope.Body.UpdateStoredBankAccountResponse.UpdateStoredBankAccountResult.AutoApprovedConfirmationNumber"));
				
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