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

public class GetBannerMessagesForCustomer extends base{
String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		
		companyId = prop.getProperty("X-CompanyId");

}
	@Test (priority = 1, testName="Bannermessages")
	public void Bannermessages() {
	

		String customerId = prop.getProperty("BannerMessageID");
		
	       Response res =  given()
	    		.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetBannerMessagesForCustomer","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(CorporateInfoPL.GetBannerMessagesForCustomer(companyId, customerId))
	         .when()
	            .post("/Info/CorporateInfo.svc")
	         .then()
            	//.log().all()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		
	       		Assert.assertTrue(res.getTime() >= 60L);
	Assert.assertNotNull(js.getString("Envelope.Body.GetBannerMessagesForCustomerResponse.GetBannerMessagesForCustomerResult.BannerMessageDto.BannerMessageId"));
	Assert.assertNotNull(js.getString("Envelope.Body.GetBannerMessagesForCustomerResponse.GetBannerMessagesForCustomerResult.BannerMessageDto.Title"));       		
	}
}