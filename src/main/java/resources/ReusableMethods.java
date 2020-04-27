package resources;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.ChangeRequestsPL;

import static io.restassured.RestAssured.given;

public class ReusableMethods {
	
	public static XmlPath rawToXML(Response r){
//		** Convert Raw XML response to String **
		
		String respon=r.asString();
		XmlPath x=new XmlPath(respon);
		return x;
	}
	
	public static JsonPath rawToJson(Response r){ 
//		** Convert Raw Json response to String **
		
		String respon=r.asString();
		JsonPath x=new JsonPath(respon);
		return x;
	}
	
	public static boolean validatePersonalInfoNewValue(String companyId, String customerId, String fieldName, String newValue) {
		
		// ** Validate change was made
		Response res =  given()
	 			.headers("SOAPAction", "http://tempuri.org/IChangeRequests/GetPersonalInformation",
	 					"Content-Type", "text/xml; charset=utf-8")
		                .and()
		                .body(ChangeRequestsPL.getPersonalInformation(companyId, customerId))
		                .when()
		            .post("/ChangeRequests/ChangeRequest.svc")
		         .then()
//	             	.log().body()
					.extract().response();
		      
					XmlPath js2 = ReusableMethods.rawToXML(res);
					
					String returnedValue = js2.getString("Envelope.Body.GetPersonalInformationResponse.GetPersonalInformationResult."+fieldName+".CurrentValue");

//					System.out.println("New Value: "+newValue);
//					System.out.println("Returned Value: "+returnedValue);
					
					if(returnedValue.equals (newValue))
					{
						return true;
					}
					else
					{
						return false;
					}

}

}
