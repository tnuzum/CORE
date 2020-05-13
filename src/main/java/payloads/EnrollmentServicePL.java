package payloads;

import resources.base;

public class EnrollmentServicePL extends base{
	
	public static String EnrollInClassStandby(String companyId, String customerId, String classId, String tomorrowsDate) {
		
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
				"            <sys:DateTime>"+tomorrowsDate+"T17:00:00</sys:DateTime>\r\n" + 
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
	
	public static String EnrollInClass(String companyId, String customerId, String classId, String tomorrowsDate) {
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
				"            <sys:DateTime>"+tomorrowsDate+"T17:00:00Z</sys:DateTime>\r\n" + 
				"            <sys:OffsetMinutes>-300</sys:OffsetMinutes>\r\n" + 
				"         </tem:occurrence>\r\n" + 
				"         <tem:paymentType>OnAccount</tem:paymentType>\r\n" + 
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
				"         <tem:paymentType>OnAccount</tem:paymentType>\r\n" + 
				"      </tem:EnrollInCourse>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}

}
