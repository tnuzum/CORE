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

public class GetClubInfoTest extends base {
	
	static String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Get Club Info")
	public void getClubInfo() {
		
		 Response res = given()
         	.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetClubInfo","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CorporateInfoPL.GetClubInfo(companyId))
         .when()
         	.post("/Info/CorporateInfo.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
         	
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertNotNull(js.getString("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.Address.AddressLine1"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.Address.City"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.Address.PostalCode"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.Address.StateProvince"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.ClubNumber"));   
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.Inactive"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.Name"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.OnlineMemberSettings.AllowBookings"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.OnlineMemberSettings.AllowMemberSearch"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.OnlineMemberSettings.AllowStoredCardPayment"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.OnlineMemberSettings.NewCardHouseAccountDefault"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.OnlineMemberSettings.NewCardInClubPurchaseDefault"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.OnlineMemberSettings.RestrictBookingToPunchcardOnly"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.OnlineMemberSettings.SaveNewCardDefault"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.OnlineMemberSettings.ViewAppointments"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.OnlineMemberSettings.ViewAppointments"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.OnlineMemberSettings.ViewAppointments"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.OnlineMemberSettings.ViewAppointments"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.PhoneNumber"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetClubsInfoResponse.GetClubInfoResult.TimeZoneSerialized"));
}
	}


