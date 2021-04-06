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
	String valueAssertions;
	XmlPath js;
	
	String agreementCategory1Id;
	String agreementCategory1Description;
	String agreementCategory2Id;
	String agreementCategory2Description;
	String agreementCategory3Id;
	String agreementCategory3Description;
	String agreementCategory4Id;
	String agreementCategory4Description;
	String agreementCategory5Id;
	String agreementCategory5Description;
	String agreementCategory6Id;
	String agreementCategory6Description;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		companyId = prop.getProperty("X-CompanyId");
		valueAssertions = prop.getProperty("valueAssertions");
		
		agreementCategory1Id = prop.getProperty("agreementCategory1Id");
		agreementCategory1Description = prop.getProperty("agreementCategory1Description");
		agreementCategory2Id = prop.getProperty("agreementCategory2Id");
		agreementCategory2Description = prop.getProperty("agreementCategory2Description");
		agreementCategory3Id = prop.getProperty("agreementCategory3Id");
		agreementCategory3Description = prop.getProperty("agreementCategory3Description");
		agreementCategory4Id = prop.getProperty("agreementCategory4Id");
		agreementCategory4Description = prop.getProperty("agreementCategory4Description");
		agreementCategory5Id = prop.getProperty("agreementCategory5Id");
		agreementCategory5Description = prop.getProperty("agreementCategory5Description");
		agreementCategory6Id = prop.getProperty("agreementCategory6Id");
		agreementCategory6Description = prop.getProperty("agreementCategory6Description");
	}
	
	@Test (testName="Agreement Categories Found", description = "PBI: 179761")
	public void agreementCategoriesFound() {
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetAgreementCategories",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getAgreementCategories(companyId))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertNotNull(js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse[0].Id"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse[0].Description"));
			
		if (valueAssertions.equals("true")) {
				// Note: this response is in Alphabetical Order by Description
			Assert.assertEquals(agreementCategory1Id, js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse[0].Id"));
			Assert.assertEquals(agreementCategory1Description, js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse[0].Description"));
			Assert.assertEquals(agreementCategory2Id, js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse[1].Id"));
			Assert.assertEquals(agreementCategory2Description, js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse[1].Description"));
			Assert.assertEquals(agreementCategory3Id, js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse[2].Id"));
			Assert.assertEquals(agreementCategory3Description, js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse[2].Description"));
			Assert.assertEquals(agreementCategory4Id, js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse[3].Id"));
			Assert.assertEquals(agreementCategory4Description, js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse[3].Description"));
			Assert.assertEquals(agreementCategory5Id, js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse[5].Id"));
			Assert.assertEquals(agreementCategory5Description, js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse[5].Description"));
			Assert.assertEquals(agreementCategory6Id, js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse[4].Id"));
			Assert.assertEquals(agreementCategory6Description, js.getString("Envelope.Body.GetAgreementCategoriesResponse.GetAgreementCategoriesResult.AgreementCategoryResponse[4].Description"));
			}			

	}
	
	@Test (testName="Company Not On File", description = "PBI: 179761")
	public void companyNotOnFile() {
		
		String companyId = "99999";
		
		Response res = 
				
		given()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetAgreementCategories",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getAgreementCategories(companyId))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(500)
			.extract().response();  
		
			js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(js.getString("Envelope.Body.Fault.faultcode").contains("Client"));
			Assert.assertTrue(js.getString("Envelope.Body.Fault.faultstring").contains("Exception is: KeyNotFoundException"));
		
	}
}


