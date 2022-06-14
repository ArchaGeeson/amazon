package com.archa.amazon.resources;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.archa.amazon.utilities.ConfigDataProvider;
import com.archa.amazon.utilities.HelperClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {

	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	public WebDriver driver;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest extentLogger;

	@BeforeSuite
	public void setupSuite() {
		log.info("Setting up the report and test started");

		config = new ConfigDataProvider();
		ExtentSparkReporter extent = new ExtentSparkReporter(
				new File(System.getProperty("user.dir") + "/Reports/" + HelperClass.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);

		log.info("Setting Done- Test can be started.");
	}

	@BeforeClass
	public void setup() {
		log.info("Starting the browser");
		driver = BrowserFactory.inilializeDriver(config.getBrowser());
		log.info("Driver is up and running");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@AfterMethod()
	public void tearDownMethod(ITestResult result) {

		log.info("Test is about to end.");
		if (result.getStatus() == ITestResult.FAILURE) {

			HelperClass.captureScreenshot(driver);
			extentLogger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());

		} else if (result.getStatus() == ITestResult.SKIP) {

			HelperClass.captureScreenshot(driver);
			extentLogger.skip("Test Skipped",
					MediaEntityBuilder.createScreenCaptureFromPath(HelperClass.captureScreenshot(driver)).build());
		}
		report.flush();
		log.info("Test Completed and Reports generated.");
	}
}