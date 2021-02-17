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

public class GetPaymentDetails extends base{
	
String companyId;
	
	@BeforeTest
	public void getData(){
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	@Test  (priority = 1, testName="Paymentdetails")
	public void Paymentdetails() {
		String paymentID = prop.getProperty("paymentID");
		Response res =  given()
	    		.headers("SOAPAction", "http://tempuri.org/IAccountHistoryService/GetPaymentDetails","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(AccountHistoryPL.GetPaymentDetails(companyId, paymentID))
	         .when()
	            .post("/AccountHistory/AccountHistory.svc")
	         .then()
            //	.log().all()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       	
	       		
	       		Assert.assertTrue(res.getTime() >= 60L);
		
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.Amount"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.AppliedPayments.AppliedPaymentDto.AppliedAmount"));		       		
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.AppliedPayments.AppliedPaymentDto.AppliedDate.DateTime"));	    		
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.AppliedPayments.AppliedPaymentDto.AppliedDate.OffsetMinutes"));	       		
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.AppliedPayments.AppliedPaymentDto.AppliedPaymentId"));
	       		
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.AppliedPayments.AppliedPaymentDto.AssociatedInvoice.Charges.InvoiceChargeDto"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.AppliedPayments.AppliedPaymentDto.AssociatedInvoice.Charges.InvoiceChargeDto.Amount"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.AppliedPayments.AppliedPaymentDto.AssociatedInvoice.Charges.InvoiceChargeDto.BilledCustomer.DisplayName"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.AppliedPayments.AppliedPaymentDto.AssociatedInvoice.Charges.InvoiceChargeDto.DueDate.DateTime"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.AppliedPayments.AppliedPaymentDto.AssociatedInvoice.Charges.InvoiceChargeDto.DueDate.OffsetMinutes"));	       		
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.AppliedPayments.AppliedPaymentDto.AssociatedInvoice.Charges.InvoiceChargeDto.InvoiceChargeId"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.AppliedPayments.AppliedPaymentDto.AssociatedInvoice.Charges.InvoiceChargeDto.PaidAmount"));
	       		
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.DiscountTotal"));		       		
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.InvoiceId"));
	       		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.InvoiceTotal"));
	       		
	     		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.LineItems.InvoiceDetailDto.Amount"));
	     		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.LineItems.InvoiceDetailDto.Description"));
	     		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.LineItems.InvoiceDetailDto.Discount"));
	     		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.LineItems.InvoiceDetailDto.InvoiceDetailId"));
	     		Assert.assertNotNull(js.getString("Envelope.Body.GetPaymentDetailsResponse.GetPaymentDetailsResult.LineItems.InvoiceDetailDto.Quantity"));
	        	       		
	}
	
	@Test  (priority = 2, testName="InvalidpaymentID")
	public void InvalidpaymentID() {
		Response res =  given()
	    		.headers("SOAPAction", "http://tempuri.org/IAccountHistoryService/GetPaymentDetails","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(AccountHistoryPL.GetPaymentDetails(companyId, "78034111"))
	         .when()
	            .post("/AccountHistory/AccountHistory.svc")
	         .then()
            //	.log().all()
	            .statusCode(400)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       	
	       		
	       		Assert.assertTrue(res.getTime() >= 60L);
		
	       		Assert.assertEquals(js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message"), "PaymentId: 78034111 is invalid.");
}
}
