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
	 * Use String OnlineFilter = OnlineOnly; to get same result as shown in JOL2.0
	 * In Response, plans with <a:IsFeaturedPlan>true</a:IsFeaturedPlan> are shown at the top of page in JOL2.0
	 * 	and not in the View All Plan section
	 * When any parameter is commented out in the request, no filtering is done on that value
	 */
	
	String companyId;
	String valueAssertions;
	int count;
	
	String clubId;
	String IndividualPlansFilter;
	String AgreementCategoryIdFilter;
	String DurationFilterValue;
	String DurationFilter;
	String OnlineFilter;
	String PlanTypeFilter;
	String PromoPlanFilter;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		companyId = prop.getProperty("X-CompanyId");
		valueAssertions = prop.getProperty("valueAssertions");
		
		clubId = prop.getProperty("X-Club1Id");
		
		
		/*
		 * IndividualPlansFilter values:-  Family Plan, Individual Plan.  Comment the parameter for All
		 * AgreementCategoryIdFilter :- Comment the parameter for All
		 * DurationFilterValue :- Comment the parameter for All
		 * DurationFilter :- Months, Weeks Comment the parameter for All
		 * OnlineFilter :- OnlineOnly, OnlineAndClub, NotAvailableOnline.  Comment the parameter for All
		 * PlanTypeFilter :- OpenEnded, Terms, TermsWRollover. Comment the parameter for All
		  */	
		}
	
	@Test (priority = 1, testName="All Parameters", description = "PBI: 179764 - Updated by PBI 185540")
	public void allParameters() {
		
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
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].Description").isBlank());
			
			
		if (valueAssertions.equals("true")) {

			}			

	}
	
	@Test (priority = 2,testName="Required Parameters Only", description = "PBI: 179764 - Updated by PBI 185540")
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
			
//			String planId = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId");
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].PlanId").equals(planId));			

	}
	
	@Test (priority = 3, testName="Specific Plan Category", description = "PBI: 179764 - Updated by PBI 185540")
	public void specificPlanCategory() {
		
		String AgreementCategoryIdFilter = prop.getProperty("agreementCategory1Id");
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansSpecificAgreementCategory(companyId, clubId, AgreementCategoryIdFilter))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
						
			count = js.getInt("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.size()");
			
			for (int i = 0; i<count; i++)
				
			{
				String PlanCategoryId = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse["+i+"].PlanCategoryId");
			   				
				Assert.assertTrue(PlanCategoryId.equals("1")); 
				
			}
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].PlanId").equals(planId));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].PlanId").equals(planId));	
			

	}
	
	@Test (priority = 4, testName="Plan Type - Open Ended", description = "PBI: 179764 - Updated by PBI 185540")
	public void PlanTypeFilterOpenEnded() {
		
		String PlanTypeFilter = prop.getProperty("membershipPlanType1");
				
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansSpecificPlanType(companyId, clubId, PlanTypeFilter))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
            count = js.getInt("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.size()");
            
            if (valueAssertions.equals("true")) {
			
			for (int i = 0; i<count; i++)
				
			{
				String PlanType = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse["+i+"].PlanType");
			   				
				Assert.assertTrue(PlanType.equals(PlanTypeFilter)); 
				
			}
			
            }

			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].PlanId").equals(planId));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].PlanId").equals(planId));
		
	}
	
	@Test (priority = 5, testName="Plan Type - Terms - Default DurationFilterValue", description = "PBI: 179764 - Updated by PBI 185540")
	public void PlanTypeFilterTermsDefaultDurationFilterValue() {
		
		String PlanTypeFilter = prop.getProperty("membershipPlanType2");
				
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansSpecificPlanType(companyId, clubId, PlanTypeFilter))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
									
			Assert.assertTrue(res.getTime() >= 60L);
			
			  count = js.getInt("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.size()");
	            
	            if (valueAssertions.equals("true")) {
				
				for (int i = 0; i<count; i++)
					
				{
					String PlanType = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse["+i+"].PlanType");
				    					
					Assert.assertTrue(PlanType.equals(PlanTypeFilter)); 
					
				}
				
	            }
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].PlanId").equals(planId));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].PlanId").equals(planId));
			
		
	}
	
	@Test (priority = 6, testName="Plan Type - Terms 2 Weeks", description = "PBI: 179764 - Updated by PBI 185540")
	public void PlanTypeFilterTerms2Weeks() {
		
		String PlanTypeFilter = prop.getProperty("membershipPlanType2");
		String DurationFilter = "Weeks";
		String DurationFilterValue = "2";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansSpecificPlanTypeAndDuration(companyId, clubId,  PlanTypeFilter,  DurationFilter,  DurationFilterValue))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);			
			
			Assert.assertTrue(res.getTime() >= 60L);
			 count = js.getInt("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.size()");
	            
	            if (valueAssertions.equals("true")) {
				
				for (int i = 0; i<count; i++)
					
				{
					String PlanType = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse["+i+"].PlanType");
					String DurationUnitType = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse["+i+"].DurationUnitType");
					String DurationUnits = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse["+i+"].DurationUnits");
				    					
					Assert.assertTrue(PlanType.equals(PlanTypeFilter)); 
					Assert.assertTrue(DurationUnitType.equals(DurationFilter)); 
					Assert.assertTrue(DurationUnits.equals(DurationFilterValue)); 
					
				}
				
	            }
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].PlanId").equals(planId));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].PlanId").equals(planId));
			
		

	}
	
	@Test (priority = 7, testName="Plan Type - Terms 2 Months", description = "PBI: 179764 - Updated by PBI 185540")
	public void PlanTypeFilterTerms2Months() {
		
		String PlanTypeFilter = prop.getProperty("membershipPlanType2");
		String DurationFilter = "Months";
		String DurationFilterValue = "2";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansSpecificPlanTypeAndDuration(companyId, clubId,  PlanTypeFilter,  DurationFilter,  DurationFilterValue))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);			
			
			Assert.assertTrue(res.getTime() >= 60L);
			 count = js.getInt("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.size()");
	            
	            if (valueAssertions.equals("true")) {
				
				for (int i = 0; i<count; i++)
					
				{
					String PlanType = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse["+i+"].PlanType");
					String DurationUnitType = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse["+i+"].DurationUnitType");
					String DurationUnits = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse["+i+"].DurationUnits");
				    					
					Assert.assertTrue(PlanType.equals(PlanTypeFilter)); 
					Assert.assertTrue(DurationUnitType.equals(DurationFilter)); 
					Assert.assertTrue(DurationUnits.equals(DurationFilterValue)); 
					
				}
				
	            }
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].PlanId").equals(planId));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].PlanId").equals(planId));
			
		

	}
	
	@Test (priority = 8, testName="Plan Type - Terms With Rollover", description = "PBI: 179764 - Updated by PBI 185540")
	public void PlanTypeFilterTermsWithRollover() {
		
		String PlanTypeFilter = prop.getProperty("membershipPlanType3");
		
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansSpecificPlanType(companyId, clubId, PlanTypeFilter))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
									
			Assert.assertTrue(res.getTime() >= 60L);
			
			 count = js.getInt("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.size()");
	            
	            if (valueAssertions.equals("true")) {
				
				for (int i = 0; i<count; i++)
					
				{
					String PlanType = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse["+i+"].PlanType");
				    					
					Assert.assertTrue(PlanType.equals(PlanTypeFilter)); 
					
				}
				
	            }
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].PlanId").equals(planId));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].PlanId").equals(planId));	
			
		

	}
	
	@Test (priority = 9, testName="Available Online Disabled", description = "PBI: 179764 - Updated by PBI 185540")
	public void OnlineFilterDisabled() {
		
		String OnlineFilter = "NotAvailableOnline";
		String membershipPlanNotAvailableOnlineId = prop.getProperty("membershipPlanNotAvailableOnlineId");
		String membershipPlanNotAvailableOnlineDescription = prop.getProperty("membershipPlanNotAvailableOnlineDescription");
		String membershipPlanAvailableOnlineId = prop.getProperty("membershipPlanAvailableOnlineId");
		String membershipPlanAvailableOnlineDescription = prop.getProperty("membershipPlanAvailableOnlineDescription");
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansSpecificOnlineFilter(companyId, clubId, OnlineFilter))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			

			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].PlanId").equals(planId));
						
			
		if (valueAssertions.equals("true")) {
			
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanId").contains(membershipPlanNotAvailableOnlineId));
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.Description").contains(membershipPlanNotAvailableOnlineDescription));
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanId").contains(membershipPlanAvailableOnlineId));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.Description").contains(membershipPlanAvailableOnlineDescription));
			}
	}

	@Test (priority = 10, testName="Available Online Only Enabled", description = "PBI: 179764 - Updated by PBI 185540")
	public void OnlineOnlyFilterEnabled() {
		
		String OnlineFilter = "OnlineOnly";
		String membershipPlanAvailableOnlineId = prop.getProperty("membershipPlanAvailableOnlineId");
		String membershipPlanAvailableOnlineDescription = prop.getProperty("membershipPlanAvailableOnlineDescription");
		String membershipPlanNotAvailableOnlineId = prop.getProperty("membershipPlanNotAvailableOnlineId");
		String membershipPlanNotAvailableOnlineDescription = prop.getProperty("membershipPlanNotAvailableOnlineDescription");
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansSpecificOnlineFilter(companyId, clubId, OnlineFilter))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			

			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].PlanId").equals(planId));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].PlanId").equals(planId));			
			
		if (valueAssertions.equals("true")) {

			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanId").contains(membershipPlanAvailableOnlineId));
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.Description").contains(membershipPlanAvailableOnlineDescription));
			
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanId").contains(membershipPlanNotAvailableOnlineId));
			Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.Description").contains(membershipPlanNotAvailableOnlineDescription));
			}
	}
	@Test (priority = 11, testName="Available Online And Club Enabled", description = "PBI: 179764 - Updated by PBI 185540")
	public void AvailableOnlineAndClubFilterEnabled() {
		
		String OnlineFilter = "OnlineAndClub";
		String membershipPlanAvailableOnlineAndClubId = prop.getProperty("membershipPlanClub1OnlyId");
		String membershipPlanAvailableOnlineAndClubDescription = prop.getProperty("membershipPlanClub1OnlyDescription");
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansSpecificOnlineFilter(companyId, clubId, OnlineFilter))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			

			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].PlanId").equals(planId));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].PlanId").equals(planId));			
			
		if (valueAssertions.equals("true")) {

			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanId").contains(membershipPlanAvailableOnlineAndClubId));
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.Description").contains(membershipPlanAvailableOnlineAndClubDescription));
			
			}
	}
	@Test (priority = 12, testName="Plan Available in Specific Club", description = "PBI: 179764 - Updated by PBI 185540")
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
			.body(AgreementInfoPL.getMembershipPlansRequiredParameters(companyId, clubId))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
						
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].PlanId").equals(planId));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].PlanId").equals(planId));			
			
		if (valueAssertions.equals("true")) {

			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanId").contains(membershipPlanClub1OnlyId));
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.Description").contains(membershipPlanClub1OnlyDescription));
			
			}
	}
	
	@Test (priority = 13, testName= "Plan Not Available in Specific Club", description = "PBI: 179764 - Updated by PBI 185540")
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
			.body(AgreementInfoPL.getMembershipPlansRequiredParameters(companyId, clubId))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);			
			
		if (valueAssertions.equals("true")) {

			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanId").contains(membershipPlanClub1OnlyId));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.Description").contains(membershipPlanClub1OnlyDescription));
			
			}
	}
	
	@Test (priority = 14, testName="Family Plans Only", description = "PBI: 179764 - Updated by PBI 185540")
	public void familyPlansOnly() {
		
		String IndividualPlansFilter = "FamilyPlan";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansSpecificIndividualPlanFilter(companyId, clubId,IndividualPlansFilter))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);				
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			count = js.getInt("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.size()");
            
            if (valueAssertions.equals("true")) {
			
			for (int i = 0; i<count; i++)
				
			{
				String IsIndividualPlan = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse["+i+"].IsIndividualPlan");
			    					
				Assert.assertTrue(IsIndividualPlan.equals("false")); 
				
			}
			
            }
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").equals("false"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.IsIndividualPlan").equals("true")); // Confirm none of the plans are Individual
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].PlanId").equals(planId));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].PlanId").equals(planId));		

	}
	
	@Test (priority = 15, testName="Individual Plans Only", description = "PBI: 179764 - Updated by PBI 185540")
	public void individualPlansOnly() {
		
		String IndividualPlansFilter = "IndividualPlan";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansSpecificIndividualPlanFilter(companyId, clubId, IndividualPlansFilter))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
	
			Assert.assertTrue(res.getTime() >= 60L);
			
			count = js.getInt("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.size()");
            
            if (valueAssertions.equals("true")) {
			
			for (int i = 0; i<count; i++)
				
			{
				String IsIndividualPlan = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse["+i+"].IsIndividualPlan");
			    					
				Assert.assertTrue(IsIndividualPlan.equals("true")); 
				
			}
			
            }
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").equals("true"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.IsIndividualPlan").equals("false")); // Confirm none of the plans are Family
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
					

	}
	
	@Test (priority = 16, testName="Promo Plans Only", description = "PBI: 179764 - Updated by PBI 185540")
	public void PromoPlansOnly() {
		
		String PromoPlanFilter = "PromoPlansOnly";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansSpecificPromoPlanFilter(companyId, clubId,PromoPlanFilter))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);				
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			count = js.getInt("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.size()");
            
            if (valueAssertions.equals("true")) {
			
			for (int i = 0; i<count; i++)
				
			{
				String IsPromoPlan = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse["+i+"].IsPromoPlan");
			    					
				Assert.assertTrue(IsPromoPlan.equals("true")); 
				
			}
			
            }
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").equals("false"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.IsIndividualPlan").equals("true")); // Confirm none of the plans are Individual
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].PlanId").equals(planId));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].PlanId").equals(planId));		

	}
	
	@Test (priority = 17, testName="Promo Plans Excluded", description = "PBI: 179764 - Updated by PBI 185540")
	public void PromoPlansExcluded() {
		
		String PromoPlanFilter = "PromoPlansExcluded";
		String PromoPlanId = prop.getProperty("PromoPlanId");
		String PromoPlanDescription = prop.getProperty("PromoPlanDescription");
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansSpecificPromoPlanFilter(companyId, clubId,PromoPlanFilter))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);				
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			count = js.getInt("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.size()");
            
            if (valueAssertions.equals("true")) {
			
			for (int i = 0; i<count; i++)
				
			{
				String IsPromoPlan = js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse["+i+"].IsPromoPlan");
			    					
				Assert.assertTrue(IsPromoPlan.equals("false")); 
				
			}
			
            }
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Description").isBlank());
			Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsIndividualPlan").equals("false"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.IsIndividualPlan").equals("true")); // Confirm none of the plans are Individual
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].PlanType").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentPrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalDownPaymentOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargePrimary").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeFirstFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].TotalRecurringChargeOtherFamily").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].IsFeaturedPlan").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].Services.PlanServiceDto[0].PlanId").equals(planId));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].ItemId").isBlank());
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].Description").isBlank());
			//Assert.assertTrue(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0].MembershipAreas.MembershipAreaDto[0].PlanId").equals(planId));		

			
			if (valueAssertions.equals("true")) {

				Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.PlanId").contains(PromoPlanId));
				Assert.assertFalse(js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse.Description").contains(PromoPlanDescription));
				
				}
	}


	@Test (priority = 18, testName="Club Not Found", description = "PBI: 179764 - Updated by PBI 185540")
	public void clubNotFound() {
		
		String clubId = "99999";
		
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
			.statusCode(500)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto").equals("Club not found"));	
			Assert.assertTrue(!js.getString("Envelope.Body").contains("GetMembershipPlansResponse"));
					

	}
	
	@Test (priority = 19, testName="Plan Category Not Found", description = "PBI: 179764 - Updated by PBI 185540")
	public void planCategoryNotFound() {
		
		String AgreementCategoryIdFilter = "99999";
		
		Response res = 
				
		given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetMembershipPlans",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getMembershipPlansSpecificAgreementCategory(companyId, clubId, AgreementCategoryIdFilter))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("PlanId"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("Description"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("IsIndividualPlan"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("PlanType"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("TotalDownPaymentPrimary"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("TotalDownPaymentFirstFamily"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("TotalDownPaymentOtherFamily"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("TotalRecurringChargePrimary"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("TotalRecurringChargeFirstFamily"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("TotalRecurringChargeOtherFamily"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("IsFeaturedPlan"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("Services.PlanServiceDto[0].ItemId"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("Services"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("MembershipAreas"));
			Assert.assertTrue(!js.getString("Envelope.Body.GetMembershipPlansResponse.GetMembershipPlansResult.MembershipPlanResponse[0]").contains("MembershipAreas"));			

	}


}


