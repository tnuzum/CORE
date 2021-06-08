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

public class GetAppointmentInfo_Group_HOH extends base {

	static String companyId;
	static String appointmentId;

	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");

		companyId = prop.getProperty("X-CompanyId");
	}

	@Test(priority = 1)
	public void PerMemberGroupChngeFeeCncelFee() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerMemberChngeFeeCncelFee-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T14:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerMemberChngeFeeCncelFee-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"), "NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "CancelFee ChangeFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"),
				"Cancellation Fee1");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.Amount"),
				"14.40"); //Verifying that the Fee amount is based on primary member's membership discount

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 2)
	public void PerMbrGroupNoFeesWindow() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerMbrNoFeesWindow-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T15:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerMbrNoFeesWindow-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");
		
		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 3)
	public void PerMbrGroupCancelFee() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerMbrCancelFee-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T16:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerMbrCancelFee-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "CancelFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"),	"Cancellation Fee");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 4)
	public void PerMbrGroupChangeFee() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerMbrChangeFee-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T17:00:00";
		
		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerMbrChangeFee-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "ChangeFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"), "Cancellation Fee1");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 5)
	public void PerMbrGroupCannotCancelFromEME() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerMbrCannotCancelFromEME-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T18:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerMbrCannotCancelFromEME-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"),"NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"),"None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}
	
	//****************************************//
	
	@Test(priority = 6)
	public void PerApptGroupChngeFeeCncelFee() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerApptChngeFeeCncelFee-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T19:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerApptChngeFeeCncelFee-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "CancelFee ChangeFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"),
				"Cancellation Fee1");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.Amount"),
				"14.40"); //Verifying that the Fee amount is based on primary member's membership discount

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 7)
	public void PerAptGroupNoFeesWindow() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerAptNoFeesWindow-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T20:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerAptNoFeesWindow-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");
		
		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 8)
	public void PerAptGroupCancelFee() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerAptCancelFee-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T21:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerAptCancelFee-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "CancelFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"),	"Cancellation Fee");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 9)
	public void PerAptGroupChangeFee() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerAptChangeFee-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T22:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerAptChangeFee-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "ChangeFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"), "Cancellation Fee1");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}

	@Test(priority = 10)
	public void PerAptGroupCannotCancelFromEME() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerAptCannotCancelFromEME-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T23:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerAptCannotCancelFromEME-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"),"NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"),"None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);


}
	
	
	@Test(priority = 11)
	public void PerAptGroupCannotCancelByHohOfGrpMbr() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HohOfGrpMember = prop.getProperty("HohOfGrpMember");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerAptNoFeesWindow-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T13:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HohOfGrpMember, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
				//.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"),	"true");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerAptNoFeesWindow-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"),"NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"),"None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);


}
	
	//*******************************
	
	@Test(priority = 12)
	public void PerMbrGroupCannotCancelByHohOfGrpMbr() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HohOfGrpMember = prop.getProperty("HohOfGrpMember");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerMbrNoFeesWindow-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T12:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
				dateTime);

		System.out.println("Id = " + appointmentId);

		Response res = given()
				.headers("SOAPAction", "http://tempuri.org/IScheduling/GetAppointmentInfo", "Content-Type",
						"text/xml; charset=utf-8")
				.and().body(SchedulingPL.GetAppointmentInfo(companyId, HohOfGrpMember, appointmentId)).when()
				.post("//Visits/Scheduling.svc")
				.then()
//				.log().all()
				.statusCode(200).extract().response();

		XmlPath js = ReusableMethods.rawToXML(res);

		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"),	"false");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerMbrNoFeesWindow-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"),"NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"),"None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);


}
	
	@Test(priority = 13)
	public void apptAlreadyCancelled() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerMbrNoFeesWindow-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T12:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChargePerAppointmentBasis"),	"false");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"),	"PerMbrNoFeesWindow-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"),"NotAllowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"NotAllowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"),"None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");

		

		
}
	
	@Test(priority = 14)
	public void PerMemberGroupWithSingleMbrChngeFeeCncelFee() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
//		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerMemberChngeFeeCncelFee-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T14:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, primaryMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerMemberChngeFeeCncelFee-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "CancelFee ChangeFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"),
				"Cancellation Fee1");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}
	
	@Test(priority = 15)
	public void PerApptGroupWithSingleMbrChngeFeeCncelFee() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
//		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerApptChngeFeeCncelFee-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T15:00:00";

		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, primaryMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerApptChngeFeeCncelFee-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "CancelFee ChangeFee");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"),
				"Cancellation Fee1");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}
	@Test(priority = 16)
	public void PerMbrGroupNoFees() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerMbrNoFees-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T16:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerMbrNoFees-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");
		
		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}
	
	@Test(priority = 17)
	public void PerAptGroupNoFees() {

		String primaryMemberId = prop.getProperty("familyMemberId1");
		String HOHcustomerId = prop.getProperty("apptMemberId");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerAptNoFees-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T17:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerAptNoFees-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"),	"Allowed");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee"), "");
		
		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);

	}
	
	@Test(priority = 18)
	public void membershipTypeRestrictionsMbr() {

		String primaryMemberId = prop.getProperty("membershipTypeRestrictionsMbr");
		String HOHcustomerId = prop.getProperty("HohOfmembershipTypeRestrictionsMbr");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId = prop.getProperty("PerMbrNoFees-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId = prop.getProperty("bookIdGrp");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T21:00:00";

		appointmentId = ReusableMethods.scheduleGroupAppointment(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId,
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
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Description"), "PerMbrNoFees-Grp");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsCancellationAllowed"), "NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.IsChangeAllowed"), "NotAllowedOnline");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.FeeStatus"), "None");
		Assert.assertEquals(js.getString("Envelope.Body.GetAppointmentInfoResponse.GetAppointmentInfoResult.Fee.ItemDescription"),
				"");

		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);
		
	}
	
	
	
	
}
