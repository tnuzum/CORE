package customerAccounting;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import payloads.CustomerAccountingPL;
import resources.ReusableMethods;
import resources.base;

public class GetCustomerAccountBalance extends base {
	
	static String companyId;
	static String format;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = "101"; //prop.getProperty("X-CompanyId");
		format = prop.getProperty("format");
		
	}
	
	@Test (testName="History Found - No Declines", description="PBI:149845", enabled = true)
	public void historyFoundNoDeclines() {
		
			String customerId = prop.getProperty("noFOPId");
		
	Response res = 
			
		  given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.BaseDate"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineAmount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineReason"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.FormOfPayment"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.LastDeclineDate"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Name"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.ReturnCode"));
    		
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.AccountValue") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CurrentBalance") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CurrentCharges") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.FutureCharges") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Past30") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Past60") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Past90") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Past120") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.TotalDue") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.UnappliedPayments") >= 0.00);
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"), customerId);
	}
	
	@Test (testName="Return - Declined", description="PBI:149845", enabled = true)
	public void returnDeclined() {
		
			String customerId = prop.getProperty("declineMemberId");
		
	Response res = 
			
		  given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.BaseDate"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineAmount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineReason"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.FormOfPayment"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.LastDeclineDate"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Name"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.ReturnCode"));
    		
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.AccountValue") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CurrentBalance") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CurrentCharges") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.FutureCharges") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Past30") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Past60") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Past90") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Past120") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.TotalDue") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.UnappliedPayments") >= 0.00);
    		
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineAmount") >= 0.00);
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineReason"), prop.getProperty("declineMessage"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.ReturnCode"), prop.getProperty("declineCode"));
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"), customerId);
	}
	
	@Test (testName="Return - Invalid CC Number", description="PBI:149845", enabled = true)
	public void returnInvalidCCNo() {
		
			String customerId = prop.getProperty("invalidCCNoMemberId");
				
	Response res = 
			
		  given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);

    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineReason"), prop.getProperty("invalidCCNoMessage"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.ReturnCode"), prop.getProperty("invalidCCNoCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"), customerId);
	}
	
	@Test (testName="Return - Transaction Exceeds Floor Limit", description="PBI:149845", enabled = true)
	public void returnTransactionExceedsFloorLimit() {
		
			String customerId =  prop.getProperty("exceedsFloorLimitMemberId");
			
	Response res = 
			
		  given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId,customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);

    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineReason"), prop.getProperty("exceedsFloorLimitMessage"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.ReturnCode"), prop.getProperty("exceedsFloorLimitCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"), customerId);
	}
	
	@Test (testName="Return - Warning Bulletin", description="PBI:149845", enabled = true)
	public void returnWarningBulletin() {
		
			String customerId = prop.getProperty("warningBulletinMemberId");
		
	Response res = 
			
		  given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId,customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);

    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineReason"), prop.getProperty("warningBulletinMessage"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.ReturnCode"), prop.getProperty("warningBulletinCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"), customerId);
	}
	
	@Test (testName="Return - No Account/Unable to Locate", description="PBI:149845", enabled = true)
	public void returnNoAmtUnableToLocate() {
		
			String customerId = prop.getProperty("noAmountMemberId");
		
	Response res = 
			
		  given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);

    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineReason"), prop.getProperty("noAmountMessage"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.ReturnCode"), prop.getProperty("noAmountCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"), customerId);
	}
	
	@Test (testName="Return - Customer Disputes Charge", description="PBI:149845", enabled = true)
	public void returnCustomerDisputesCharge() {
		
			String customerId = prop.getProperty("customerDisputesChargeMemberId");
		
	Response res = 
			
		  given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);

    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineReason"), prop.getProperty("customerDisputesChargeMessage"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.ReturnCode"), prop.getProperty("customerDisputesChargeCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"), customerId);
	}
	
	@Test (testName="Return - Frozen Status", description="PBI:149845", enabled = true)
	public void returnFrozenStatus() {
		
			String customerId =  prop.getProperty("frozenStatusMemberId");
		
	Response res = 
			
		  given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);

    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineReason"), prop.getProperty("frozenStatusMessage"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.ReturnCode"), prop.getProperty("frozenStatusCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"), customerId);
	}
	
	@Test (testName="Return - Delete Status", description="PBI:149845", enabled = true)
	public void returnDeleteStatus() {
		
			String customerId = prop.getProperty("deleteStatusMemberId");
		
	Response res = 
			
		  given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);

    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineReason"), prop.getProperty("deleteStatusMessage"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.ReturnCode"), prop.getProperty("deleteStatusCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"), customerId);
	}
	
	@Test (testName="Return - NSF", description="PBI:149845", enabled = true)
	public void returnNSF() {
		
			String customerId = prop.getProperty("nFSMemberId");
		
	Response res = 
			
		  given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);

    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineReason"), prop.getProperty("nFSMessage"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.ReturnCode"), prop.getProperty("nFSCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"), customerId);
	}
	
	@Test (testName="Negative Balances", description="PBI:149845", enabled = true)
	public void negativeBalances() {
		
			String companyId = "236";
			String customerId = prop.getProperty("negativeAcctBalMemberId");
		
	Response res = 
			
		  given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
         	.log().all()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
    		
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.AccountValue") < 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CurrentBalance") < 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CurrentCharges") < 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.TotalDue") < 0.00);
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"), customerId);
	}
	
	@Test (testName="Customer Not Found", description="PBI:149845", enabled = true)
	public void customerNotFound() {
		
		String customerId = "99999";
		
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(500)
         	.body("Envelope.Body.Fault.detail.InternalServerErrorFaultDto.Message", equalTo("CustomerId '"+customerId+"' not found"));
	}
	
	
}