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
	
	public static String getSubmissionReasonsForSubmissionWithClub (String companyId, String clubId) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetSubmissionReasonsForSubmission>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubNumber>"+clubId+"</tem:clubNumber>\r\n" + 
				"      </tem:GetSubmissionReasonsForSubmission>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		
		return pl;
	}
	
	public static String getSubmissionReasonsForSubmissionNoClub (String companyId) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.Auth\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetSubmissionReasonsForSubmission>\r\n" +
				"      </tem:GetSubmissionReasonsForSubmission>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		
		return pl;
	}
	
	public static String updatePersonalInformationNoFamily (String companyId, String customerId, String fieldName, String newValue, String submissionReason, String submissionReasonDetail) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.ChangeRequest\" xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.ChangeRequest\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:UpdatePersonalInformation>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:request>\r\n" + 
				"            <jfi:ChangeRequest>\r\n" + 
				"               <jfi:ChangeDetails>\r\n" + 
				"                  <!--Zero or more repetitions:-->\r\n" + 
				"                  <jfi:ChangeRequestSubmissionDetailDto>\r\n" + 
				"                     <jfi:FieldName>"+fieldName+"</jfi:FieldName>\r\n" + 
				"                     <jfi:NewValue>"+newValue+"</jfi:NewValue>\r\n" + 
				"                  </jfi:ChangeRequestSubmissionDetailDto>\r\n" + 
				"               </jfi:ChangeDetails>\r\n" + 
				"               <jfi:CustomerId>"+customerId+"</jfi:CustomerId>\r\n" + 
				"               <jfi:Signature>null</jfi:Signature>\r\n" + 
				"               <jfi:SubmissionReason>"+submissionReason+"</jfi:SubmissionReason>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:SubmissionReasonDetail>"+submissionReasonDetail+"</jfi:SubmissionReasonDetail>\r\n" + 
				"            </jfi:ChangeRequest>\r\n" + 
				"            <jfi1:FamilyMemberCustomerIds>\r\n" + 
				"               <!--Zero or more repetitions:-->\r\n" + 
				"            </jfi1:FamilyMemberCustomerIds>\r\n" + 
				"         </tem:request>\r\n" + 
				"      </tem:UpdatePersonalInformation>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
		
		return pl;
	}
	
	
	
public static String AddStoredBankAccount (String companyId, String customerId) {
		
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.ChangeRequest\" xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.ChangeRequest\" xmlns:arr=\"http://schemas.microsoft.com/2003/10/Serialization/Arrays\">\r\n"
				+ "   <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:AddStoredBankAccount>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:request>\r\n"
				+ "            <jfi:ChangeRequest>\r\n"
				+ "               <jfi:ChangeDetails>\r\n"
				+ "                  <!--Zero or more repetitions:-->\r\n"
				+ "\r\n"
				+ "                 \r\n"
				+ "                   <jfi:ChangeRequestSubmissionDetailDto>\r\n"
				+ "                     <jfi:FieldName>BankId</jfi:FieldName>\r\n"
				+ "                     <jfi:NewValue>111099984</jfi:NewValue>\r\n"
				+ "                  </jfi:ChangeRequestSubmissionDetailDto>\r\n"
				+ "\r\n"
				+ "                   <jfi:ChangeRequestSubmissionDetailDto>\r\n"
				+ "                     <jfi:FieldName>BankAccountNumber</jfi:FieldName>\r\n"
				+ "                     <jfi:NewValue>333333330430</jfi:NewValue>\r\n"
				+ "                  </jfi:ChangeRequestSubmissionDetailDto>\r\n"
				+ "\r\n"
				+ "                  <jfi:ChangeRequestSubmissionDetailDto>\r\n"
				+ "                     <jfi:FieldName>BankAccountType</jfi:FieldName>\r\n"
				+ "                     <jfi:NewValue>2</jfi:NewValue>\r\n"
				+ "                  </jfi:ChangeRequestSubmissionDetailDto>\r\n"
				+ "\r\n"
				+ "                   <jfi:ChangeRequestSubmissionDetailDto>\r\n"
				+ "                     <jfi:FieldName>SECCode</jfi:FieldName>\r\n"
				+ "                     <jfi:NewValue>2</jfi:NewValue>\r\n"
				+ "                  </jfi:ChangeRequestSubmissionDetailDto>\r\n"
				+ "                  \r\n"
				+ "                  \r\n"
				+ "                  <jfi:ChangeRequestSubmissionDetailDto>\r\n"
				+ "                     <jfi:FieldName>BillingName</jfi:FieldName>\r\n"
				+ "                     <jfi:NewValue>Bhagya Kalle</jfi:NewValue>\r\n"
				+ "                  </jfi:ChangeRequestSubmissionDetailDto>                    \r\n"
				+ "                            \r\n"
				+ "               </jfi:ChangeDetails>\r\n"
				+ "               <jfi:CustomerId>"+customerId+"</jfi:CustomerId>\r\n"
				+ "               <jfi:Signature>null</jfi:Signature>\r\n"
				+ "               <jfi:SubmissionReason>Change Request</jfi:SubmissionReason>\r\n"
				+ "               <!--Optional:-->\r\n"
				+ "               <jfi:SubmissionReasonDetail>Change Request</jfi:SubmissionReasonDetail>\r\n"
				+ "            </jfi:ChangeRequest>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi1:AgreementsToUpdate>\r\n"
				+ "               <!--Zero or more repetitions:-->\r\n"
				+ "               <!--arr:string>No Thanks</arr:string-->\r\n"
				+ "            </jfi1:AgreementsToUpdate>\r\n"
				+ "            <!--Optional:-->\r\n"
				+ "            <jfi1:SetAsHouseAccount>false</jfi1:SetAsHouseAccount>\r\n"
				+ "         </tem:request>\r\n"
				+ "      </tem:AddStoredBankAccount>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		
		return pl;
	}
	
	
public static String UpdateStoredBankAccount (String companyId, String customerId, String accountId) {
	
	String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.ChangeRequest\" xmlns:jfi1=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.Messages.ChangeRequest\" xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\">\r\n"
			+ "   <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId>\r\n"
			+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:UpdateStoredBankAccount>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:request>\r\n"
			+ "            <jfi:ChangeRequest>\r\n"
			+ "               <jfi:ChangeDetails>\r\n"
			+ "                  <!--Zero or more repetitions:-->\r\n"
			+ "                  <jfi:ChangeRequestSubmissionDetailDto>\r\n"
			+ "                     <jfi:FieldName>BankAccountNumber</jfi:FieldName>\r\n"
			+ "                     <jfi:NewValue>369852180</jfi:NewValue>\r\n"
			+ "                  </jfi:ChangeRequestSubmissionDetailDto>\r\n"
			+ "                  \r\n"
			+ "               </jfi:ChangeDetails>\r\n"
			+ "               <jfi:CustomerId>"+customerId+"</jfi:CustomerId>\r\n"
			+ "               <jfi:Signature>null</jfi:Signature>\r\n"
			+ "               <jfi:SubmissionReason>Change Request</jfi:SubmissionReason>\r\n"
			+ "               <!--Optional:-->\r\n"
			+ "               <jfi:SubmissionReasonDetail>OK</jfi:SubmissionReasonDetail>\r\n"
			+ "            </jfi:ChangeRequest>\r\n"
			+ "            <jfi1:AccountId>"+accountId+"</jfi1:AccountId>\r\n"
			+ "            <jfi1:SetAsHouseAccount>false</jfi1:SetAsHouseAccount>\r\n"
			+ "         </tem:request>\r\n"
			+ "      </tem:UpdateStoredBankAccount>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	
	return pl;
}
	
	
	
	
	
	
}
