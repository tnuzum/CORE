package CustomerAccounting;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;
import io.restassured.RestAssured;
import payloads.CustomerAccountingPL;
import resources.base;

public class GetAccountHistory extends base {
	
	static String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		
	}
	
	@Test (testName="Account History Found - Payment")
	public void accountHistoryFoundPayment() {
		
			String customerId = prop.getProperty("creditLimitId");
			String startDateTime = "2020-04-12";
			String startOffset = "0";
			String endDateTime = "2020-04-14";
			String endOffset = "0";
		
		 given()
//				.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetAccountHistory","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getAccountHistory(companyId, customerId, startDateTime, startOffset, endDateTime, endOffset))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
 //        	.log().body()
         	.statusCode(200)
         	.time(lessThan(60L),TimeUnit.SECONDS)
         	.body("Envelope.Body.GetAccountHistoryResponse.GetAccountHistoryResult.ReceiptItemSummaryDto[0].ItemType", equalTo("Payment"));
	
	}
	
	@Test (testName="Account History Found - Charge")
	public void accountHistoryFoundCharge() {
		
			String customerId = prop.getProperty("availableId");
			String startDateTime = "2020-04-12";
			String startOffset = "0";
			String endDateTime = "2020-04-14";
			String endOffset = "0";
		
		 given()
//				.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetAccountHistory","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getAccountHistory(companyId, customerId, startDateTime, startOffset, endDateTime, endOffset))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.time(lessThan(60L),TimeUnit.SECONDS)
         	.body("Envelope.Body.GetAccountHistoryResponse.GetAccountHistoryResult.ReceiptItemSummaryDto[0].ItemType", equalTo("Charge"));
	}
	
	@Test (testName="Account History Not Found")
	public void accountHistoryNotFound() {
		
			String customerId = prop.getProperty("creditLimitId");
			String startDateTime = "2020-01-01";
			String startOffset = "0";
			String endDateTime = "2020-01-02";
			String endOffset = "0";
		
		 given()
//				.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetAccountHistory","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getAccountHistory(companyId, customerId, startDateTime, startOffset, endDateTime, endOffset))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
 //        	.log().body()
         	.statusCode(200);
	
	}
	
	
}