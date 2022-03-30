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
	String billingCycle;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		companyId = prop.getProperty("X-CompanyId");
		valueAssertions = prop.getProperty("valueAssertions");
		
		clubId = prop.getProperty("X-Club1Id");
		planId = prop.getProperty("membershipPlanAvailableOnlineId");
		effectiveDate = ReusableDates.getCurrentDate();
		billingCycle = "Monthly";
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
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanCategory.Id").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanCategory.Name").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.BillingCategory.Id").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.BillingCategory.Description").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MembershipType.Id").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MembershipType.Name").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.IsIndividualPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.IsRenewalPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanRestrictions").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanRestrictions.AgeRestriction.MinimumAge").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanRestrictions.AgeRestriction.MaximumAge").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanRestrictions.MinimumMemberCount").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanRestrictions.MaximumMemberCount").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.RenewalPlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.CorporationSettings.SellAsGroupPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.CorporationSettings.IsCorporationResponsible").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.CorporationSettings.CorporationId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PercentageOfTotalDuesToPay").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.HasMaximumTotalDues").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MaximumTotalDues").isBlank());
			
				
						
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].OtherMemberPricing.DownPayment").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].OtherMemberPricing.DownPaymentProration").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].OtherMemberPricing.Freeze").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].OtherMemberPricing.MaxDiscountDownPayment").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].OtherMemberPricing.MaxDiscountProration").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].OtherMemberPricing.MaxDiscountRecurring").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].OtherMemberPricing.Recurring").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].OtherMemberPricing.Rollover").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].OtherMemberPricing.ValuePerDay").isBlank());
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].PrimaryMemberPricing.DownPayment").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].PrimaryMemberPricing.DownPaymentProration").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].PrimaryMemberPricing.Freeze").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].PrimaryMemberPricing.MaxDiscountDownPayment").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].PrimaryMemberPricing.MaxDiscountProration").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].PrimaryMemberPricing.MaxDiscountRecurring").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].PrimaryMemberPricing.Recurring").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].PrimaryMemberPricing.Rollover").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].PrimaryMemberPricing.ValuePerDay").isBlank());
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].SecondaryMemberPricing.DownPayment").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].SecondaryMemberPricing.DownPaymentProration").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].SecondaryMemberPricing.Freeze").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].SecondaryMemberPricing.MaxDiscountDownPayment").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].SecondaryMemberPricing.MaxDiscountProration").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].SecondaryMemberPricing.MaxDiscountRecurring").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].SecondaryMemberPricing.Recurring").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].SecondaryMemberPricing.Rollover").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.Services.PlanServiceBreakdownDto[0].SecondaryMemberPricing.ValuePerDay").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.BillingCycle").isBlank());
			
			
			
		if (valueAssertions.equals("true")) {
			Assert.assertEquals(prop.getProperty("membershipPlanAvailableOnlineDescription"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanDescription"));
			//Assert.assertEquals(prop.getProperty("planSummary"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanSummary"));
			Assert.assertEquals(prop.getProperty("planType"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanType"));
			Assert.assertEquals("false", js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Inactive"));
			Assert.assertEquals(prop.getProperty("planCategoryId"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanCategory.Id"));
			Assert.assertEquals(prop.getProperty("planCategory"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanCategory.Name"));
			Assert.assertEquals(prop.getProperty("billingCategoryId"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.BillingCategory.Id"));
			Assert.assertEquals(prop.getProperty("billingCategoryDescription"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.BillingCategory.Description"));
			Assert.assertEquals(prop.getProperty("membershipTypeId"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MembershipType.Id"));
			Assert.assertEquals(prop.getProperty("membershipTypeName"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MembershipType.Name"));
			Assert.assertEquals(prop.getProperty("isIndividualPlan"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.IsIndividualPlan"));
			Assert.assertEquals(prop.getProperty("isRenewalPlan"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.IsRenewalPlan"));
//			Assert.assertEquals(prop.getProperty("isApplyAgeRestriction"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.IsApplyAgeRestriction"));
			Assert.assertEquals(prop.getProperty("minimumAge"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanRestrictions.AgeRestriction.MinimumAge"));
			Assert.assertEquals(prop.getProperty("maximumAge"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanRestrictions.AgeRestriction.MaximumAge"));
			Assert.assertEquals(prop.getProperty("minimumMemberCount"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanRestrictions.MinimumMemberCount"));
			Assert.assertEquals(prop.getProperty("maximumMemberCount"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PlanRestrictions.MaximumMemberCount"));
			Assert.assertEquals(prop.getProperty("renewalPlanType"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.RenewalPlanType"));
			Assert.assertEquals(prop.getProperty("sellAsGroupPlan"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.CorporationSettings.SellAsGroupPlan"));
			Assert.assertEquals(prop.getProperty("isCorpResponsible"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.CorporationSettings.IsCorporationResponsible"));
			Assert.assertEquals(prop.getProperty("corporationId"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.CorporationSettings.CorporationId"));
			Assert.assertEquals(prop.getProperty("percentageOfTotalDuesToPay"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.PercentageOfTotalDuesToPay"));
			Assert.assertEquals(prop.getProperty("hasMaximumTotalDues"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.HasMaximumTotalDues"));
			Assert.assertEquals(prop.getProperty("maximumTotalDues"), js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.MaximumTotalDues"));
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.AgreementDates.EffectiveDate").contains(effectiveDate));
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.AgreementDates.SaleDate").contains(effectiveDate));
			Assert.assertEquals(js.getString("Envelope.Body.GetMembershipPlanDetailsResponse.GetMembershipPlanDetailsResult.Details.BillingCycle.Description"), billingCycle);
			
		}			
	}
	
	@Test (testName="Effective Date is a Required Parameter", description = "PBI: 179764")
	public void verifyEffectiveDateIsRequiredParameter() {
	Response res =	given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlanDetails",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlanDetailsEffectiveDateIsRequiredParameter(companyId, clubId, planId))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(500)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);	
			
			Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto").contains("Expecting element 'EffectiveDate'.'."));
	}
	
	@Test (testName="Verify a messagere is turned when plan is not available at club", description = "PBI: 179764")
	public void planNotAvailableInClub() {
		
		clubId = "2";
	
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
			.statusCode(400)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InvalidInputFaultDto.Message").contains("PlanId: "+planId+" is not available at club "+clubId+"."));

	}

}


