package customerAccounting;

import static io.restassured.RestAssured.given;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.lessThan;
import java.util.concurrent.TimeUnit;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import payloads.CustomerAccountingPL;
import resources.ReusableMethods;
import resources.base;

public class GetCustomerAccountValue extends base {
	
	static String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		
	}
	
	@Test (testName="Get Customer Account Value")
	public void getCustomerAccountValue() {
		
			String customerId = prop.getProperty("noFOPId");
		Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountValue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountValue(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(200)
         	.extract().response();
	
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			Assert.assertTrue(js.getDouble("Envelope.Body.GetCustomerAccountValueResponse.GetCustomerAccountValueResult") > 0.00);
		
	}
	
	@Test (testName="Customer Not Found")
	public void customerNotFound() {
		
			String customerId = "99999";
		
		given()
//				.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetCustomerAccountValue","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getCustomerAccountValue(companyId, customerId))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(500)
         	.time(lessThan(60L),TimeUnit.SECONDS);
	
	}

}
