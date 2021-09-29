package bulkCustomerInfo;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.BulkCustomerInfoPL;
import resources.ReusableDates;
import resources.ReusableMethods;
import resources.base;

public class GetCustomers extends base {
	
	String basePath;
	String companyId;
	String clubId;
	String activeOnly;
	String lastUpdateDate;
	int page;
	int pageSize;
	String customerId;
	String fieldName;
	String newValue;
	String submissionReasonDetail;
	String submissionReason;
	
	@BeforeClass
	public void getData(){
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		basePath = "Envelope.Body.GetCustomersResponse.GetCustomersResult";
		
		companyId = prop.getProperty("X-CompanyId");
		clubId = prop.getProperty("club1Id");
		
		activeOnly = "true";
		lastUpdateDate = ReusableDates.getCurrentDate();
		page = 1;
		pageSize = 50;
	}
	
	@Test (testName="Required Fields Only")
	public void requiredFieldsOnly(){
		
	       Response res =  given()
//	    		.log().all()
                .headers("SOAPAction", "http://tempuri.org/IBulkCustomerInfo/GetCustomers","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(BulkCustomerInfoPL.getCustomersRequiredParametersOnly(companyId, clubId))
	         .when()
	            .post("/Info/BulkCustomerInfo.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		
	       		Assert.assertTrue(res.getTime() >= 60L);

	       		/*  These assertions are validating the response body
	       		 *  by assuming at least 1 member has data in the field,
	       		 *  that why it's not using an index number */
	       		
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.Address1").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.Address2").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.AllowCharges").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.BarcodeId").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.CellPhone").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.City").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.CreditLimit").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.CurrentBalance").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.DataExchangeID").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.DateOfBirth").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.DisplayName").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.Email").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.EmailContactConsent").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.EmergencyContact").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.EmergencyPhone").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.Employer").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.FirstName").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.Gender").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.GroupName").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.GroupNumber").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.HomeClubName").isBlank());
	       		Assert.assertTrue(js.getString(basePath+".Customers.CustomerDto.HomeClubNumber").contains(clubId));
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.HomePhoneContactConsent").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.Id").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.Interests").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.JoinDate").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.Last30DaysCheckinCount").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.Last90DaysCheckinCount").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.LastName").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.LastVisitDate").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.MaritalStatus").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.MarketingSourceDescription").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.MarketingSourceID").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.MemberType").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.MembershipExpires").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.MembershipType").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.MiddleInitial").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.MobilePhoneContactConsent").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.PreferredPhone").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.ReferringCustomerId").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.SalespersonID").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.SalespersonName").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.SourceID").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.State").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.Status").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.StatusDate").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.StatusID").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.StatusReason").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.Title").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.Title").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry1").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry2").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry3").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry4").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry5").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry6").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry7").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry8").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry9").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry10").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry11").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry12").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry13").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry14").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry15").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.UserEntry16").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.WorkPhone").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.WorkPhoneContactConsent").isBlank());
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.ZipCode").isBlank());

	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.Page") > 0);
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.PageSize") > 0);
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.TotalPages") > 0);
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.TotalRecords") > 0);
}
	
	@Test (testName="All Parameters")
	public void allParameters(){
		
			ReusableMethods.setLastUpdateDateToday(companyId, clubId);
			
			Response res =  given()
//	    		.log().all()
                .headers("SOAPAction", "http://tempuri.org/IBulkCustomerInfo/GetCustomers","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(BulkCustomerInfoPL.getCustomersAllParameters(companyId, clubId, activeOnly, lastUpdateDate, page, pageSize))
	         .when()
	            .post("/Info/BulkCustomerInfo.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		
	       		Assert.assertTrue(res.getTime() >= 60L);
	       		
	       		Assert.assertTrue(js.getString(basePath+".Customers.CustomerDto.HomeClubNumber").contains(clubId));
	       		
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.Page") == page);
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.PageSize") > 0);
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.TotalPages") > 0);
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.TotalRecords") > 0);
}
	
	@Test (testName="Active Customers Only Found")
	public void activeCustomersOnlyFound(){
		
	       Response res =  given()
//	    		.log().all()
                .headers("SOAPAction", "http://tempuri.org/IBulkCustomerInfo/GetCustomers","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(BulkCustomerInfoPL.getCustomersRequiredParametersOnly(companyId, clubId))
	         .when()
	            .post("/Info/BulkCustomerInfo.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		
	       		Assert.assertFalse(js.getString(basePath+".CustomerDto.Status").contains("Terminate"));
	       		Assert.assertFalse(js.getString(basePath+".CustomerDto.Status").contains("Freeze"));
}
	
	@Test (testName="All Customers Found")
	public void allCustomersFound(){
		
			String activeOnly = "false";
		
			Response res =  given()
//	    		.log().all()
                .headers("SOAPAction", "http://tempuri.org/IBulkCustomerInfo/GetCustomers","Content-Type", "text/xml; charset=utf-8")
                .body(BulkCustomerInfoPL.getAllCustomers(companyId, clubId, activeOnly))
	         .when()
	            .post("/Info/BulkCustomerInfo.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		
	       		Assert.assertTrue(js.getString(basePath+".Customers.CustomerDto.Status").contains("Terminate"));
	       		
}
	
	@Test (testName="Club 2 Only")
	public void club2Only(){
		
			String clubId = "1";
			String club2Id = "2";
		
	       Response res =  given()
//	    		.log().all()
                .headers("SOAPAction", "http://tempuri.org/IBulkCustomerInfo/GetCustomers","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(BulkCustomerInfoPL.getCustomersRequiredParametersOnly(companyId, club2Id))
	         .when()
	            .post("/Info/BulkCustomerInfo.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);

	       		Assert.assertTrue(js.getString(basePath+".Customers.CustomerDto.HomeClubNumber").contains(club2Id));
	       		Assert.assertFalse(js.getString(basePath+".Customers.CustomerDto.HomeClubNumber").contains(clubId));
}
	
	@Test (testName="No Customers Found")
	public void noCustomersFound(){
		
			String lastUpdateDate = "2100-01-01";
			
			Response res =  given()
//	    		.log().all()
                .headers("SOAPAction", "http://tempuri.org/IBulkCustomerInfo/GetCustomers","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(BulkCustomerInfoPL.getCustomersAllParameters(companyId, clubId, activeOnly, lastUpdateDate, page, pageSize))
	         .when()
	            .post("/Info/BulkCustomerInfo.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
	            .extract().response();
	       		
	       		Assert.assertTrue(res.getTime() >= 60L);
	}
	
	@Test (testName="Page Size")
	public void pageSize(){
		
			String lastUpdateDate = "1900-01-01T00:00:00";
			int pageSize = 1;
			
			Response res =  given()
//	    		.log().all()
                .headers("SOAPAction", "http://tempuri.org/IBulkCustomerInfo/GetCustomers","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(BulkCustomerInfoPL.getCustomersAllParameters(companyId, clubId, activeOnly, lastUpdateDate, page, pageSize))
	         .when()
	            .post("/Info/BulkCustomerInfo.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		
	       		Assert.assertTrue(res.getTime() >= 60L);
	       		
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.Page") == page);
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.PageSize") == pageSize);
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.TotalPages") > 0);
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.TotalRecords") > 0);
	}
	
	@Test (testName="Page Count")
	public void pageCount(){
		
			String lastUpdateDate = "1900-01-01T00:00:00";
			int pageSize = 10;
			int page = 2;
			
			Response res =  given()
//	    		.log().all()
                .headers("SOAPAction", "http://tempuri.org/IBulkCustomerInfo/GetCustomers","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(BulkCustomerInfoPL.getCustomersAllParameters(companyId, clubId, activeOnly, lastUpdateDate, page, pageSize))
	         .when()
	            .post("/Info/BulkCustomerInfo.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
	            .extract().response();
	       
	       		XmlPath js = ReusableMethods.rawToXML(res);
	       		
	       		Assert.assertTrue(res.getTime() >= 60L);
	       		
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.Page") == page);
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.PageSize") == pageSize);
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.TotalPages") > 0);
	       		Assert.assertTrue(js.getInt(basePath+".PagingInfo.TotalRecords") > 0);
	}
	
}
