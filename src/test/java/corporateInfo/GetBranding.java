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
		
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[0].Key"), "BRND_BannerBGColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[1].Key"), "BRND_BoxHeadingBGColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[2].Key"), "BRND_BoxHeadingFontColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[3].Key"), "BRND_BtnBGColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[4].Key"), "BRND_BtnFontColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[5].Key"), "BRND_FeatureCalloutBGColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[6].Key"), "BRND_FeatureHeadingFontColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[7].Key"), "BRND_HeadingColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[8].Key"), "BRND_LogoFileName");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[9].Key"), "BRND_MenuActiveBG");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[10].Key"), "BRND_MenuActiveBGFont");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[11].Key"), "BRND_MenuBGColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[12].Key"), "BRND_MenuFontColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[13].Key"), "BRND_MenuFontROColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[14].Key"), "BRND_MenuRollOverBG");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[15].Key"), "BRND_PageBGcolor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[16].Key"), "BRND_ProspectBtnBGColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[17].Key"), "BRND_ProspectBtnFontColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[18].Key"), "GBL_NotifyClubEmail");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[19].Key"), "GBL_NotifyClubOnSales");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[20].Key"), "GBL_SellAddOns");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[21].Key"), "GBL_SendContractViaEmail");	
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
		
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[0].Key"), "BRND_BannerBGColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[1].Key"), "BRND_BoxHeadingBGColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[2].Key"), "BRND_BoxHeadingFontColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[3].Key"), "BRND_BtnBGColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[4].Key"), "BRND_BtnFontColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[5].Key"), "BRND_FeatureCalloutBGColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[6].Key"), "BRND_FeatureHeadingFontColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[7].Key"), "BRND_HeadingColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[8].Key"), "BRND_LogoFileName");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[9].Key"), "BRND_MenuActiveBG");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[10].Key"), "BRND_MenuActiveBGFont");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[11].Key"), "BRND_MenuBGColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[12].Key"), "BRND_MenuFontColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[13].Key"), "BRND_MenuFontROColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[14].Key"), "BRND_MenuRollOverBG");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[15].Key"), "BRND_PageBGcolor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[16].Key"), "BRND_ProspectBtnBGColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[17].Key"), "BRND_ProspectBtnFontColor");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[18].Key"), "GBL_NotifyClubEmail");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[19].Key"), "GBL_NotifyClubOnSales");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[20].Key"), "GBL_SellAddOns");
		Assert.assertEquals(js.getString("Envelope.Body.GetBrandingResponse.GetBrandingResult.KeyValueOfstringstring[21].Key"), "GBL_SendContractViaEmail");	
	}
	
}


