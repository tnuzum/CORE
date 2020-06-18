package customerInfo;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CustomerInfoPL;
import resources.ReusableMethods;
import resources.base;

public class GetMemberActions extends base {
	
	String companyId;
	
	@BeforeTest
	public void getData(){
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Member Actions Found", description = "PBI: 165564")
	public void memberActionsFound(){
		
	       Response res =  given()
                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetMemberActions","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(CustomerInfoPL.getMemberActions(companyId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		
	       		Assert.assertTrue(res.getTime() >= 60L);
	       
				Assert.assertNotNull(js.getString("Envelope.Body.GetMemberActionsResponse.GetMemberActionsResult.MemberActionDto[0].ActionDescription"));
				Assert.assertTrue(js.getInt("Envelope.Body.GetMemberActionsResponse.GetMemberActionsResult.MemberActionDto[0].MemberActionId") == 1);
	}
	
	@Test (testName="Action Is Nursery Plan Default", description = "PBI: 165564")
	public void actionIsNurseryPlanDefault(){
		
	       Response res =  given()
                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetMemberActions","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(CustomerInfoPL.getMemberActions(companyId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		
	       		Assert.assertTrue(res.getTime() >= 60L);
	       
				Assert.assertTrue(js.getString("Envelope.Body.GetMemberActionsResponse.GetMemberActionsResult.MemberActionDto[0].IsNurseryDefault").equals("true"));   
	}
	
	@Test (testName="Action Is Not Nursery Plan Default", description = "PBI: 165564")
	public void actionIsNotNurseryPlanDefault(){
		
	       Response res =  given()
                .headers("SOAPAction", "http://tempuri.org/ICustomerInfo/GetMemberActions","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(CustomerInfoPL.getMemberActions(companyId))
	         .when()
	            .post("/Info/CustomerInfo.svc")
	         .then()
//             	.log().all()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		
	       		Assert.assertTrue(res.getTime() >= 60L);
	       
				Assert.assertTrue(js.getString("Envelope.Body.GetMemberActionsResponse.GetMemberActionsResult.MemberActionDto[1].IsNurseryDefault").equals("false"));   
	}

}
