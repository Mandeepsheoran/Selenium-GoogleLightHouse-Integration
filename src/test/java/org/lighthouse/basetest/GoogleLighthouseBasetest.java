package org.lighthouse.basetest;

import java.io.IOException;
import org.lighthouseaudit.lighthousereportsetup.EnableDriverDebugger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class GoogleLighthouseBasetest {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws IOException {
		 driver= EnableDriverDebugger.enableDebugger();
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

}
