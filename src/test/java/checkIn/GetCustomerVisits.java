package checkIn;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CheckInPL;
import resources.ReusableMethods;
import resources.base;

public class GetCustomerVisits extends base{
	String companyId;
	@BeforeTest
	public void getdata()
	{
		base.getPropertyData();
		RestAssured.baseURI =prop.getProperty("baseURI");
		companyId= prop.getProperty("X-CompanyId");
	}
	
	@Test(priority=1, testName= "customerVisits")
	public void customerVisits()
	{
		String customerId = prop.getProperty("MemberId");
		String startDateTime = "2021-01-18"; 
		String startOffset = "0";
		String endDateTime = "2021-09-18";
		String endOffset = "0";
	//	String tomorrowsDate = ReusableMethods.getTomorrowsDate()+"T21:00:00Z";
		//T21:15:05.393Z
		
		
		Response res =	 given()

			  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/GetCustomerVisits","Content-Type", "text/xml; charset=utf-8")
			  	.and()
			  	.body(CheckInPL.GetCustomerVisits(companyId, customerId,startDateTime, startOffset, endDateTime, endOffset))
			  	.when()
			  	.post("/Visits/CheckIn.svc")
			  	.then()
			  // .log().all()
			   .statusCode(200)
			  // .time(lessThan(60L),TimeUnit.SECONDS)
			   	.extract().response();
				XmlPath js = ReusableMethods.rawToXML(res);
				Assert.assertTrue(res.getTime() >= 60L);
				
			Assert.assertNotNull(js.get("Envelope.Body.GetCustomerVisitsResponse.GetCustomerVisitsResult.CheckInDto.CheckInDate"));	
			Assert.assertNotNull(js.get("Envelope.Body.GetCustomerVisitsResponse.GetCustomerVisitsResult.CheckInDto.CheckInDate.DateTime"));
			Assert.assertNotNull(js.get("Envelope.Body.GetCustomerVisitsResponse.GetCustomerVisitsResult.CheckInDto.CheckInDate.OffsetMinutes"));
			Assert.assertNotNull(js.get("Envelope.Body.GetCustomerVisitsResponse.GetCustomerVisitsResult.CheckInDto.ClubName"));	
			Assert.assertNotNull(js.get("Envelope.Body.GetCustomerVisitsResponse.GetCustomerVisitsResult.CheckInDto.ClubNumber"));	
			Assert.assertNotNull(js.get("Envelope.Body.GetCustomerVisitsResponse.GetCustomerVisitsResult.CheckInDto.Description"));	
			
	}

}
