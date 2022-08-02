package checkIn;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CheckInPL;
import resources.ReusableDates;
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
		String customerId = prop.getProperty("availableId");
		String startDateTime = ReusableDates.getCurrentDateMinusXYears(2); 
		String startOffset = "0";
		String endDateTime = ReusableDates.getCurrentDatePlusXDays(1);
		String endOffset = "0";		
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/GetCustomerVisits","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.GetCustomerVisits(companyId, customerId,startDateTime, startOffset, endDateTime, endOffset))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify(); 
			System.out.println(xmlPretty);
			
			Assert.assertTrue(xmlPretty.contains("CheckInDate"));
			Assert.assertTrue(xmlPretty.contains("DateTime"));
			Assert.assertTrue(xmlPretty.contains("OffsetMinutes"));
			Assert.assertTrue(xmlPretty.contains("ClubName"));
			Assert.assertTrue(xmlPretty.contains("ClubNumber"));
			Assert.assertTrue(xmlPretty.contains("Description"));
					
	}

}
