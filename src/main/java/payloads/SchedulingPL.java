package payloads;

import resources.base;

public class SchedulingPL extends base {

public static String GetCustomerSchedule(String companyId, String customerId, String startDateTime, String endDateTime, String ScheduleRequestType) {
	
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Info\" xmlns:sys=\"http://schemas.datacontract.org/2004/07/System\">\r\n" + 
			"  <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:GetCustomerSchedule>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:request>\r\n" + 
			"            <jfi:CustomerId>"+customerId+"</jfi:CustomerId>\r\n" + 
			"            <jfi:StartRange>\r\n" + 
			"               <sys:DateTime>"+startDateTime+"T00:00:00Z</sys:DateTime>\r\n" + 
			"               <sys:OffsetMinutes>-240</sys:OffsetMinutes>\r\n" + 
			"            </jfi:StartRange>\r\n" + 
			"            <jfi:EndRange>\r\n" + 
			"               <sys:DateTime>"+endDateTime+"T00:00:00Z</sys:DateTime>\r\n" + 
			"               <sys:OffsetMinutes>-240</sys:OffsetMinutes>\r\n" + 
			"            </jfi:EndRange>\r\n" + 
			"            <jfi:ScheduleRequestType>"+ScheduleRequestType+"</jfi:ScheduleRequestType>\r\n" + 
			"         </tem:request>\r\n" + 
			"      </tem:GetCustomerSchedule>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;

}
}
