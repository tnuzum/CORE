package payloads;

import resources.base;

public class WaiversPL  extends base{
	
public static String GetFamilyNeedDob(String companyId, String customerId, String clubId)
	
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
				+ "   <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetFamilyNeedsDob>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:customerId>"+customerId+"</tem:customerId>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:clubId>"+clubId+"</tem:clubId>\r\n"
				+ "      </tem:GetFamilyNeedsDob>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
}
}
