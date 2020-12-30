package payloads;

import resources.base;

public class CorporateInfoPL extends base {
	
	public static String companyHasModuleGrant(String companyId){
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:CompanyHasModuleGrant>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <!--tem:moduleName></tem:moduleName-->\r\n" + 
				"      </tem:CompanyHasModuleGrant>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetActiveClubs(String companyId){
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"      <soapenv:Header>\r\n" + 
				"    <CompanyId xmlns=\"http://jonasfitness.com/Core/\">" + companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"        <soapenv:Body>\r\n" + 
				"      <tem:GetActiveClubs/>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetBranding(String companyId, String clubId, String brandingFilter){
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Info\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Employee</CallerContext><EmployeeBarcode i:nil=\"true\" xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://jonasfitness.com/Core/\"/></soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetBranding>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubNumber>"+clubId+"</tem:clubNumber>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:brandingFilter>"+brandingFilter+"</tem:brandingFilter>\r\n" + 
				"      </tem:GetBranding>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetBrandingLogo(String companyId, String clubId, String brandingFilter){
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetBrandingLogo>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubNumber>"+clubId+"</tem:clubNumber>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:brandingFilter>"+brandingFilter+"</tem:brandingFilter>\r\n" + 
				"      </tem:GetBrandingLogo>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetChangeRequestTermsAndConditions(String companyId){
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetChangeRequestTermsAndConditions/>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}

	public static String GetClubInfo(String companyId, int clubId){
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">" + companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetClubInfo>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubNumber>"+clubId+"</tem:clubNumber>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubInfo>All</tem:clubInfo>\r\n" + 
				"      </tem:GetClubInfo>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
}
	
	public static String GetClubAcceptedCreditCards(String companyId, String clubId) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetClubAcceptedCreditCards>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubNumber>"+clubId+"</tem:clubNumber>\r\n" + 
				"      </tem:GetClubAcceptedCreditCards>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetCompanyName(String companyId) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetCompanyName/>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetExternalLinks(String companyId, String clubId) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetExternalLinks>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubNumber>"+clubId+"</tem:clubNumber>\r\n" + 
				"      </tem:GetExternalLinks>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetGoogleAnalyticsId(String companyId, String appFilter) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetGoogleAnalyticsId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:appFilter>"+appFilter+"</tem:appFilter>\r\n" + 
				"      </tem:GetGoogleAnalyticsId>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetInterestConfiguration(String companyId) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetInterestConfiguration/>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetRequiredFields(String companyId) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetRequiredFields/>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetBusinessIntelligenceConfiguration(String companyId) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Employee</CallerContext></soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetBusinessIntelligenceConfiguration/>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String SetBusinessIntelligenceConfiguration(
			
			String companyId,
			String clubId,
			String clubName,
			String clubIsSelected,
			String timeFrame,
			String timeFrameUnits,
			String isActivated) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Business\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:SetBusinessIntelligenceConfiguration>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:businessIntelligenceConfiguration>\r\n" + 
				"            <!--Optional:-->\r\n" + 
				"            <jfi:ClubSelection>\r\n" + 
				"               <!--Zero or more repetitions:-->\r\n" + 
				"               <jfi:BIClubSelectionDto>\r\n" + 
				"                  <!--Optional:-->\r\n" + 
				"                  <jfi:ClubId>"+clubId+"</jfi:ClubId>\r\n" + 
				"                  <!--Optional:-->\r\n" + 
				"                  <jfi:ClubName>"+clubName+"</jfi:ClubName>\r\n" + 
				"                  <!--Optional:-->\r\n" + 
				"                  <jfi:IsSelected>"+clubIsSelected+"</jfi:IsSelected>\r\n" + 
				"               </jfi:BIClubSelectionDto>\r\n" + 
				"            </jfi:ClubSelection>\r\n" + 
				"            <!--Optional:-->\r\n" + 
				"            <jfi:DataStorageTimeframe>"+timeFrame+"</jfi:DataStorageTimeframe>\r\n" + 
				"            <!--Optional:-->\r\n" + 
				"            <jfi:DataStorageTimeframeUnits>"+timeFrameUnits+"</jfi:DataStorageTimeframeUnits>\r\n" + 
				"            <!--Optional:-->\r\n" + 
				"            <jfi:IsActivated>"+isActivated+"</jfi:IsActivated>\r\n" + 
				"         </tem:businessIntelligenceConfiguration>\r\n" + 
				"      </tem:SetBusinessIntelligenceConfiguration>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String SetBusinessIntelligenceConfiguration_MultipleClubs(String companyId, String clubId, String clubName, String clubIsSelected, String club2Id, String club2Name, String club2IsSelected, String timeFrame, String timeFrameUnits, String isActivated) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Business\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:SetBusinessIntelligenceConfiguration>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:businessIntelligenceConfiguration>\r\n" + 
				"            <!--Optional:-->\r\n" + 
				"            <jfi:ClubSelection>\r\n" + 
				"               <!--Zero or more repetitions:-->\r\n" + 
				"               <jfi:BIClubSelectionDto>\r\n" + 
				"                  <!--Optional:-->\r\n" + 
				"                  <jfi:ClubId>"+clubId+"</jfi:ClubId>\r\n" + 
				"                  <!--Optional:-->\r\n" + 
				"                  <jfi:ClubName>"+clubName+"</jfi:ClubName>\r\n" + 
				"                  <!--Optional:-->\r\n" + 
				"                  <jfi:IsSelected>"+clubIsSelected+"</jfi:IsSelected>\r\n" + 
				"               </jfi:BIClubSelectionDto>\r\n" + 
				"               <jfi:BIClubSelectionDto>\r\n" + 
				"                  <!--Optional:-->\r\n" + 
				"                  <jfi:ClubId>"+club2Id+"</jfi:ClubId>\r\n" + 
				"                  <!--Optional:-->\r\n" + 
				"                  <jfi:ClubName>"+club2Name+"</jfi:ClubName>\r\n" + 
				"                  <!--Optional:-->\r\n" + 
				"                  <jfi:IsSelected>"+club2IsSelected+"</jfi:IsSelected>\r\n" + 
				"               </jfi:BIClubSelectionDto>\r\n" + 
				"            </jfi:ClubSelection>\r\n" + 
				"            <!--Optional:-->\r\n" + 
				"            <jfi:DataStorageTimeframe>"+timeFrame+"</jfi:DataStorageTimeframe>\r\n" + 
				"            <!--Optional:-->\r\n" + 
				"            <jfi:DataStorageTimeframeUnits>"+timeFrameUnits+"</jfi:DataStorageTimeframeUnits>\r\n" + 
				"            <!--Optional:-->\r\n" + 
				"            <jfi:IsActivated>"+isActivated+"</jfi:IsActivated>\r\n" + 
				"         </tem:businessIntelligenceConfiguration>\r\n" + 
				"      </tem:SetBusinessIntelligenceConfiguration>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetBannerMessagesForCustomer(String companyID, String customerid) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
				+ "   <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyID+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetBannerMessagesForCustomer>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:customerId>"+customerid+"</tem:customerId>\r\n"
				+ "      </tem:GetBannerMessagesForCustomer>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}
	

}
