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
	
public static String SendFamilyVirtualClassEnrollmentAndStandbyConfirmationEmail(String companyId, String customerid)
	
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
				"            <arr:int>73096</arr:int>\r\n" + 
				"             <arr:int>73097</arr:int>\r\n" + 
				"             <arr:int>73098</arr:int>\r\n" + 
				"             <arr:int>73099</arr:int>\r\n" + 
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

public static String SendFamilyVirtualCourseEnrollmentAndStandbyConfirmationEmail(String companyId, String customerid)
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
		"            <arr:int>73092</arr:int>\r\n" + 
		"             <arr:int>73093</arr:int>\r\n" + 
		"             <arr:int>73094</arr:int>\r\n" + 
		"             <arr:int>73095</arr:int>\r\n" + 
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

public static String SendVirtualCustomerClassEnrollmentConfirmationEmail(String companyId, String enrollmentId)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
			"   <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendCustomerClassEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentId>"+enrollmentId+"</tem:enrollmentId>\r\n" + 
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

public static String SendVirtualCustomerCourseEnrollmentConfirmationEmail(String companyId, String enrollmentId)

{
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
			"   <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"   </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendCustomerCourseEnrollmentConfirmationEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentId>"+enrollmentId+"</tem:enrollmentId>\r\n" + 
			"      </tem:SendCustomerCourseEnrollmentConfirmationEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}

public static String SendClassStandbyPromotionEmail(String companyId, String enrollmentId) {
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
			"  <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"      </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendClassStandbyPromotionEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"          <tem:enrollmentId>"+enrollmentId+"</tem:enrollmentId>\r\n" + 
			"       </tem:SendClassStandbyPromotionEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}

public static String SendCourseStandbyPromotionEmail(String companyId, String enrollmentId) {
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
			"<soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"      </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendCourseStandbyPromotionEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentId>"+enrollmentId+"</tem:enrollmentId>\r\n" + 
			"      </tem:SendCourseStandbyPromotionEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}

public static String SendCustomerClassUnenrollmentEmail(String companyId, String customerId, String itemId, String startTime, String startTimeOffset, String endTime, String endTimeOffset, String enrollmentOccurrenceTime, String enrollmentOccurrenceTimeOffset) {
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Messaging\" xmlns:sys=\"http://schemas.datacontract.org/2004/07/System\">\r\n" + 
			"   <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"      </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendCustomerClassUnenrollmentEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentDto>\r\n" + 
			"            <!--Optional:-->\r\n" + 
			"            <jfi:CustomerId>"+customerId+"</jfi:CustomerId>\r\n" + 
			"            <jfi:EndDate>\r\n" + 
			"               <sys:DateTime>"+endTime+"</sys:DateTime>\r\n" + 
			"               <sys:OffsetMinutes>"+endTimeOffset+"</sys:OffsetMinutes>\r\n" + 
			"            </jfi:EndDate>\r\n" + 
			"            <!--Optional:-->\r\n" + 
			"            <jfi:EnrollmentOccurredOn>\r\n" + 
			"               <sys:DateTime>"+enrollmentOccurrenceTime+"</sys:DateTime>\r\n" + 
			"               <sys:OffsetMinutes>"+enrollmentOccurrenceTimeOffset+"</sys:OffsetMinutes>\r\n" + 
			"            </jfi:EnrollmentOccurredOn>\r\n" + 
			"            <jfi:ItemId>"+itemId+"</jfi:ItemId>\r\n" + 
			"            <!--Optional:-->\r\n" + 
			"            <jfi:StartDate>\r\n" + 
			"               <sys:DateTime>"+startTime+"</sys:DateTime>\r\n" + 
			"               <sys:OffsetMinutes>"+startTimeOffset+"</sys:OffsetMinutes>\r\n" + 
			"            </jfi:StartDate>\r\n" + 
			"         </tem:enrollmentDto>\r\n" + 
			"      </tem:SendCustomerClassUnenrollmentEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
}

public static String SendCustomerCourseUnenrollmentEmail(String companyId, String customerId, String itemId, String startTime, String startTimeOffset, String endTime, String endTimeOffset, String enrollmentOccurrenceTime, String enrollmentOccurrenceTimeOffset) {
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Messaging\" xmlns:sys=\"http://schemas.datacontract.org/2004/07/System\">\r\n" + 
			"   <soapenv:Header>\r\n" + 
			"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
			"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
			"      </soapenv:Header>\r\n" + 
			"   <soapenv:Body>\r\n" + 
			"      <tem:SendCustomerCourseUnenrollmentEmail>\r\n" + 
			"         <!--Optional:-->\r\n" + 
			"         <tem:enrollmentDto>\r\n" + 
			"            <!--Optional:-->\r\n" + 
			"            <jfi:CustomerId>"+customerId+"</jfi:CustomerId>\r\n" + 
			"            <!--Optional:-->\r\n" + 
			"            <!--jfi:EndDate>\r\n" + 
			"               <sys:DateTime>"+endTime+"</sys:DateTime>\r\n" + 
			"               <sys:OffsetMinutes>"+endTimeOffset+"</sys:OffsetMinutes>\r\n" + 
			"            </jfi:EndDate-->\r\n" + 
			"            <!--Optional:-->\r\n" + 
			"            <jfi:EnrollmentOccurredOn>\r\n" + 
			"               <sys:DateTime>"+enrollmentOccurrenceTime+"</sys:DateTime>\r\n" + 
			"               <sys:OffsetMinutes>"+enrollmentOccurrenceTimeOffset+"</sys:OffsetMinutes>\r\n" + 
			"            </jfi:EnrollmentOccurredOn>\r\n" + 
			"            <jfi:ItemId>"+itemId+"</jfi:ItemId>\r\n" + 
			"            <!--Optional:-->\r\n" + 
			"            <!--jfi:StartDate>\r\n" + 
			"               <sys:DateTime>"+startTime+"</sys:DateTime>\r\n" + 
			"               <sys:OffsetMinutes>"+startTimeOffset+"</sys:OffsetMinutes>\r\n" + 
			"            </jfi:StartDate-->\r\n" + 
			"         </tem:enrollmentDto>\r\n" + 
			"      </tem:SendCustomerCourseUnenrollmentEmail>\r\n" + 
			"   </soapenv:Body>\r\n" + 
			"</soapenv:Envelope>";
	return pl;
		
	}

public static String SendAppointmentCancellationConfirmations(String companyId, String appointmentId) {
	
	String PL = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
			+ " <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
			+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
			+ "   </soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:SendAppointmentCancellationConfirmations>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:appointmentId>"+appointmentId+"</tem:appointmentId>\r\n"
			+ "      </tem:SendAppointmentCancellationConfirmations>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	return PL;

}

}
