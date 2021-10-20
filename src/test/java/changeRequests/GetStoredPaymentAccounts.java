package changeRequests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.ChangeRequestsPL;
import resources.ReusableMethods;
import resources.base;

public class GetStoredPaymentAccounts extends base {
	
	String companyId;
	String customerId;
	String clubId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Checking Account No Agreement")
	public void checkingAccountNoAgreement(){
		
		String customerId = prop.getProperty("checkingMemberId");

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/GetStoredPaymentAccounts",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.getStoredPaymentAccounts(companyId, customerId))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);	
				
				Assert.assertTrue(res.getTime() >= 60L);
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].AccountId.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].AccountId.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].BankAccountType.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].BankAccountType.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].BillingName.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].BillingName.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].IsBusiness.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].IsBusiness.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].IsHouseAccount.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].IsHouseAccount.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].PendingAdd"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].RoutingNumber.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].RoutingNumber.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].TruncatedAccountNumber.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].TruncatedAccountNumber.PendingChange"));
				
				Assert.assertEquals(js.getInt("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.BankAccounts.StoredBankAccountWithChangeDetailsDto[0].AccountId.CurrentValue"), 1);
	}
	
	@Test (testName="Multiple Agreements Single Card")
	public void multipleAgreementsSingleCard(){
		
		String customerId = prop.getProperty("MultipleAgreementsWithSingleCardId");

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/GetStoredPaymentAccounts",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.getStoredPaymentAccounts(companyId, customerId))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].AccountId.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].AccountId.PendingChange"));
				Assert.assertEquals(js.getInt("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].AccountId.CurrentValue"), 1);
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Address1.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Address1.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Address2.PendingChange"));
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[0].AgreementNumber"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[0].Description"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[0].IsAssigned"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[0].PendingChange"));
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].Agreements.AgreementWithPendingChangeDto[1].AgreementNumber"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].Agreements.AgreementWithPendingChangeDto[1].Description"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].Agreements.AgreementWithPendingChangeDto[1].IsAssigned"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].Agreements.AgreementWithPendingChangeDto[1].PendingChange"));
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].CardType.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].CardType.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].City.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].City.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].ExpirationDate.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].ExpirationDate.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].IsHouseAccount.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].IsHouseAccount.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].IsSameAsMemberAddress.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].IsSameAsMemberAddress.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].NameOnCard.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].NameOnCard.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].PendingAdd"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].State.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].State.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].TruncatedAccountNumber.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].TruncatedAccountNumber.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].UseInPOS.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].UseInPOS.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].ZipCode.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].ZipCode.PendingChange"));
	}
	
	@Test (testName="Multiple Agreements Multiple Credit Cards")
	public void multipleAgreementsMultipleCreditCards(){
		
		String customerId = prop.getProperty("MultipleAgreementsWithMultipleCardsId");

	      Response res =  given()
//	        .log().all()
 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/GetStoredPaymentAccounts",
 					"Content-Type", "text/xml; charset=utf-8")
	                .and()
	                .body(ChangeRequestsPL.getStoredPaymentAccounts(companyId, customerId))
	         .when()
	            .post("/ChangeRequests/ChangeRequest.svc")
	         .then()
//             	.log().body()
	            .statusCode(200)
				.extract().response();
	      
				XmlPath js = ReusableMethods.rawToXML(res);		
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].AccountId.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].AccountId.PendingChange"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].AccountId.CurrentValue"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Address1.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Address1.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Address2.PendingChange"));
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[0].AgreementNumber"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[0].Description"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[0].IsAssigned"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[0].PendingChange"));
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[1].AgreementNumber"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[1].Description"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[1].IsAssigned"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[1].PendingChange"));
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].CardType.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].CardType.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].City.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].City.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].ExpirationDate.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].ExpirationDate.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].IsHouseAccount.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].IsHouseAccount.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].IsSameAsMemberAddress.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].IsSameAsMemberAddress.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].NameOnCard.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].NameOnCard.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].PendingAdd"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].State.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].State.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].TruncatedAccountNumber.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].TruncatedAccountNumber.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].UseInPOS.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].UseInPOS.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].ZipCode.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].ZipCode.PendingChange"));
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].AccountId.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].AccountId.PendingChange"));
				Assert.assertNotNull(js.getInt("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].AccountId.CurrentValue"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].Address1.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].Address1.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].Address2.PendingChange"));
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[1].AgreementNumber"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[1].Description"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[1].IsAssigned"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[0].Agreements.AgreementWithPendingChangeDto[1].PendingChange"));
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].Agreements.AgreementWithPendingChangeDto[1].AgreementNumber"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].Agreements.AgreementWithPendingChangeDto[1].Description"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].Agreements.AgreementWithPendingChangeDto[1].IsAssigned"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].Agreements.AgreementWithPendingChangeDto[1].PendingChange"));
				
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].CardType.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].CardType.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].City.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].City.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].ExpirationDate.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].ExpirationDate.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].IsHouseAccount.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].IsHouseAccount.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].IsSameAsMemberAddress.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].IsSameAsMemberAddress.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].NameOnCard.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].NameOnCard.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].PendingAdd"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].State.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].State.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].TruncatedAccountNumber.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].TruncatedAccountNumber.PendingChange"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].UseInPOS.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].UseInPOS.PendingChange"));
				Assert.assertNotNull(js.getString("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].ZipCode.CurrentValue"));
				Assert.assertNotNull(js.getBoolean("Envelope.Body.GetStoredPaymentAccountsResponse.GetStoredPaymentAccountsResult.CreditCards.StoredCreditCardWithChangeDetailsDto[1].ZipCode.PendingChange"));
	}
	
	
	
	
	
	
	
	
	
	
	
}