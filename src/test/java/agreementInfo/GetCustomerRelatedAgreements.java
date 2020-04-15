package agreementInfo;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.AgreementInfoPL;
import resources.ReusableMethods;
import resources.base;

public class GetCustomerRelatedAgreements extends base {
	
	String companyId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	
	@Test (testName="Single Agreement Found")
	public void singleAgreementFound() {
		
		String customerId = prop.getProperty("agreementMemberId");
		
		Response res = given()
 			.headers("SOAPAction", "http://tempuri.org/IAgreementInfo/GetCustomerRelatedAgreements",
 					"Content-Type", "text/xml; charset=utf-8")
			.and()
			.body(AgreementInfoPL.getCustomerRelatedAgreements(companyId, customerId))
		.when()
			.post("/Agreements/AgreementInfo.svc")
		.then()
//			.log().all()
			.statusCode(200)
			.extract().response();  
			
			XmlPath js = ReusableMethods.rawToXML(res);
			
			Assert.assertTrue(res.getTime() >= 60L);
			
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.AgreementNumber"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.AgreementStatus"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.AllowedPaymentTypes.AcceptsCheckingAccountFormOfPayment"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.AllowedPaymentTypes.AcceptsCreditCardFormOfPayment"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.AllowedPaymentTypes.AcceptsNotBilledFormOfPayment"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.AllowedPaymentTypes.AcceptsSavingsAccountFormOfPayment"));
			Assert.assertNotNull(js.getBoolean("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.AllowedPaymentTypes.AcceptsStatementFormOfPayment"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.Description"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.EffectiveDate.DateTime"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.EffectiveDate.OffsetMinutes"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.ExpirationDate"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.NextBillingDate.DateTime"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.NextBillingDate.OffsetMinutes"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.PaymentInfo.AccountId"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.PaymentInfo.AccountTypeDescription"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.PaymentInfo.BarcodeId"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.PaymentInfo.CardType"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.PaymentInfo.CustomerId"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.PaymentInfo.CustomerName.DisplayName"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.PaymentInfo.CustomerName.FirstName"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.PaymentInfo.CustomerName.LastName"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.PaymentInfo.CustomerName.LastName"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.PaymentInfo.TruncatedAccountNumber"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.RecurringDuesAmount"));
			Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerRelatedAgreementsResponse.GetCustomerRelatedAgreementsResult.RelatedAgreementsResponse.TermType"));
			
		}			





}


