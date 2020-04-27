package changeRequests;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.lessThan;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.ChangeRequestsPL;
import resources.ReusableMethods;
import resources.base;

public class Draft_UpdateStoredBankAccount extends base {
	
	String companyId;
	String customerId;
	String clubId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Update Billing Name")
	public void updateBillingName(){
		
		/* !!! validate change is pending with GetPersonalInfo call > pendingchange = true;
		 * maybe make reusableMethod and pass value of change field
		 * 
		 */
		
		String customerId = prop.getProperty("passwordChangeId");

//	      Response res =  
	    		  given()
	        .log().all()
	                .headers("SOAPAction:", "http://tempuri.org/IChangeRequests/UpdateStoredBankAccount",
	                		"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                //.body(ChangeRequestsPL.updateStoredBankAccount(companyId, customerId))
	                .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.ChangeRequest\" xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.ChangeRequest\">\r\n" + 
	                		"   <soapenv:Header>\r\n" + 
	                		"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId>\r\n" + 
	                		"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
	                		"   </soapenv:Header>\r\n" + 
	                		"   <soapenv:Body>\r\n" + 
	                		"      <tem:UpdateStoredBankAccount>\r\n" + 
	                		"         <!--Optional:-->\r\n" + 
	                		"         <tem:request>\r\n" + 
	                		"            <jfi:ChangeRequest>\r\n" + 
	                		"               <jfi:ChangeDetails>\r\n" + 
	                		"                  <!--Zero or more repetitions:-->\r\n" + 
	                		"                  <jfi:ChangeRequestSubmissionDetailDto>\r\n" + 
	                		"                     <jfi:FieldName>BillingName</jfi:FieldName>\r\n" + 
	                		"                     <jfi:NewValue>Tommy Smith</jfi:NewValue>\r\n" + 
	                		"                  </jfi:ChangeRequestSubmissionDetailDto>\r\n" + 
	                		"               </jfi:ChangeDetails>\r\n" + 
	                		"               <jfi:CustomerId>233</jfi:CustomerId>\r\n" + 
	                		"               <jfi:Signature>null</jfi:Signature>\r\n" + 
	                		"               <jfi:SubmissionReason>Change Request</jfi:SubmissionReason>\r\n" + 
	                		"                <!--Optional:-->\r\n" + 
	                		"               <jfi:SubmissionReasonDetail>Test Reason Detail</jfi:SubmissionReasonDetail>\r\n" + 
	                		"               </jfi:ChangeRequest>\r\n" + 
	                		"            <jfi1:AccountId>1</jfi1:AccountId>\r\n" + 
	                		"            <jfi1:SetAsHouseAccount>true</jfi1:SetAsHouseAccount>\r\n" + 
	                		"         </tem:request>\r\n" + 
	                		"      </tem:UpdateStoredBankAccount>\r\n" + 
	                		"   </soapenv:Body>\r\n" + 
	                		"</soapenv:Envelope>")
	         .when()
	         		.post("/ChangeRequests/ChangeRequest.svc")
	         .then()
             	.log().all();
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