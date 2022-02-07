package payloads;

import resources.base;

public class AgreementInfoPL extends base {
	
	public static String getCustomerRelatedAgreements(String companyId, String customerId)
	
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetCustomerRelatedAgreements>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
				"      </tem:GetCustomerRelatedAgreements>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}

	public static String getAgreementCategories(String companyId)
	
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
				+ "   <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      	<CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "      </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetAgreementCategories/>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}
	
	public static String getMembershipPlansAllParameters(String companyId,String clubId,String includeAllClubs,String includeIndividualPlans,String planCategoryId,String duration,String durationType,String availableOnlineOnly,String planType)
	
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Agreements\">\r\n"
				+ "   <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetMembershipPlans>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:request>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi:ClubId>"+clubId+"</jfi:ClubId>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi:IncludeAllClubs>"+includeAllClubs+"</jfi:IncludeAllClubs>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi:IncludeIndividualPlans>"+includeIndividualPlans+"</jfi:IncludeIndividualPlans>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi:PlanCategoryId>"+planCategoryId+"</jfi:PlanCategoryId>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi:Duration>"+duration+"</jfi:Duration>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi:DurationType>"+durationType+"</jfi:DurationType>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi:AvailableOnlineOnly>"+availableOnlineOnly+"</jfi:AvailableOnlineOnly>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi:PlanType>"+planType+"</jfi:PlanType>\r\n"
				+ "         </tem:request>\r\n"
				+ "      </tem:GetMembershipPlans>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}
	
	public static String getMembershipPlansRequiredParameters(String companyId,String clubId)
	
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Agreements\">\r\n"
				+ "   <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetMembershipPlans>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:request>\r\n"
				+ "            <jfi:ClubId>"+clubId+"</jfi:ClubId>\r\n"
				+ "         </tem:request>\r\n"
				+ "      </tem:GetMembershipPlans>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}
	
public static String getMembershipPlansSpecificAgreementCategory(String companyId,String clubId, String AgreementCategoryIdFilter)
	
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Agreements\">\r\n"
				+ "  <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetMembershipPlans>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:request>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "            <jfi:AgreementCategoryIdFilter>"+AgreementCategoryIdFilter+"</jfi:AgreementCategoryIdFilter>\r\n"
				+ "            <jfi:ClubId>"+clubId+"</jfi:ClubId>\r\n"
				+ "         </tem:request>\r\n"
				+ "      </tem:GetMembershipPlans>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}
public static String getMembershipPlansSpecificPlanType(String companyId,String clubId, String PlanType)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Agreements\">\r\n"
			+ "  <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:GetMembershipPlans>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:request>\r\n"
			+ "         <!--Optional:-->            \r\n"
			+ "            <jfi:ClubId>"+clubId+"</jfi:ClubId>\r\n"
			+ "              <jfi:PlanTypeFilter>"+PlanType+"</jfi:PlanTypeFilter>\r\n"
			+ "         </tem:request>\r\n"
			+ "      </tem:GetMembershipPlans>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	return pl;
}

public static String getMembershipPlansSpecificPlanTypeAndDuration(String companyId,String clubId, String PlanType, String DurationFilter, String DurationFilterValue)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Agreements\">\r\n"
			+ "  <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:GetMembershipPlans>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:request>\r\n"
			+ "         <!--Optional:-->            \r\n"
			+ "            <jfi:ClubId>"+clubId+"</jfi:ClubId>\r\n"
			+ "            <!--Optional:-->\r\n"
			+ "            <jfi:DurationFilter>"+DurationFilter+"</jfi:DurationFilter>\r\n"
			+ "            <!--Optional:-->\r\n"
			+ "            <jfi:DurationFilterValue>"+DurationFilterValue+"</jfi:DurationFilterValue>\r\n"
			+ "              <jfi:PlanTypeFilter>"+PlanType+"</jfi:PlanTypeFilter>          \r\n"
			+ "         </tem:request>\r\n"
			+ "      </tem:GetMembershipPlans>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	return pl;
}

public static String getMembershipPlansSpecificOnlineFilter(String companyId,String clubId, String OnlineFilter)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Agreements\">\r\n"
			+ "  <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:GetMembershipPlans>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:request>\r\n"
			+ "         <!--Optional:-->            \r\n"
			+ "            <jfi:ClubId>"+clubId+"</jfi:ClubId>\r\n"
			+ "              <jfi:OnlineFilter>"+OnlineFilter+"</jfi:OnlineFilter>   \r\n"
			+ "         </tem:request>\r\n"
			+ "      </tem:GetMembershipPlans>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	return pl;
}

public static String getMembershipPlansSpecificIndividualPlanFilter(String companyId, String clubId, String IndividualPlansFilter)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Agreements\">\r\n"
			+ "  <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:GetMembershipPlans>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:request>\r\n"
			+ "         <!--Optional:-->            \r\n"
			+ "            <jfi:ClubId>"+clubId+"</jfi:ClubId>\r\n"
			+ "             <jfi:IndividualPlansFilter>"+IndividualPlansFilter+"</jfi:IndividualPlansFilter>  \r\n"
			+ "         </tem:request>\r\n"
			+ "      </tem:GetMembershipPlans>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	return pl;
}

public static String getMembershipPlansSpecificPromoPlanFilter(String companyId, String clubId, String IndividualPlansFilter)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Agreements\">\r\n"
			+ "  <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:GetMembershipPlans>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:request>\r\n"
			+ "         <!--Optional:-->            \r\n"
			+ "            <jfi:ClubId>"+clubId+"</jfi:ClubId>\r\n"
			+ "              <jfi:PromoPlanFilter>"+IndividualPlansFilter+"</jfi:PromoPlanFilter>  \r\n"
			+ "         </tem:request>\r\n"
			+ "      </tem:GetMembershipPlans>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	return pl;
}


	public static String getMembershipPlanDetailsAllParameters(String companyId,String clubId, String planId, String effectiveDate)
	
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
				+ "   <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Employee</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetMembershipPlanDetails>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:clubId>"+clubId+"</tem:clubId>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:planId>"+planId+"</tem:planId>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:effectiveDate>"+effectiveDate+"</tem:effectiveDate>\r\n"
				+ "      </tem:GetMembershipPlanDetails>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}
	
	public static String getMembershipPlanDetailsRequiredParameters(String companyId,String clubId, String planId)
	
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
				+ "   <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Employee</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetMembershipPlanDetails>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:clubId>"+clubId+"</tem:clubId>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:planId>"+planId+"</tem:planId>\r\n"
				+ "      </tem:GetMembershipPlanDetails>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}
	
	
	
	
	
}
