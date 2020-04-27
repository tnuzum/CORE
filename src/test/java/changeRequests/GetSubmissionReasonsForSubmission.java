package changeRequests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.ChangeRequestsPL;
import resources.ReusableMethods;
import resources.base;

public class GetSubmissionReasonsForSubmission extends base {
	
	String companyId;
	String clubId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Get Submission Reasons For Submission With Club")
	public void getSubmissionReasonsForSubmissionWithClub(){
		
		String clubId = prop.getProperty("club1Id");
		String submissionReason = prop.getProperty("submissionReason");

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/GetSubmissionReasonsForSubmission",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.getSubmissionReasonsForSubmissionWithClub(companyId, clubId))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);	
				
				Assert.assertTrue(res.getTime() >= 60L);
				
				Assert.assertEquals(js.getString("Envelope.Body.GetSubmissionReasonsForSubmissionResponse.GetSubmissionReasonsForSubmissionResult"), submissionReason);
	}

	@Test (testName="Get Submission Reasons For Submission No Club")
	public void getSubmissionReasonsForSubmissionNohClub(){
		
		String submissionReason = prop.getProperty("submissionReason");

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/GetSubmissionReasonsForSubmission",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.getSubmissionReasonsForSubmissionNoClub(companyId))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
 //            	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertEquals(js.getString("Envelope.Body.GetSubmissionReasonsForSubmissionResponse.GetSubmissionReasonsForSubmissionResult"), submissionReason);
	}















}