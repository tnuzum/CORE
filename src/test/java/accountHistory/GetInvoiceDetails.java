package accountHistory;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.AccountHistoryPL;

import resources.ReusableMethods;
import resources.base;

public class GetInvoiceDetails extends base{
	
String companyId;
	
	@BeforeTest
	public void getData(){
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	@Test  (priority = 1, testName="Invoicedetails")
	public void Invoicedetails() {
	String invoiceID = prop.getProperty("invoiceID");
		  Response res =  given()
		    		.headers("SOAPAction", "http://tempuri.org/IAccountHistoryService/GetInvoiceDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(AccountHistoryPL.GetInvoiceDetails(companyId, invoiceID))
		         .when()
		            .post("/AccountHistory/AccountHistory.svc")
		         .then()
	            //	.log().all()
		            .statusCode(200)
		            .extract().response();
		       
		       		XmlPath js = ReusableMethods.rawToXML(res);
		       	
		       		
		       		Assert.assertTrue(res.getTime() >= 60L);
		       		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.Charges.InvoiceChargeDto"));
		       		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.Charges.InvoiceChargeDto.Amount"));		       		
		       		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.Charges.InvoiceChargeDto.BilledCustomer.DisplayName"));
		       		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.Charges.InvoiceChargeDto.BilledCustomer.Id"));
		       		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.Charges.InvoiceChargeDto.DueDate.DateTime"));
		       		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.Charges.InvoiceChargeDto.DueDate.OffsetMinutes"));
		       		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.Charges.InvoiceChargeDto.InvoiceChargeId"));
		       		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.Charges.InvoiceChargeDto.InvoiceChargeId"));
		       		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.Charges.InvoiceChargeDto.PaidAmount"));
		       		
		       		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.DiscountTotal"));		       		
		       		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.InvoiceId"));
		       		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.InvoiceTotal"));
		       		
		     		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.LineItems.InvoiceDetailDto.Amount"));
		     		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.LineItems.InvoiceDetailDto.Description"));
		     		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.LineItems.InvoiceDetailDto.Discount"));
		     		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.LineItems.InvoiceDetailDto.InvoiceDetailId"));
		     		Assert.assertNotNull(js.getString("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.LineItems.InvoiceDetailDto.Quantity"));
		    		int count =js.getInt("Envelope.Body.GetInvoiceDetailsResponse.GetInvoiceDetailsResult.Charges.InvoiceChargeDto.size()");
		     		System.out.println(count);
		     		Assert.assertEquals(count, 2);
	}
	
	
	@Test  (priority = 2, testName="InvalidID")
	public void InvalidID() {
	
		  Response res =  given()
		    		.headers("SOAPAction", "http://tempuri.org/IAccountHistoryService/GetInvoiceDetails","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(AccountHistoryPL.GetInvoiceDetails(companyId, "1685801"))
		         .when()
		            .post("/AccountHistory/AccountHistory.svc")
		         .then()
	            	//.log().all()
		            .statusCode(400)
		            .extract().response();
		       
		       		XmlPath js = ReusableMethods.rawToXML(res);
		       	
		       		
		       		Assert.assertTrue(res.getTime() >= 60L);
		       		Assert.assertEquals(js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message"), "InvoiceId: 1685801 is invalid.");
		       	
	}
		
		
}
