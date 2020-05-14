package customerAccounting;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CustomerAccountingPL;
import resources.ReusableMethods;
import resources.base;

public class GetMemberBillingDeclines extends base {
	
	static String companyId;
	static String format;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = "101"; // prop.getProperty("X-CompanyId");
		format = prop.getProperty("format");
	}
	
	@Test (testName="Return - Declined", description="PBI:150146")
	public void returnDeclined() {

			String customerId = prop.getProperty("declineMemberId");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMemberBillingDeclines","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMemberBillingDeclines(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Amount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Attendant"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Code"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Date"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].FormOfPayment"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Format"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].LateFee"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Reason"));
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Code"), prop.getProperty("declineCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Reason"), prop.getProperty("declineMessage"));
	}
	
	@Test (testName="Return - Invalid CC Number", description="PBI:150146")
	public void returnInvalidCCNo() {
		
			String customerId = prop.getProperty("invalidCCNoMemberId");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMemberBillingDeclines","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMemberBillingDeclines(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Code"), prop.getProperty("invalidCCNoCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Reason"), prop.getProperty("invalidCCNoMessage"));
	}
	
	@Test (testName="Return - Transaction Exceeds Floor Limit", description="PBI:150146")
	public void returnTransactionExceedsFloorLimit() {
		
			String customerId =  prop.getProperty("exceedsFloorLimitMemberId");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMemberBillingDeclines","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMemberBillingDeclines(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Code"), prop.getProperty("exceedsFloorLimitCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Reason"), prop.getProperty("exceedsFloorLimitMessage"));
	}
	
	@Test (testName="Return - Warning Bulletin", description="PBI:150146")
	public void returnWarningBulletin() {
		
			String customerId = prop.getProperty("warningBulletinMemberId");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMemberBillingDeclines","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMemberBillingDeclines(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Code"), prop.getProperty("warningBulletinCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Reason"), prop.getProperty("warningBulletinMessage"));
	}
	
	@Test (testName="Return - No Account/Unable to Locate", description="PBI:150146")
	public void returnNoAmtUnableToLocate() {
		
			String customerId = prop.getProperty("noAmountMemberId");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMemberBillingDeclines","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMemberBillingDeclines(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Code"), prop.getProperty("noAmountCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Reason"), prop.getProperty("noAmountMessage"));
	}
	
	@Test (testName="Return - Customer Disputes Charge", description="PBI:150146")
	public void returnCustomerDisputesCharge() {
		
			String customerId = prop.getProperty("customerDisputesChargeMemberId");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMemberBillingDeclines","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMemberBillingDeclines(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Code"), prop.getProperty("customerDisputesChargeCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Reason"), prop.getProperty("customerDisputesChargeMessage"));
	}
	
	@Test (testName="Return - Frozen Status", description="PBI:150146")
	public void returnFrozenStatus() {
		
			String customerId =  prop.getProperty("frozenStatusMemberId");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMemberBillingDeclines","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMemberBillingDeclines(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Code"), prop.getProperty("frozenStatusCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Reason"), prop.getProperty("frozenStatusMessage"));
	}
	
	@Test (testName="Return - Delete Status", description="PBI:150146")
	public void returnDeleteStatus() {
		
			String customerId = prop.getProperty("deleteStatusMemberId");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMemberBillingDeclines","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMemberBillingDeclines(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Code"), prop.getProperty("deleteStatusCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Reason"), prop.getProperty("deleteStatusMessage"));
	}
	
	@Test (testName="Return - NSF", description="PBI:150146")
	public void returnNSF() {
		
			String customerId = prop.getProperty("nFSMemberId");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMemberBillingDeclines","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMemberBillingDeclines(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Code"), prop.getProperty("nFSCode"));
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.BillingDeclines.MemberBillingDeclineDto[0].Reason"), prop.getProperty("nFSMessage"));
	}
	
	@Test (testName="No History Found", description="PBI:150146")
	public void noHistoryFound() {
		
		String customerId = prop.getProperty("noFOPId");                         
		
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMemberBillingDeclines","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMemberBillingDeclines(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(200);
	}
	
	@Test (testName="Member Not Found", description="PBI:150146", enabled = true)
	public void memberNotFound() {
		
			String customerId = "9999999";     
		
	Response res = 
		
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMemberBillingDeclines","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMemberBillingDeclines(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
 //        	.log().all()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
         	Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.Message"), "Customer not found");
	}

	
	
	
	
	
	
	
	
}