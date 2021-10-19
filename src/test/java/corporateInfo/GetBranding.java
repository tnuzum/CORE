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

public class GetBranding extends base {
	
	String companyId;
	String clubId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		clubId = prop.getProperty("club1Id");
	}
	
	@Test (testName="Get EME Branding")
	public void getEMEBranding() {
		
		String brandingFilter = "EME";
		
		Response res = given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetBranding","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.GetBranding(companyId, clubId, brandingFilter))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
		
		XmlPath js = ReusableMethods.rawToXML(res);
		
		Assert.assertTrue(res.getTime() >= 60L);
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_BannerBGColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_BoxHeadingBGColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_BoxHeadingFontColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_BtnBGColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_BtnFontColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_FeatureCalloutBGColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_FeatureHeadingFontColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_HeadingColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_LogoFileName"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_MenuActiveBG"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_MenuActiveBGFont"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_MenuBGColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_MenuFontColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_MenuFontROColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_MenuRollOverBG"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_PageBGcolor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_ProspectBtnBGColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_ProspectBtnFontColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("GBL_NotifyClubEmail"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("GBL_NotifyClubOnSales"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("GBL_SellAddOns"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("GBL_SendContractViaEmail"));
			
	}
	
	@Test (testName="Get JOL Branding")
	public void getJOLBranding() {
		
		String brandingFilter = "JOL";
		
		Response res = given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetBranding","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.GetBranding(companyId, clubId, brandingFilter))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
		
		XmlPath js = ReusableMethods.rawToXML(res);
		
		Assert.assertTrue(res.getTime() >= 60L);
		
		Assert.assertTrue(res.getTime() >= 60L);
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_BannerBGColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_BoxHeadingBGColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_BoxHeadingFontColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_BtnBGColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_BtnFontColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_FeatureCalloutBGColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_FeatureHeadingFontColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_HeadingColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_LogoFileName"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_MenuActiveBG"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_MenuActiveBGFont"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_MenuBGColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_MenuFontColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_MenuFontROColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_MenuRollOverBG"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_PageBGcolor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_ProspectBtnBGColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("BRND_ProspectBtnFontColor"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("GBL_NotifyClubEmail"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("GBL_NotifyClubOnSales"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("GBL_SellAddOns"));
		Assert.assertTrue(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring.Key").contains("GBL_SendContractViaEmail"));	
	}
	
}


