package payloads;

import resources.base;

public class PackageServicePL extends base {
	
		public static String getPackageDetails(int customerId, int packageId, int clubId, boolean includeItemRestrictions)
		{
			
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"  <soapenv:Body>\r\n" + 
					"      <tem:GetPackageDetails>\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"         <tem:packageId>"+packageId+"</tem:packageId>\r\n" + 
					"         <tem:clubNumber>"+clubId+"</tem:clubNumber>\r\n" + 
					"         <tem:includeItemRestrictions>"+includeItemRestrictions+"</tem:includeItemRestrictions>\r\n" + 
					"      </tem:GetPackageDetails>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
			
}
