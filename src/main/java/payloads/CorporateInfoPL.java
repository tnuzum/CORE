package payloads;

import resources.base;

public class CorporateInfoPL extends base {
	
	public static String GetActiveClubs()
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"      <soapenv:Header>\r\n" + 
				"    <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"        <soapenv:Body>\r\n" + 
				"      <tem:GetActiveClubs/>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}

}
