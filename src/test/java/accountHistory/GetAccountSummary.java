package accountHistory;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import payloads.AccountHistoryPL;
import resources.ReusableMethods;
import resources.base;

public class GetAccountSummary extends base{
static String companyId;
	
	@BeforeTest
	public void getData() {
		
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		
	}
	@Test(priority = 1)
		public void getTransactionSummaryforADueDateRange() {
		
		String customerId = prop.getProperty("apptMemberId");
		
	Response res =	 given()

  	.headers("SOAPAction", "http://tempuri.org/IAccountHistoryService/GetAccountSummary","Content-Type", "text/xml; charset=utf-8")
  	.and()
  	.body(AccountHistoryPL.GetAccountSummary(companyId, customerId))
  	.when()
  	.post("/AccountHistory/AccountHistory.svc")
  	.then()
    .log().body()
  	.statusCode(200)
  	.time(lessThan(60L),TimeUnit.SECONDS)
   	.extract().response();
	
//	 Assert.assertTrue(res.getTime() >= 60L);
	
	XmlPath js = ReusableMethods.rawToXML(res);
	
	Assert.assertNotNull(js.getString("Envelope.Body.GetAccountSummaryResponse.GetAccountSummaryResult.Balance"));
	Assert.assertNotNull(js.getString("Envelope.Body.GetAccountSummaryResponse.GetAccountSummaryResult.CreditAmount"));
	Assert.assertNotNull(js.getString("Envelope.Body.GetAccountSummaryResponse.GetAccountSummaryResult.UnpaidAmount"));
	}
	
}
