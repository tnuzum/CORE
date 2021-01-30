package scheduling;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.SchedulingPL;
import resources.ReusableMethods;
import resources.base;

public class GetAppointmentEligibility extends base {

	static String companyId;
	

	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");

		companyId = prop.getProperty("X-CompanyId");
	}

	@Test(priority = 1)
	public void getAppointmentEligiblity_Eligible() {

		String customerId = prop.getProperty("apptHoh");
		String itemId = prop.getProperty("PerMemberChngeFeeCncelFee");
		String clubId =  prop.getProperty("club1Id");
		
		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentEligibility", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentEligibility(companyId, clubId, customerId, itemId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentEligibilityResponse.GetAppointmentEligibilityResult.CustomerEligibilityDto.EligibilityStatus"), "Eligible");

	}
	
	@Test(priority = 2)
	public void getAppointmentEligiblity_ClubAccessDenied() {

		String customerId = prop.getProperty("Kidapptmbr");
		String itemId = prop.getProperty("PerMemberChngeFeeCncelFee");
		String clubId =  prop.getProperty("club1Id");
		
		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentEligibility", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentEligibility(companyId, clubId, customerId, itemId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentEligibilityResponse.GetAppointmentEligibilityResult.CustomerEligibilityDto.EligibilityStatus"), "ClubAccessDenied");

	}
	
	@Test(priority = 3)
	public void getAppointmentEligiblity_CategoryRestricted() {

		String customerId = prop.getProperty("Kidapptmbr");
		String itemId = prop.getProperty("CatRestrctnItemId");
		String clubId =  prop.getProperty("club4Id");
		
		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentEligibility", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentEligibility(companyId, clubId, customerId, itemId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentEligibilityResponse.GetAppointmentEligibilityResult.CustomerEligibilityDto.EligibilityStatus"), "ProductAccessDenied");

	}

}
