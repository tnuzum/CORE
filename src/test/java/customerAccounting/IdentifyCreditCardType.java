package customerAccounting;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;
import io.restassured.RestAssured;
import payloads.CustomerAccountingPL;
import resources.base;

public class IdentifyCreditCardType extends base {
	
	static String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		
	}
	
	@Test (testName="Credit Card Type Visa")
	public void creditCardTypeVisa() {
		
			String cardNumber = prop.getProperty("cardNumberVisa");
		
		 given()
//				.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/IdentifyCreditCardType","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.identifyCreditCardType(companyId, cardNumber))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(200)
         	.time(lessThan(60L),TimeUnit.SECONDS)
        	.body("Envelope.Body.IdentifyCreditCardTypeResponse.IdentifyCreditCardTypeResult", equalTo("Visa"));
	}
	
	@Test (testName="Credit Card Type MasterCard")
	public void creditCardTypeMasterCard() {
		
			String cardNumber = prop.getProperty("cardNumberMasterCard");
		
		 given()
//				.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/IdentifyCreditCardType","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.identifyCreditCardType(companyId, cardNumber))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(200)
         	.time(lessThan(60L),TimeUnit.SECONDS)
        	.body("Envelope.Body.IdentifyCreditCardTypeResponse.IdentifyCreditCardTypeResult", equalTo("MasterCard"));
	}
}