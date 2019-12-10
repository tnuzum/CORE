package payloads;

import resources.base;

public class PackageServicePL extends base {
	
		public static String getAvailablePackagesByClub(int customerId, int clubId)
		{
			
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId>\r\n" + 
					"   </soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetAvailablePackagesByClub>\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"         <tem:clubNumber>"+clubId+"</tem:clubNumber>\r\n" + 
					"      </tem:GetAvailablePackagesByClub>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		
		public static String getAvailablePackagesByClubOnlineBypass(int customerId, int clubId, Boolean returnOnlinePackageOnly)
		{
			
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetAvailablePackagesByClubOnlineBypass>\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"         <tem:clubNumber>1</tem:clubNumber>\r\n" + 
					"         <tem:returnOnlinePackagesOnly>"+returnOnlinePackageOnly+"</tem:returnOnlinePackagesOnly>\r\n" + 
					"      </tem:GetAvailablePackagesByClubOnlineBypass>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		
		public static String getPackage(int customerId, int packageId, int clubId)
		{
			
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+prop.getProperty("CompanyId")+"</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" +
//					"      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext><CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId></soapenv:Header>\r\n" + 
					"   <soapenv:Body>\r\n" + 
					"      <tem:GetPackage>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:customerId>"+customerId+"</tem:customerId>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:packageId>"+packageId+"</tem:packageId>\r\n" + 
					"         <!--Optional:-->\r\n" + 
					"         <tem:clubNumber>"+clubId+"</tem:clubNumber>\r\n" + 
					"      </tem:GetPackage>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
	
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
