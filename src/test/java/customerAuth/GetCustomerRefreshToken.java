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

public class GetCustomerRefreshToken extends base{
	static String companyId;

	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	@Test(priority = 1)
	public void verifyCustomerRefreshToken(){
		String customerId = prop.getProperty("MemberId1");

		Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/ICustomerAuth/GetCustomerRefreshToken","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CustomerAuthPL.GetCustomerRefreshToken(companyId, customerId))
			.when()
				.post("/Auth/CustomerAuth.svc")
			.then()
			.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
						
				Assert.assertTrue(res.getTime() >= 60L);
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRefreshTokenResponse.GetCustomerRefreshTokenResult"));
				String RefreshToken= js.getString("Envelope.Body.GetCustomerRefreshTokenResponse.GetCustomerRefreshTokenResult");
				System.out.println(RefreshToken);

}
}
