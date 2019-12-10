package CORE.CustomerInfo;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.CustomerInfoPL;
import resources.base;

public class UpdateCustomerName extends base {
	
	@BeforeTest
	public void getData() throws IOException {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}

	@Test (priority = 1, testName="Customer Name Updated")
	public void customerNameUpdated(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/UpdateCustomerName","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.updateCustomerName(244, "Changed Named", "Changed", "Named", "Z", "Changed"))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.UpdateCustomerNameResponse.UpdateCustomerNameResult", equalTo("true"));    
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetCustomerInfo","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getCustomerInfo(244))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
	            .statusCode(200)
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.DisplayName", equalTo("Changed Named"))
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.FirstName", equalTo("Changed"))
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.LastName", equalTo("Named"))
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.MiddleInitial", equalTo("Z"))
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.PreferredName", equalTo("Changed"));
	}

//** CHANGING NAMES BACK TO WHAT THEY WERE BEFORE THIS TEST WAS RUN
	
	@Test (priority = 2, testName="Customer Name Updated 2")
	public void customerNameUpdated2(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/UpdateCustomerName","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.updateCustomerName(244, "Change Name", "Change", "Name", "M", "Change"))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.UpdateCustomerNameResponse.UpdateCustomerNameResult", equalTo("true"));    
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetCustomerInfo","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getCustomerInfo(244))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
	            .statusCode(200)
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.DisplayName", equalTo("Change Name"))
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.FirstName", equalTo("Change"))
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.LastName", equalTo("Name"))
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.MiddleInitial", equalTo("M"))
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.Name.PreferredName", equalTo("Change"));
	}

}
