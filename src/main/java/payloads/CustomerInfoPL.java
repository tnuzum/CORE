package payloads;

import resources.base;

public class CustomerInfoPL extends base {

		public static String getCustomerInfo(String customerId)
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
		
		public static String getFamilyMembersFor(String customerId)
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
		
		public static String getFullFamilyFor(String customerId)
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
		
		public static String getMemberAccessibleClubs(String customerId)
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
		
		public static String updateCustomerInterests_AddInterest(String customerId, String interestToAdd)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Info\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:UpdateCustomerInterests>\r\n" + 
					"         <tem:request>\r\n" + 
					"            <jfi1:CustomerId xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Info\">"+customerId+"</jfi1:CustomerId>\r\n" + 
					"            <jfi1:InterestsToAdd xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Info\">\r\n" + 
					"               <!--Zero or more repetitions:-->\r\n" + 
					"               <arr:string>"+interestToAdd+"</arr:string>\r\n" + 
					"            </jfi1:InterestsToAdd>\r\n" + 
					"            <!--jfi1:InterestsToRemove xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Info\"-->\r\n" + 
					"               <!--Zero or more repetitions:-->\r\n" + 
					"               <!--arr:string>?</arr:string-->\r\n" + 
					"            <!--/jfi1:InterestsToRemove-->\r\n" + 
					"         </tem:request>\r\n" + 
					"      </tem:UpdateCustomerInterests>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String updateCustomerInterests_RemoveInterest(String customerId, String interestToRemove)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Info\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:UpdateCustomerInterests>\r\n" + 
					"         <tem:request>\r\n" + 
					"            <jfi1:CustomerId xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Info\">"+customerId+"</jfi1:CustomerId>\r\n" + 
					"            <!--jfi1:InterestsToAdd xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Info\"-->\r\n" + 
					"               <!--Zero or more repetitions:-->\r\n" + 
					"               <!--arr:string>?</arr:string-->\r\n" + 
					"            <!--/jfi1:InterestsToAdd-->\r\n" + 
					"            <jfi1:InterestsToRemove xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.Info\">\r\n" + 
					"               <!--Zero or more repetitions:-->\r\n" + 
					"               <arr:string>"+interestToRemove+"</arr:string>\r\n" + 
					"            </jfi1:InterestsToRemove>\r\n" + 
					"         </tem:request>\r\n" + 
					"      </tem:UpdateCustomerInterests>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String updateCustomerName(String customerId, String displayName, String firstName, String lastName, String middleInitial, String preferredName)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Info\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:UpdateCustomerName>\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"         <tem:nameDto>\r\n" + 
					"            <jfi1:DisplayName xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Common\">"+displayName+"</jfi1:DisplayName>\r\n" + 
					"            <jfi1:FirstName xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Common\">"+firstName+"</jfi1:FirstName>\r\n" + 
					"            <jfi1:LastName xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Common\">"+lastName+"</jfi1:LastName>\r\n" + 
					"            <jfi1:MiddleInitial xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Common\">"+middleInitial+"</jfi1:MiddleInitial>\r\n" + 
					"            <jfi1:PreferredName xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Common\">"+preferredName+"</jfi1:PreferredName>\r\n" + 
					"         </tem:nameDto>\r\n" + 
					"      </tem:UpdateCustomerName>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String updateHeadOfHousehold(String customerId, int headOfHousehold)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:UpdateHeadOfHousehold>\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"         <tem:headofHousehold>"+headOfHousehold+"</tem:headofHousehold>\r\n" + 
					"      </tem:UpdateHeadOfHousehold>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String updatePreferredPhoneNumber(String customerId, String phoneType)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:UpdatePreferredPhoneNumber>\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"         <tem:phoneType>"+phoneType+"</tem:phoneType>\r\n" + 
					"      </tem:UpdatePreferredPhoneNumber>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
}
