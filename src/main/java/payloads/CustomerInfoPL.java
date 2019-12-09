package payloads;

import resources.base;

public class CustomerInfoPL extends base {

		public static String getCustomerInfo(int customerId)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetCustomerInfo>\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"         <!--tem:customerInfo>General</tem:customerInfo-->\r\n" + 
					"      </tem:GetCustomerInfo>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String getFamilyMembersFor(int customerId)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetFamilyMembersFor>\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"      </tem:GetFamilyMembersFor>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String getFullFamilyFor(int customerId)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetFullFamilyFor>\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"      </tem:GetFullFamilyFor>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String getMemberAccessibleClubs(int customerId)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetMemberAccessibleClubs>\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"      </tem:GetMemberAccessibleClubs>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String searchMembers(String name, String phoneNumber, String email)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"  <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:SearchMembers>\r\n" + 
					"         <tem:name>"+name+"</tem:name>\r\n" + 
					"         <tem:phoneNumber>"+phoneNumber+"</tem:phoneNumber>\r\n" + 
					"         <tem:email>"+email+"</tem:email>\r\n" + 
					"      </tem:SearchMembers>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
}
