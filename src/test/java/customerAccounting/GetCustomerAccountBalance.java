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
	static String format;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		format = prop.getProperty("format");
		
	}
	
	@Test (testName="History Found - No Declines", description="PBI:149845", enabled = true)
	public void historyFoundNoDeclines() {
		
			String customerId = prop.getProperty("noFOPId");
		
	Response res = 
			
		  given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountBalance","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountBalance(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.BaseDate"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineAmount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.DeclineReason"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.FormOfPayment"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.LastDeclineDate"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Name"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.ReturnCode"));
    		
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.AccountValue") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CurrentBalance") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CurrentCharges") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.FutureCharges") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Past30") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Past60") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Past90") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.Past120") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.TotalDue") >= 0.00);
    		Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.UnappliedPayments") >= 0.00);
    		
    		Assert.assertEquals(js.getString("Envelope.Body.GetCustomerAccountBalanceResponse.GetCustomerAccountBalanceResult.CustomerId"), customerId);
	}
	

	
}