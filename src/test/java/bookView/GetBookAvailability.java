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

public class GetBookAvailability extends base{
	String companyId;
	@BeforeTest
	public void getData(){
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	@Test  (priority = 1, testName="BookAvailability")
	
		public void BookAvailability() 
	{
		String bookID = prop.getProperty("bookID");
		String clubID = prop.getProperty("X-Club1Id");
		String resourceTypeId = prop.getProperty("resourceTypeId");
		Response res =  given()
	    		.headers("SOAPAction", "http://tempuri.org/IBookView/GetBookAvailability","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(BookViewPL.GetBookAvailability(companyId, bookID, resourceTypeId, clubID))
	         .when()
	            .post("/BookView/BookView.svc")
	         .then()
            	//.log().all()
            	 .statusCode(200)
 	            .extract().response();
       		XmlPath js = ReusableMethods.rawToXML(res);
       		Assert.assertTrue(res.getTime() >= 60L);
       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityResponse.GetBookAvailabilityResult.BookAvailabilityInformationDto.Active"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityResponse.GetBookAvailabilityResult.BookAvailabilityInformationDto.Availability.BookAvailabilityDto.ClubId"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityResponse.GetBookAvailabilityResult.BookAvailabilityInformationDto.Availability.BookAvailabilityDto.ClubName"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityResponse.GetBookAvailabilityResult.BookAvailabilityInformationDto.Availability.BookAvailabilityDto.DayOfWeek"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityResponse.GetBookAvailabilityResult.BookAvailabilityInformationDto.Availability.BookAvailabilityDto.EndDate"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityResponse.GetBookAvailabilityResult.BookAvailabilityInformationDto.Availability.BookAvailabilityDto.EndTime"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityResponse.GetBookAvailabilityResult.BookAvailabilityInformationDto.Availability.BookAvailabilityDto.ResourceTypeDescription"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityResponse.GetBookAvailabilityResult.BookAvailabilityInformationDto.Availability.BookAvailabilityDto.ResourceTypeId"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityResponse.GetBookAvailabilityResult.BookAvailabilityInformationDto.Availability.BookAvailabilityDto.ResourceTypeName"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityResponse.GetBookAvailabilityResult.BookAvailabilityInformationDto.Availability.BookAvailabilityDto.StartDate"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetBookAvailabilityResponse.GetBookAvailabilityResult.BookAvailabilityInformationDto.Availability.BookAvailabilityDto.StartTime"));
       		
	}
}
