package TransactionProcessing;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.TransactionProcessingPL;
import resources.ReusableMethods;
import resources.base;

public class GetInvoicingInformation extends base {
	static String companyId;
		

	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test(priority = 1)
	public void InvoicingInfo_Package() {
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/ITransactionProcessing/GetInvoicingInformation","Content-Type","text/xml; charset=utf-8") .and()
				  .body(TransactionProcessingPL.InvoicingInfo_Package(companyId)) .when()
				  .post("/Financial/TransactionProcessing.svc") 
				  .then() 
				  //.log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  Assert.assertTrue(res.getTime() >= 60L);
				  
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.CanPlaceOnAccount"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.GrandTotal"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.CustomerId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.IsTaxed"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.ItemId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.Price"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.SubTotal"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.Tax"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.TaxDetails.InvoiceTaxInfoDto.TaxAmount"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.TaxDetails.InvoiceTaxInfoDto.TaxItemId"));

	}
	
	@Test(priority = 2)
	public void InvoicingInfo_Class() {
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/ITransactionProcessing/GetInvoicingInformation","Content-Type","text/xml; charset=utf-8") .and()
				  .body(TransactionProcessingPL.InvoicingInfo_Class(companyId)) .when()
				  .post("/Financial/TransactionProcessing.svc") 
				  .then() 
				  //.log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  Assert.assertTrue(res.getTime() >= 60L);
				  
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.CanPlaceOnAccount"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.GrandTotal"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.CustomerId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.IsTaxed"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.ItemId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.Price"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.SubTotal"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.Tax"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.TaxDetails.InvoiceTaxInfoDto.TaxAmount"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.TaxDetails.InvoiceTaxInfoDto.TaxItemId"));

	}
	
	@Test(priority = 3)
	public void InvoicingInfo_Training() {
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/ITransactionProcessing/GetInvoicingInformation","Content-Type","text/xml; charset=utf-8") .and()
				  .body(TransactionProcessingPL.InvoicingInfo_Training(companyId)) .when()
				  .post("/Financial/TransactionProcessing.svc") 
				  .then() 
				  //.log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  Assert.assertTrue(res.getTime() >= 60L);
				  
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.CanPlaceOnAccount"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.GrandTotal"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.CustomerId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.IsTaxed"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.ItemId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.Price"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.SubTotal"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.Tax"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.TaxDetails.InvoiceTaxInfoDto.TaxAmount"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.TaxDetails.InvoiceTaxInfoDto.TaxItemId"));

	}
	
	@Test(priority = 4)
	public void InvoicingInfo_RefundWithCancelFee() {
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/ITransactionProcessing/GetInvoicingInformation","Content-Type","text/xml; charset=utf-8") .and()
				  .body(TransactionProcessingPL.InvoicingInfo_RefundWithCancelFee(companyId)) .when()
				  .post("/Financial/TransactionProcessing.svc") 
				  .then() 
				  //.log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  Assert.assertTrue(res.getTime() >= 60L);
				  
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.CanPlaceOnAccount"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.GrandTotal"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto[0].CustomerId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto[0].IsTaxed"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto[0].ItemId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto[0].Price"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto[1].CustomerId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto[1].IsTaxed"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto[1].ItemId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto[1].Price"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.SubTotal"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.Tax"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.TaxDetails.InvoiceTaxInfoDto.TaxAmount"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.TaxDetails.InvoiceTaxInfoDto.TaxItemId"));

	}
	
	@Test(priority = 5)
	public void InvoicingInfo_RefundWithNoCancelFee() {
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/ITransactionProcessing/GetInvoicingInformation","Content-Type","text/xml; charset=utf-8") .and()
				  .body(TransactionProcessingPL.InvoicingInfo_RefundWithNoCancelFee(companyId)) .when()
				  .post("/Financial/TransactionProcessing.svc") 
				  .then() 
				  //.log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  Assert.assertTrue(res.getTime() >= 60L);
				  
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.CanPlaceOnAccount"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.GrandTotal"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.CustomerId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.IsTaxed"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.ItemId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.Price"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.SubTotal"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.Tax"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.TaxDetails.InvoiceTaxInfoDto.TaxAmount"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.TaxDetails.InvoiceTaxInfoDto.TaxItemId"));

	}
	
	@Test(priority = 6)
	public void InvoicingInfo_Item() {
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/ITransactionProcessing/GetInvoicingInformation","Content-Type","text/xml; charset=utf-8") .and()
				  .body(TransactionProcessingPL.InvoicingInfo_Class(companyId)) .when()
				  .post("/Financial/TransactionProcessing.svc") 
				  .then() 
				  //.log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  Assert.assertTrue(res.getTime() >= 60L);
				  
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.CanPlaceOnAccount"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.GrandTotal"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.CustomerId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.IsTaxed"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.ItemId"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.PriceDetails.InvoicePriceInfoDto.Price"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.SubTotal"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.Tax"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.TaxDetails.InvoiceTaxInfoDto.TaxAmount"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetInvoicingInformationResponse.GetInvoicingInformationResult.TaxDetails.InvoiceTaxInfoDto.TaxItemId"));

	}
	
	@Test(priority = 7)
	public void InvalidCustomerId1() {
		

		 Response res = given() .headers("SOAPAction", "http://tempuri.org/ITransactionProcessing/GetInvoicingInformation","Content-Type","text/xml; charset=utf-8") .and()
				  .body(TransactionProcessingPL.InvoicingInfo_InvalidCustomerId1(companyId)) .when()
				  .post("/Financial/TransactionProcessing.svc") 
				  .then() 
				  //.log().all()
				  .statusCode(400) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  Assert.assertTrue(res.getTime() >= 60L);
				  String text = js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message");
				  Assert.assertEquals("CustomerId: 822222 is not valid.", text);
		
	}

	
	@Test(priority = 8)
	public void InvalidCustomerId2() {
		

		 Response res = given() .headers("SOAPAction", "http://tempuri.org/ITransactionProcessing/GetInvoicingInformation","Content-Type","text/xml; charset=utf-8") .and()
				  .body(TransactionProcessingPL.InvoicingInfo_InvalidCustomerId2(companyId)) .when()
				  .post("/Financial/TransactionProcessing.svc") 
				  .then() 
				  //.log().all()
				  .statusCode(400) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  Assert.assertTrue(res.getTime() >= 60L);
				  String text = js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message");
				  Assert.assertEquals("CustomerId: 832222 is not valid.", text);
		
	}
	
	@Test(priority = 9)
	public void InvalidItemId() {
		

		 Response res = given() .headers("SOAPAction", "http://tempuri.org/ITransactionProcessing/GetInvoicingInformation","Content-Type","text/xml; charset=utf-8") .and()
				  .body(TransactionProcessingPL.InvoicingInfo_InvalidItemId(companyId)) .when()
				  .post("/Financial/TransactionProcessing.svc") 
				  .then() 
				  //.log().all()
				  .statusCode(400) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  Assert.assertTrue(res.getTime() >= 60L);
				  String text = js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message");
				  Assert.assertEquals("ItemId: 308111 is not valid.", text);
	}
	
	@Test(priority = 10)
	public void InvoiceDetailId() {
		

		 Response res = given() .headers("SOAPAction", "http://tempuri.org/ITransactionProcessing/GetInvoicingInformation","Content-Type","text/xml; charset=utf-8") .and()
				  .body(TransactionProcessingPL.InvoicingInfo_InvalidInvoiceDetailId(companyId)) .when()
				  .post("/Financial/TransactionProcessing.svc") 
				  .then() 
				  //.log().all()
				  .statusCode(400) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  Assert.assertTrue(res.getTime() >= 60L);
				  String text = js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message");
				  Assert.assertEquals("InvoiceDetailId: 1052233333 is not valid.", text);
		
	}
}
