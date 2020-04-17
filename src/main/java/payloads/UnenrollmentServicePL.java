package payloads;

import resources.base;

public class UnenrollmentServicePL extends base{
	
public static String GetUnenrollmentEligibility(String companyId, String enrollmentId)
	
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"     <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetUnenrollmentEligibility>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:enrollmentId>"+enrollmentId+"</tem:enrollmentId>\r\n" + 
				"      </tem:GetUnenrollmentEligibility>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}


}
