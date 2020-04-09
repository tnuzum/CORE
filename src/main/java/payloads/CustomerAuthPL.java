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


}
