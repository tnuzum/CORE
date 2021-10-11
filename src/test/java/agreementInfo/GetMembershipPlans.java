package agreementInfo;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.AgreementInfoPL;
import resources.ReusableMethods;
import resources.base;

public class GetMembershipPlans extends base {
	
	/*
	 * Testing notes:
	 * Use String availableOnlineOnly ="1"; to get same result as shown in JOL2.0
	 * In Response, plans with <a:IsFeaturedPlan>true</a:IsFeaturedPlan> are shown at the top of page in JOL2.0
	 * 	and not in the View All Plan section
	 */
	
	String companyId;
	String valueAssertions;
	
	String clubId;
	String includeAllClubs;
	String includeIndividualPlans;
	String planCategoryId;
	String duration;
	String durationType;
	String availableOnlineOnly;
	String planType;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		companyId = prop.getProperty("X-CompanyId");
		valueAssertions = prop.getProperty("valueAssertions");
		
		clubId = prop.getProperty("X-Club1Id");
		includeAllClubs = "0"; // 0=All Clubs(default), 1=Single Club, 2=Multiple Clubs
		includeIndividualPlans = "-1"; // -1=All Plans(default), 0=Family Plan, 1=Individual Plan
		planCategoryId = "-1"; // -1=All Agreement Categories(default)
		duration = "-1"; // -1=All Durations(default)
		durationType = "0"; // 0=Months(default), 1=Weeks (Note: this parameter is ignored if duration = -1)
		availableOnlineOnly = "-1"; // -1=Both(default), 0=Disabled, 1=Enabled
		planType = "0"; //0=All(default), 1=Open Ended, 2=Terms, 3=TermsWithRollover
	}
	
	@Test (testName="All Parameters", description = "PBI: 179764")
	public void allParameters() {
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtPrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.PlanId").isBlank());
			
		if (valueAssertions.equals("true")) {

			}			

	}
	
	@Test (testName="Required Parameters Only", description = "PBI: 179764")
	public void requiredParametersOnly() {
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansRequiredParameters(companyId, clubId))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtPrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.PlanId").isBlank());			

	}
	
	@Test (testName="Specific Plan Category", description = "PBI: 179764")
	public void specificPlanCategory() {
		
		String planCategoryId = prop.getProperty("agreementCategory1Id");
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtPrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.PlanId").isBlank());			

	}
	
	@Test (testName="Plan Type - Open Ended", description = "PBI: 179764")
	public void planTypeOpenEnded() {
		
		String planTypeDescription = prop.getProperty("membershipPlanType1");
		String planType = "1";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtPrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.PlanId").isBlank());
			
		if (valueAssertions.equals("true")) {
			
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").equals(planTypeDescription));
			}

	}
	
	@Test (testName="Plan Type - Terms - Default Duration", description = "PBI: 179764")
	public void planTypeTermsDefaultDuration() {
		
		String planTypeDescription = prop.getProperty("membershipPlanType2");
		String planType = "2";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtPrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.PlanId").isBlank());
			
		if (valueAssertions.equals("true")) {
			
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").equals(planTypeDescription));
			}

	}
	
	@Test (testName="Plan Type - Terms 2 Weeks", description = "PBI: 179764")
	public void planTypeTerms2Weeks() {
		
		String planTypeDescription = prop.getProperty("membershipPlanType2");

		String planType = "2";
		String duration = "2";
		String durationType = "1";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtPrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.PlanId").isBlank());
			
		if (valueAssertions.equals("true")) {
			
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").equals(planTypeDescription));
			}

	}
	
	@Test (testName="Plan Type - Terms 2 Months", description = "PBI: 179764")
	public void planTypeTerms2Months() {
		
		String planTypeDescription = prop.getProperty("membershipPlanType2");

		String planType = "2";
		String duration = "2";
		String durationType = "0";
		
		String availableOnlineOnly = "1";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtPrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.PlanId").isBlank());
			
		if (valueAssertions.equals("true")) {
			
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").equals(planTypeDescription));
			}

	}
	
	@Test (testName="Plan Type - Terms With Rollover", description = "PBI: 179764")
	public void planTypeTermsWithRollover() {
		
		String planTypeDescription = prop.getProperty("membershipPlanType3");
		String planType = "3";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtPrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.PlanId").isBlank());	
			
		if (valueAssertions.equals("true")) {
			
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").equals(planTypeDescription));
			}

	}
	
	@Test (testName="Available Online Only Disabled", description = "PBI: 179764")
	public void availableOnlineOnlyDisabled() {
		
		String availableOnlineOnly = "0";
		String membershipPlanNotAvailableOnlineId = prop.getProperty("membershipPlanNotAvailableOnlineId");
		String membershipPlanNotAvailableOnlineDescription = prop.getProperty("membershipPlanNotAvailableOnlineDescription");
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtPrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.PlanId").isBlank());			
			
		if (valueAssertions.equals("true")) {
			
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanId").contains(membershipPlanNotAvailableOnlineId));
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanDescription").contains(membershipPlanNotAvailableOnlineDescription));
			
			}
	}

	@Test (testName="Available Online Only Enabled", description = "PBI: 179764")
	public void availableOnlineOnlyEnabled() {
		
		String availableOnlineOnly = "1";
		String membershipPlanAvailableOnlineId = prop.getProperty("membershipPlanAvailableOnlineId");
		String membershipPlanAvailableOnlineDescription = prop.getProperty("membershipPlanAvailableOnlineDescription");
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtPrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.PlanId").isBlank());			
			
		if (valueAssertions.equals("true")) {

			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanId").contains(membershipPlanAvailableOnlineId));
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanDescription").contains(membershipPlanAvailableOnlineDescription));
			
			}
	}
	
	@Test (testName="Plan Available in Specific Club", description = "PBI: 179764")
	public void planAvailableInSpecificClub() {
		
		String clubId = "1";
		String membershipPlanClub1OnlyId = prop.getProperty("membershipPlanClub1OnlyId");
		String membershipPlanClub1OnlyDescription = prop.getProperty("membershipPlanClub1OnlyDescription");
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtPrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.PlanId").isBlank());			
			
		if (valueAssertions.equals("true")) {

			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanId").contains(membershipPlanClub1OnlyId));
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanDescription").contains(membershipPlanClub1OnlyDescription));
			
			}
	}
	
	@Test (testName="Plan Not Available in Specific Club", description = "PBI: 179764")
	public void planNotAvailableInSpecificClub() {
		
		String clubId = "2";
		String membershipPlanClub1OnlyId = prop.getProperty("membershipPlanClub1OnlyId");
		String membershipPlanClub1OnlyDescription = prop.getProperty("membershipPlanClub1OnlyDescription");
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);			
			
		if (valueAssertions.equals("true")) {

			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanId").contains(membershipPlanClub1OnlyId));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanDescription").contains(membershipPlanClub1OnlyDescription));
			
			}
	}
	
	@Test (testName="Family Plans Only", description = "PBI: 179764")
	public void familyPlansOnly() {
		
		String includeIndividualPlans = "0";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanDescription").isBlank());
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").equals("false"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.IsIndividualPlan").equals("true")); // Confirm none of the plans are Individual
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtPrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.PlanId").isBlank());		

	}
	
	@Test (testName="Individual Plans Only", description = "PBI: 179764")
	public void individualPlansOnly() {
		
		String includeIndividualPlans = "1";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanDescription").isBlank());
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").equals("true"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.IsIndividualPlan").equals("false")); // Confirm none of the plans are Family
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtPrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPmtOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services[0].PlanService.PlanId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemId").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.ItemDescription").isBlank());
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas[0].MembershipArea.PlanId").isBlank());		

	}

	@Test (testName="Club Not Found", description = "PBI: 179764")
	public void clubNotFound() {
		
		String clubId = "99999";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(500)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto").equals("Club not found"));	
			Assert.assertFalse(js.getString("Envelope.Body").contains("GetMembershipPlansResponse"));
					

	}
	
	@Test (testName="Plan Category Not Found", description = "PBI: 179764")
	public void planCategoryNotFound() {
		
		String planCategoryId = "99999";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansAllParameters(companyId, clubId, includeAllClubs, includeIndividualPlans, planCategoryId, duration, durationType, availableOnlineOnly, planType))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("PlanId"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("PlanDescription"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("IsIndividualPlan"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("PlanType"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("TotalDownPmtPrimary"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("TotalDownPmtFirstFamily"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("TotalDownPmtOtherFamily"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("TotalRecurringChargePrimary"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("TotalRecurringChargeFirstFamily"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("TotalRecurringChargeOtherFamily"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("IsFeaturedPlan"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("Services[0].PlanService.ItemId"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("AddOns"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("ServiceAreas"));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("ServiceAreas"));			

	}


}


