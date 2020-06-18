package resources;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import payloads.CorporateInfoPL;

public class myGets {
	
	public static Response getProjectConfiguration(String companyId) {
		
		Response res = given()
//				.log().all()
	 			.headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetBusinessIntelligenceConfiguration","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(CorporateInfoPL.GetBusinessIntelligenceConfiguration(companyId))
			.when()
				.post("/Info/CorporateInfo.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();
			
			return res;	
	}

}
