package corporateInfo;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.lessThan;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CorporateInfoPL;
import resources.ReusableMethods;
import resources.base;
import resources.myGets;

public class Vita_SetBusinessIntelligenceConfiguration extends base {
	
	String companyId;
	String clubId;
	String clubName;
	String clubIsSelected;
	String bICompanyId;
	String timeFrame;
	String timeFrameUnits;
	String isActivated;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		clubId = prop.getProperty("X-Club1Id");
		clubName = prop.getProperty("club1Name");
		clubIsSelected = "true";
		bICompanyId = prop.getProperty("X-CompanyId");
		timeFrame = "1";
		timeFrameUnits = "1";
		isActivated = "true";
	}
	
	@Test (testName="Set All Parameters Test 1", description = "PBI: 164526")
	public void setAllParametersTest1() {
		
			String isSelected = "false";
			String bICompanyId = prop.getProperty("X-CompanyId");
			String timeFrame = "5";
			String timeFrameUnits = "5";
			String isActivated = "false";
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_AllParameters(companyId, clubId, clubName, isSelected, bICompanyId, timeFrame, timeFrameUnits, isActivated))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
		
		// ** Validate field was updated correctly
		
		Response res	=	myGets.getProjectConfiguration(companyId);
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].ClubId"), clubId);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].ClubName"), clubName);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].IsSelected"), isSelected);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.CompanyId"), companyId);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.DataStorageTimeframe"), timeFrame);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.DataStorageTimeframeUnits"), timeFrameUnits);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.IsActivated"), isActivated);
	}	
	
	@Test (testName="Set All Parameters Test 2", description = "PBI: 164526")
	public void setAllParametersTest2() {
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_AllParameters(companyId, clubId, clubName, clubIsSelected, bICompanyId, timeFrame, timeFrameUnits, isActivated))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
		
		// ** Validate field was updated correctly
		
		Response res	=	myGets.getProjectConfiguration(companyId);
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].ClubId"), clubId);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].ClubName"), clubName);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].IsSelected"), clubIsSelected);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.CompanyId"), companyId);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.DataStorageTimeframe"), timeFrame);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.DataStorageTimeframeUnits"), timeFrameUnits);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.IsActivated"), isActivated);
	}	
	
	@Test (testName="Set All Parameters Multiple Clubs", description = "PBI: 164526")
	public void setAllParametersMultipleClubs() {
		
			String club2Id = prop.getProperty("club2Id");
			String club2Name = prop.getProperty("club2Name");
			String club2IsSelected = "true";
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_MultipleClubs(companyId, clubId, clubName, clubIsSelected, club2Id, club2Name, club2IsSelected, bICompanyId, timeFrame, timeFrameUnits, isActivated))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
		
		// ** Validate field was updated correctly
		
		Response res	=	myGets.getProjectConfiguration(companyId);
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].ClubId"), clubId);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].ClubName"), clubName);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].IsSelected"), clubIsSelected);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[1].ClubId"), club2Id);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[1].ClubName"), club2Name);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[1].IsSelected"), club2IsSelected);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.CompanyId"), companyId);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.DataStorageTimeframe"), timeFrame);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.DataStorageTimeframeUnits"), timeFrameUnits);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.IsActivated"), isActivated);
	}
	
	@Test (testName="Set IsActivated", description = "PBI: 164526")
	public void setIsActivated() {
						
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_IsActivated(companyId, isActivated))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
		
		// ** Validate field was updated correctly
		
		Response res	=	myGets.getProjectConfiguration(companyId);
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.CompanyId"), companyId);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.IsActivated"), isActivated);
	}
	
	@Test (testName="Company is Deactivated", description = "PBI: 164526")
	public void companyIsDeactivated() {
		
			String isActivated = "false";
						
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_IsActivated(companyId, isActivated))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
		
		// ** Validate field was updated correctly
		
		Response res	=	myGets.getProjectConfiguration(companyId);
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.CompanyId"), companyId);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.IsActivated"), isActivated);
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].IsSelected"), false); //this is set to false when company is deactivated
	}
	
	@Test (testName="Set Time Frame", description = "PBI: 164526")
	public void setTimeFrame() {
		
		String timeFrame = "7";
						
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_TimeFrame(companyId, timeFrame))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
		
		// ** Validate field was updated correctly
		
		Response res	=	myGets.getProjectConfiguration(companyId);
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.CompanyId"), companyId);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.DataStorageTimeframe"), timeFrame);
	}
	
	@Test (testName="Set Time Frame Units", description = "PBI: 164526")
	public void setTimeFrameUnits() {
		
		String timeFrameUnits = "2";
						
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_TimeFrameUnits(companyId, timeFrameUnits))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
		
		// ** Validate field was updated correctly
		
		Response res	=	myGets.getProjectConfiguration(companyId);
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.CompanyId"), companyId);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.DataStorageTimeframeUnits"), timeFrameUnits);
	}
	
	@Test (testName="Club Is Selected", description = "PBI: 164526")
	public void clubIsSelected() {
		
		String isSelected = "true";
						
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_ClubIsSelected(companyId, clubId, isSelected))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
		
		// ** Validate field was updated correctly
		
		Response res	=	myGets.getProjectConfiguration(companyId);
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.CompanyId"), companyId);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].ClubId"), clubId);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].IsSelected"), isSelected);
	}
	
	@Test (testName="Club Is Not Selected", description = "PBI: 164526")
	public void clubIsNotSelected() {
		
		String isSelected = "false";
						
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_ClubIsSelected(companyId, clubId, isSelected))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
		
		// ** Validate field was updated correctly
		
		Response res	=	myGets.getProjectConfiguration(companyId);
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.CompanyId"), companyId);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].ClubId"), clubId);
			Assert.assertEquals(js.getString("Envelope.Body.GetBusinessIntelligenceConfigurationResponse.GetBusinessIntelligenceConfigurationResult.ClubSelection.BIClubSelectionDto[0].IsSelected"), isSelected);
	}
	
	@Test (testName="Club Id Null", description = "PBI: 164526")
	public void clubIdNull() {
		
			String clubId = prop.getProperty("NOF");
			
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_AllParameters(companyId, clubId, clubName, clubIsSelected, bICompanyId, timeFrame, timeFrameUnits, isActivated))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(500)
			.statusLine("HTTP/1.1 500 Internal Server Error")
			.extract().response();
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto[0]").contains("The value 'null' cannot be parsed"));
	}
	
	@Test (testName="Club Is Select Null", description = "PBI: 164526")
	public void clubIsSelectedNull() {
		
			String isSelected = prop.getProperty("NOF");
			
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_AllParameters(companyId, clubId, clubName, isSelected, bICompanyId, timeFrame, timeFrameUnits, isActivated))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(500)
			.statusLine("HTTP/1.1 500 Internal Server Error")
			.extract().response();
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto[0]").contains("The value 'null' cannot be parsed"));
	}
	
	@Test (testName="BI Club Is Null", description = "PBI: 164526")
	public void bIClubIsSelectedNull() {
		
			String bICompanyId = prop.getProperty("NOF");
			
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_AllParameters(companyId, clubId, clubName, clubIsSelected, bICompanyId, timeFrame, timeFrameUnits, isActivated))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(500)
			.statusLine("HTTP/1.1 500 Internal Server Error")
			.extract().response();
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto[0]").contains("The value 'null' cannot be parsed"));
	}
	
	@Test (testName="Time Frame Null", description = "PBI: 164526")
	public void timeFrameNull() {
		
			String timeFrame = prop.getProperty("NOF");
			
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_AllParameters(companyId, clubId, clubName, clubIsSelected, bICompanyId, timeFrame, timeFrameUnits, isActivated))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(500)
			.statusLine("HTTP/1.1 500 Internal Server Error")
			.extract().response();
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto[0]").contains("The value 'null' cannot be parsed"));
	}
	
	@Test (testName="Time Frame UnitsNull", description = "PBI: 164526")
	public void timeFrameUnitsNull() {
		
			String timeFrameUnits = prop.getProperty("NOF");
			
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_AllParameters(companyId, clubId, clubName, clubIsSelected, bICompanyId, timeFrame, timeFrameUnits, isActivated))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(500)
			.statusLine("HTTP/1.1 500 Internal Server Error")
			.extract().response();
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto[0]").contains("The value 'null' cannot be parsed"));
	}
	
	@Test (testName="Is Activated UnitsNull", description = "PBI: 164526")
	public void isActivatedNull() {
		
			String isActivated = prop.getProperty("NOF");
			
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/SetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.SetBusinessIntelligenceConfiguration_AllParameters(companyId, clubId, clubName, clubIsSelected, bICompanyId, timeFrame, timeFrameUnits, isActivated))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
		    .time(lessThan(60L),TimeUnit.SECONDS)
			.statusCode(500)
			.statusLine("HTTP/1.1 500 Internal Server Error")
			.extract().response();
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto[0]").contains("The value 'null' cannot be parsed"));
	}
	
	
}


