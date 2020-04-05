package payloads;

import resources.base;

public class MessagingServicePL extends base {
	
	public static String SendFamilyClassEnrollmentAndStandbyConfirmationEmail(String companyId, String customerid)
	
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
				"  <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:SendFamilyClassEnrollmentConfirmationEmail>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>"+customerid+"</tem:customerId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:enrollmentIds>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <arr:int>33075</arr:int>\r\n" + 
				"             <arr:int>33076</arr:int>\r\n" + 
				"             <arr:int>33077</arr:int>\r\n" + 
				"             <arr:int>33078</arr:int>\r\n" + 
				" 			\r\n" + 
				"         </tem:enrollmentIds>\r\n" + 
				"      </tem:SendFamilyClassEnrollmentConfirmationEmail>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}

public static String SendFamilyClassEnrollmentOnlyConfirmationEmail(String companyId, String customerid)
	
	{
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
				"  <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:SendFamilyClassEnrollmentConfirmationEmail>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>"+customerid+"</tem:customerId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:enrollmentIds>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <arr:int>33079</arr:int>\r\n" + 
				"             <arr:int>33080</arr:int>\r\n" + 
				"           \r\n" + 
				"         </tem:enrollmentIds>\r\n" + 
				"      </tem:SendFamilyClassEnrollmentConfirmationEmail>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}

public static String SendFamilyClassStandbyOnlyConfirmationEmail(String companyId, String customerid)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
			"  <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendFamilyClassEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:customerId>"+customerid+"</tem:customerId>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentIds>\r\n" + 
			"            <!--Zero or more repetitions:-->\r\n" + 
			"            <arr:int>33081</arr:int>\r\n" + 
			"             <arr:int>33082</arr:int>\r\n" + 
			        
			" 			\r\n" + 
			"         </tem:enrollmentIds>\r\n" + 
			"      </tem:SendFamilyClassEnrollmentConfirmationEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}

public static String SendFamilyClassEnrollmentAndStandbyNoHohConfirmationEmail(String companyId, String customerid)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
			"  <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendFamilyClassEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:customerId>"+customerid+"</tem:customerId>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentIds>\r\n" + 
			"            <!--Zero or more repetitions:-->\r\n" + 
			"            <arr:int>33083</arr:int>\r\n" + 
			"             <arr:int>33084</arr:int>\r\n" + 
			"             <arr:int>33085</arr:int>\r\n" + 
			 
			" 			\r\n" + 
			"         </tem:enrollmentIds>\r\n" + 
			"      </tem:SendFamilyClassEnrollmentConfirmationEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}
public static String InvalidCustomerId(String companyId, String customerid)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
			"  <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendFamilyClassEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:customerId>"+customerid+"</tem:customerId>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentIds>\r\n" + 
			"            <!--Zero or more repetitions:-->\r\n" + 
			"            <arr:int>33075</arr:int>\r\n" + 
			"             <arr:int>33076</arr:int>\r\n" + 
			"             <arr:int>33077</arr:int>\r\n" + 
			"             <arr:int>33078</arr:int>\r\n" + 
			" 			\r\n" + 
			"         </tem:enrollmentIds>\r\n" + 
			"      </tem:SendFamilyClassEnrollmentConfirmationEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}

public static String InvalidEnrollmentId(String companyId, String customerid)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
			"  <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendFamilyClassEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:customerId>"+customerid+"</tem:customerId>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentIds>\r\n" + 
			"            <!--Zero or more repetitions:-->\r\n" + 
			"            <arr:int>3307555</arr:int>\r\n" + 
			"             <arr:int>33076</arr:int>\r\n" + 
			"             <arr:int>33077</arr:int>\r\n" + 
			"             <arr:int>33078</arr:int>\r\n" + 
			" 			\r\n" + 
			"         </tem:enrollmentIds>\r\n" + 
			"      </tem:SendFamilyClassEnrollmentConfirmationEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}

public static String SendFamilyCourseEnrollmentAndStandbyConfirmationEmail(String companyId, String customerid)
{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
		"  <soapenv:Header>\r\n" + 
		"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
		"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
		"   </soapenv:Header>\r\n" + 
		"   <soapenv:Body>\r\n" + 
		"      <tem:SendFamilyCourseEnrollmentConfirmationEmail>\r\n" + 
		"         <!--Optional:-->\r\n" + 
		"         <tem:customerId>"+customerid+"</tem:customerId>\r\n" + 
		"         <!--Optional:-->\r\n" + 
		"         <tem:enrollmentIds>\r\n" + 
		"            <!--Zero or more repetitions:-->\r\n" + 
		"            <arr:int>33090</arr:int>\r\n" + 
		"             <arr:int>33091</arr:int>\r\n" + 
		"             <arr:int>33092</arr:int>\r\n" + 
		"             <arr:int>33093</arr:int>\r\n" + 
		" 			\r\n" + 
		"         </tem:enrollmentIds>\r\n" + 
		"      </tem:SendFamilyCourseEnrollmentConfirmationEmail>\r\n" + 
		"   </soapenv:Body>\r\n" + 
		"</soapenv:Envelope>";
return pl;
}

public static String SendFamilyCourseEnrollmentOnlyConfirmationEmail(String companyId, String customerid)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
			"  <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendFamilyCourseEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:customerId>"+customerid+"</tem:customerId>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentIds>\r\n" + 
			"            <!--Zero or more repetitions:-->\r\n" + 
			"            <arr:int>33086</arr:int>\r\n" + 
			"             <arr:int>33087</arr:int>\r\n" + 
			"             <arr:int>33088</arr:int>\r\n" + 
			"             <arr:int>33089</arr:int>\r\n" + 
			"           \r\n" + 
			"         </tem:enrollmentIds>\r\n" + 
			"      </tem:SendFamilyCourseEnrollmentConfirmationEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}

public static String SendFamilyCourseStandbyOnlyConfirmationEmail(String companyId, String customerid)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
			"  <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendFamilyCourseEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:customerId>"+customerid+"</tem:customerId>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentIds>\r\n" + 
			"            <!--Zero or more repetitions:-->\r\n" + 
			"            <arr:int>33096</arr:int>\r\n" + 
			"             <arr:int>33097</arr:int>\r\n" + 
			        
			" 			\r\n" + 
			"         </tem:enrollmentIds>\r\n" + 
			"      </tem:SendFamilyCourseEnrollmentConfirmationEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}

public static String SendFamilyCourseEnrollmentAndStandbyNoHohConfirmationEmail(String companyId, String customerid)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
			"  <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendFamilyCourseEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:customerId>"+customerid+"</tem:customerId>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentIds>\r\n" + 
			"            <!--Zero or more repetitions:-->\r\n" + 
			"            <arr:int>33098</arr:int>\r\n" + 
			"             <arr:int>33099</arr:int>\r\n" + 
			"             <arr:int>33100</arr:int>\r\n" + 
			 
			" 			\r\n" + 
			"         </tem:enrollmentIds>\r\n" + 
			"      </tem:SendFamilyCourseEnrollmentConfirmationEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}
public static String InvalidCourseCustomerId(String companyId, String customerid)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
			"  <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendFamilyCourseEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:customerId>"+customerid+"</tem:customerId>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentIds>\r\n" + 
			"            <!--Zero or more repetitions:-->\r\n" + 
			"            <arr:int>33086</arr:int>\r\n" + 
			"             <arr:int>33087</arr:int>\r\n" + 
			"             <arr:int>33088</arr:int>\r\n" + 
			"             <arr:int>33089</arr:int>\r\n" + 
			" 			\r\n" + 
			"         </tem:enrollmentIds>\r\n" + 
			"      </tem:SendFamilyCourseEnrollmentConfirmationEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}

public static String InvalidCourseEnrollmentId(String companyId, String customerid)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
			"  <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendFamilyCourseEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:customerId>"+customerid+"</tem:customerId>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentIds>\r\n" + 
			"            <!--Zero or more repetitions:-->\r\n" + 
			"            <arr:int>3308611</arr:int>\r\n" + 
			"             <arr:int>33087</arr:int>\r\n" + 
			"             <arr:int>33088</arr:int>\r\n" + 
			"             <arr:int>33089</arr:int>\r\n" + 
			" 			\r\n" + 
			"         </tem:enrollmentIds>\r\n" + 
			"      </tem:SendFamilyCourseEnrollmentConfirmationEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}


public static String SendCustomerClassEnrollmentConfirmationEmail(String companyId)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
			"   <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendCustomerClassEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentId>33077</tem:enrollmentId>\r\n" + 
			"      </tem:SendCustomerClassEnrollmentConfirmationEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}

public static String SendCustomerClassEnrollmentConfirmationEmail_InvalidEnrlmntId(String companyId)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
			"   <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendCustomerClassEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentId>330777</tem:enrollmentId>\r\n" + 
			"      </tem:SendCustomerClassEnrollmentConfirmationEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}

public static String SendCustomerCourseEnrollmentConfirmationEmail(String companyId)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
			"   <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendCustomerCourseEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentId>33095</tem:enrollmentId>\r\n" + 
			"      </tem:SendCustomerCourseEnrollmentConfirmationEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}

public static String SendCustomerCourseEnrollmentConfirmationEmail_InvalidEnrlmntId(String companyId)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
			"   <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendCustomerCourseEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentId>330958</tem:enrollmentId>\r\n" + 
			"      </tem:SendCustomerCourseEnrollmentConfirmationEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}

}
