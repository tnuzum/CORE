package CORE.CorporateInfo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import payloads.CorporateInfoPL;
import resources.base;

public class GetActiveClubsTest extends base {
	@BeforeTest
	public void getData() throws IOException {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
	}
	
	@Test (testName="Get Active Clubs")
	public void GetActiveClubs() {
		
		 given()
         .headers("SOAPAction", "http://tempuri.org/ICorporateInfo/GetActiveClubs","Content-Type", "text/xml; charset=utf-8")
         .and()
         .body(CorporateInfoPL.GetActiveClubs())
  .when()
     .post("/Info/CorporateInfo.svc")
  .then()
 	.log().all()
     .statusCode(200)
		.time(lessThan(5L),TimeUnit.SECONDS)
		.body("Envelope.Body.GetActiveClubsResponse.GetActiveClubsResult.ClubListDto.Id",  not(empty()));    
}
	}


