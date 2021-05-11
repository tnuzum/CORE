package scheduling;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.SchedulingPL;
import resources.ReusableDates;
import resources.ReusableMethods;
import resources.base;

public class ScheduleAppointment extends base {
	
	static String companyId;
	static String appointmentId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test(priority = 1)
	public void scheduleAppointment() {
		String customerId = prop.getProperty("apptMemberId");
		String itemId= prop.getProperty("PerMbrNoFees");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId =  prop.getProperty("bookId");
//		String dateTime = ReusableDates.getCurrentDate();
		String dateTime = ReusableMethods.getTomorrowsDate()+"T14:00:00";
		
		Response res = given() .headers("SOAPAction", "http://tempuri.org/IScheduling/ScheduleAppointment","Content-Type","text/xml; charset=utf-8") .and()
				  .body(SchedulingPL.ScheduleSingleMbrAppt(companyId, customerId, clubId, itemId, bookId, dateTime)) 
				  .when()
				  .post("//Visits/Scheduling.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(200) .extract().response();
		
		         XmlPath js = ReusableMethods.rawToXML(res);
		         
		        appointmentId = js.getString("Envelope.Body.ScheduleAppointmentResponse.ScheduleAppointmentResult.AppointmentId");
		        Assert.assertNotNull(appointmentId);
		        System.out.println(appointmentId);
		        Assert.assertEquals(js.getString("Envelope.Body.ScheduleAppointmentResponse.ScheduleAppointmentResult.Result"), "Success");
		        
		        ReusableMethods.cancelAppointment(companyId, customerId, appointmentId);
	}
	
	@Test(priority = 2)
	public void scheduleGrpAppointment() {
		
		String primaryMemberId = prop.getProperty("apptMemberId");
		String groupMemberId = prop.getProperty("groupMemberId");
		String itemId= prop.getProperty("PerMbrNoFees-Grp");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId =  prop.getProperty("bookIdGrp");
//		String dateTime = ReusableDates.getCurrentDate()+"T17:00:00";
		String dateTime = ReusableMethods.getTomorrowsDate()+"T18:00:00";
		
		Response res = given() .headers("SOAPAction", "http://tempuri.org/IScheduling/ScheduleAppointment","Content-Type","text/xml; charset=utf-8") .and()
				  .body(SchedulingPL.ScheduleGroupAppt(companyId, primaryMemberId, groupMemberId, clubId, itemId, bookId, dateTime)) 
				  .when()
				  .post("//Visits/Scheduling.svc") 
				  .then() 
				  .log().all()
				  .statusCode(200) .extract().response();
		
		         XmlPath js = ReusableMethods.rawToXML(res);
		         
		        appointmentId = js.getString("Envelope.Body.ScheduleAppointmentResponse.ScheduleAppointmentResult.AppointmentId");
		        Assert.assertNotNull(appointmentId);
		        System.out.println(appointmentId);
		        Assert.assertEquals(js.getString("Envelope.Body.ScheduleAppointmentResponse.ScheduleAppointmentResult.Result"), "Success");
		        
		        ReusableMethods.cancelAppointment(companyId, primaryMemberId, appointmentId);
		
	}
	

@Test(priority = 3)
public void scheduleFamilyAppointment() {
	
	String primaryFamilyMemberId = prop.getProperty("familyMemberId1");
	String FamilyMemberId = prop.getProperty("familyMemberId2");
	String itemId= prop.getProperty("PerMbrNoFees-Grp");
	String clubId = prop.getProperty("X-Club4Id");
	String bookId =  prop.getProperty("bookIdGrp");
//	String dateTime = ReusableDates.getCurrentDate();
	String dateTime = ReusableMethods.getTomorrowsDate()+"T19:00:00";
	
	Response res = given() .headers("SOAPAction", "http://tempuri.org/IScheduling/ScheduleAppointment","Content-Type","text/xml; charset=utf-8") .and()
			  .body(SchedulingPL.ScheduleGroupAppt(companyId, primaryFamilyMemberId, FamilyMemberId, clubId, itemId, bookId, dateTime)) 
			  .when()
			  .post("//Visits/Scheduling.svc") 
			  .then() 
//			  .log().all()
			  .statusCode(200) .extract().response();
	
	         XmlPath js = ReusableMethods.rawToXML(res);
	         
	        appointmentId = js.getString("Envelope.Body.ScheduleAppointmentResponse.ScheduleAppointmentResult.AppointmentId");
	        Assert.assertNotNull(appointmentId);
	        System.out.println(appointmentId);
	        Assert.assertEquals(js.getString("Envelope.Body.ScheduleAppointmentResponse.ScheduleAppointmentResult.Result"), "Success");
	        
	        ReusableMethods.cancelAppointment(companyId, primaryFamilyMemberId, appointmentId);
	
}

}
