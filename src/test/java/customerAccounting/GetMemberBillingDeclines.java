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
	static String customerId;
	static String format;
	static String declineCode;
	static String declineMessage;
	static String invalidCCNoCode;
	static String invalidCCNoMessage;
	static String exceedsFloorLimitCode;
	static String exceedsFloorLimitMessage;
	static String warningBulletinCode;
	static String warningBulletinMessage;
	static String noAmountCode;
	static String noAmountMessage;
	static String customerDisputesChargeCode;
	static String customerDisputesChargeMessage;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = "101"; // prop.getProperty("X-CompanyId");
		customerId =prop.getProperty("availableId");
		
		format = "Jonas Fitness EFT";
		
		declineCode = "R41";
		declineMessage = "Declined";
		invalidCCNoCode = "R30";
		invalidCCNoMessage = "Invalid Credit Card Number";
		exceedsFloorLimitCode = "R38";
		exceedsFloorLimitMessage = "Transaction Exceeds Floor Limit";
		warningBulletinCode = "R32";
		warningBulletinMessage = "Credit Card Number on Warning Bulletin";
		noAmountCode = "R03";
		noAmountMessage = "No Account/Unable to Locate";
		customerDisputesChargeCode = "R33";
		customerDisputesChargeMessage = "Customer Disputes Charge";
	}
	
	@Test (testName="History Found - Decline", description="PBI:150146")
	public void historyFoundDecline() {

		String customerId = "25517";
		
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
    		
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Amount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Attendant"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Code"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Date"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].FormOfPayment"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Format"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].LateFee"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Reason"));
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Code"), declineCode);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Reason"), declineMessage);
	}
	
	@Test (testName="History Found - Invalid CC Number", description="PBI:150146")
	public void historyFoundInvalidCCNo() {
		
		String customerId = "24010";
		
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
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Code"), invalidCCNoCode);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Reason"), invalidCCNoMessage);
	}
	
	@Test (testName="History Found - Transaction Exceeds Floor Limit", description="PBI:150146")
	public void historyFoundExceedsFloorLimit() {
		
		String customerId = "20967";
		
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
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Code"), exceedsFloorLimitCode);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Reason"), exceedsFloorLimitMessage);
	}
	
	@Test (testName="History Found - Warning Bulletin", description="PBI:150146")
	public void historyFoundWarningBulletin() {
		
		String customerId = "21074";
		
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
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Code"), warningBulletinCode);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Reason"), warningBulletinMessage);
	}
	
	@Test (testName="History Found - No Account/Unable to Locate", description="PBI:150146")
	public void historyFoundNoAmt() {
		
		String customerId = "21441";
		
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
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Code"), noAmountCode);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Reason"), noAmountMessage);
	}
	
	@Test (testName="History Found - Customer Disputes Charge", description="PBI:150146")
	public void historyFoundCustomerDisputesCharge() {
		
		String customerId = "23448";
		
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
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].CustomerId"), customerId);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Code"), customerDisputesChargeCode);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Format"), format);
    		Assert.assertEquals(js.getString("Envelope.Body.GetMemberBillingDeclinesResponse.GetMemberBillingDeclinesResult.MemberBillingDeclineDto[0].Reason"), customerDisputesChargeMessage);
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
	
	@Test (testName="Member Not Found", description="PBI:150146", enabled = false)
	public void memberNotFound() {
		
		companyId = prop.getProperty("X-CompanyId");
		String customerId = "9999999";                         
		
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMemberBillingDeclines","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMemberBillingDeclines(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().all()
         	.statusCode(500);
	}

	
	
	
	
	
	
	
	
}