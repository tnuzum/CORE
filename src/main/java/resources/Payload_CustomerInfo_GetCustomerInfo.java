package resources;

public class Payload_CustomerInfo_GetCustomerInfo {
	
	

		public static String customerFound()
		{
			int companyId	= 236;
			int customerId = 223;
			
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetCustomerInfo>\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"         <!--tem:customerInfo>General</tem:customerInfo-->\r\n" + 
					"      </tem:GetCustomerInfo>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		public static String customerNotFound()
		{
			int companyId	= 236;
			int customerId = 223;
			
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetCustomerInfo>\r\n" + 
					"         <tem:customerId>"+customerId+"999</tem:customerId>\r\n" + 
					"         <!--tem:customerInfo>General</tem:customerInfo-->\r\n" + 
					"      </tem:GetCustomerInfo>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
}
