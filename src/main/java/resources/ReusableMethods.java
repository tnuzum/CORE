package resources;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

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

}
