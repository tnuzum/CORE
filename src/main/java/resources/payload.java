package resources;

public class payload {

	//---------------------------------------------------------------------------
	// Service Items
	
		public static String RestrictTrueServiceFound()
		{
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"  <soapenv:Body>\r\n" + 
					"      <tem:GetPackageDetails>\r\n" + 
					"         <tem:customerId>223</tem:customerId>\r\n" + 
					"         <tem:packageId>36</tem:packageId>\r\n" + 
					"         <tem:clubNumber>1</tem:clubNumber>\r\n" + 
					"         <tem:includeItemRestrictions>true</tem:includeItemRestrictions>\r\n" + 
					"      </tem:GetPackageDetails>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		public static String RestrictTrueInactiveService()
		{
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"  <soapenv:Body>\r\n" + 
					"      <tem:GetPackageDetails>\r\n" + 
					"         <tem:customerId>223</tem:customerId>\r\n" + 
					"         <tem:packageId>217</tem:packageId>\r\n" + 
					"         <tem:clubNumber>1</tem:clubNumber>\r\n" + 
					"         <tem:includeItemRestrictions>true</tem:includeItemRestrictions>\r\n" + 
					"      </tem:GetPackageDetails>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		public static String RestrictTrueServiceNotAllowedOnline()
		{
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"  <soapenv:Body>\r\n" + 
					"      <tem:GetPackageDetails>\r\n" + 
					"         <tem:customerId>223</tem:customerId>\r\n" + 
					"         <tem:packageId>13</tem:packageId>\r\n" + 
					"         <tem:clubNumber>1</tem:clubNumber>\r\n" + 
					"         <tem:includeItemRestrictions>true</tem:includeItemRestrictions>\r\n" + 
					"      </tem:GetPackageDetails>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		public static String RestrictFalseServiceFound()
		{
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"  <soapenv:Body>\r\n" + 
					"      <tem:GetPackageDetails>\r\n" + 
					"         <tem:customerId>223</tem:customerId>\r\n" + 
					"         <tem:packageId>36</tem:packageId>\r\n" + 
					"         <tem:clubNumber>1</tem:clubNumber>\r\n" + 
					"         <tem:includeItemRestrictions>false</tem:includeItemRestrictions>\r\n" + 
					"      </tem:GetPackageDetails>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		public static String RestrictFalseInactiveService()
		{
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"  <soapenv:Body>\r\n" + 
					"      <tem:GetPackageDetails>\r\n" + 
					"         <tem:customerId>223</tem:customerId>\r\n" + 
					"         <tem:packageId>217</tem:packageId>\r\n" + 
					"         <tem:clubNumber>1</tem:clubNumber>\r\n" + 
					"         <tem:includeItemRestrictions>false</tem:includeItemRestrictions>\r\n" + 
					"      </tem:GetPackageDetails>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		public static String RestrictFalseServiceNotAllowedOnline()
		{
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"  <soapenv:Body>\r\n" + 
					"      <tem:GetPackageDetails>\r\n" + 
					"         <tem:customerId>223</tem:customerId>\r\n" + 
					"         <tem:packageId>13</tem:packageId>\r\n" + 
					"         <tem:clubNumber>1</tem:clubNumber>\r\n" + 
					"         <tem:includeItemRestrictions>false</tem:includeItemRestrictions>\r\n" + 
					"      </tem:GetPackageDetails>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		
//----------------------------------------------------------------------------------------
		// TRAINING ITEMS
		
		public static String RestrictTrueTrainingFound()
		{
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"  <soapenv:Body>\r\n" + 
					"      <tem:GetPackageDetails>\r\n" + 
					"         <tem:customerId>223</tem:customerId>\r\n" + 
					"         <tem:packageId>23</tem:packageId>\r\n" + 
					"         <tem:clubNumber>1</tem:clubNumber>\r\n" + 
					"         <tem:includeItemRestrictions>true</tem:includeItemRestrictions>\r\n" + 
					"      </tem:GetPackageDetails>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		public static String RestrictTrueInactiveTraining()
		{
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"  <soapenv:Body>\r\n" + 
					"      <tem:GetPackageDetails>\r\n" + 
					"         <tem:customerId>223</tem:customerId>\r\n" + 
					"         <tem:packageId>218</tem:packageId>\r\n" + 
					"         <tem:clubNumber>1</tem:clubNumber>\r\n" + 
					"         <tem:includeItemRestrictions>true</tem:includeItemRestrictions>\r\n" + 
					"      </tem:GetPackageDetails>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		public static String RestrictTrueTrainingNotAllowedOnline()
		{
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"  <soapenv:Body>\r\n" + 
					"      <tem:GetPackageDetails>\r\n" + 
					"         <tem:customerId>223</tem:customerId>\r\n" + 
					"         <tem:packageId>75</tem:packageId>\r\n" + 
					"         <tem:clubNumber>1</tem:clubNumber>\r\n" + 
					"         <tem:includeItemRestrictions>true</tem:includeItemRestrictions>\r\n" + 
					"      </tem:GetPackageDetails>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		public static String RestrictFalseTrainingFound()
		{
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"  <soapenv:Body>\r\n" + 
					"      <tem:GetPackageDetails>\r\n" + 
					"         <tem:customerId>223</tem:customerId>\r\n" + 
					"         <tem:packageId>23</tem:packageId>\r\n" + 
					"         <tem:clubNumber>1</tem:clubNumber>\r\n" + 
					"         <tem:includeItemRestrictions>false</tem:includeItemRestrictions>\r\n" + 
					"      </tem:GetPackageDetails>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		public static String RestrictFalseInactiveTraining()
		{
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"  <soapenv:Body>\r\n" + 
					"      <tem:GetPackageDetails>\r\n" + 
					"         <tem:customerId>223</tem:customerId>\r\n" + 
					"         <tem:packageId>218</tem:packageId>\r\n" + 
					"         <tem:clubNumber>1</tem:clubNumber>\r\n" + 
					"         <tem:includeItemRestrictions>false</tem:includeItemRestrictions>\r\n" + 
					"      </tem:GetPackageDetails>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		public static String RestrictFalseTrainingNotAllowedOnline()
		{
			String pd = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n" + 
					"   <soapenv:Header>\r\n" + 
					"      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">236</CompanyId><CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext></soapenv:Header>\r\n" + 
					"  <soapenv:Body>\r\n" + 
					"      <tem:GetPackageDetails>\r\n" + 
					"         <tem:customerId>223</tem:customerId>\r\n" + 
					"         <tem:packageId>75</tem:packageId>\r\n" + 
					"         <tem:clubNumber>1</tem:clubNumber>\r\n" + 
					"         <tem:includeItemRestrictions>false</tem:includeItemRestrictions>\r\n" + 
					"      </tem:GetPackageDetails>\r\n" + 
					"   </soapenv:Body>\r\n" + 
					"</soapenv:Envelope>";
			return pd;
		}
		
		
		
}
