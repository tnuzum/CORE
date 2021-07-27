package checkIn;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CheckInPL;

import resources.ReusableMethods;
import resources.base;

public class GetAvailablePunchcardsForMember extends base {
static String comapnayId;

	@BeforeTest
	public void getData()
	{
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		comapnayId = prop.getProperty("X-CompanyId");
	}

@Test(priority = 1, testName="available punchCards for member")
public void GetAvailablePunchesForMember() {
	String customerId = prop.getProperty("MemberId");
	
	Response res =	 given()

		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/GetAvailablePunchcardsForMember","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.GetAvailablePunchcardsForMember(comapnayId, customerId))
		  	.when()
		  	.post("/Visits/CheckIn.svc")
		  	.then()
		//   .log().all()
		   .statusCode(200)
		  // .time(lessThan(60L),TimeUnit.SECONDS)
		   	.extract().response();
			XmlPath js = ReusableMethods.rawToXML(res);
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailablePunchcardsForMemberResponse.GetAvailablePunchcardsForMemberResult.PunchcardSummaryInfoDto.ExpirationDate"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailablePunchcardsForMemberResponse.GetAvailablePunchcardsForMemberResult.PunchcardSummaryInfoDto.InvoiceNumber"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailablePunchcardsForMemberResponse.GetAvailablePunchcardsForMemberResult.PunchcardSummaryInfoDto.PackageName"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailablePunchcardsForMemberResponse.GetAvailablePunchcardsForMemberResult.PunchcardSummaryInfoDto.PackagePrice"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailablePunchcardsForMemberResponse.GetAvailablePunchcardsForMemberResult.PunchcardSummaryInfoDto.PunchcardType"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailablePunchcardsForMemberResponse.GetAvailablePunchcardsForMemberResult.PunchcardSummaryInfoDto.PurchaseDate"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailablePunchcardsForMemberResponse.GetAvailablePunchcardsForMemberResult.PunchcardSummaryInfoDto.SaleClubNumber"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailablePunchcardsForMemberResponse.GetAvailablePunchcardsForMemberResult.PunchcardSummaryInfoDto.SoldInEme"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailablePunchcardsForMemberResponse.GetAvailablePunchcardsForMemberResult.PunchcardSummaryInfoDto.TotalUnitsRedeemed"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailablePunchcardsForMemberResponse.GetAvailablePunchcardsForMemberResult.PunchcardSummaryInfoDto.UnitsPurchased"));
			Assert.assertNotNull(js.get("Envelope.Body.GetAvailablePunchcardsForMemberResponse.GetAvailablePunchcardsForMemberResult.PunchcardSummaryInfoDto.UnitsRemaining"));
				
}

}

