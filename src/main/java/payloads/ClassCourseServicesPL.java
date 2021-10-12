package payloads;

import resources.base;

public class ClassCourseServicesPL extends base {
	
	public static String GetAvailableClasses(String companyId, String customerId, String clubId, String startDateTime, String endDateTime)
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Info\" xmlns:sys=\"http://schemas.datacontract.org/2004/07/System\">\r\n"
				+ "    <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetAvailableClasses>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:customerId>"+customerId+"</tem:customerId>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:clubNumber>"+clubId+"</tem:clubNumber>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:startDate>\r\n"
				+ "            <sys:DateTime>"+startDateTime+"</sys:DateTime>\r\n"
				+ "            <sys:OffsetMinutes>-300</sys:OffsetMinutes>\r\n"
				+ "         </tem:startDate>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:endDate>\r\n"
				+ "            <sys:DateTime>"+endDateTime+"</sys:DateTime>\r\n"
				+ "            <sys:OffsetMinutes>-300</sys:OffsetMinutes>\r\n"
				+ "         </tem:endDate>\r\n"
				+ "      </tem:GetAvailableClasses>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		
		return pl;
	}
	
	
	public static String GetAvailableCourses(String companyId, String customerId, String clubId, String startDateTime, String endDateTime)
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Info\" xmlns:sys=\"http://schemas.datacontract.org/2004/07/System\">\r\n"
				+ "    <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetAvailableCourses>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:customerId>"+customerId+"</tem:customerId>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:clubNumber>"+clubId+"</tem:clubNumber>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:startDate>\r\n"
				+ "            <sys:DateTime>"+startDateTime+"</sys:DateTime>\r\n"
				+ "            <sys:OffsetMinutes>-300</sys:OffsetMinutes>\r\n"
				+ "         </tem:startDate>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:endDate>\r\n"
				+ "            <sys:DateTime>"+endDateTime+"</sys:DateTime>\r\n"
				+ "            <sys:OffsetMinutes>-300</sys:OffsetMinutes>\r\n"
				+ "         </tem:endDate>\r\n"
				+ "      </tem:GetAvailableCourses>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
	
		return pl;
	}
	
	public static String GetAvailableClass(String companyId, String customerId, String classBarcodeId, String DateTime)
	{
		String pl= "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Info\" xmlns:sys=\"http://schemas.datacontract.org/2004/07/System\">\r\n"
				+ "    <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetAvailableClass>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:customerId>"+customerId+"</tem:customerId>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:classBarcodeId>"+classBarcodeId+"</tem:classBarcodeId>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:classDateTime>\r\n"
				+ "            <sys:DateTime>"+DateTime+"</sys:DateTime>\r\n"
				+ "            <sys:OffsetMinutes>-300</sys:OffsetMinutes>\r\n"
				+ "         </tem:classDateTime>\r\n"
				+ "      </tem:GetAvailableClass>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}
	
}
