package customerAuth;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.Static;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CustomerAuthPL;
import resources.ReusableMethods;
import resources.base;

public class ValidateCustomerRefreshToken extends base{
	static String companyId;
static String refreshToken;
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	
	}
	@Test(priority = 1)
	public void verifyValidateRefreshToken(){
		String customerId = prop.getProperty("MemberId1");
		
		// refreshToken = "x4V6iX3U0s5nrD7NQA/bNF1x+KBkVERGfgPaERvHutE=";
	
		refreshToken = ReusableMethods.CustomerRefreshToken(companyId, customerId);
		Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/ValidateCustomerRefreshToken","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.ValidateCustomerRefreshToken(companyId, customerId, refreshToken))
				.log().all()
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
			.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				
				Assert.assertEquals(js.getString("Envelope.Body.ValidateCustomerRefreshTokenResponse.ValidateCustomerRefreshTokenResult.IsValid"), "true");
			
	}
	@Test(priority = 2)
	public void verifyInValidateRefreshToken(){
		String customerId = prop.getProperty("MemberId1");
		
		//refreshToken = ReusableMethods.CustomerRefreshToken(companyId, customerId);
		Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/ValidateCustomerRefreshToken","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.ValidateCustomerRefreshToken(companyId, customerId, refreshToken))
				.log().all()
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
			.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				
				Assert.assertEquals(js.getString("Envelope.Body.ValidateCustomerRefreshTokenResponse.ValidateCustomerRefreshTokenResult.IsValid"), "false");
			
	}

}
