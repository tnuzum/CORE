package Waivers;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import payloads.WaiversPL;
import resources.ReusableMethods;
import resources.base;

public class GetFamilyNeedDob extends base{
static String companyId;
	
	@BeforeTest
	public void getData() {
		
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		
	}
	@Test(priority = 1,testName="NonHOH Member-with no DOB")
		public void GetMemberNeedsDateOfBirth() {
		
		String customerId = prop.getProperty("MemberIdneedsDOB");
				String clubId = prop.getProperty("X-Club1Id");
		
	Response res =	 given()

  	.headers("SOAPAction", "http://tempuri.org/IWaivers/GetFamilyNeedsDob","Content-Type", "text/xml; charset=utf-8")
  	.and()
  	.body(WaiversPL.GetFamilyNeedDob(companyId, customerId, clubId))
  	.when()
  	.post("/Waivers/Waivers.svc")
  	.then()
 //   .log().all()
  	.statusCode(200)
  //	.time(lessThan(60L),TimeUnit.SECONDS)
   	.extract().response();
	XmlPath js = ReusableMethods.rawToXML(res);
		Assert.assertTrue(res.getTime() >= 60L);
		
		Assert.assertNotNull(js.get("Envelope.Body.GetFamilyNeedsDobResponse.GetFamilyNeedsDobResult.CustomerNeedsDobDto.CustomerId"));
		Assert.assertNotNull(js.get("Envelope.Body.GetFamilyNeedsDobResponse.GetFamilyNeedsDobResult.CustomerNeedsDobDto.DisplayName"));
	

}
	

	@Test(priority = 2, testName="HOH Member-with no DOB")
	public void GetAllFamilyNeedsDateOfBirth() {
	
	String customerId = prop.getProperty("HOHMemberIdneedsDOB");

	String clubId = prop.getProperty("X-Club1Id");
	
  Response res =	 given()

	.headers("SOAPAction", "http://tempuri.org/IWaivers/GetFamilyNeedsDob","Content-Type", "text/xml; charset=utf-8")
	.and()
	.body(WaiversPL.GetFamilyNeedDob(companyId, customerId, clubId))
	.when()
	.post("/Waivers/Waivers.svc")
	.then()
//.log().all()
	.statusCode(200)
//	.time(lessThan(60L),TimeUnit.SECONDS)
	.extract().response();
XmlPath js = ReusableMethods.rawToXML(res);
	Assert.assertTrue(res.getTime() >= 60L);
	

	Assert.assertNotNull(js.get("Envelope.Body.GetFamilyNeedsDobResponse.GetFamilyNeedsDobResult.CustomerNeedsDobDto.CustomerId"));
	Assert.assertNotNull(js.get("Envelope.Body.GetFamilyNeedsDobResponse.GetFamilyNeedsDobResult.CustomerNeedsDobDto.DisplayName"));
	Assert.assertNotNull(js.get("Envelope.Body.GetFamilyNeedsDobResponse.GetFamilyNeedsDobResult.CustomerNeedsDobDto.CustomerId"));
	Assert.assertNotNull(js.get("Envelope.Body.GetFamilyNeedsDobResponse.GetFamilyNeedsDobResult.CustomerNeedsDobDto.DisplayName"));
}

@Test(priority = 3)
	public void hohClubNeedsWaiverAndFamilyHasNoDob() {
	
	String customerId = prop.getProperty("MemberIdneedsDOB1");
    
    	String clubId = prop.getProperty("X-Club1Id");
	
  Response res =	 given()

	.headers("SOAPAction", "http://tempuri.org/IWaivers/GetFamilyNeedsDob","Content-Type", "text/xml; charset=utf-8")
	.and()
	.body(WaiversPL.GetFamilyNeedDob(companyId, customerId, clubId))
	.when()
	.post("/Waivers/Waivers.svc")
	.then()
//.log().all()
	.statusCode(200)
//	.time(lessThan(60L),TimeUnit.SECONDS)
	.extract().response();
XmlPath js = ReusableMethods.rawToXML(res);
	Assert.assertTrue(res.getTime() >= 60L);
	
int count = js.getInt("Envelope.Body.GetFamilyNeedsDobResponse.GetFamilyNeedsDobResult.CustomerNeedsDobDto.size()");
	Assert.assertEquals(count, 3);
	
for (int i = 0; i<count; i++)
		
	{
	
	Assert.assertNotNull(js.get("Envelope.Body.GetFamilyNeedsDobResponse.GetFamilyNeedsDobResult.CustomerNeedsDobDto["+i+"].CustomerId"));
	Assert.assertNotNull(js.get("Envelope.Body.GetFamilyNeedsDobResponse.GetFamilyNeedsDobResult.CustomerNeedsDobDto["+i+"].DisplayName"));

	}

}
}
