package agreementInfo;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.AgreementInfoPL;
import resources.ReusableMethods;
import resources.base;

public class GetAgreementCategories extends base {
	
	String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Agreement Categories Found", description = "PBI: 179761")
	public void agreementCategoriesFound() {
		
		Response res = 
				
		given()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetAgreementCategories",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getAgreementCategories(companyId))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertNotNull(js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse.Id"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse.Description"));
		}			



}


