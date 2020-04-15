package corporateInfo;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.CorporateInfoPL;
import resources.ReusableMethods;
import resources.base;

public class GetRequiredFields extends base {
	
	String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");

	}
	
	@Test (testName="Get Required Fields")
	public void getRequiredFields() {
		
		Response res = given()
//			.log().all()
 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetRequiredFields","Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(CorporateInfoPL.GetRequiredFields(companyId))
		.when()
			.post("/Info/CorporateInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();
		
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[0].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[0].Name"), "Title");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[1].IsRequired"), true);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[1].Name"), "FirstName");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[2].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[2].Name"), "MI");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[3].IsRequired"), true);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[3].Name"), "LastName");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[4].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[4].Name"), "Preferred");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[5].IsRequired"), true);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[5].Name"), "Address1");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[6].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[6].Name"), "Address2");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[7].IsRequired"), true);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[7].Name"), "City");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[8].IsRequired"), true);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[8].Name"), "State");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[9].IsRequired"), true);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[9].Name"), "Zipcode");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[10].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[10].Name"), "HomePhone");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[11].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[11].Name"), "WorkPhone");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[12].IsRequired"), true);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[12].Name"), "CellPhone");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[13].IsRequired"), true);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[13].Name"), "Email");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[14].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[14].Name"), "SendEmailStatements");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[15].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[15].Name"), "EmergencyContact");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[16].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[16].Name"), "EmergencyPhone");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[17].IsRequired"), true);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[17].Name"), "DateOfBirth");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[18].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[18].Name"), "DriverLicNum");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[19].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[19].Name"), "SSNum");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[20].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[20].Name"), "Gender");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[21].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[21].Name"), "TrainerID");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[22].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[22].Name"), "Promotion");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[23].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[23].Name"), "SourceID");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[24].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[24].Name"), "Occupation");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[25].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[25].Name"), "Employer");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[26].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[26].Name"), "IncomeChoice");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[27].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[27].Name"), "Login");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[28].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[28].Name"), "GroupID");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[29].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[29].Name"), "InsuranceID");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[30].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[30].Name"), "InsuranceRegistrationDate");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[31].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[31].Name"), "UserEntry1");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[32].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[32].Name"), "UserEntry2");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[33].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[33].Name"), "UserEntry3");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[34].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[34].Name"), "UserEntry4");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[35].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[35].Name"), "UserEntry5");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[36].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[36].Name"), "UserEntry6");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[37].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[37].Name"), "UserEntry7");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[38].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[38].Name"), "UserEntry8");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[39].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[39].Name"), "UserEntry9");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[40].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[40].Name"), "UserEntry10");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[41].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[41].Name"), "UserEntry11");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[42].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[42].Name"), "UserEntry12");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[43].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[43].Name"), "UserEntry13");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[4].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[44].Name"), "UserEntry14");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[45].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[45].Name"), "UserEntry15");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[46].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[46].Name"), "UserEntry16");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[47].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[47].Name"), "UserDate1");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[48].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[48].Name"), "UserDate2");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[49].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[49].Name"), "UserDate3");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[50].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[50].Name"), "UserDate4");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[51].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[51].Name"), "UserAmount1");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[52].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[52].Name"), "UserAmount2");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[53].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[53].Name"), "UserAmount3");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[54].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[54].Name"), "UserAmount4");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[55].IsRequired"), true);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[55].Name"), "CategoryID");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[56].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[56].Name"), "PreferredPhone");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[57].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[57].Name"), "ExcludeFromMailing");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[58].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[58].Name"), "DoNotMarket");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[59].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[59].Name"), "ApplyCreditLimit");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[60].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[60].Name"), "CreditLimit");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[61].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[61].Name"), "RestrictMemberFromSearch");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[62].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[62].Name"), "OnlineMemberSearch");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[63].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[63].Name"), "ReferringCustomerID");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[64].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[64].Name"), "Date");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[65].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[65].Name"), "InterestID");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[66].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[66].Name"), "GeneralNotes");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[67].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[67].Name"), "MedicalRisk");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[68].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[68].Name"), "ClubNumber");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[69].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[69].Name"), "IsLead");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[70].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[70].Name"), "StageId");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[71].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[71].Name"), "Priority");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[72].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[72].Name"), "SalespersonID");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[73].IsRequired"), false);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[73].Name"), "MedicalNote");
			Assert.assertEquals(js.getBoolean("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[74].IsRequired"), true);
			Assert.assertEquals(js.getString("Envelope.Body.GetRequiredFieldsResponse.GetRequiredFieldsResult.RequiredFieldDto[74].Name"), "BarcodeID");
		
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
}


