package org.lighthouseaudit.lighthousereportsetup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EnableDriverDebugger {
	
	private static ChromeDriver driver;

	public static WebDriver enableDebugger() throws IOException {
		WebDriverManager.chromedriver().setup();		
		GoogleLighthouseSetup.chromeDebug();
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setAcceptInsecureCerts(true);
		options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222"); 
		driver = new ChromeDriver(options);
		return driver;
	}
}
