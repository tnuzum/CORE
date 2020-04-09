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

public class GetClubAcceptedCreditCards extends base {
	
	static String companyId;
	static String clubId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		clubId = prop.getProperty("X-Club1Id");
	}
	
	@Test (testName="Get Cards")
	public void getCards() {
		
		 Response res = given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetClubAcceptedCreditCards","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CorporateInfoPL.GetClubAcceptedCreditCards(companyId, clubId))
         .when()
         	.post("/Info/CorporateInfo.svc")
         .then()
 //        	.log().body()
         	.statusCode(200)
         	.extract().response();
         	
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			Assert.assertEquals(js.getString("Envelope.Body.GetClubAcceptedCreditCardsResponse.GetClubAcceptedCreditCardsResult.CreditCardTypeDte[0]"),"Visa");
			Assert.assertEquals(js.getString("Envelope.Body.GetClubAcceptedCreditCardsResponse.GetClubAcceptedCreditCardsResult.CreditCardTypeDte[1]"),"MasterCard");
}
	}


