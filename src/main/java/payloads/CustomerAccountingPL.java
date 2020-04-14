package payloads;

import resources.base;

public class CustomerAccountingPL extends base {

		public static String getAccountHistory(String companyId, String customerId, String startDateTime, String startOffset, String endDateTime, String endOffset)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:sys=\"http://schemas.datacontract.org/2004/07/System\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetAccountHistory>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:startDate>\r\n" + 
					"         		<sys:DateTime>"+startDateTime+"</sys:DateTime>\r\n" + 
					"            	<sys:OffsetMinutes>"+startOffset+"</sys:OffsetMinutes>\r\n" + 
					"         </tem:startDate>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:endDate>\r\n" + 
					"         		<sys:DateTime>"+endDateTime+"</sys:DateTime>\r\n" + 
					"            	<sys:OffsetMinutes>"+endOffset+"</sys:OffsetMinutes>\r\n" + 
					"         </tem:endDate>\r\n" + 
					"      </tem:GetAccountHistory>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String getCustomerAccountValue(String companyId, String customerId)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetCustomerAccountValue>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"      </tem:GetCustomerAccountValue>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String getCustomerCurrentBalance(String companyId, String customerId)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetCustomerCurrentBalance>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"      </tem:GetCustomerCurrentBalance>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String getInvoiceChargeReceiptDetail(String companyId, String headerId)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetInvoiceChargeReceiptDetail>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:headerId>"+headerId+"</tem:headerId>\r\n" + 
					"      </tem:GetInvoiceChargeReceiptDetail>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String getInvoiceChargeReceiptDetailForReceiptNumber(String companyId, String receiptId)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
					"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
					"   </soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetInvoiceChargeReceiptDetailForReceiptNumber>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:receiptNumber>"+receiptId+"</tem:receiptNumber>\r\n" + 
					"      </tem:GetInvoiceChargeReceiptDetailForReceiptNumber>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String getLastPaymentDateForCustomer(String companyId, String customerId)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetLastPaymentDateForCustomer>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"      </tem:GetLastPaymentDateForCustomer>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String getPaymentReceiptDetail(String companyId, String headerId)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetPaymentReceiptDetail>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:headerId>"+headerId+"</tem:headerId>\r\n" + 
					"      </tem:GetPaymentReceiptDetail>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String getPaymentReceiptDetailForReceiptNumber(String companyId, String receiptId)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
					"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
					"   </soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetPaymentReceiptDetailForReceiptNumber>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:receiptNumber>"+receiptId+"</tem:receiptNumber>\r\n" + 
					"      </tem:GetPaymentReceiptDetailForReceiptNumber>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String getStoredPaymentAccountsForCustomer(String companyId, String customerId)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetStoredPaymentAccountsForCustomer>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"      </tem:GetStoredPaymentAccountsForCustomer>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		public static String identifyCreditCardType(String companyId, String cardNumber)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n" + 
					"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
					"   </soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:IdentifyCreditCardType>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:cardNumber>"+cardNumber+"</tem:cardNumber>\r\n" + 
					"      </tem:IdentifyCreditCardType>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pl;
		}
		
		
}