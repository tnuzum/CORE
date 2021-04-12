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
	
	public static String getMembershipPlansAllParameters(String companyId,String clubId,String includeAllClubs,String includeIndividualPlans,String agreementCategoryId,String duration,String durationType,String availableOnlineOnly,String planType)
	
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
				+ "            <jfi:AgreementCategoryId>"+agreementCategoryId+"</jfi:AgreementCategoryId>\r\n"
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

}
