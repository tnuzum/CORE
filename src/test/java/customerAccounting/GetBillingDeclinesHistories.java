package customerAccounting;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CustomerAccountingPL;
import resources.ReusableDates;
import resources.ReusableMethods;
import resources.base;

public class GetBillingDeclinesHistories extends base {
	
	static String companyId;
	static String clubId;
	static String startDate;
	static String endDate;
	static String minimumDeclinesCount;
	static String returnsType;
	
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");

		companyId = prop.getProperty("X-CompanyId");
		clubId = prop.getProperty("club1Id");
		startDate = ReusableDates.getCurrentDateMinusXYears(5);
		endDate = ReusableDates.getCurrentDate();
		minimumDeclinesCount = "0";
		returnsType = "All";
		
	}
	
	@Test (testName="History Found For All Clubs", description="PBI:150327")
	public void historyFoundAllClubs() {
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersAllClubs(companyId, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].Amount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].Attendant"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ClubName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].DisplayCode"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].LateFeeAppliedAmount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnCode"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnDate"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnDescription"));	
	}
	
	@Test (testName="All History Found for 1 club", description="PBI:150327")
	public void allHistoryFound() {
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersSingleClub(companyId, clubId, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].Amount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].Attendant"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ClubName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].DisplayCode"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].LateFeeAppliedAmount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnCode"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnDate"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnDescription"));	
	}
	
	@Test (testName="Corrections History Found", description="PBI:150327", enabled = false)
	public void correctionsHistoryFound() {
		
		String startDate = ReusableDates.getCurrentDateMinusXYears(10);
		String returnsType = "Corrections";
		
	Response res = 
		
		 given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersSingleClub(companyId, clubId, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].Amount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].Attendant"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ClubName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].DisplayCode"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].LateFeeAppliedAmount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnCode"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnDate"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnDescription"));
	}
	
	@Test (testName="Declines History Found", description="PBI:150327")
	public void declinesHistoryFound() {
		
			String returnsType = "Declines";
			
	Response res = 
		
		 given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersSingleClub(companyId, clubId, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].Amount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].Attendant"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ClubName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].DisplayCode"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].LateFeeAppliedAmount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnCode"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnDate"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnDescription"));
	}
	
	@Test (testName="History Found For Multiple Clubs", description="PBI:150327")
	public void historyFoundMultipleClubs() {
		
			String club2Id = prop.getProperty("club2Id");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersMultipleClubs(companyId, clubId, club2Id, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200)
         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
       		
    		Assert.assertTrue(res.getTime() >= 60L);
    		Assert.assertNotNull(js.getDouble("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].Amount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].Attendant"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ClubName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerBarcodeId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerId"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].CustomerName"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].DisplayCode"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].LateFeeAppliedAmount"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnCode"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnDate"));
    		Assert.assertNotNull(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.BillingDeclines.BillingDeclinesHistoryDto[0].ReturnDescription"));	
	}
	
	@Test (testName="All History Not Found", description="PBI:150327")
	public void allHistoryNotFound() {
		
		String startDate = ReusableDates.getCurrentDateMinusXYears(12);
		String endDate = ReusableDates.getCurrentDateMinusXYears(11);
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersSingleClub(companyId, clubId, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().body()
         	.statusCode(200);
	}
	
	@Test (testName="Corrections History Not Found", description="PBI:150327")
	public void correctionsHistoryNotFound() {
		
		String startDate = ReusableDates.getCurrentDateMinusXYears(12);
		String endDate = ReusableDates.getCurrentDateMinusXYears(11);
		String returnsType = "Corrections";
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersSingleClub(companyId, clubId, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200);
	}

	@Test (testName="Declines History Not Found", description="PBI:150327")
	public void declinesHistoryNotFound() {
		
		String startDate = ReusableDates.getCurrentDateMinusXYears(10);
		String endDate = ReusableDates.getCurrentDateMinusXYears(11);
		String returnsType = "Declines";
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersSingleClub(companyId, clubId, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200);
	}
	
	@Test (testName="No History Found Minimum Declines Count", description="PBI:150327")
	public void noHistoryFoundMinimumDeclinesCount() {
		
		String minimumDeclinesCount = "500";
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersSingleClub(companyId, clubId, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200);
	}
	
	@Test (testName="Future Date Range", description="PBI:150327")
	public void futureDateRange() {
		
		String startDate = ReusableDates.getCurrentDatePlusXDays(100);
		String endDate = ReusableDates.getCurrentDatePlusXDays(101);
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersSingleClub(companyId, clubId, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(200);
	}
	
	@Test (testName="Invalid Minimum Declines Count", description="PBI:150327")
	public void invalidMinimumDeclinesCount() {
		
		String minimumDeclinesCount = prop.getProperty("NOF");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersSingleClub(companyId, clubId, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//        	.log().all()
         	.statusCode(500)
         	.extract().response();
	 
			XmlPath js = ReusableMethods.rawToXML(res);
	
			Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto.Message").contains("The value 'null' cannot be parsed as the type 'Int32'."));	
	}
	
	@Test (testName="Invalid Request Type", description="PBI:150327")
	public void invalidRequestType() {
		
		String returnsType = "Approvals";// not a valid Request Type
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersSingleClub(companyId, clubId, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(500)

         	.extract().response();
		 
    		XmlPath js = ReusableMethods.rawToXML(res);
    		
    		Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto.Message").contains("Invalid enum value"));
	}
	
	@Test (testName="Start Date Required", description="PBI:150327")
	public void startDateRequired() {
		
		String startDate = prop.getProperty("NOFDate");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersSingleClub(companyId, clubId, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(500)
         	.extract().response();
	 
			XmlPath js = ReusableMethods.rawToXML(res);
	
			Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto.Message").contains("The value 'null' cannot be parsed as the type 'DateTime'."));	
	}
	
	@Test (testName="End Date Required", description="PBI:150327")
	public void endDateRequired() {
		
		String endDate = prop.getProperty("NOFDate");
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersSingleClub(companyId, clubId, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().body()
         	.statusCode(500)
         	.extract().response();
	 
			XmlPath js = ReusableMethods.rawToXML(res);
	
			Assert.assertTrue(js.getString("Envelope.Body.Fault.detail.InternalServerErrorFaultDto.Message").contains("The value 'null' cannot be parsed as the type 'DateTime'."));	
	}
	
	@Test (testName="End Date Prior to Start Date", description="PBI:150327", enabled = true)
	public void endDatePriorToStartDate() {
		
		String endDate = ReusableDates.getCurrentDateMinusXYears(50);
		
	Response res = 
			
		given()
//			.log().all()
         	.headers("SOAPAction", "http://tempuri.org/ICustomerAccounting/GetBillingDeclinesHistories","Content-Type", "text/xml; charset=utf-8")
         	.and()
         	.body(CustomerAccountingPL.getBillingDeclinesHistoriesAllParametersSingleClub(companyId, clubId, startDate, endDate, minimumDeclinesCount, returnsType))
         .when()
         	.post("/Financial/CustomerAccounting.svc")
         .then()
//         	.log().all()
         	.statusCode(200)
         	.extract().response();
	 
			XmlPath js = ReusableMethods.rawToXML(res);
	
			Assert.assertEquals(js.getString("Envelope.Body.GetBillingDeclinesHistoriesResponse.GetBillingDeclinesHistoriesResult.Messages"), "StartDate must be less than or equal to EndDate");	
	}
	
	
	
	
	
	
}