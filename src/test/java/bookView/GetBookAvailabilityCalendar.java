package bookView;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.BookViewPL;
import resources.ReusableMethods;
import resources.base;

public class GetBookAvailabilityCalendar extends base {
String companyId;
	
	@BeforeTest
	public void getData(){
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test  (priority = 1, testName="BookAvailabilityCalendar")
	public void BookAvailabilityCalendar() 
		{
			String bookID = prop.getProperty("bookID");
			String clubID = prop.getProperty("X-Club1Id");
			String resourceTypeId = prop.getProperty("resourceTypeId");
			Response res =  given()
		    		.headers("SOAPAction", "http://tempuri.org/IBookView/GetBookAvailabilityCalendar","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(BookViewPL.GetBookAvailabilityCalendar(companyId, bookID, resourceTypeId, clubID))
		         .when()
		            .post("/BookView/BookView.svc")
		         .then()
	            	.log().all()
	            	 .statusCode(200)
	 	            .extract().response();
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		Assert.assertTrue(res.getTime() >= 60L);
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookDescription"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookId"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookName"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookResourceAvailability"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookResourceAvailabilityDto.Availability"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookResourceAvailabilityDto.DateRangeDto"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookResourceAvailabilityDto.DateRangeDto.End.DateTime"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookResourceAvailabilityDto.DateRangeDto.End.OffsetMinutes"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookResourceAvailabilityDto.DateRangeDto.Start.DateTime"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookResourceAvailabilityDto.DateRangeDto.Start.OffsetMinutes"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookResourceAvailabilityDto.DateRangeDto.OffsetMinutes"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookResourceAvailabilityDto.ResourceTypeDescription"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookResourceAvailabilityDto.ResourceTypeId"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookResourceAvailabilityDto.ResourceTypeName"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookType"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.BookingBasedOnAvailabilityMinutes"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityCalendarResponse.GetBookAvailabilityCalendarResult.BookCalendarAvailabilityDto.IsBookingBasedOnAvailability"));
	       		
	       		
	       				
}
	}
