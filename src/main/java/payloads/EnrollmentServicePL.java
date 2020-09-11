package payloads;

import resources.base;

public class EnrollmentServicePL extends base{
	
	public static String EnrollInClassStandby(String companyId, String customerId, String classId, String dateTime) {
		
		String pl ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:sys=\"http://schemas.datacontract.org/2004/07/System\">\r\n" + 
				"  <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"      </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:EnrollInClassStandby>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:classId>"+classId+"</tem:classId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:occurrence>\r\n" + 
				"            <sys:DateTime>"+dateTime+"T21:00:00</sys:DateTime>\r\n" + 
				"            <sys:OffsetMinutes>-240</sys:OffsetMinutes>\r\n" + 
				"         </tem:occurrence>\r\n" + 
				"      </tem:EnrollInClassStandby>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
public static String EnrollInCourseStandby(String companyId, String customerId, String courseId) {
		
		String pl ="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"  <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"      </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:EnrollInCourseStandby>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:courseId>"+courseId+"</tem:courseId>\r\n" + 
				"      </tem:EnrollInCourseStandby>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String DeleteEnrollment(String companyId, String enrollmentId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"  <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"      </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:DeleteEnrollment>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:enrollmentId>"+enrollmentId+"</tem:enrollmentId>\r\n" + 
				"      </tem:DeleteEnrollment>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String PromoteStandbyEnrollmentsForClass(String companyId, String classId, String tomorrowsDate) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:sys=\"http://schemas.datacontract.org/2004/07/System\">\r\n" + 
				"  <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"      </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:PromoteStandbyEnrollmentsForClass>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:classId>"+classId+"</tem:classId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:occurrence>\r\n" + 
				"            <sys:DateTime>"+tomorrowsDate+"T17:00:00</sys:DateTime>\r\n" + 
				"            <sys:OffsetMinutes>-240</sys:OffsetMinutes>\r\n" + 
				"         </tem:occurrence>\r\n" + 
				"      </tem:PromoteStandbyEnrollmentsForClass>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String PromoteStandbyEnrollmentsForCourse(String companyId, String courseId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"  <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"      </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:PromoteStandbyEnrollmentsForCourse>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:courseId>"+courseId+"</tem:courseId>\r\n" + 
				"      </tem:PromoteStandbyEnrollmentsForCourse>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String EnrollInClass(String companyId, String customerId, String classId, String dateTime) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:sys=\"http://schemas.datacontract.org/2004/07/System\">\r\n" + 
				"      <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"      </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:EnrollInClass>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:classId>"+classId+"</tem:classId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:occurrence>\r\n" + 
				
				" <sys:DateTime>"+dateTime+"</sys:DateTime>\r\n" + 
				"            <sys:OffsetMinutes>-240</sys:OffsetMinutes>\r\n" + 
				"         </tem:occurrence>\r\n" + 
				"         <tem:paymentType>Money</tem:paymentType>\r\n" + 
				"      </tem:EnrollInClass>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String EnrollInCourse(String companyId, String customerId, String courseId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"  <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"      </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:EnrollInCourse>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:courseId>"+courseId+"</tem:courseId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <!--tem:invoiceDetailId>?</tem:invoiceDetailId-->\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:paymentType>Money</tem:paymentType>\r\n" + 
				"      </tem:EnrollInCourse>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetClass_Virtual(String companyId, String customerId, String classId, String dateTime) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:sys=\"http://schemas.datacontract.org/2004/07/System\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"      </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetClass>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:itemId>"+classId+"</tem:itemId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:occurrence>\r\n" + 
				"            <sys:DateTime>"+dateTime+"</sys:DateTime>\r\n" + 
				"            <sys:OffsetMinutes>-240</sys:OffsetMinutes>\r\n" + 
				"         </tem:occurrence>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerIds>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <arr:int>"+customerId+"</arr:int>\r\n" + 
				"         </tem:customerIds>\r\n" + 
				"      </tem:GetClass>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetCourse_Virtual(String companyId, String customerId, String classId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
				"  <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"      </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetCourse>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:itemId>"+classId+"</tem:itemId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerIds>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"           <arr:int>"+customerId+"</arr:int>\r\n" + 
				"         </tem:customerIds>\r\n" + 
				"      </tem:GetCourse>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetAvailableClasses_Virtual(String companyId, String customerId, String startDateTime, String endDateTime) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Common\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"      </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetAvailableClasses>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubId>1</tem:clubId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerIds>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"             <arr:int>"+customerId+"</arr:int>\r\n" + 
				"            \r\n" + 
				"             </tem:customerIds>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:startDate>\r\n" + 
				"            <jfi:ClubId>1</jfi:ClubId>\r\n" + 
				"            <jfi:DateTime>"+startDateTime+"</jfi:DateTime>\r\n" + 
				"         </tem:startDate>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:endDate>\r\n" + 
				"            <jfi:ClubId>1</jfi:ClubId>\r\n" + 
				"            <jfi:DateTime>"+endDateTime+"</jfi:DateTime>\r\n" + 
				"         </tem:endDate>\r\n" + 
				"      </tem:GetAvailableClasses>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetAvailableCourses_Virtual(String companyId, String customerId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Common\">\r\n" + 
				"  <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"      </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetAvailableCourses>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubId>1</tem:clubId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerIds>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"             <!--arr:int>"+customerId+"</arr:int-->\r\n" + 
				"         </tem:customerIds>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:startDate>\r\n" + 
				"            <jfi:ClubId>1</jfi:ClubId>\r\n" + 
				"            <jfi:DateTime>2020-12-13T00:00:00</jfi:DateTime>\r\n" + 
				"         </tem:startDate>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:endDate>\r\n" + 
				"            <jfi:ClubId>6</jfi:ClubId>\r\n" + 
				"            <jfi:DateTime>2020-12-31T11:59:00</jfi:DateTime>\r\n" + 
				"         </tem:endDate>\r\n" + 
				"      </tem:GetAvailableCourses>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}


}
