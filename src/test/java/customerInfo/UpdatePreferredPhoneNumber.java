package customerInfo;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.CustomerInfoPL;
import resources.base;

public class UpdatePreferredPhoneNumber extends base {
	
	String companyId;
	String customerId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		customerId = prop.getProperty("MultipleAgreementsWithSingleCardId");
	}

	@Test (priority=1, testName="Preferred Phone Number Updated to Home")
	public void preferredPhoneUpdatedHome(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/UpdatePreferredPhoneNumber","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.updatePreferredPhoneNumber(companyId, customerId, "Home"))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.UpdatePreferredPhoneNumberResponse.UpdatePreferredPhoneNumberResult", equalTo("true"));    
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetCustomerInfo","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getCustomerInfo(companyId, customerId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//	         .log().all()
	            .statusCode(200)
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneType", equalTo("Home"));
	}
	
	@Test (priority=2, testName="Preferred Phone Number Updated to Work")
	public void preferredPhoneUpdatedWork(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/UpdatePreferredPhoneNumber","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.updatePreferredPhoneNumber(companyId, customerId, "Work"))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.UpdatePreferredPhoneNumberResponse.UpdatePreferredPhoneNumberResult", equalTo("true"));    
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetCustomerInfo","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getCustomerInfo(companyId, customerId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//	         .log().all()
	            .statusCode(200)
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneType", equalTo("Work"));
	}
	
	@Test (priority=3, testName="Preferred Phone Number Updated to Mobile")
	public void preferredPhoneUpdatedMobile(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/UpdatePreferredPhoneNumber","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.updatePreferredPhoneNumber(companyId, customerId, "Mobile"))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.UpdatePreferredPhoneNumberResponse.UpdatePreferredPhoneNumberResult", equalTo("true"));    
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetCustomerInfo","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getCustomerInfo(companyId, customerId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//	         .log().all()
	            .statusCode(200)
				.body("Envelope.Body.GetCustomerInfoResponse.GetCustomerInfoResult.PreferredPhoneType", equalTo("Mobile"));
	}
	
	@Test (priority=4, testName="Preferred Phone Number Not Updated")
	public void preferredPhoneNotUpdated(){
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/UpdatePreferredPhoneNumber","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.updatePreferredPhoneNumber(companyId, "99999", "Mobile"))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.body("Envelope.Body.UpdatePreferredPhoneNumberResponse.UpdatePreferredPhoneNumberResult", equalTo("false"));    

	}

	
	
}
