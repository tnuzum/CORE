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
import payloads.AccountHistory;
import resources.ReusableMethods;
import resources.base;

public class GetTransactionSummary extends base{
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
		String startDateTime = "2020-11-01T00:00:00";
		String endDateTime = "2020-12-01T00:00:00";
		String clubId = prop.getProperty("X-Club1Id");
		
	Response res =	 given()

  	.headers("SOAPAction", "http://tempuri.org/IAccountHistoryService/GetTransactionSummary","Content-Type", "text/xml; charset=utf-8")
  	.and()
  	.body(AccountHistory.getTransactionSummary(companyId, customerId, clubId, startDateTime, endDateTime))
  	.when()
  	.post("/AccountHistory/AccountHistory.svc")
  	.then()
//    .log().body()
  	.statusCode(200)
  	.time(lessThan(60L),TimeUnit.SECONDS)
   	.extract().response();
	
//	 Assert.assertTrue(res.getTime() >= 60L);
	
	XmlPath js = ReusableMethods.rawToXML(res);
	
	int count = js.getInt("Envelope.Body.GetTransactionSummaryResponse.GetTransactionSummaryResult.TransactionSummaryDto.size()");
	
	ArrayList<String> itemTypes = new  ArrayList<String>();
	
	for (int i = 0; i<count; i++)
		
	{
		String itemType = js.getString("Envelope.Body.GetTransactionSummaryResponse.GetTransactionSummaryResult.TransactionSummaryDto["+i+"].ItemType");
//		System.out.println(itemType);
		itemTypes.add(itemType);
		
		Assert.assertNotNull(js.getString("Envelope.Body.GetTransactionSummaryResponse.GetTransactionSummaryResult.TransactionSummaryDto["+i+"].Amount"));
		Assert.assertNotNull(js.getString("Envelope.Body.GetTransactionSummaryResponse.GetTransactionSummaryResult.TransactionSummaryDto["+i+"].Balance"));
		Assert.assertNotNull(js.getString("Envelope.Body.GetTransactionSummaryResponse.GetTransactionSummaryResult.TransactionSummaryDto["+i+"].Balance"));
		Assert.assertNotNull(js.getString("Envelope.Body.GetTransactionSummaryResponse.GetTransactionSummaryResult.TransactionSummaryDto["+i+"].DetailId"));
		Assert.assertNotNull(js.getString("Envelope.Body.GetTransactionSummaryResponse.GetTransactionSummaryResult.TransactionSummaryDto["+i+"].DueDate.DateTime"));
		Assert.assertNotNull(js.getString("Envelope.Body.GetTransactionSummaryResponse.GetTransactionSummaryResult.TransactionSummaryDto["+i+"].DueDate.OffsetMinutes"));
		Assert.assertNotNull(js.getString("Envelope.Body.GetTransactionSummaryResponse.GetTransactionSummaryResult.TransactionSummaryDto["+i+"].HeaderId"));
		Assert.assertNotNull(js.getString("Envelope.Body.GetTransactionSummaryResponse.GetTransactionSummaryResult.TransactionSummaryDto["+i+"].ItemType"));
		Assert.assertNotNull(js.getString("Envelope.Body.GetTransactionSummaryResponse.GetTransactionSummaryResult.TransactionSummaryDto["+i+"].ReceiptNumber"));
		Assert.assertNotNull(js.getString("Envelope.Body.GetTransactionSummaryResponse.GetTransactionSummaryResult.TransactionSummaryDto["+i+"].TransactionDate.DateTime"));
		Assert.assertNotNull(js.getString("Envelope.Body.GetTransactionSummaryResponse.GetTransactionSummaryResult.TransactionSummaryDto["+i+"].TransactionDate.OffsetMinutes"));
		
	}
		
		Assert.assertTrue(itemTypes.contains("Charge"));
		Assert.assertTrue(itemTypes.contains("Payment"));
		
	}

}
