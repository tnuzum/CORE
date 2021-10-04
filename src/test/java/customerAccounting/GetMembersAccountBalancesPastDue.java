package customerAccounting;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CustomerAccountingPL;
import resources.ReusableDates;
import resources.ReusableMethods;
import resources.base;

public class GetMembersAccountBalancesPastDue extends base {
	
	static String companyId;
	static String clubId;
	
	static String asOfDate;
	static String daysPastDue;
	static String membershipTypeId;
	static String customerStatusId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");

		companyId = prop.getProperty("X-CompanyId");
		clubId = prop.getProperty("club1Id");
		
		asOfDate = "2019-06-01";
		daysPastDue = "Days30";
		membershipTypeId = "3";
		customerStatusId = "4";
	}
	
	@Test (testName="Past Due 30 Days", description="PBI:150324",enabled = true)
	public void pastDue30Days() {
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMembersAccountBalancesPastDue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMembersAccountBalancesPastDueAsOfDate(companyId,asOfDate,daysPastDue))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertTrue(js.getBoolean("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.Success"));
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].AccountBalance"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CurrentCharges"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].DisplayName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].MembershipType"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].PreferredPhone"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].OpenPayments"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past120"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past60"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past90"));	
    		
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past30") > 0.00);
	}
	
	@Test (testName="Past Due 60 Days", description="PBI:150324",enabled = true)
	public void pastDue60Days() {
		
			String daysPastDue = "Days60";
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMembersAccountBalancesPastDue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMembersAccountBalancesPastDueAsOfDate(companyId,asOfDate,daysPastDue))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertTrue(js.getBoolean("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.Success"));
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].AccountBalance"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CurrentCharges"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].DisplayName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].MembershipType"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].PreferredPhone"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].OpenPayments"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past120"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past30"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past90"));	
    		
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past60") > 0.00);
	}
	
	@Test (testName="Past Due 90 Days", description="PBI:150324",enabled = true)
	public void pastDue90Days() {

		String daysPastDue = "Days90";
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMembersAccountBalancesPastDue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMembersAccountBalancesPastDueAsOfDate(companyId,asOfDate,daysPastDue))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertTrue(js.getBoolean("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.Success"));
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].AccountBalance"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CurrentCharges"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].DisplayName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].MembershipType"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].PreferredPhone"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].OpenPayments"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past120"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past30"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past60"));	
    		
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past90") > 0.00);
	}
	
	@Test (testName="Past Due 120 Days", description="PBI:150324",enabled = true)
	public void pastDue120Days() {
		
		String daysPastDue = "Days120";
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMembersAccountBalancesPastDue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMembersAccountBalancesPastDueRequiredOnly(companyId,daysPastDue))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertTrue(js.getBoolean("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.Success"));
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].AccountBalance"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CurrentCharges"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].DisplayName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].MembershipType"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].PreferredPhone"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].OpenPayments"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past90"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past30"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past60"));	
    		
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past120") > 0.00);
	}
	
	@Test (testName="Single Club", description="PBI:150324")
	public void singleClub() {
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMembersAccountBalancesPastDue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMembersAccountBalancesPastDueSingleClub(companyId,asOfDate,daysPastDue, clubId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertTrue(js.getBoolean("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.Success"));
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].AccountBalance"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CurrentCharges"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].DisplayName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].MembershipType"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].PreferredPhone"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].OpenPayments"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past120"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past30"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past60"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past90"));	
	}
	
	@Test (testName="Multiple Clubs", description="PBI:150324")
	public void mulitpleClubs() {
		
			String club2Id = prop.getProperty("club2Id");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMembersAccountBalancesPastDue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMembersAccountBalancesPastDueMultipleClubs(companyId,asOfDate,daysPastDue, clubId, club2Id))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertTrue(js.getBoolean("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.Success"));
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].AccountBalance"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CurrentCharges"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].DisplayName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].MembershipType"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].PreferredPhone"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].OpenPayments"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past120"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past30"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past60"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past90"));	
	}
	
	@Test (testName="Single Membership Type", description="PBI:150324")
	public void singleMembershipType() {
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMembersAccountBalancesPastDue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMembersAccountBalancesPastDueSingleMembershipType(companyId,asOfDate,daysPastDue, membershipTypeId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertTrue(js.getBoolean("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.Success"));
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].AccountBalance"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CurrentCharges"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].DisplayName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].MembershipType"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].PreferredPhone"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].OpenPayments"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past120"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past30"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past60"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past90"));	
	}
	
	@Test (testName="Multiple Membership Types", description="PBI:150324")
	public void multipleMembershipTypes() {
		
		String membershipType2Id = "2";
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMembersAccountBalancesPastDue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMembersAccountBalancesPastDueMultipleMembershipTypes(companyId,asOfDate,daysPastDue, membershipTypeId, membershipType2Id))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertTrue(js.getBoolean("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.Success"));
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].AccountBalance"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CurrentCharges"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].DisplayName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].MembershipType"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].PreferredPhone"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].OpenPayments"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past120"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past30"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past60"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past90"));	
	}
	
	@Test (testName="Single Customer Status", description="PBI:150324")
	public void singleCustomerStatus() {
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMembersAccountBalancesPastDue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMembersAccountBalancesPastDueSingleCustomerStatus(companyId,asOfDate,daysPastDue, customerStatusId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertTrue(js.getBoolean("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.Success"));
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].AccountBalance"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CurrentCharges"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].DisplayName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].MembershipType"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].PreferredPhone"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].OpenPayments"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past120"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past30"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past60"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past90"));	
	}
	
	@Test (testName="Multiple Customer Statuses", description="PBI:150324")
	public void multipleCustomerStatuses() {
		
			String customerStatus2Id = "2";
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMembersAccountBalancesPastDue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMembersAccountBalancesPastDueMultipleCustomerStatuses(companyId,asOfDate,daysPastDue, customerStatusId, customerStatus2Id))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertTrue(js.getBoolean("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.Success"));
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].AccountBalance"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CurrentCharges"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].DisplayName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].MembershipType"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].PreferredPhone"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].OpenPayments"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past120"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past30"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past60"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past90"));	
	}
	
	@Test (testName="All Parameters", description="PBI:150324")
	public void allParameters() {
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMembersAccountBalancesPastDue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMembersAccountBalancesPastDueSingleClubAllParameters(companyId,asOfDate,daysPastDue,clubId,membershipTypeId,customerStatusId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertTrue(js.getBoolean("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.Success"));
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].AccountBalance"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CurrentCharges"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].DisplayName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].MembershipType"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].PreferredPhone"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].OpenPayments"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past120"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past30"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past60"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetMembersAccountBalancesPastDueResponse.GetMembersAccountBalancesPastDueResult.MemberAccountBalancesPastDue.MemberAccountBalancesPastDueDto[0].Past90"));	
	}
	
	@Test (testName="Days Past Due Required - Null", description="PBI:150324",enabled = true)
	public void daysPastDueRequiredNull() {
		
		String daysPastDue = prop.getProperty("NOF");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMembersAccountBalancesPastDue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMembersAccountBalancesPastDueRequiredOnly(companyId,daysPastDue))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(500)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto.Message").contains("'Invalid enum value 'null'"));
	}
	
	@Test (testName="Days Past Due Required - Blank", description="PBI:150324",enabled = true)
	public void daysPastDueRequiredBlank() {
		
			String daysPastDue = "";
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetMembersAccountBalancesPastDue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getMembersAccountBalancesPastDueRequiredOnly(companyId,daysPastDue))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(500)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto.Message").contains("'Invalid enum value ''"));    	
	}
	
	
	
}