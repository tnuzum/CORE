package payloads;

import resources.base;

public class CorporateInfoPL extends base {
	
	public static String GetActiveClubs(String companyId)
	
	{
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
	
	public static String GetBranding(String companyId, String clubId, String brandingFilter)
	
	{
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
	
	public static String GetBrandingLogo(String companyId, String clubId, String brandingFilter)
	
	{
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
	
	public static String GetClubInfo(String companyId, int clubId)
	{
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
	
	
}
