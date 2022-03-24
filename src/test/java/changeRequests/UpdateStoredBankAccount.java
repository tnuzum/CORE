package changeRequests;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.lessThan;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.ChangeRequestsPL;
import resources.ReusableMethods;
import resources.base;

public class UpdateStoredBankAccount extends base {
	
	String companyId;
	String customerId;
	String clubId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
		customerId = prop.getProperty("availableId");
	}
	
	@Test (testName="Update stored Bank Account")
	public void verifyUpdateStoredBankAccount(){
		
		/* !!! validate change is pending with GetPersonalInfo call > pendingchange = true;
		 * maybe make reusableMethod and pass value of change field
		 * 
		 */
		String accountId = "2";
		
	      Response res =  given()
//	        .log().all()
	                .headers("SOAPAction", "http://tempuri.org/IChangeRequests/UpdateStoredBankAccount","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.UpdateStoredBankAccount(companyId, customerId, accountId))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.time(lessThan(5L),TimeUnit.SECONDS)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);	
				
				Assert.assertNotNull(js.getString("Envelope.Body.UpdateStoredBankAccountResponse.UpdateStoredBankAccountResult.AutoApprovedConfirmationNumber"));
			    Assert.assertEquals(js.getString("Envelope.Body.UpdateStoredBankAccountResponse.UpdateStoredBankAccountResult.ErrorMessages"), "None");
 

	}
}