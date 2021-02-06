package messagingService;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.MessagingServicePL;
import payloads.SchedulingPL;
import resources.ReusableDates;
import resources.ReusableMethods;
import resources.base;

public class SendAppointmentCancellationConfirmations extends base{

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
		String dateTime = ReusableMethods.getTomorrowsDate()+"T14:00:00";
		
		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId, dateTime);
		
		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);
		
		 System.out.println("Id = "+appointmentId);
				
		 given() .headers("SOAPAction", "http://tempuri.org/IMessagingService/SendAppointmentCancellationConfirmations","Content-Type","text/xml; charset=utf-8") .and()
				  .body(MessagingServicePL.SendAppointmentCancellationConfirmations(companyId, appointmentId)) 
				  .when()
				  .post("/Messaging/MessagingService.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(200).extract().response();
			
		      
	}
	
	@Test(priority = 2)
	public void appointmentIsNotCancelled() {
		
		String customerId = prop.getProperty("apptMemberId");
		String itemId= prop.getProperty("PerMbrNoFees");
		String clubId = prop.getProperty("X-Club4Id");
		String bookId =  prop.getProperty("bookId");
		String dateTime = ReusableMethods.getTomorrowsDate()+"T15:00:00";
		
		appointmentId = ReusableMethods.scheduleSingleMbrAppointment(companyId, customerId, clubId, itemId, bookId, dateTime);
	
	    System.out.println("Id = "+appointmentId);
				
		Response res =  given() .headers("SOAPAction", "http://tempuri.org/IMessagingService/SendAppointmentCancellationConfirmations","Content-Type","text/xml; charset=utf-8") .and()
				  .body(MessagingServicePL.SendAppointmentCancellationConfirmations(companyId, appointmentId)) 
				  .when()
				  .post("/Messaging/MessagingService.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(400).extract().response();
		
		XmlPath xp = ReusableMethods.rawToXML(res);
		
		Assert.assertEquals(xp.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message"), "appointmentId: "+appointmentId+" is not valid or is not cancelled.");
		
		ReusableMethods.CancelAppointmentByAppointmentId(companyId, appointmentId);   
	}
	
	@Test(priority = 3)
	public void appointmentIdIsNotValid() {
				
		appointmentId = "1234";
	  
				
		Response res =  given() .headers("SOAPAction", "http://tempuri.org/IMessagingService/SendAppointmentCancellationConfirmations","Content-Type","text/xml; charset=utf-8") .and()
				  .body(MessagingServicePL.SendAppointmentCancellationConfirmations(companyId, appointmentId)) 
				  .when()
				  .post("/Messaging/MessagingService.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(400).extract().response();
		
		XmlPath xp = ReusableMethods.rawToXML(res);
		
		Assert.assertEquals(xp.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message"), "appointmentId: "+appointmentId+" is not valid or is not cancelled.");
		
		
	}
}
