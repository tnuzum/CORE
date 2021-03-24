package customerInfo;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CustomerInfoPL;
import resources.ReusableMethods;
import resources.base;

public class GetFamilyMembersForTest extends base {
	
	String companyId; 
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Family Member Found")
	public void familyMemberFound(){
		
			String customerId = prop.getProperty("availableId");
		
	        Response res = given()
	        	.headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetFamilyMembersFor","Content-Type", "text/xml; charset=utf-8")
	        	.and()
	        	.body(CustomerInfoPL.getFamilyMembersFor(companyId, customerId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
            	.log().all()
	            .statusCode(200)
	            .extract().response();
	        
	        	XmlPath js = ReusableMethods.rawToXML(res);	
	        
	        	Assert.assertTrue(res.getTime() >= 60L);
	        
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].BarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].DateOfBirth"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].DisplayName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].EmailAddress"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].FirstName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].HeadOfHousehold"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].Id"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].LastName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[0].PreferredName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].BarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].DateOfBirth"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].DisplayName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].EmailAddress"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].FirstName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].HeadOfHousehold"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].Id"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].LastName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult.FamilyMemberResponse[1].PreferredName"));  
	}
	
	@Test (testName="Family Member Not Found")
	public void familyMemberNotFound(){
		
			String customerId = prop.getProperty("MultipleAgreementsWithSingleCardId");
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetFamilyMembersFor","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getFamilyMembersFor(companyId, customerId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.body("Envelope.Body.GetFamilyMembersForResponse.GetFamilyMembersForResult", not(hasKey("FamilyMemberResponse")));    
	}
}
