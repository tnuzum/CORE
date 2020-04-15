package customerAccounting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;

import io.restassured.RestAssured;
import payloads.CustomerAccountingPL;
import resources.base;

public class GetInvoiceChargeReceiptDetail extends base {
	
	static String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		
	}
	
	@Test (testName="Get Invoice Charge Receipt Detail")
	public void getInvoiceChargeReceiptDetail() {
		
			String headerId = prop.getProperty("chargeHeaderId");
		
		given()
//				.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetInvoiceChargeReceiptDetail","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getInvoiceChargeReceiptDetail(companyId, headerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.time(lessThan(60L),TimeUnit.SECONDS);
		
		
	}
	
}
