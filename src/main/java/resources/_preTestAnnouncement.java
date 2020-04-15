package resources;

import org.testng.annotations.BeforeSuite;

import resources.base;

public class _preTestAnnouncement extends base {

		@BeforeSuite
		public void getPreTestAnnouncement() {

			base.getPropertyData();
			
			System.out.println("[INFO] -------------------------------------------------------");
			System.out.println("[INFO] "+prop.getProperty("product")+" - Automated Testing Suite");
			System.out.println("[INFO] Test Environment: "+prop.getProperty("environment"));
			System.out.println("[INFO] Started at: "+ReusableDates.getCurrentDateTime());
			System.out.println("[INFO] -------------------------------------------------------");
	}

}
