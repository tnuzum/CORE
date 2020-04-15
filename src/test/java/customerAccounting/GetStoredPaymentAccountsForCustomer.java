package customerAccounting;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import io.restassured.RestAssured;
import payloads.CustomerAccountingPL;
import resources.base;

public class GetStoredPaymentAccountsForCustomer extends base {
	
	static String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		
	}
	
	@Test (testName="Credit Card Found")
	public void creditCardFound() {
		
			String customerId = prop.getProperty("MultipleAgreementsWithSingleCardId");
		
		given()
//				.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetStoredPaymentAccountsForCustomer","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getStoredPaymentAccountsForCustomer(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.time(lessThan(60L),TimeUnit.SECONDS)
         	.body("Envelope.Body.GetStoredPaymentAccountsForCustomerResponse.GetStoredPaymentAccountsForCustomerResult.CreditCards.StoredCreditCardResponse[0].AccountId", equalTo("1"));
	}
	
	@Test (testName="Multiple Credit Cards Found")
	public void multipleCreditCardsFound() {
		
			String customerId = prop.getProperty("MultipleAgreementsWithMultipleCardsId");
		
		given()
//				.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetStoredPaymentAccountsForCustomer","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getStoredPaymentAccountsForCustomer(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.time(lessThan(60L),TimeUnit.SECONDS)
         	.body("Envelope.Body.GetStoredPaymentAccountsForCustomerResponse.GetStoredPaymentAccountsForCustomerResult.CreditCards.StoredCreditCardResponse[0].AccountId", equalTo("1"))
         	.body("Envelope.Body.GetStoredPaymentAccountsForCustomerResponse.GetStoredPaymentAccountsForCustomerResult.CreditCards.StoredCreditCardResponse[1].AccountId", equalTo("2"));
	}
	
	@Test (testName="Checking Account Found")
	public void checkingAccountFound() {
		
			String customerId = prop.getProperty("checkingMemberId");
		
		given()
//				.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetStoredPaymentAccountsForCustomer","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getStoredPaymentAccountsForCustomer(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.time(lessThan(60L),TimeUnit.SECONDS)
         	.body("Envelope.Body.GetStoredPaymentAccountsForCustomerResponse.GetStoredPaymentAccountsForCustomerResult.BankAccounts.StoredBankAccountResponse[0].AccountId", equalTo("1"));
	}
	
	@Test (testName="No Form Of Payment")
	public void noFormOfPayment() {
		
			String customerId = prop.getProperty("noFOPId");
		
		given()
//				.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetStoredPaymentAccountsForCustomer","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getStoredPaymentAccountsForCustomer(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.time(lessThan(60L),TimeUnit.SECONDS)
         	.body("Envelope.Body.GetStoredPaymentAccountsForCustomerResponse.GetStoredPaymentAccountsForCustomerResult.CreditCards.StoredCreditCardResponse[0].AccountId", not(equalTo("1")));
	}
	
}
