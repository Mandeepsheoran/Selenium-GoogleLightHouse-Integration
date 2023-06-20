package org.lighthouse.seleniumtest;

import java.io.IOException;
import org.lighthouse.basetest.GoogleLighthouseBasetest;
import org.lighthouseaudit.config.ConfigFactory;
import org.lighthouseaudit.lighthousereportsetup.EnableDriverDebugger;
import org.lighthouseaudit.lighthousereportsetup.GoogleLighthouseSetup;
import org.testng.annotations.Test;

public class LighthousePageTest extends GoogleLighthouseBasetest {

	@Test(description = "Web page health check and audit using Google Lighthouse")
	public void webPageAuditTest() throws InterruptedException, IOException {
		String URL = ConfigFactory.getConfig().lighthouseappurl();
		EnableDriverDebugger.enableDebugger().get(URL);
		URL = EnableDriverDebugger.enableDebugger().getCurrentUrl();
		 String newWindow = null;
		newWindow = GoogleLighthouseSetup.windowOperations(); 
		GoogleLighthouseSetup.lighthouseAudit(URL, "LighthouseAuditReport_HomePage");		
		GoogleLighthouseSetup.lighthouseAudit(URL, "LighthouseAuditReport_BusinessPage");
	} 
}
