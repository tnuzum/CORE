package payloads;

import resources.base;

public class BookViewPL extends base{
	public static String getAvailableResourceTypesByClub(String companyId, String clubID)
	{
		String pl="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
				+ "  <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetAvailableResourceTypesByClub>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:clubId>"+clubID+"</tem:clubId>\r\n"
				+ "      </tem:GetAvailableResourceTypesByClub>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetResourceTypeAvailability(String companyId, String clubID, String resourceTypeId)
	{
		String pl="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
				+ "    <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetResourceTypeAvailability>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:resourceTypeId>"+resourceTypeId+"</tem:resourceTypeId>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:clubId>"+clubID+"</tem:clubId>\r\n"
				+ "      </tem:GetResourceTypeAvailability>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetActiveBooksByResourceTypey(String companyId, String clubID, String resourceTypeId)
	{
		String pl="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
				+ "    <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetActiveBooksByResourceType>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:resourceTypeId>"+resourceTypeId+"</tem:resourceTypeId>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:clubId>"+clubID+"</tem:clubId>\r\n"
				+ "      </tem:GetActiveBooksByResourceType>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}
	public static String GetProductByBook(String companyId, String clubID, String bookID)
	{
		String pl= "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
				+ "   <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <tem:GetProductByBook>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:clubId>"+clubID+"</tem:clubId>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:bookId>"+bookID+"</tem:bookId>\r\n"
				+ "      </tem:GetProductByBook>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetBookAvailability(String companyId, String bookID, String resourceTypeId, String clubID)
	{
		String pl= "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
				+ "  <soapenv:Header>\r\n"
				+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
				+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "         <soapenv:Body>\r\n"
				+ "      <tem:GetBookAvailability>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:bookId>"+bookID+"</tem:bookId>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:resourceTypeId>"+resourceTypeId+"</tem:resourceTypeId>\r\n"
				+ "         <!--Optional:-->\r\n"
				+ "         <tem:clubId>"+clubID+"</tem:clubId>\r\n"
				+ "      </tem:GetBookAvailability>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		return pl;
	}
	
	public static String GetBookAvailabilityCalendar(String companyId, String bookID, String resourceTypeId, String clubID)
	{
	String pl= "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\r\n"
			+ "   <soapenv:Header>\r\n"
			+ "      <CompanyId xmlns=\"http://jonasfitness.com/Core/\">"+companyId+"</CompanyId>\r\n"
			+ "      <CallerContext xmlns=\"http://jonasfitness.com/Core/\">Member</CallerContext>\r\n"
			+ "   </soapenv:Header>\r\n"
			+ "   <soapenv:Body>\r\n"
			+ "      <tem:GetBookAvailabilityCalendar>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:clubId>"+clubID+"</tem:clubId>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:startDateTime>2019-10-28T08:00:00</tem:startDateTime>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:endDateTime>2019-10-29T21:00:00</tem:endDateTime>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:bookId>"+bookID+"</tem:bookId>\r\n"
			+ "         <!--Optional:-->\r\n"
			+ "         <tem:resourceTypeId>"+resourceTypeId+"</tem:resourceTypeId>\r\n"
			+ "      </tem:GetBookAvailabilityCalendar>\r\n"
			+ "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>\r\n"
			+ "\r\n"
			+ "";
	return pl;
	}
}
