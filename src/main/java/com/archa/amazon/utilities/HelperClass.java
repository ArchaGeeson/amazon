package com.archa.amazon.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.archa.amazon.pageobjects.LandingPage;

public class HelperClass {

	public static Logger log = LogManager.getLogger(HelperClass.class.getName());
	/*
	 * This method is to capture the screenshot
	 * and saving it to the given file path
	 * 
	 * */
	
	public static String captureScreenshot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + getCurrentDateTime() + ".png";

		try {
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot captured");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot"+ e.getMessage());

		}
		
		return screenshotPath;
	}

	/*
	 * This method to get the current date and time 
	 * */
	
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
	
	/*
	 * This method selects the correct window handle and driver scope will be switching to it.
	 * */
	public static boolean switchToRightWindow(WebDriver driver, String windowTitle, List<String> handles) {
		for(String handle : handles) {
			String title = driver.switchTo().window(handle).getTitle();
			if(title.contains(windowTitle)) {
				log.info("Right window found.");
				return true;
			}
		}
		return false;
	}
	
	
}