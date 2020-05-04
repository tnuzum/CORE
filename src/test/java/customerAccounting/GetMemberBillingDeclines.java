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
	
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = "101"; //companyId = prop.getProperty("X-CompanyId");
		customerId = "15599";//prop.getProperty("availableId");
		
	}
	
	@Test (testName="History Found", description="PBI:150146")
	public void historyFound() {
		
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
	}
	
	@Test (testName="No History Found", description="PBI:150146")
	public void noHistoryFound() {
		
		String customerId = "1";                         
		
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