package payloads;

import resources.base;

	public class CheckInPL extends base{
	
	public static String GetAvailablePunchcardsForMember(String companyId, String customerId){
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
			+ "  <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
			+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
			+ "   </soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:GetAvailablePunchcardsForMember>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:customerId>"+customerId+"</tem:customerId>\r\n"
			+ "      </tem:GetAvailablePunchcardsForMember>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	
	return pl;
	}

	public static String GetCustomerVisits(String companyId, String customerId, String startDateTime, String startOffset, String endDateTime,  String endOffset){
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Info\" xmlns:sys=\"http://schemas.datacontract.org/2004/07/System\">\r\n"
		+ "    <soapenv:Header>\r\n"
		+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
		+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
		+ "   </soapenv:Header>\r\n"
		+ "   <soapenv:Body>\r\n"
		+ "      <tem:GetCustomerVisits>\r\n"
		+ "         <!--Optional:-->\r\n"
		+ "         <tem:request>\r\n"
		+ "            <jfi:CustomerId>"+customerId+"</jfi:CustomerId>\r\n"
		+ "            <jfi:StartDate>\r\n"
		+ "               <sys:DateTime>"+startDateTime+"</sys:DateTime>\r\n"
		+ "               <sys:OffsetMinutes>"+startOffset+"</sys:OffsetMinutes>\r\n"
		+ "            </jfi:StartDate>\r\n"
		+ "            <jfi:EndDate>\r\n"
		+ "               <sys:DateTime>"+endDateTime+"</sys:DateTime>\r\n"
		+ "               <sys:OffsetMinutes>"+endOffset+"</sys:OffsetMinutes>\r\n"
		+ "            </jfi:EndDate>\r\n"
		+ "         </tem:request>\r\n"
		+ "      </tem:GetCustomerVisits>\r\n"
		+ "   </soapenv:Body>\r\n"
		+ "</soapenv:Envelope>";

		return pl;
	}
	
	public static String processCustomerCheckInPl(String companyId, String checkInValidations, String clubId, String customerId, String serviceId, String stationId) {
		
		String	pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.CheckIns\">\r\n"
				+ "	<soapenv:Header>\r\n"
				+ "		<CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "		<CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "	</soapenv:Header>\r\n"
				+ "	<soapenv:Body>\r\n"
				+ "      <tem:ProcessCustomerCheckIn>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:request>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi:CheckInValidations>"+checkInValidations+"</jfi:CheckInValidations>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi:ClubId>"+clubId+"</jfi:ClubId>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi:CustomerId>"+customerId+"</jfi:CustomerId>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi:ServiceId>"+serviceId+"</jfi:ServiceId>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi:StationId>"+stationId+"</jfi:StationId>\r\n"
				+ "         </tem:request>\r\n"
				+ "      </tem:ProcessCustomerCheckIn>\r\n"
				+ "	</soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
	
		return pl; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
