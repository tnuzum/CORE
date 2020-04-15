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

public class GetClubInfo extends base {
	
	static String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		
	}
	
	@Test (testName="Get Club 1 Info")
	public void getClub1Info() {
		
		String c = prop.getProperty("club1Id");
		int clubId = Integer.parseInt(c);
		String clubName = prop.getProperty("club1Name");
		
		 Response res = given()
         	.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetClubInfo","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CorporateInfoPL.GetClubInfo(companyId, clubId))
         .when()
         	.post("/Info/CorporateInfo.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
         	
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			Assert.assertEquals(js.getInt("Envelope.Body.GetClubInfoResponse.GetClubInfoResult.ClubNumber"), clubId);
			Assert.assertEquals(js.getString("Envelope.Body.GetClubInfoResponse.GetClubInfoResult.Name"),clubName);
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetClubInfoResponse.GetClubInfoResult.Inactive"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetClubInfoResponse.GetClubInfoResult.PrivacyPolicyUrl"), "https://jonasfitness.com/privacy-policy/");
}
	
	@Test (testName="Get Club 2 Info")
	public void getClub2Info() {
		
		String c = prop.getProperty("club2Id");
		int clubId = Integer.parseInt(c);
		String clubName = prop.getProperty("club2Name");
		
		 Response res = given()
         	.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetClubInfo","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CorporateInfoPL.GetClubInfo(companyId, clubId))
         .when()
         	.post("/Info/CorporateInfo.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
         	
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			Assert.assertEquals(js.getInt("Envelope.Body.GetClubInfoResponse.GetClubInfoResult.ClubNumber"), clubId);
			Assert.assertEquals(js.getString("Envelope.Body.GetClubInfoResponse.GetClubInfoResult.Name"),clubName);
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetClubInfoResponse.GetClubInfoResult.Inactive"), false);
}
	
	@Test (testName="Custom Privacy Policy")
	public void customPrivacyPolicy() {
		
		String companyId = "202";
		String c = prop.getProperty("club1Id");
		int clubId = Integer.parseInt(c);
		
		 Response res = given()
         	.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetClubInfo","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CorporateInfoPL.GetClubInfo(companyId, clubId))
         .when()
         	.post("/Info/CorporateInfo.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
         	
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			Assert.assertEquals(js.getString("Envelope.Body.GetClubInfoResponse.GetClubInfoResult.PrivacyPolicyUrl"), "http://www.google.com/");
}
	
	@Test (testName="Inactive Club")
	public void inactiveClub() {
		
		String c = prop.getProperty("inactiveClubId");
		int clubId = Integer.parseInt(c);
		String clubName = prop.getProperty("inactiveClubName");
		
		 Response res = given()
         	.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetClubInfo","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CorporateInfoPL.GetClubInfo(companyId, clubId))
         .when()
         	.post("/Info/CorporateInfo.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
         	
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			Assert.assertEquals(js.getInt("Envelope.Body.GetClubInfoResponse.GetClubInfoResult.ClubNumber"), clubId);
			Assert.assertEquals(js.getString("Envelope.Body.GetClubInfoResponse.GetClubInfoResult.Name"),clubName);
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetClubInfoResponse.GetClubInfoResult.Inactive"), true);
}
	}


