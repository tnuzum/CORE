package customerInfo;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.hasKey;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CustomerInfoPL;
import resources.ReusableMethods;
import resources.base;

public class GetFullFamilyForTest extends base {
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}
	
	@Test (testName="Family Found")
	public void familyFound(){
		
		String customerId = prop.getProperty("availableId");
		
	        Response res = given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetFullFamilyFor","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getFullFamilyFor(customerId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
	            .extract().response();
	        
	        XmlPath js = ReusableMethods.rawToXML(res);
	        
	        	Assert.assertTrue(res.getTime() >= 60L);
	        	        
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].BarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].DisplayName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].EmailAddress"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].FirstName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].HeadOfHousehold"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].Id"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].LastName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[0].PreferredName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].BarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].DisplayName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].EmailAddress"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].FirstName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].HeadOfHousehold"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].Id"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].LastName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[1].PreferredName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].BarcodeId"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].DisplayName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].EmailAddress"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].FirstName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].HeadOfHousehold"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].Id"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].LastName"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult.FamilyMemberResponse[2].PreferredName"));   
	}
	
	@Test (testName="Family Member Not Found")
	public void familyMemberNotFound(){
		
			String customerId = prop.getProperty("MultipleAgreementsWithSingleCardId");
		
	        given()
	                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetFullFamilyFor","Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(CustomerInfoPL.getFullFamilyFor(customerId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
				.body("Envelope.Body.GetFullFamilyForResponse.GetFullFamilyForResult", not(hasKey("FamilyMemberResponse")))
				;    
	}
}
