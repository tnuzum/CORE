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

public class SearchForAppointmentCustomers extends base{

	static String companyId;
	@BeforeTest
	public void getData()
	{
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		companyId= prop.getProperty("X-CompanyId");
	}
	@Test(priority = 1, testName=" Partcipant Count")
	public void VerifySearchForAppointmentCustomers()
	{
		String productId = prop.getProperty("ProductId1");
		String customerId = prop.getProperty("MemberId1");
		String clubID = prop.getProperty("club1Id");
		String	SearchParameter = "Seema1";
	
		
		Response res =	 given()
			 	.headers("SOAPAction", "http://tempuri.org/IScheduling/SearchForAppointmentCustomers","Content-Type", "text/xml; charset=utf-8")
			  	.and()
			  	.body(SchedulingPL.SearchForAppointmentCustomers(companyId,customerId, SearchParameter,clubID, productId ))
			  	.when()
			  	.post("/Visits/Scheduling.svc")
			  	.then()
			 .log().all()
			   .statusCode(200)
			  // .time(lessThan(60L),TimeUnit.SECONDS)
			   	.extract().response();
				XmlPath js = ReusableMethods.rawToXML(res);
				Assert.assertTrue(res.getTime() >= 60L);
				
				Assert.assertNotNull(js.getString("Envelope.Body.SearchForAppointmentCustomersResponse.SearchForAppointmentCustomersResult.AppointmentSearchCustomerDto.AddressLine1"));
				Assert.assertNotNull(js.getString("Envelope.Body.SearchForAppointmentCustomersResponse.SearchForAppointmentCustomersResult.AppointmentSearchCustomerDto.BarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.SearchForAppointmentCustomersResponse.SearchForAppointmentCustomersResult.AppointmentSearchCustomerDto.CellPhone"));
				Assert.assertNotNull(js.getString("Envelope.Body.SearchForAppointmentCustomersResponse.SearchForAppointmentCustomersResult.AppointmentSearchCustomerDto.DisplayName"));
				Assert.assertNotNull(js.getString("Envelope.Body.SearchForAppointmentCustomersResponse.SearchForAppointmentCustomersResult.AppointmentSearchCustomerDto.EmailAddress"));
				Assert.assertNotNull(js.getString("Envelope.Body.SearchForAppointmentCustomersResponse.SearchForAppointmentCustomersResult.AppointmentSearchCustomerDto.FirstName"));
				Assert.assertNotNull(js.getString("Envelope.Body.SearchForAppointmentCustomersResponse.SearchForAppointmentCustomersResult.AppointmentSearchCustomerDto.Id"));
				Assert.assertNotNull(js.getString("Envelope.Body.SearchForAppointmentCustomersResponse.SearchForAppointmentCustomersResult.AppointmentSearchCustomerDto.LastName"));
				Assert.assertNotNull(js.getString("Envelope.Body.SearchForAppointmentCustomersResponse.SearchForAppointmentCustomersResult.AppointmentSearchCustomerDto.PostalCode"));
				Assert.assertNotNull(js.getString("Envelope.Body.SearchForAppointmentCustomersResponse.SearchForAppointmentCustomersResult.AppointmentSearchCustomerDto.PreferredName"));
				Assert.assertNotNull(js.getString("Envelope.Body.SearchForAppointmentCustomersResponse.SearchForAppointmentCustomersResult.AppointmentSearchCustomerDto.StateProvince"));
			
				}
	
	
	
}
