package customerAccounting;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CustomerAccountingPL;
import resources.ReusableMethods;
import resources.base;

public class GetCustomerAccountBalance extends base {
	
	static String companyId;
	static String customerId;
	
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		customerId = prop.getProperty("availableId");
		
	}
	
	@Test (testName="History Found", description="PBI:149845", enabled = false)
	public void historyFound() {
		
//			String customerId = "15599";
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
         	.log().all()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.AccountValue"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.BaseDate"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.CurrentBalance"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.CurrentCharges"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.DeclineAmount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.DeclineReason"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.FormOfPayment"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.FutureCharges"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.LastDeclineDate"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.Name"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.Past120"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.Past30"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.Past60"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.Past90"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.ReturnCode"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.TotalDue"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.UnappliedPayments"));
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerAccountBalanceDto.CustomerId"), customerId);
	}
	
	@Test (testName="History Not Found", description="PBI:149845", enabled = false)
	public void historyNotFound() {
		
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
         	.log().body()
         	.statusCode(200);
	}
	
	@Test (testName="Customer Not Found", description="PBI:149845", enabled = true)
	public void customerNotFound() {
		
		String customerId = "99999";
		
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200);
	}
	
	
}