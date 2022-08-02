package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class base {
	
	static String environment = "DevQA";
	
	public static Properties prop = new Properties();
	//static String projectPath = System.getenv("CORE_HOME");

	static String projectPath = System.getProperty("user.dir");
	   
	public static void getPropertyData(){

	prop = new Properties();
	FileInputStream fis = null;
	
	if (environment.equals("DevQA")){
		try {
			fis = new FileInputStream(projectPath + "\\src\\main\\java\\resources\\DevQA.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println("[INFO] Environment: "+prop.getProperty("environment"));
	}

	if (environment.equals("StageRegression")){
		try {
			fis = new FileInputStream(projectPath + "\\src\\main\\java\\resources\\StageRegression.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println("[INFO] Environment: "+prop.getProperty("environment"));
}
}

}



