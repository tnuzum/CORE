package checkIn;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CheckInPL;
import resources.ReusableDates;
import resources.ReusableMethods;
import resources.base;

public class ProcessCustomerCheckIn extends base{
	
	String clubId;
	String companyId;
	String serviceId;
	String stationId;
	
	@BeforeTest
	public void getdata()
	{
		base.getPropertyData();
		RestAssured.baseURI =prop.getProperty("baseURI");
		companyId= prop.getProperty("X-CompanyId");
		clubId = prop.getProperty("X-Club1Id");
		serviceId = "1";
		stationId = "15";
	}
	
	@Test(testName= "Active Member Check-In")
	public void activeMemberCheckIn()
	{
		String customerId = prop.getProperty("availableId");
		String checkInValidations = "StatusValidation";
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("CheckInId"));
			Assert.assertTrue(xmlPretty.contains("CheckInResult"));
			Assert.assertTrue(xmlPretty.contains("Success"));
			
			String startDateTime = ReusableDates.getCurrentDate();
			String endDateTime = ReusableDates.getCurrentDatePlusXDays(1);
			
			String cv = ReusableMethods.getCustomerVisits(companyId, customerId, startDateTime, "0", endDateTime, "0");

			Assert.assertTrue(cv.contains(startDateTime));		
	}	
	
	@Test(testName= "Prospect Check-In")
	public void prospectCheckIn()
	{
		String customerId = prop.getProperty("prospectId");
		String checkInValidations = "StatusValidation";
				
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("CheckInId"));
			Assert.assertTrue(xmlPretty.contains("CheckInResult"));
			Assert.assertTrue(xmlPretty.contains("Success"));
			
			String startDateTime = ReusableDates.getCurrentDate();
			String endDateTime = ReusableDates.getCurrentDatePlusXDays(1);
			
			String cv = ReusableMethods.getCustomerVisits(companyId, customerId, startDateTime, "0", endDateTime, "0");

			Assert.assertTrue(cv.contains(startDateTime));
					
	}
	
	@Test(testName= "Expired Membership Allowed")
	public void expiredMembershipAllowed()
	{
		String customerId = prop.getProperty("expiredMembershipId");
		String checkInValidations = ""; // allowed because no validation is sent
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("CheckInId"));
			Assert.assertTrue(xmlPretty.contains("CheckInResult"));
			Assert.assertTrue(xmlPretty.contains("Success"));
			
			String startDateTime = ReusableDates.getCurrentDate();
			String endDateTime = ReusableDates.getCurrentDatePlusXDays(1);
			
			String cv = ReusableMethods.getCustomerVisits(companyId, customerId, startDateTime, "0", endDateTime, "0");

			Assert.assertTrue(cv.contains(startDateTime));		
	}	
	
	@Test(testName= "Expired Membership Not Allowed")
	public void expiredMembershipNotAllowed()
	{
		String customerId = prop.getProperty("expiredMembershipId");
		String checkInValidations = "ActiveContractValidation";
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("NoActiveContract"));
	
	}	
	
	@Test(testName= "Past Due Balance Allowed")
	public void pastDueBalanceAllowed()
	{
		String customerId = prop.getProperty("noFOPId");
		String checkInValidations = ""; // allowed because no validation is sent
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("CheckInId"));
			Assert.assertTrue(xmlPretty.contains("CheckInResult"));
			Assert.assertTrue(xmlPretty.contains("Success"));
			
			String startDateTime = ReusableDates.getCurrentDate();
			String endDateTime = ReusableDates.getCurrentDatePlusXDays(1);
			
			String cv = ReusableMethods.getCustomerVisits(companyId, customerId, startDateTime, "0", endDateTime, "0");

			Assert.assertTrue(cv.contains(startDateTime));		
	}	
	
	@Test(testName= "Past Due Balance Not Allowed")
	public void pastDueBalanceNotAllowed()
	{
		String customerId = prop.getProperty("noFOPId");
		String checkInValidations = "BalanceValidation";
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("HasPastDueBalance"));
	
	}	
	
	@Test(testName= "Service Area Allowed")
	public void serviceAreaAllowed()
	{
		String customerId = prop.getProperty("serviceAreaRestrictionId");
		String checkInValidations = ""; // allowed because no validation is sent
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("CheckInId"));
			Assert.assertTrue(xmlPretty.contains("CheckInResult"));
			Assert.assertTrue(xmlPretty.contains("Success"));
			
			String startDateTime = ReusableDates.getCurrentDate();
			String endDateTime = ReusableDates.getCurrentDatePlusXDays(1);
			
			String cv = ReusableMethods.getCustomerVisits(companyId, customerId, startDateTime, "0", endDateTime, "0");

			Assert.assertTrue(cv.contains(startDateTime));		
	}	
	
	@Test(testName= "Service Area Not Allowed")
	public void serviceAreaNotAllowed()
	{
		String customerId = prop.getProperty("serviceAreaRestrictionId");
		String serviceId = "18";
		String checkInValidations = "MembershipTypeServiceAreaAdmittanceValidation";
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("MembershipTypeServiceAreaRestrictionNotAllowed"));
		
	}	

	@Test(testName= "Time Not Allowed")
	public void timeNotAllowed()
	{
		String customerId = prop.getProperty("membershipTypeTimeRestrictionValidationId");
		String checkInValidations = "MembershipTypeTimeRestrictionValidation";
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("MembershipTypeTimeRestrictionNotAllowed"));
	
	}	
	
	@Test(testName= "Club Not Allowed")
	public void ClubNotAllowed()
	{
		String customerId = prop.getProperty("membershipTypeClubAdmittanceValidationId");
		String checkInValidations = "MembershipTypeClubAdmittanceValidation";
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("MembershipTypeClubAdmittanceNotAllowed"));
	
	}	
	
	@Test(testName= "Terminated Member Allowed")
	public void terminatedMemberAllowed()
	{
		String customerId = prop.getProperty("terminatedId");
		String checkInValidations = ""; // allowed because no validation is sent
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("CheckInId"));
			Assert.assertTrue(xmlPretty.contains("CheckInResult"));
			Assert.assertTrue(xmlPretty.contains("Success"));
			
			String startDateTime = ReusableDates.getCurrentDate();
			String endDateTime = ReusableDates.getCurrentDatePlusXDays(1);
			
			String cv = ReusableMethods.getCustomerVisits(companyId, customerId, startDateTime, "0", endDateTime, "0");

			Assert.assertTrue(cv.contains(startDateTime));		
	}	
	
	@Test(testName= "Terminated Member Not Allowed")
	public void terminatedMemberNotAllowed()
	{
		String customerId = prop.getProperty("terminatedId");
		String checkInValidations = "StatusValidation";
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("IsInactiveStatus"));
		
	}	
	
	@Test(testName= "Frozen Member Allowed")
	public void frozenMemberAllowed()
	{
		String customerId = prop.getProperty("frozenId");
		String checkInValidations = ""; // allowed because no validation is sent
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("CheckInId"));
			Assert.assertTrue(xmlPretty.contains("CheckInResult"));
			Assert.assertTrue(xmlPretty.contains("Success"));
			
			String startDateTime = ReusableDates.getCurrentDate();
			String endDateTime = ReusableDates.getCurrentDatePlusXDays(1);
			
			String cv = ReusableMethods.getCustomerVisits(companyId, customerId, startDateTime, "0", endDateTime, "0");

			Assert.assertTrue(cv.contains(startDateTime));		
	}	
	
	@Test(testName= "Frozen Member Not Allowed")
	public void frozenMemberNotAllowed()
	{
		String customerId = prop.getProperty("frozenId");
		String checkInValidations = "StatusValidation";
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("IsInactiveStatus"));
		
	}	
	
	@Test(testName= "Multiple Validations")
	public void multipleValidations()
	{
		String customerId = prop.getProperty("terminatedId");
		String checkInValidations = "ActiveContractValidation BalanceValidation MembershipTypeServiceAreaAdmittanceValidation MembershipTypeClubAdmittanceValidation MembershipTypeClubAdmittanceValidation StatusValidation";
			
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("NoActiveContract HasPastDueBalance IsInactiveStatus"));
		
	}	
	
	@Test(testName= "Invalid Member Not Allowed")
	public void invalidMemberNotAllowed()
	{
		String customerId = "9999999";
		String checkInValidations = "ActiveContractValidation BalanceValidation MembershipTypeServiceAreaAdmittanceValidation MembershipTypeClubAdmittanceValidation MembershipTypeClubAdmittanceValidation StatusValidation";
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(400)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("CustomerId: 9999999 is invalid"));
		
	}	
	
	@Test(testName= "Invalid Service Not Allowed")
	public void invalidServiceNotAllowed()
	{
		String customerId = prop.getProperty("availableId");
		String serviceId = "4";
		String checkInValidations = "ActiveContractValidation BalanceValidation MembershipTypeServiceAreaAdmittanceValidation MembershipTypeClubAdmittanceValidation MembershipTypeClubAdmittanceValidation StatusValidation";
			
		
		Response res =	 
		
		given()
//			.log().all()
		  	.headers("SOAPAction", "http://tempuri.org/ICheckIn/ProcessCustomerCheckIn","Content-Type", "text/xml; charset=utf-8")
		  	.and()
		  	.body(CheckInPL.processCustomerCheckInPl(companyId, checkInValidations, clubId, customerId, serviceId, stationId))
		 .when()
		  	.post("/Visits/CheckIn.svc")
		 .then()
//		  	.log().all()
		   	.statusCode(200)
		   	.extract().response();
	
			XmlPath xml = ReusableMethods.rawToXML(res);
			String  xmlPretty = xml.prettify();
			
			Assert.assertTrue(xmlPretty.contains("ServiceIdInvalid"));
		
	}	
	
	
	
	
	
}
