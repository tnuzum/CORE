package customerAccounting;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.not;
import java.util.concurrent.TimeUnit;

import io.restassured.RestAssured;
import payloads.CustomerAccountingPL;
import resources.base;

public class GetLastPaymentDateForCustomer extends base {
	
	static String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		
	}
	
	@Test (testName="GetLastPaymentDateForCustomer")
	public void getCustomerAccountValue() {
		
			String customerId = prop.getProperty("availableId");
		
		given()
//				.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetLastPaymentDateForCustomer","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getLastPaymentDateForCustomer(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(200)
         	.time(lessThan(60L),TimeUnit.SECONDS);
	
	}


}
