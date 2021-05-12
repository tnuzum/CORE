package agreementInfo;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.AgreementInfoPL;
import resources.ReusableDates;
import resources.ReusableMethods;
import resources.base;

public class GetMembershipPlansDetails extends base {
	
	String companyId;
	String valueAssertions;
	
	String clubId;
	String planId;
	String effectiveDate;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		companyId = prop.getProperty("X-CompanyId");
		valueAssertions = prop.getProperty("valueAssertions");
		
		clubId = prop.getProperty("X-Club1Id");
		planId = prop.getProperty("membershipPlanAvailableOnlineId");
		effectiveDate = ReusableDates.getCurrentDate();
	}
	
	@Test (testName="All Parameters", description = "PBI: 179764")
	public void allParameters() {
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlanDetails",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlanDetailsAllParameters(companyId, clubId, planId, effectiveDate))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanId").equals(planId));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Inactive").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanCategoryId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanCategory").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.BillingCategoryId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.BillingCategoryDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MembershipTypeId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MembershipTypeName").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.IsIndividualPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.IsRenewalPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.IsApplyAgeRestriction").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MinimumAge").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MaximumAge").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MinimumMemberCount").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MaximumMemberCount").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.RenewalPlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.SellAsGroupPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.IsCorpResponsible").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.CorporationId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PercentageOfTotalDuesToPay").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.HasMaximumTotalDues").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MaximumTotalDues").isBlank());
			
			
			
			
			
			
			
			
			
		if (valueAssertions.equals("true")) {
			Assert.assertEquals(prop.getProperty("membershipPlanAvailableOnlineDescription"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanDescription"));
			//Assert.assertEquals(prop.getProperty("planSummary"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanSummary"));
			Assert.assertEquals(prop.getProperty("planType"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanType"));
			Assert.assertEquals("false", js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Inactive"));
			Assert.assertEquals(prop.getProperty("planCategoryId"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanCategoryId"));
			Assert.assertEquals(prop.getProperty("planCategory"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanCategory"));
			Assert.assertEquals(prop.getProperty("billingCategoryId"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.BillingCategoryId"));
			Assert.assertEquals(prop.getProperty("billingCategoryDescription"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.BillingCategoryDescription"));
			Assert.assertEquals(prop.getProperty("membershipTypeId"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MembershipTypeId"));
			Assert.assertEquals(prop.getProperty("membershipTypeName"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MembershipTypeName"));
			Assert.assertEquals(prop.getProperty("isIndividualPlan"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.IsIndividualPlan"));
			Assert.assertEquals(prop.getProperty("isRenewalPlan"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.IsRenewalPlan"));
			Assert.assertEquals(prop.getProperty("isApplyAgeRestriction"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.IsApplyAgeRestriction"));
			Assert.assertEquals(prop.getProperty("minimumAge"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MinimumAge"));
			Assert.assertEquals(prop.getProperty("maximumAge"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MaximumAge"));
			Assert.assertEquals(prop.getProperty("minimumMemberCount"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MinimumMemberCount"));
			Assert.assertEquals(prop.getProperty("maximumMemberCount"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MaximumMemberCount"));
			Assert.assertEquals(prop.getProperty("renewalPlanType"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.RenewalPlanType"));
			Assert.assertEquals(prop.getProperty("sellAsGroupPlan"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.SellAsGroupPlan"));
			Assert.assertEquals(prop.getProperty("isCorpResponsible"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.IsCorpResponsible"));
			Assert.assertEquals(prop.getProperty("corporationId"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.CorporationId"));
			Assert.assertEquals(prop.getProperty("percentageOfTotalDuesToPay"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PercentageOfTotalDuesToPay"));
			Assert.assertEquals(prop.getProperty("hasMaximumTotalDues"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.HasMaximumTotalDues"));
			Assert.assertEquals(prop.getProperty("maximumTotalDues"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MaximumTotalDues"));
			}			
	}
	
	@Test (testName="Required Parameters", description = "PBI: 179764")
	public void requiredParametersonly() {
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlanDetails",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlanDetailsRequiredParameters(companyId, clubId, planId))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200);		
	}

}


