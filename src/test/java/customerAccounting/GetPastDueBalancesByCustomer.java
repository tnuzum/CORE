package customerAccounting;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.lessThan;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import payloads.CustomerAccountingPL;
import resources.ReusableDates;
import resources.ReusableMethods;
import resources.base;

public class GetPastDueBalancesByCustomer extends base {
	
	String companyId;
	String asOfDate;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		asOfDate = ReusableDates.getCurrentDateMinusOneMonth();

	}
	
	@Test (testName="Get Past Due Balances By Customer")
	public void getPastDueBalancesByCustomer() {
		
			String customerId = prop.getProperty("availableId");
		
		 Response res = given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetPastDueBalancesByCustomer","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getPastDueBalancesByCustomer(companyId, customerId, asOfDate))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.time(lessThan(60L),TimeUnit.SECONDS)
			.extract().response();
  	      
			XmlPath js = ReusableMethods.rawToXML(res);	
			
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[0].AccountBalance"));
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[0].CurrentCharges"));
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[0].OpenPayments"));
			
			Assert.assertNotNull(js.getString("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[0].CustomerId"), customerId);
	
	}
	
	@Test (testName="Get Past Due Balances By Customers")
	public void getPastDueBalancesByCustomers() {
		
			String customer1Id = prop.getProperty("noFOPId");
			String customer2Id = prop.getProperty("creditLimitId");
		
		 Response res = given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetPastDueBalancesByCustomer","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getPastDueBalancesByCustomers(companyId,customer1Id, customer2Id, asOfDate))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.time(lessThan(60L),TimeUnit.SECONDS)
			.extract().response();
  	      
			XmlPath js = ReusableMethods.rawToXML(res);	
			
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[0].AccountBalance"));
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[0].CurrentCharges"));
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[0].OpenPayments"));
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[1].AccountBalance"));
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[1].CurrentCharges"));
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[1].OpenPayments"));
			
			Assert.assertNotNull(js.getString("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[0].CustomerId"), customer1Id);
			Assert.assertNotNull(js.getString("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[1].CustomerId"), customer2Id);
	
	}
	
	@Test (testName="Get Past Due Balances All Dates")
	public void getPastDueBalancesAllDates() {
		
			String customerId = prop.getProperty("availableId");
		
		 Response res = given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetPastDueBalancesByCustomer","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getPastDueBalancesByCustomerAllDates(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.time(lessThan(60L),TimeUnit.SECONDS)
			.extract().response();
  	      
			XmlPath js = ReusableMethods.rawToXML(res);	
			
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[0].AccountBalance"));
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[0].CurrentCharges"));
			Assert.assertNotNull(js.getDouble("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[0].OpenPayments"));
			
			Assert.assertNotNull(js.getString("Envelope.Body.GetPastDueBalancesByCustomerResponse.GetPastDueBalancesByCustomerResult.PastDueBalancesByCustomerDto[0].CustomerId"), customerId);
	
	}
	
}