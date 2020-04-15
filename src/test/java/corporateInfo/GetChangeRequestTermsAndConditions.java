package corporateInfo;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CorporateInfoPL;
import resources.ReusableMethods;
import resources.base;

public class GetChangeRequestTermsAndConditions extends base {
	
	String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Get Change Request Terms And Conditions")
	public void getChangeRequestTermsAndConditions() {
		
		Response res = given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetChangeRequestTermsAndConditions","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.GetChangeRequestTermsAndConditions(companyId))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertEquals(js.getString("Envelope.Body.GetChangeRequestTermsAndConditionsResponse.GetChangeRequestTermsAndConditionsResult"), "By signing below you are authorizing the above noted changes to your membership account. All changes will go into effect immediately unless otherwise noted.");
		
		
	}
	
}


