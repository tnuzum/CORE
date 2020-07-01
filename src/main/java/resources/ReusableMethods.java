package resources;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.ChangeRequestsPL;
import payloads.EnrollmentServicePL;

import static io.restassured.RestAssured.given;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;

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
	public static String getTomorrowsDate() {
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		Calendar today1 = Calendar.getInstance();
		today1.add(Calendar.DAY_OF_YEAR, 1);
		String tomorrowsDate = dateFormat1.format(today1.getTime());
		return tomorrowsDate;
		
	}
	
	public static String enrollInClass(String companyId, String customerId, String classId, String tomorrowsDate) {
		
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/EnrollInClass","Content-Type","text/xml; charset=utf-8") .and()
				  .body(EnrollmentServicePL.EnrollInClass(companyId, customerId,classId, tomorrowsDate)) 
				  .when()
				  .post("/ClassesAndCourses/EnrollmentService.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
					
				  String  enrollmentId = js.getString("Envelope.Body.EnrollInClassResponse.EnrollInClassResult.EnrollmentId");
				return enrollmentId;
}
	
	public static String enrollInCourse(String companyId, String customerId, String courseId) {
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/EnrollInCourse","Content-Type","text/xml; charset=utf-8") .and()
				  .body(EnrollmentServicePL.EnrollInCourse(companyId, customerId, courseId)) 
				  .when()
				  .post("/ClassesAndCourses/EnrollmentService.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				    				 
				  String  enrollmentId = js.getString("Envelope.Body.EnrollInCourseResponse.EnrollInCourseResult.EnrollmentId");
				   
				return enrollmentId;
}
	
public static String placeOnStandby(String companyId, String customerId, String classId, String tomorrowsDate) {
			
				
		Response res = given()
	 			.headers("SOAPAction", "http://tempuri.org/IEnrollmentService/EnrollInClassStandby","Content-Type", "text/xml; charset=utf-8")
				.and()
				.body(EnrollmentServicePL.EnrollInClassStandby(companyId, customerId, classId, tomorrowsDate))
			.when()
				.post("/ClassesAndCourses/EnrollmentService.svc")
			.then()
//				.log().all()
				.statusCode(200)
				.extract().response();  
				
				XmlPath js = ReusableMethods.rawToXML(res);
					
				
				String enrollmentId = js.getString("Envelope.Body.EnrollInClassStandbyResponse.EnrollInClassStandbyResult.EnrollmentId");
				return enrollmentId;
}

public static String placeOnStandbyCourse(String companyId, String customerId, String courseId) {
	
	  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/EnrollInCourseStandby","Content-Type","text/xml; charset=utf-8") .and()
			  .body(EnrollmentServicePL.EnrollInCourseStandby(companyId, customerId,courseId)) .when()
			  .post("/ClassesAndCourses/EnrollmentService.svc") 
			  .then() 
//			  .log().all()
			  .statusCode(200) .extract().response();
			  
			  XmlPath js = ReusableMethods.rawToXML(res);
						  
			  String enrollmentId = js.getString("Envelope.Body.EnrollInCourseStandbyResponse.EnrollInCourseStandbyResult.EnrollmentId");
					
			  return enrollmentId;
}

public static String[] deleteEnrollment(String companyId, String enrollmentId) {
	
	Response res =given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/DeleteEnrollment","Content-Type","text/xml; charset=utf-8") .and()
			  .body(EnrollmentServicePL.DeleteEnrollment(companyId, enrollmentId)) .when()
			  .post("/ClassesAndCourses/EnrollmentService.svc") 
			  .then() 
	//		  .log().all()
			  .statusCode(200) .extract().response();
	 XmlPath js = ReusableMethods.rawToXML(res);
	  
	 Assert.assertTrue(res.getTime() >= 60L); 
	 String output[] = new String[9];
	 
	 String customerId = js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.CustomerId");
	 String itemId = js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.ItemId");
	 String startTime =  js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.StartDate.DateTime");
	 String startTimeOffset = js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.StartDate.OffsetMinutes");
	 String endTime = js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.EndDate.DateTime");
	 String endTimeOffset = js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.EndDate.OffsetMinutes");
	 String enrollmentOccurrenceTime = js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.EnrollmentOccurredOn.DateTime");
	 String enrollmentOccurrenceTimeOffset = js.getString("Envelope.Body.DeleteEnrollmentResponse.DeleteEnrollmentResult.EnrollmentOccurredOn.OffsetMinutes");
	 output[0] = customerId;
	 output[1] = itemId;
	 output[2] = startTime;
	 output[3] = startTimeOffset;
	 output[4] = endTime;
	 output[5] = endTimeOffset;
	 output[6] = enrollmentOccurrenceTime;
	 output[7] = enrollmentOccurrenceTimeOffset;
	
	 return output;
	
	//return customerId, itemId, startTime, startTimeOffset, endTime, endTimeOffset, enrollmentOccurrenceTime, enrollmentOccurrenceTimeOffset;
	
}
public static  String promoteStandbyEnrollmentsForClass(String companyId, String classId, String tomorrowsDate) {
	
	 Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/PromoteStandbyEnrollmentsForClass","Content-Type","text/xml; charset=utf-8") .and()
			  .body(EnrollmentServicePL.PromoteStandbyEnrollmentsForClass(companyId, classId, tomorrowsDate)) 
			  .when()
			  .post("/ClassesAndCourses/EnrollmentService.svc") 
			  .then() 
//			  .log().all()
			  .statusCode(200) .extract().response();
			  
			  XmlPath js = ReusableMethods.rawToXML(res);
			  String enrollmentId = js.getString("Envelope.Body.PromoteStandbyEnrollmentsForClassResponse.PromoteStandbyEnrollmentsForClassResult.int");
						 		 
	return enrollmentId;
}
public static String PromoteStandbyEnrollmentsForCourse(String companyId, String courseId) {
	  Response res = given() .headers("SOAPAction", "http://tempuri.org/IEnrollmentService/PromoteStandbyEnrollmentsForCourse","Content-Type","text/xml; charset=utf-8") .and()
			  .body(EnrollmentServicePL.PromoteStandbyEnrollmentsForCourse(companyId, courseId)) 
			  .when()
			  .post("/ClassesAndCourses/EnrollmentService.svc") 
			  .then() 
//			  .log().all()
			  .statusCode(200) .extract().response();
			  
			  XmlPath js = ReusableMethods.rawToXML(res);
			  String enrollmentId = js.getString("Envelope.Body.PromoteStandbyEnrollmentsForCourseResponse.PromoteStandbyEnrollmentsForCourseResult.int");
	return enrollmentId;
}
}
