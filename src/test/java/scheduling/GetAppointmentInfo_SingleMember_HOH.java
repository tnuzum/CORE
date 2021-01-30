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

public class GetAppointmentInfo_SingleMember_HOH extends base {

	static String companyId;
	static String appointmentId;

	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");

		companyId = prop.getProperty("X-CompanyId");
	}

	@Test(priority = 1)
	public void PerMemberSingleChngeFeeCncelFee() {

		String customerId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String itemId = prop.getProperty("PerMemberChngeFeeCncelFee");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T14:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HOHcustomerId, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
//				.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"), "false");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerMemberChngeFeeCncelFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "CancelFee ChangeFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"),
				"Cancellation Fee1");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.Amount"),
				"11.20"); //Verifying that the Fee amount is based on primary member's membership discount

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 2)
	public void PerMbrSingleNoFeesWindow() {

		String customerId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String itemId = prop.getProperty("PerMbrNoFeesWindow");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T15:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HOHcustomerId, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				//.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"), "false");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerMbrNoFeesWindow");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");
		
		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 3)
	public void PerMbrSingleCancelFee() {

		String customerId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String itemId = prop.getProperty("PerMbrCancelFee");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T16:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HOHcustomerId, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
			//	.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"),	"false");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerMbrCancelFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "CancelFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"),	"Cancellation Fee");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 4)
	public void PerMbrSingleChangeFee() {

		String customerId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String itemId = prop.getProperty("PerMbrChangeFee");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T17:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HOHcustomerId, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				//.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"),	"false");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerMbrChangeFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "ChangeFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"), "Cancellation Fee");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 5)
	public void PerMbrSingleCannotCancelFromEME() {

		String customerId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String itemId = prop.getProperty("PerMbrCannotCancelFromEME");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T18:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HOHcustomerId, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				//.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"),	"false");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerMbrCannotCancelFromEME");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"),"NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"),"None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}
	
	//****************************************//
	
	@Test(priority = 6)
	public void PerApptSingleChngeFeeCncelFee() {

		String customerId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String itemId = prop.getProperty("PerApptChngeFeeCncelFee");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T19:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HOHcustomerId, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
//				.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"), "true");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerApptChngeFeeCncelFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "CancelFee ChangeFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"),
				"Cancellation Fee1");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.Amount"),
				"11.20"); //Verifying that the Fee amount is based on primary member's membership discount

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 7)
	public void PerAptSingleNoFeesWindow() {

		String customerId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String itemId = prop.getProperty("PerAptNoFeesWindow");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T20:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HOHcustomerId, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				//.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"), "true");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerAptNoFeesWindow");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");
		
		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 8)
	public void PerAptSingleCancelFee() {

		String customerId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String itemId = prop.getProperty("PerAptCancelFee");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T21:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HOHcustomerId, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				//.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"),	"true");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerAptCancelFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "CancelFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"),	"Cancellation Fee");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 9)
	public void PerAptSingleChangeFee() {

		String customerId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String itemId = prop.getProperty("PerAptChangeFee");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T22:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HOHcustomerId, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				//.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"),	"true");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerAptChangeFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "ChangeFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"), "Cancellation Fee");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 10)
	public void PerAptSingleCannotCancelFromEME() {

		String customerId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String itemId = prop.getProperty("PerAptCannotCancelFromEME");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T23:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HOHcustomerId, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				//.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"),	"true");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerAptCannotCancelFromEME");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"),"NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"),"None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);


}
	
	@Test(priority = 11)
	public void apptAlreadyCancelled() {

		String customerId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String itemId = prop.getProperty("PerMemberChngeFeeCncelFee");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T13:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);
		
		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HOHcustomerId, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				//.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"), "false");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerMemberChngeFeeCncelFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "NotAllowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"), "NotAllowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "CancelFee ChangeFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"),
				"Cancellation Fee");

		

	}
	
	@Test(priority = 12)
	public void membershipTypeRestrictionsMbr() {

		String customerId = prop.getProperty("membershipTypeRestrictionsMbr");
		String HOHcustomerId = prop.getProperty("HohOfmembershipTypeRestrictionsMbr");
		String itemId = prop.getProperty("PerApptChngeFeeCncelFee");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T22:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);
		
	

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HOHcustomerId, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				//.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"), "true");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerApptChngeFeeCncelFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"), "NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "CancelFee ChangeFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"),
				"Cancellation Fee");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);
		
	}
	
	@Test(priority = 13)
	public void PerMbrSingleNoFees() {

		String customerId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String itemId = prop.getProperty("PerMbrNoFees");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T15:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HOHcustomerId, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				//.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"), "false");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerMbrNoFees");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");
		
		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}
	
	@Test(priority = 14)
	public void PerAptSingleNoFees() {

		String customerId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String itemId = prop.getProperty("PerAptNoFees");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T15:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HOHcustomerId, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				//.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"), "true");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerAptNoFees");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");
		
		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}



	
}
