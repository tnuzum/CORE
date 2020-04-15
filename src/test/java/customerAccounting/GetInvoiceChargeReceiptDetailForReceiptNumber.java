package customerAccounting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

import io.restassured.RestAssured;
import payloads.CustomerAccountingPL;
import resources.base;

public class GetInvoiceChargeReceiptDetailForReceiptNumber extends base {
	
	static String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		
	}
	
	@Test (testName="Get Invoice Charge Receipt Detail For Receipt Number")
	public void getInvoiceChargeReceiptDetailForReceiptNumber() {
		
			String receiptId = prop.getProperty("chargeReceiptId");
		
		given()
//				.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetInvoiceChargeReceiptDetailForReceiptNumber","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getInvoiceChargeReceiptDetailForReceiptNumber(companyId, receiptId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.time(lessThan(60L),TimeUnit.SECONDS);
	}
	
}
