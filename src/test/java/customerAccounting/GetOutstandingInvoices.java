package customerAccounting;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import payloads.CustomerAccountingPL;
import resources.ReusableDates;
import resources.ReusableMethods;
import resources.base;

public class GetOutstandingInvoices extends base {
	
	String companyId;
	String asOfDate;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");

	}
	
	@Test (testName="Outstanding Invoices Found", description = "PBI: 153782")
	public void outstandingInvoicesFound() {
		
		asOfDate = ReusableDates.getCurrentDate();
		
		 Response res = given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetOutstandingInvoices","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getOutstandingInvoices(companyId, asOfDate))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(200)
			.extract().response();
  	      
			XmlPath js = ReusableMethods.rawToXML(res);	
       		
       		Assert.assertTrue(res.getTime() >= 60L);
			
       		Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.OutstandingInvoiceDto[0].CustomerId"));
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.OutstandingInvoiceDto[0].InvoiceBalance"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.OutstandingInvoiceDto[0].InvoiceCategory"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.OutstandingInvoiceDto[0].InvoiceCreationDate"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.OutstandingInvoiceDto[0].InvoiceDescription"));
			Assert.assertNotNull(js.getInt("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.OutstandingInvoiceDto[0].InvoiceId"));
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.OutstandingInvoiceDto[0].InvoicePaidAmount"));
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.OutstandingInvoiceDto[0].InvoiceTotal"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.OutstandingInvoiceDto[0].NsfFeeApplied"));
			Assert.assertNotNull(js.getInt("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.OutstandingInvoiceDto[0].ReceiptNumber"));
	
	}
	
	@Test (testName="Outstanding Invoices Not Found", description = "PBI: 153782")
	public void outstandingInvoicesNotFound() {
		
		asOfDate = "1980-01-01";
		
		 given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetOutstandingInvoices","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getOutstandingInvoices(companyId, asOfDate))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(200);
	}
	
	@Test (testName="Invalid Date", description = "PBI: 153782")
	public void invalidDate() {
		
		asOfDate = "1980-13-01";
		
		 given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetOutstandingInvoices","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getOutstandingInvoices(companyId, asOfDate))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(500);
	}
	

	
}