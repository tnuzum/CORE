package payloads;

import resources.base;

public class CustomerAuthPL extends base {
	
	public static String AuthorizeCustomer(String companyId, String customerid)
	
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:AuthorizeCustomer>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>"+customerid+"</tem:customerId>\r\n" + 
				"      </tem:AuthorizeCustomer>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	public static String AuthenticateCustomer(String companyId, String userName, String passWord) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Auth\">\r\n"
				+ "   <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "      <EmployeeBarcode i:nil=\"true\" xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://jonasfitness.com/Core/\"/>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:AuthenticateCustomer>\r\n"
				+ "         <tem:request>\r\n"
				+ "            <jfi:Password>"+passWord+"</jfi:Password>\r\n"
				+ "            <jfi:Username>"+userName+"</jfi:Username>\r\n"
				+ "         </tem:request>\r\n"
				+ "      </tem:AuthenticateCustomer>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}


}
