package payloads;

import resources.base;

public class BulkCustomerInfoPL extends base {

		public static String getCustomersRequiredParametersOnly(String companyId, String clubId)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://tempuri.org/\">\r\n"
					+ "   <soapenv:Header>\r\n"
					+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
					+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
					+ "   </soapenv:Header>\r\n"
					+ "   <soapenv:Body>\r\n"
					+ "      <tem:GetCustomers>\r\n"
					+ "         <tem:clubId>"+clubId+"</tem:clubId>\r\n"
					+ "         <tem:pagingRequest/>\r\n"
					+ "      </tem:GetCustomers>\r\n"
					+ "   </soapenv:Body>\r\n"
					+ "</soapenv:Envelope>";
			return pl;
		}
		
		public static String getCustomersAllParameters(String companyId, String clubId, String activeOnly, String lastUpdateDate, int page, int pageSize)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\r\n"
					+ "xmlns:tem=\"http://tempuri.org/\"\r\n"
					+ "xmlns:jfi=\"http://schemas.datacontract.org/2004/07/JFI.Core.Services.Contracts.DataContracts.DTOs.Paging\">\r\n"
					+ "   <soapenv:Header>\r\n"
					+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
					+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
					+ "   </soapenv:Header>\r\n"
					+ "   <soapenv:Body>\r\n"
					+ "      <tem:GetCustomers>\r\n"
					+ "         <tem:clubId>"+clubId+"</tem:clubId>\r\n"
					+ "         <tem:activeOnly>"+activeOnly+"</tem:activeOnly>\r\n"
					+ "         <tem:lastUpdateDate>"+lastUpdateDate+"</tem:lastUpdateDate>\r\n"
					+ "         <tem:pagingRequest>\r\n"
					+ "            <jfi:Page>"+page+"</jfi:Page>\r\n"
					+ "            <jfi:PageSize>"+pageSize+"</jfi:PageSize>\r\n"
					+ "         </tem:pagingRequest>\r\n"
					+ "      </tem:GetCustomers>\r\n"
					+ "   </soapenv:Body>\r\n"
					+ "</soapenv:Envelope>";
			return pl;
		}
		
		public static String getAllCustomers(String companyId, String clubId, String activeOnly)
		{
			String pl = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:jfi=\"http://tempuri.org/\">\r\n"
					+ "   <soapenv:Header>\r\n"
					+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
					+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
					+ "   </soapenv:Header>\r\n"
					+ "   <soapenv:Body>\r\n"
					+ "      <tem:GetCustomers>\r\n"
					+ "         <tem:clubId>"+clubId+"</tem:clubId>\r\n"
					+ "         <tem:activeOnly>"+activeOnly+"</tem:activeOnly>\r\n"
					+ "         <tem:pagingRequest/>\r\n"
					+ "      </tem:GetCustomers>\r\n"
					+ "   </soapenv:Body>\r\n"
					+ "</soapenv:Envelope>";
			return pl;
		}
		
		
		
		
		
		
		
		
		
		
}
