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
	
		static String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Outstanding Invoices Found", description = "PBI: 153782")
	public void outstandingInvoicesFound() {
		
		 Response res = given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetOutstandingInvoices","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getOutstandingInvoices(companyId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(200)
			.extract().response();
  	      
			XmlPath js = ReusableMethods.rawToXML(res);	
       		
       		Assert.assertTrue(res.getTime() >= 60L);
			
       		Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.CustomerOutstandingInvoicesDto[0].CustomerId"));
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.CustomerOutstandingInvoicesDto[0].OutstandingInvoices.OutstandingInvoiceDto[0].InvoiceBalance"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.CustomerOutstandingInvoicesDto[0].OutstandingInvoices.InvoiceCategory"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.CustomerOutstandingInvoicesDto[0].OutstandingInvoices.InvoiceCreationDate"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.CustomerOutstandingInvoicesDto[0].OutstandingInvoices.InvoiceDescription"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.CustomerOutstandingInvoicesDto[0].OutstandingInvoices.InvoiceDueDate"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.CustomerOutstandingInvoicesDto[0].OutstandingInvoices.InvoiceId"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.CustomerOutstandingInvoicesDto[0].OutstandingInvoices.InvoicePaidAmount"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.CustomerOutstandingInvoicesDto[0].OutstandingInvoices.InvoiceTotal"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.CustomerOutstandingInvoicesDto[0].OutstandingInvoices.NsfFeeApplied"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.CustomerOutstandingInvoiceDtos[0].OutstandingInvoices.ReceiptNumber"));
	}
	
	@Test (testName="Outstanding Invoices Not Found", description = "PBI: 153782")
	public void outstandingInvoicesNotFound() {
		
			String asOfDate = "1980-01-01";
		
		 given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetOutstandingInvoices","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getOutstandingInvoicesAsOfDate(companyId, asOfDate))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(200);
	}
	
	@Test (testName="Specific Customer Found", description = "PBI: 153782")
	public void specificCustomerFound() {
		
			String customerId = prop.getProperty("outstandingInvoiceCardOnFileMemberId");
		
			 Response res = given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetOutstandingInvoices","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getOutstandingInvoicesSpecificCustomer(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//	      	.log().body()
         	.statusCode(200)
			.extract().response();
  	      
			XmlPath js = ReusableMethods.rawToXML(res);	
       		
       		Assert.assertTrue(res.getTime() >= 60L);
       		
       		Assert.assertNotNull(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.CustomerOutstandingInvoicesDto[0].CustomerId"));
	}

	@Test (testName="Specific As Of Date", description = "PBI: 153782")
	public void specificAsOfDate() {
		
			String asOfDate = ReusableDates.getCurrentDateMinusXDays(30);
		
		 given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetOutstandingInvoices","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getOutstandingInvoicesAsOfDate(companyId, asOfDate))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(200);
	}
	
	@Test (testName="Terminated Member Not Included", description = "PBI: 153782")
	public void terminatedMemberNotIncluded() {
		
			String includeTerminatedMember = "false";
		
		 Response res = given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetOutstandingInvoices","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getOutstandingInvoicesExcludeTerminatedMember(companyId, includeTerminatedMember))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(200)
			.extract().response();
  	      
			XmlPath js = ReusableMethods.rawToXML(res);	
       		
       		Assert.assertTrue(res.getTime() >= 60L);
       		
       		Assert.assertFalse(js.getString("Envelope.Body.GetOutstandingInvoicesResponse.GetOutstandingInvoicesResult.OutstandingInvoiceDto.CustomerId").contains(prop.getProperty("terminatedId")));
	}
	
	@Test (testName="Invalid Date", description = "PBI: 153782")
	public void invalidDate() {
		
			String asOfDate = "1980-13-01";
		
		 given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetOutstandingInvoices","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getOutstandingInvoicesAsOfDate(companyId, asOfDate))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(500);
	}
	

	
}