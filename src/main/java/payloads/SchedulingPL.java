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

public static String ScheduleSingleMbrAppt(String companyId, String customerId, String clubId, String itemId, String bookId, String dateTime) {
	
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\" xmlns:sys=\"http://schemas.datacontract.org/2004/07/System\">\r\n"
			+ "  <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
			+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
			+ "   </soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:ScheduleAppointment>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:customerId>"+customerId+"</tem:customerId>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "       \r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:clubId>"+clubId+"</tem:clubId>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:itemId>"+itemId+"</tem:itemId>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:requestedBooks>\r\n"
			+ "            <!--Zero or more repetitions:-->\r\n"
			+ "            <arr:int>"+bookId+"</arr:int>\r\n"
			+ "         </tem:requestedBooks>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:occurrence>\r\n"
			+ "            <sys:DateTime>"+dateTime+"</sys:DateTime>\r\n"
			+ "            <sys:OffsetMinutes>-480</sys:OffsetMinutes>\r\n"
			+ "         </tem:occurrence>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:enforcePunchesRequired>false</tem:enforcePunchesRequired>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:userDisplayedPrice>90.00</tem:userDisplayedPrice>\r\n"
			+ "      </tem:ScheduleAppointment>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	return pl;

}

public static String ScheduleGroupAppt(String companyId, String primaryMemberId, String groupMemberId, String clubId, String itemId, String bookId, String dateTime) {
	
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\" xmlns:sys=\"http://schemas.datacontract.org/2004/07/System\">\r\n"
			+ "  <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
			+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
			+ "   </soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:ScheduleAppointment>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:customerId>"+primaryMemberId+"</tem:customerId>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "      <tem:additionalCustomerIds>\r\n"
			+ "            <!--Zero or more repetitions:-->\r\n"
			+ "            <arr:int>"+groupMemberId+"</arr:int>\r\n"
			+ "         </tem:additionalCustomerIds>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:clubId>"+clubId+"</tem:clubId>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:itemId>"+itemId+"</tem:itemId>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:requestedBooks>\r\n"
			+ "            <!--Zero or more repetitions:-->\r\n"
			+ "            <arr:int>"+bookId+"</arr:int>\r\n"
			+ "         </tem:requestedBooks>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:occurrence>\r\n"
			+ "            <sys:DateTime>"+dateTime+"</sys:DateTime>\r\n"
			+ "            <sys:OffsetMinutes>-480</sys:OffsetMinutes>\r\n"
			+ "         </tem:occurrence>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:enforcePunchesRequired>false</tem:enforcePunchesRequired>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:userDisplayedPrice>90.00</tem:userDisplayedPrice>\r\n"
			+ "      </tem:ScheduleAppointment>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	return pl;

}


public static String cancelAppointment(String companyId, String customerId, String appointmentId) {
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
			+ "   <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
			+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
			+ "   </soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:CancelAppointment>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:customerId>"+customerId+"</tem:customerId>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:appointmentId>"+appointmentId+"</tem:appointmentId>\r\n"
			+ "      </tem:CancelAppointment>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	return pl;
}


public static String cancelAppointmentByAppointmentId(String companyId, String appointmentId) {
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
			+ "  <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId>\r\n"
			+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
			+ "   </soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:CancelAppointmentByAppointmentId>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:appointmentId>"+appointmentId+"</tem:appointmentId>\r\n"
			+ "      </tem:CancelAppointmentByAppointmentId>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	return pl;
}
public static String GetAppointmentInfo(String companyId, String customerId, String appointmentId) {
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
			+ "    <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
			+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
			+ "   </soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:GetAppointmentInfo>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:customerId>"+customerId+"</tem:customerId>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:appointmentId>"+appointmentId+"</tem:appointmentId>\r\n"
			+ "      </tem:GetAppointmentInfo>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	return pl;
}

public static String GetAppointmentEligibility(String companyId, String clubId, String customerId, String ItemId) {
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n"
			+ "   <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
			+ "      </soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:GetAppointmentEligibility>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:clubId>"+clubId+"</tem:clubId>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:itemId>"+ItemId+"</tem:itemId>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:customerIds>\r\n"
			+ "            <!--Zero or more repetitions:-->\r\n"
			+ "            <arr:int>"+customerId+"</arr:int>\r\n"	
	        + "         </tem:customerIds>\r\n"
			+ "      </tem:GetAppointmentEligibility>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	return pl;
}

}
