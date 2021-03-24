package bookView;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.BookViewPL;
import resources.ReusableMethods;
import resources.base;

public class GetProductByBook extends base{
	String companyId;
	@BeforeTest
	public void getData()
	{
		base.getPropertyData();
		
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	@Test (priority = 1, testName="ProductByBook")
	public void ProductByBook()
	{
		String bookID = prop.getProperty("bookID");
		String clubID = prop.getProperty("X-Club1Id");
		Response res =  given()
	    		.headers("SOAPAction", "http://tempuri.org/IBookView/GetProductByBook","Content-Type", "text/xml; charset=utf-8")
                .and()
                .body(BookViewPL.GetProductByBook(companyId, clubID, bookID))
	         .when()
	            .post("/BookView/BookView.svc")
	         .then()
            	//.log().all()
            	 .statusCode(200)
 	            .extract().response();
       		XmlPath js = ReusableMethods.rawToXML(res);
       		Assert.assertTrue(res.getTime() >= 60L);
       		Assert.assertNotNull(js.get("Envelope.Body.GetProductByBookResponse.GetProductByBookResult.ProductByBookDto.ProductId"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetProductByBookResponse.GetProductByBookResult.ProductByBookDto.BarcodeId"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetProductByBookResponse.GetProductByBookResult.ProductByBookDto.ProductDescription"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetProductByBookResponse.GetProductByBookResult.ProductByBookDto.ProductType"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetProductByBookResponse.GetProductByBookResult.ProductByBookDto.ProductLongDescription"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetProductByBookResponse.GetProductByBookResult.ProductByBookDto.ProductCategoryId"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetProductByBookResponse.GetProductByBookResult.ProductByBookDto.ProductCategoryDescription"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetProductByBookResponse.GetProductByBookResult.ProductByBookDto.AllowedStartTimes"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetProductByBookResponse.GetProductByBookResult.ProductByBookDto.BookingDuration"));
       		Assert.assertNotNull(js.get("Envelope.Body.GetProductByBookResponse.GetProductByBookResult.ProductByBookDto.MemberLimit"));
	}
}
