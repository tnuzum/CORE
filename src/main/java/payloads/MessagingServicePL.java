package payloads;

import resources.base;

public class MessagingServicePL extends base {
	
	public static String SendFamilyClassEnrollmentConfirmationEmail(String companyId, String InvoiceId)
	
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:SendFamilyClassEnrollmentConfirmationEmail>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:invoiceId>"+InvoiceId+"</tem:invoiceId>\r\n" + 
				"      </tem:SendFamilyClassEnrollmentConfirmationEmail>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}

}
