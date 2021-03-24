package bookView;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.BookViewPL;
import resources.ReusableMethods;
import resources.base;

public class GetAvailableResourceTypesByClub extends base {
String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (priority = 1, testName="AvailableResourceTypeByClub")
	public void AvailableResourceTypeByClub() {
		String clubID = prop.getProperty("X-Club1Id");
		 Response res =  given()
		    		.headers("SOAPAction", "http://tempuri.org/IBookView/GetAvailableResourceTypesByClub","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(BookViewPL.getAvailableResourceTypesByClub(companyId, clubID))
		         .when()
		            .post("/BookView/BookView.svc")
		         .then()
	            	//.log().all()
	            	 .statusCode(200)
	 	            .extract().response();
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		Assert.assertTrue(res.getTime() >= 60L);
	       		Assert.assertNotNull(js.get("Envelope.Body.GetAvailableResourceTypesByClubResponse.GetAvailableResourceTypesByClubResult.AvailableResourceTypeDto.ResourceTypeDescription"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetAvailableResourceTypesByClubResponse.GetAvailableResourceTypesByClubResult.AvailableResourceTypeDto.ResourceTypeId"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetAvailableResourceTypesByClubResponse.GetAvailableResourceTypesByClubResult.AvailableResourceTypeDto.ResourceTypeName"));
	}
}
