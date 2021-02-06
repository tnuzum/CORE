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

public class CancelAppointmentByAppointmentId extends base{

	static String companyId;
	static String appointmentId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test(priority = 1)
	public void cancelAppointmentByAppointmentId() {
		
		String customerId = prop.getProperty("apptMemberId");
		String itemId= prop.getProperty("PerMbrNoFees");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId =  prop.getProperty("bookId");
//		String dateTime = ReusableDates.getCurrentDate();
		String dateTime = ReusableMethods.getTomorrowsDate()+"T14:00:00";
		
		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId, dateTime);
		
		 System.out.println("Id = "+appointmentId);
				
		Response res =  given() .headers("SOAPAction", "http://tempuri.org/IScheduling/CancelAppointmentByAppointmentId","Content-Type","text/xml; charset=utf-8") .and()
				  .body(SchedulingPL.cancelAppointmentByAppointmentId(companyId, appointmentId)) 
				  .when()
				  .post("//Visits/Scheduling.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(200).extract().response();
		
		XmlPath xp = ReusableMethods.rawToXML(res);
		
		Assert.assertEquals(xp.getString("Envelope.Body.CancelAppointmentByAppointmentIdResponse.CancelAppointmentByAppointmentIdResult"), "C"+appointmentId);
		
		      
	}
}
