package scheduling;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import payloads.SchedulingPL;
import resources.ReusableMethods;
import resources.base;

public class GetCustomerSchedule extends base {
	
	static String companyId;
	static String enrollmentId;
	
	@BeforeTest
	public void getData() {
		base.getPropertyData();
		RestAssured.baseURI = prop.getProperty("baseURI");
		
		companyId = prop.getProperty("X-CompanyId");
	}
	@Test(priority = 1)
	public void getCustomerScheduleForNonVirtualClass() {
		String customerId = prop.getProperty("enrollmentCustomerId");
		String classId= prop.getProperty("enrollmentClassId");
		String tomorrowsDate = ReusableMethods.getTomorrowsDate();
		String DayAfterTomorrowsDate = ReusableMethods.getDayAfterTomorrowsDate();
		
		enrollmentId = ReusableMethods.enrollInClass(companyId, customerId, classId, tomorrowsDate+"T21:00:00Z");
		System.out.println(enrollmentId);
		
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IScheduling/GetCustomerSchedule","Content-Type","text/xml; charset=utf-8") .and()
				  .body(SchedulingPL.GetCustomerSchedule(companyId, customerId, tomorrowsDate, DayAfterTomorrowsDate, "Classes")) 
				  .when()
				  .post("//Visits/Scheduling.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				 				  
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.CategoryDescription"), "Personal Training");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClassEnrollmentStatusDte"), "Enrolled");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClubName"), "Jonas Sports-Plex");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClubNumber"), "1");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.DurationInMinutes"), "30");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ForCustomerId"), "822");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.Id"), enrollmentId);
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.IsRecurring"), "false");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.IsVirtual"), "false");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemBarcodeId"), "corecl");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemDescription"), "CoreClass");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ScheduleInstanceType"), "Class");
				//  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.StartDateTime.DateTime"), tomorrowsDate+"T21:00:00Z");
				//  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.StartDateTime.OffsetMinutes"), "-240");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.OriginalInstructorName"), "B");
				  Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemStartDateTime"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemEndDateTime"));
				  
				  ReusableMethods.deleteEnrollment(companyId, enrollmentId);
				  
				  
	}
	
	@Test(priority = 2)
	public void getCustomerScheduleForVirtualClass() {
		String customerId = prop.getProperty("enrollmentCustomerId");
		String classId= prop.getProperty("virtualEnrollmentClassId");
		String tomorrowsDate = ReusableMethods.getTomorrowsDate();
		String DayAfterTomorrowsDate = ReusableMethods.getDayAfterTomorrowsDate();
		
		enrollmentId = ReusableMethods.enrollInClass(companyId, customerId, classId, tomorrowsDate+"T21:00:00Z");
		System.out.println(enrollmentId);
		
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IScheduling/GetCustomerSchedule","Content-Type","text/xml; charset=utf-8") .and()
				  .body(SchedulingPL.GetCustomerSchedule(companyId, customerId, tomorrowsDate, DayAfterTomorrowsDate, "Classes")) 
				  .when()
				  .post("//Visits/Scheduling.svc") 
				  .then() 
				  //.log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				 				  
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.CategoryDescription"), "Personal Training");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClassEnrollmentStatusDte"), "Enrolled");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClubName"), "Jonas Sports-Plex");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClubNumber"), "1");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.DurationInMinutes"), "15");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ForCustomerId"), "822");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.Id"), enrollmentId);
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.IsRecurring"), "false");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.IsVirtual"), "true");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemBarcodeId"), "nevircl");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemDescription"), "NewVirtualClass");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ScheduleInstanceType"), "Class");
//				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.StartDateTime.DateTime"), tomorrowsDate+"T21:00:00Z");
//				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.StartDateTime.OffsetMinutes"), "-240");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.OriginalInstructorName"), "B");
				  Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemStartDateTime"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemEndDateTime"));
				  
				  ReusableMethods.deleteEnrollment(companyId, enrollmentId);
				  
				  
	}
	
	@Test(priority = 3)
	public void getCustomerScheduleForNonVirtualClassWithVirtualURl() {
		String customerId = prop.getProperty("enrollmentCustomerId");
		String classId= prop.getProperty("NonVirtualWithOverrideClassId");
		String tomorrowsDate = ReusableMethods.getTomorrowsDate();
		String DayAfterTomorrowsDate = ReusableMethods.getDayAfterTomorrowsDate();
		
		enrollmentId = ReusableMethods.enrollInClass(companyId, customerId, classId, tomorrowsDate+"T21:00:00Z");
		System.out.println(enrollmentId);
		
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IScheduling/GetCustomerSchedule","Content-Type","text/xml; charset=utf-8") .and()
				  .body(SchedulingPL.GetCustomerSchedule(companyId, customerId, tomorrowsDate, DayAfterTomorrowsDate, "Classes")) 
				  .when()
				  .post("//Visits/Scheduling.svc") 
				  .then() 
				  //.log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				 				  
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.CategoryDescription"), "Nutrition");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClassEnrollmentStatusDte"), "Enrolled");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClubName"), "Jonas Sports-Plex");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClubNumber"), "1");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.DurationInMinutes"), "15");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ForCustomerId"), "822");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.Id"), enrollmentId);
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.IsRecurring"), "false");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.IsVirtual"), "false");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemBarcodeId"), "copy");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemDescription"), "Copy of Balance Weight Loss & Nutrition ");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ScheduleInstanceType"), "Class");
//				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.StartDateTime.DateTime"), tomorrowsDate+"T17:30:00Z");
//				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.StartDateTime.OffsetMinutes"), "-240");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.OriginalInstructorName"), "B");
				  Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemStartDateTime"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemEndDateTime"));
				  
				  ReusableMethods.deleteEnrollment(companyId, enrollmentId);
				  
				  
	}
	
	@Test(priority = 4)
	public void getCustomerScheduleForNonVirtualCourse() {
		String customerId = prop.getProperty("enrollmentCustomerId");
//		String courseId= prop.getProperty("enrollmentCourseId");
		String startDateTime = "2020-12-13";
		String endDateTime = "2020-12-14";
		
//		enrollmentId = ReusableMethods.enrollInCourse(companyId, customerId, courseId);
//		System.out.println(enrollmentId);
		
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IScheduling/GetCustomerSchedule","Content-Type","text/xml; charset=utf-8") .and()
				  .body(SchedulingPL.GetCustomerSchedule(companyId, customerId, startDateTime, endDateTime, "Courses")) 
				  .when()
				  .post("//Visits/Scheduling.svc") 
				  .then() 
//				  .log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				  
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.CategoryDescription"), "Personal Training");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClassEnrollmentStatusDte"), "Enrolled");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClubName"), "Jonas Sports-Plex");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClubNumber"), "1");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.DurationInMinutes"), "15");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ForCustomerId"), "822");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.Id"), "95198");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.IsRecurring"), "false");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.IsVirtual"), "false");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemBarcodeId"), "alwaysAvailCo");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemDescription"), "AlwaysAvailableCourse");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ScheduleInstanceType"), "Course");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.DaysOfWeek"), "Sunday Monday Tuesday Wednesday Thursday Friday Saturday");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.OriginalInstructorName"), "Max Gibbs");
				  Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemStartDateTime"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemEndDateTime"));

				  
								  
				  
	}
	
	@Test(priority = 5)
	public void getCustomerScheduleForVirtualCourse() {
		String customerId = prop.getProperty("standbyCustomerId3");
		String courseId= prop.getProperty("virtualEnrollmentCourseId");
		String tomorrowsDate = ReusableMethods.getTomorrowsDate();
		String DayAfterTomorrowsDate = ReusableMethods.getDayAfterTomorrowsDate();
		
		enrollmentId = ReusableMethods.enrollInCourse(companyId, customerId, courseId);
		System.out.println(enrollmentId);
		
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IScheduling/GetCustomerSchedule","Content-Type","text/xml; charset=utf-8") .and()
				  .body(SchedulingPL.GetCustomerSchedule(companyId, customerId, tomorrowsDate, DayAfterTomorrowsDate, "Courses")) 
				  .when()
				  .post("//Visits/Scheduling.svc") 
				  .then() 
				  //.log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				 				  
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.CategoryDescription"), "Personal Training");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClassEnrollmentStatusDte"), "Enrolled");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClubName"), "Jonas Sports-Plex");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClubNumber"), "1");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.DurationInMinutes"), "15");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ForCustomerId"), "874");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.Id"), enrollmentId);
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.IsRecurring"), "false");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.IsVirtual"), "true");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemBarcodeId"), "newvirco");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemDescription"), "NewVirtualCourse");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ScheduleInstanceType"), "Course");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.DaysOfWeek"), "Sunday Monday Tuesday Wednesday Thursday Friday Saturday");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.OriginalInstructorName"), "B");
				  Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemStartDateTime"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemEndDateTime"));
				  
				  ReusableMethods.deleteEnrollment(companyId, enrollmentId);
				  
				  
	}
	
	@Test(priority = 6)
	public void getCustomerScheduleForNonVirtualCourseWithVirtualURl() {
		String customerId = prop.getProperty("standbyCustomerId3");
		String courseId= prop.getProperty("NonVirtualWithOverrideCourseId");
		String tomorrowsDate = ReusableMethods.getTomorrowsDate();
		String DayAfterTomorrowsDate = ReusableMethods.getDayAfterTomorrowsDate();
		
		enrollmentId = ReusableMethods.enrollInCourse(companyId, customerId, courseId);
		System.out.println(enrollmentId);
		
		
		 Response res = given() .headers("SOAPAction", "http://tempuri.org/IScheduling/GetCustomerSchedule","Content-Type","text/xml; charset=utf-8") .and()
				  .body(SchedulingPL.GetCustomerSchedule(companyId, customerId, tomorrowsDate, DayAfterTomorrowsDate, "Courses")) 
				  .when()
				  .post("//Visits/Scheduling.svc") 
				  .then() 
				  //.log().all()
				  .statusCode(200) .extract().response();
				  
				  XmlPath js = ReusableMethods.rawToXML(res);
				 				  
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.CategoryDescription"), "Personal Training");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClassEnrollmentStatusDte"), "Enrolled");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClubName"), "Jonas Sports-Plex");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ClubNumber"), "1");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.DurationInMinutes"), "60");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ForCustomerId"), "874");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.Id"), enrollmentId);
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.IsRecurring"), "false");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.IsVirtual"), "false");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemBarcodeId"), "testVirtual");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemDescription"), "VirtualTest");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ScheduleInstanceType"), "Course");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.DaysOfWeek"), "Sunday Monday Tuesday Wednesday Thursday Friday Saturday");
				  Assert.assertEquals(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.OriginalInstructorName"), "Max Gibbs");
				  Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemStartDateTime"));
				  Assert.assertNotNull(js.getString("Envelope.Body.GetCustomerScheduleResponse.GetCustomerScheduleResult.ScheduleInstanceDto.ItemEndDateTime"));
				  
				  ReusableMethods.deleteEnrollment(companyId, enrollmentId);
				  
				  
	}
}
