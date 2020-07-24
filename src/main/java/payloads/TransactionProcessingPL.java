package payloads;

import resources.base;

public class TransactionProcessingPL extends base{

	
	public static String InvoicingInfo_Package(String companyId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Financial.InvoiceInfo\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetInvoicingInformation>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"          <!--Optional:-->\r\n" + 
				"         <tem:customerId>822</tem:customerId>\r\n" + 
				"          <!--Optional:-->\r\n" + 
				"         <tem:packages>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:PackageItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>92b9a9f2-73f4-4fbe-9f00-d2497c423e9e</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CustomerId>822</jfi:CustomerId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:ItemId>36</jfi:ItemId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:Quantity>1</jfi:Quantity>\r\n" + 
				"            </jfi:PackageItemInvoiceRequestDto>\r\n" + 
				"         </tem:packages>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubId>1</tem:clubId>\r\n" + 
				"      </tem:GetInvoicingInformation>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
				return pl;
		
	}
	
	public static String InvoicingInfo_Class(String companyId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Financial.InvoiceInfo\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">+"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetInvoicingInformation>\r\n" + 
				"       <!--Optional:-->\r\n" + 
				"         <tem:customerId>822</tem:customerId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:items>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:ItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>92b9a9f2-73f4-4fbe-9f00-d2497c423e9e</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CustomerId>822</jfi:CustomerId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:ItemId>380</jfi:ItemId>\r\n" + 
				"            </jfi:ItemInvoiceRequestDto>\r\n" + 
				"         </tem:items>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         \r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubId>1</tem:clubId>\r\n" + 
				"      </tem:GetInvoicingInformation>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
				return pl;
		
	}
	
	public static String InvoicingInfo_Training(String companyId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Financial.InvoiceInfo\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetInvoicingInformation>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"          <!--Optional:-->\r\n" + 
				"         <tem:customerId>822</tem:customerId>\r\n" + 
				"          <!--Optional:-->\r\n" + 
				"         <tem:packages>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:PackageItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>6465720e-a1fd-4e1c-b5e9-f9dcc6cc5384</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CustomerId>822</jfi:CustomerId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:ItemId>139</jfi:ItemId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:Quantity>2</jfi:Quantity>\r\n" + 
				"            </jfi:PackageItemInvoiceRequestDto>\r\n" + 
				"         </tem:packages>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubId>1</tem:clubId>\r\n" + 
				"      </tem:GetInvoicingInformation>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
				return pl;
		
	}
	
	public static String InvoicingInfo_Item(String companyId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Financial.InvoiceInfo\">\r\n" + 
				"   <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">+"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetInvoicingInformation>\r\n" + 
				"       <!--Optional:-->\r\n" + 
				"         <tem:customerId>822</tem:customerId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:items>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:ItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>92b9a9f2-73f4-4fbe-9f00-d2497c423e9e</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CustomerId>822</jfi:CustomerId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:ItemId>8</jfi:ItemId>\r\n" + 
				"            </jfi:ItemInvoiceRequestDto>\r\n" + 
				"         </tem:items>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         \r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubId>1</tem:clubId>\r\n" + 
				"      </tem:GetInvoicingInformation>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
				return pl;
		
	}
	
	public static String InvoicingInfo_RefundWithNoCancelFee(String companyId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Financial.InvoiceInfo\">\r\n" + 
				"    <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetInvoicingInformation>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>822</tem:customerId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:refundItems>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:RefundItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>81e20c56-4923-4b54-95c1-81327aee3998</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:InvoiceDetailId>105223</jfi:InvoiceDetailId>\r\n" + 
				"            </jfi:RefundItemInvoiceRequestDto>\r\n" + 
				"         </tem:refundItems>\r\n" + 
				"\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         \r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubId>1</tem:clubId>\r\n" + 
				"      </tem:GetInvoicingInformation>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
				return pl;
		
	}
	
	public static String InvoicingInfo_RefundWithCancelFee(String companyId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Financial.InvoiceInfo\">\r\n" + 
				"    <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetInvoicingInformation>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>822</tem:customerId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:items>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:ItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>8606b660-98ca-4def-b0d7-a35ca96d259b</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CustomerId>822</jfi:CustomerId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:ItemId>308</jfi:ItemId>\r\n" + 
				"            </jfi:ItemInvoiceRequestDto>\r\n" + 
				"         </tem:items>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:refundItems>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:RefundItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>81e20c56-4923-4b54-95c1-81327aee3998</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:InvoiceDetailId>105223</jfi:InvoiceDetailId>\r\n" + 
				"            </jfi:RefundItemInvoiceRequestDto>\r\n" + 
				"         </tem:refundItems>\r\n" + 
				"\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         \r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubId>1</tem:clubId>\r\n" + 
				"      </tem:GetInvoicingInformation>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
				return pl;
		
	}
	
	public static String InvoicingInfo_InvalidCustomerId1(String companyId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Financial.InvoiceInfo\">\r\n" + 
				"    <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetInvoicingInformation>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>822222</tem:customerId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:items>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:ItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>8606b660-98ca-4def-b0d7-a35ca96d259b</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CustomerId>822</jfi:CustomerId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:ItemId>308</jfi:ItemId>\r\n" + 
				"            </jfi:ItemInvoiceRequestDto>\r\n" + 
				"         </tem:items>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:refundItems>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:RefundItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>81e20c56-4923-4b54-95c1-81327aee3998</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:InvoiceDetailId>105223</jfi:InvoiceDetailId>\r\n" + 
				"            </jfi:RefundItemInvoiceRequestDto>\r\n" + 
				"         </tem:refundItems>\r\n" + 
				"\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         \r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubId>1</tem:clubId>\r\n" + 
				"      </tem:GetInvoicingInformation>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
				return pl;
		
	}
	
	public static String InvoicingInfo_InvalidCustomerId2(String companyId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Financial.InvoiceInfo\">\r\n" + 
				"    <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetInvoicingInformation>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>822</tem:customerId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:items>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:ItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>8606b660-98ca-4def-b0d7-a35ca96d259b</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CustomerId>832222</jfi:CustomerId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:ItemId>308</jfi:ItemId>\r\n" + 
				"            </jfi:ItemInvoiceRequestDto>\r\n" + 
				"         </tem:items>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:refundItems>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:RefundItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>81e20c56-4923-4b54-95c1-81327aee3998</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:InvoiceDetailId>105223</jfi:InvoiceDetailId>\r\n" + 
				"            </jfi:RefundItemInvoiceRequestDto>\r\n" + 
				"         </tem:refundItems>\r\n" + 
				"\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         \r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubId>1</tem:clubId>\r\n" + 
				"      </tem:GetInvoicingInformation>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
				return pl;
		
	}
	
	public static String InvoicingInfo_InvalidItemId(String companyId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Financial.InvoiceInfo\">\r\n" + 
				"    <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetInvoicingInformation>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>822</tem:customerId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:items>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:ItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>8606b660-98ca-4def-b0d7-a35ca96d259b</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CustomerId>822</jfi:CustomerId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:ItemId>308111</jfi:ItemId>\r\n" + 
				"            </jfi:ItemInvoiceRequestDto>\r\n" + 
				"         </tem:items>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:refundItems>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:RefundItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>81e20c56-4923-4b54-95c1-81327aee3998</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:InvoiceDetailId>105223</jfi:InvoiceDetailId>\r\n" + 
				"            </jfi:RefundItemInvoiceRequestDto>\r\n" + 
				"         </tem:refundItems>\r\n" + 
				"\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         \r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubId>1</tem:clubId>\r\n" + 
				"      </tem:GetInvoicingInformation>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
				return pl;
		
	}
	
	public static String InvoicingInfo_InvalidInvoiceDetailId(String companyId) {
		String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Financial.InvoiceInfo\">\r\n" + 
				"    <soapenv:Header>\r\n" + 
				"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
				"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
				"   </soapenv:Header>\r\n" + 
				"   <soapenv:Body>\r\n" + 
				"      <tem:GetInvoicingInformation>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:customerId>822</tem:customerId>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:items>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:ItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>8606b660-98ca-4def-b0d7-a35ca96d259b</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CustomerId>822</jfi:CustomerId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:ItemId>308</jfi:ItemId>\r\n" + 
				"            </jfi:ItemInvoiceRequestDto>\r\n" + 
				"         </tem:items>\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:refundItems>\r\n" + 
				"            <!--Zero or more repetitions:-->\r\n" + 
				"            <jfi:RefundItemInvoiceRequestDto>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:CorrelationId>81e20c56-4923-4b54-95c1-81327aee3998</jfi:CorrelationId>\r\n" + 
				"               <!--Optional:-->\r\n" + 
				"               <jfi:InvoiceDetailId>1052233333</jfi:InvoiceDetailId>\r\n" + 
				"            </jfi:RefundItemInvoiceRequestDto>\r\n" + 
				"         </tem:refundItems>\r\n" + 
				"\r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         \r\n" + 
				"         <!--Optional:-->\r\n" + 
				"         <tem:clubId>1</tem:clubId>\r\n" + 
				"      </tem:GetInvoicingInformation>\r\n" + 
				"   </soapenv:Body>\r\n" + 
				"</soapenv:Envelope>";
				return pl;
		
	}
}
