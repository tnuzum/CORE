package payloads;

import resources.base;

public class AccountHistory extends base {
	
	public static String getTransactionSummary(String companyId, String customerId, String clubId, String startDateTime, String endDateTime)
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Common\">\r\n"
				+ "  <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetTransactionSummary>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:customerId>"+customerId+"</tem:customerId>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:startRange>\r\n"
				+ "            <jfi:ClubId>"+clubId+"</jfi:ClubId>\r\n"
				+ "            <jfi:DateTime>"+startDateTime+"</jfi:DateTime>\r\n"
				+ "         </tem:startRange>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:endRange>\r\n"
				+ "            <jfi:ClubId>1</jfi:ClubId>\r\n"
				+ "            <jfi:DateTime>"+endDateTime+"</jfi:DateTime>\r\n"
				+ "         </tem:endRange>\r\n"
				+ "      </tem:GetTransactionSummary>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}

}
