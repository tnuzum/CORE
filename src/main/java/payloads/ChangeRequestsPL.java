package payloads;

import resources.base;

public class ChangeRequestsPL extends base {
	
	public static String updateStoredBankAccount(String companyId, String customerId){
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.ChangeRequest\" xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.ChangeRequest\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Employee</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:UpdateStoredBankAccount>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:request>\r\n" + 
				"            <jfi:ChangeRequest>\r\n" + 
				"               <jfi:ChangeDetails>\r\n" + 
				"                  <!--Zero or more repetitions:-->\r\n" + 
				"                  <jfi:ChangeRequestSubmissionDetailDto>\r\n" + 
				"                     <jfi:FieldName>BillingName</jfi:FieldName>\r\n" + 
				"                     <jfi:NewValue>Thomas Smith</jfi:NewValue>\r\n" + 
				"                  </jfi:ChangeRequestSubmissionDetailDto>\r\n" + 
				"               </jfi:ChangeDetails>\r\n" + 
				"               <jfi:CustomerId>"+customerId+"</jfi:CustomerId>\r\n" + 
				"               <jfi:Signature>null</jfi:Signature>\r\n" + 
				"               <jfi:SubmissionReason>Change Request</jfi:SubmissionReason>\r\n" + 
				"                <!--Optional:-->\r\n" + 
				"               <jfi:SubmissionReasonDetail>Test Reason Detail</jfi:SubmissionReasonDetail>\r\n" + 
				"               </jfi:ChangeRequest>\r\n" + 
				"            <jfi1:AccountId>1</jfi1:AccountId>\r\n" + 
				"            <jfi1:SetAsHouseAccount>true</jfi1:SetAsHouseAccount>\r\n" + 
				"         </tem:request>\r\n" + 
				"      </tem:UpdateStoredBankAccount>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		return pl;
	}
	
	public static String getPersonalInformation (String companyId, String customerId) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetPersonalInformation>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
				"      </tem:GetPersonalInformation>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		
		return pl;
	}
	
	public static String getStoredPaymentAccounts (String companyId, String customerId) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetStoredPaymentAccounts>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
				"      </tem:GetStoredPaymentAccounts>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		
		return pl;
	}
	
}
