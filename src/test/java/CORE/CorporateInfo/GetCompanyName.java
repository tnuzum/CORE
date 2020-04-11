package CORE.CorporateInfo;

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

public class GetCompanyName extends base {
	
	String companyId;
	String companyName;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		companyName = prop.getProperty("CompanyName");
	}
	
	@Test (testName="Get Company Name")
	public void getCompanyName() {
		
		Response res = given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetCompanyName","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.GetCompanyName(companyId))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertEquals(js.getString("Envelope.Body.GetCompanyNameResponse.GetCompanyNameResult"), companyName);
	
	}
	
}


