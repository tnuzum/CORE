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

public class GetResourceTypeAvailability extends base{

	
String companyId;
@BeforeTest
public void getData()
{
	base.getPropertyData();
	
	RestAssured.baseURI = prop.getProperty("baseURI");
	
	companyId = prop.getProperty("X-CompanyId");
}
	
	
	@Test (priority = 1, testName="ResourceTypeAvailability")
	public void ResourceTypeAvailability() {
		String resourceTypeId = prop.getProperty("resourceTypeId");
		String clubID = prop.getProperty("X-Club1Id");
		 Response res =  given()
		    		.headers("SOAPAction", "http://tempuri.org/IBookView/GetResourceTypeAvailability","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(BookViewPL.GetResourceTypeAvailability(companyId, clubID, resourceTypeId))
		         .when()
		            .post("/BookView/BookView.svc")
		         .then()
	            	//.log().all()
	            	 .statusCode(200)
	 	            .extract().response();
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		Assert.assertTrue(res.getTime() >= 60L);
	       		Assert.assertNotNull(js.get("Envelope.Body.GetResourceTypeAvailabilityResponse.GetResourceTypeAvailabilityResult.ResourceTypeAvailabilityInformationDto.Availability"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetResourceTypeAvailabilityResponse.GetResourceTypeAvailabilityResult.ResourceTypeAvailabilityInformationDto.Availability.ResourceTypeAvailabilityDto.DayOfWeek"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetResourceTypeAvailabilityResponse.GetResourceTypeAvailabilityResult.ResourceTypeAvailabilityInformationDto.Availability.ResourceTypeAvailabilityDto.EndTime"));
	       		Assert.assertNotNull(js.get("Envelope.Body.GetResourceTypeAvailabilityResponse.GetResourceTypeAvailabilityResult.ResourceTypeAvailabilityInformationDto.Availability.ResourceTypeAvailabilityDto.StartTime"));
	}
}


