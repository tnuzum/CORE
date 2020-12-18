package customerAuth;


import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CustomerAuthPL;
import resources.ReusableMethods;
import resources.base;

public class AuthenticateCustomer extends base {
	static String companyId;

	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	@Test(priority = 1)
	public void verifyCustomerAuthentication_SuccessfulLogin(){
		
		String userName = prop.getProperty("AuthorizeCustomerUsername");
		String passWord = prop.getProperty("AuthorizeCustomerPassword");
		
		Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthenticateCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthenticateCustomer(companyId, userName, passWord))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//			.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				
				Assert.assertEquals(js.getString("Envelope.Body.AuthenticateCustomerResponse.AuthenticateCustomerResult.AuthenticationResult"), "Success");
				Assert.assertNotNull(js.getString("Envelope.Body.AuthenticateCustomerResponse.AuthenticateCustomerResult.BarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.AuthenticateCustomerResponse.AuthenticateCustomerResult.ExternalId"));
				Assert.assertNotNull(js.getString("Envelope.Body.AuthenticateCustomerResponse.AuthenticateCustomerResult.Id"));
				Assert.assertNotNull(js.getString("Envelope.Body.AuthenticateCustomerResponse.AuthenticateCustomerResult.LastSuccessfulLogin.DateTime"));
		
	}
	
	@Test(priority = 2)
	public void verifyCustomerAuthentication_FailedLogin(){
		String userName = prop.getProperty("AuthorizeCustomerUsername");
		String wrongPassword = prop.getProperty("AuthorizeCustomerWrongPassword");
		
		Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/AuthenticateCustomer","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.AuthenticateCustomer(companyId, userName, wrongPassword))
	
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
//			.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				
				Assert.assertEquals(js.getString("Envelope.Body.AuthenticateCustomerResponse.AuthenticateCustomerResult.AuthenticationResult"), "WrongCredentials");
				Assert.assertEquals(js.getString("Envelope.Body.AuthenticateCustomerResponse.AuthenticateCustomerResult.BarcodeId"), "");
				Assert.assertEquals(js.getString("Envelope.Body.AuthenticateCustomerResponse.AuthenticateCustomerResult.ExternalId"), "");
				Assert.assertEquals(js.getString("Envelope.Body.AuthenticateCustomerResponse.AuthenticateCustomerResult.LastSuccessfulLogin"), "");
				
		
	}
}
