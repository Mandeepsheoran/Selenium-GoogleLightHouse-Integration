package org.lighthouseaudit.lighthousereportsetup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.openqa.selenium.WindowType;
import static org.lighthouseaudit.lighthousereportsetup.EnableDriverDebugger.*;


public class GoogleLighthouseSetup {
		
	public static String windowOperations() throws InterruptedException, IOException {
		String originalWindow = enableDebugger().getWindowHandle();
		enableDebugger().switchTo().newWindow(WindowType.TAB);
		String newWindow = enableDebugger().getWindowHandle();
		enableDebugger().switchTo().window(originalWindow);
		enableDebugger().close();
		return newWindow;
	}

	public static void chromeDebug() throws IOException  {
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "chrome-debug --port=9222");
		builder.redirectErrorStream(true); 
		Process p = builder.start();
	}
	
	public static void lighthouseAudit(String URL, String ReportName) throws IOException {
		ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "lighthouse", URL, "--port=9222",
				"--preset=desktop", "--output=html", "--output-path=src/test/resources/GoogleLightHouseReport/" + ReportName + ".html");
		builder.redirectErrorStream(true);
		Process p = builder.start();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while (true) {
			line = r.readLine();
			if (line == null) {
				break;
			}
			System.out.println(line);
		}
	}
}