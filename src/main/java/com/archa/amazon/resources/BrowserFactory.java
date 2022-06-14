package com.archa.amazon.resources;



import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {

	public static Logger log = LogManager.getLogger(BrowserFactory.class.getName());
	public static WebDriver driver;

	public static WebDriver inilializeDriver(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Chrome driver is up and running");

		} else if (browserName.equalsIgnoreCase("Edge")) {

			System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			log.info("Edge driver is up and running");

		} else {

			System.out.println("We do not support this browser...");
		}

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
		log.info("browser is closed");
	}
}
