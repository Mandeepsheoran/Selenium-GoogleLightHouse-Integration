# Selenium-GoogleLightHouse-Integration
This project will integrate Google Lighthouse tool with Selenium for application audit and other health check-up stuffs.

Google Lighthouse is an open-source, automated tool for improving the quality of web pages. It can be run on any web page, public or requiring authentication. 
It has audits for performance, accessibility, progressive web apps, SEO and more. Lighthouse runs a series of tests on the page, 
and then generates a report on how well the page did. The report includes opportunities for improvement and suggestions on how to fix them.

Selenium will help to navigate to different pages of application where we have to run the lighthouse audit as sometimes its not required to run on every page.

We will use Lighthouse Node CLI as its the most powerful and advanced way to run performance and accessibility audits. 
This is also recommended by the Lighthouse Team in their GitHub Page.

1.	Use below command to install lighthouse CLI in your laptop.

npm install -g lighthouse

2.	Launch the chrome browser programmatically using process builder on any available port.

ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "chrome-debug --port=9222");
builder.redirectErrorStream(true);
Process p = builder.start();

3. Now using selenium, point this above existing chrome instance by pointing to the mentioned port i.e. 9200.

ChromeOptions options = new ChromeOptions();
options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
ChromeDriver driver = new ChromeDriver(options);

4. After introduction of websocket in latest versions of Selenium, its creating problem while connecting with existing chrome instances. Therefore, use below dependency to handle this.

<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-http-jdk-client</artifactId>
			<version>4.5.0</version>
		</dependency>

![image](https://github.com/Mandeepsheoran/Selenium-GoogleLightHouse-Integration/assets/70449523/e08b7244-2405-43dc-8b70-a5d7e664d79d)



