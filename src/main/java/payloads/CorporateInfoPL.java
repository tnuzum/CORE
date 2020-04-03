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
	
	public static String GetClubInfo(String companyId)
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">" + companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetClubInfo>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubNumber>1</tem:clubNumber>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubInfo>All</tem:clubInfo>\r\n" + 
				"      </tem:GetClubInfo>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;

}
	
}
