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


}
