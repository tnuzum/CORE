package resources;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

//	** THIS FILE NEEDS MOVED TO files PACKAGE, BUT imports AREN'T WORKING WHEN IT'S IN THAT PACKAGE **
public class ReusableMethods {
	
	static Properties prop = new Properties();
	public void getData() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Todd\\eclipse-workspace\\RestPractice\\src\\main\\java\\files\\rest.properties");
		prop.load(fis);	
	}
	public static XmlPath rawToXML(Response r)
	{
		String respon=r.asString();
		XmlPath x=new XmlPath(respon);
		return x;
	}
	public static JsonPath rawToJson(Response r)
	{ 
		String respon=r.asString();
		JsonPath x=new JsonPath(respon);
		return x;
	}

}
