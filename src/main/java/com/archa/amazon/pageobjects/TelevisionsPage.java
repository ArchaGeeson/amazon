package com.archa.amazon.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelevisionsPage {
	public static Logger log = LogManager.getLogger(TelevisionsPage.class.getName());
	public WebDriver driver;

	public TelevisionsPage(WebDriver driver) {
		this.driver = driver;

	}

	private By brandSamsung = By.xpath("//span[text()='Samsung']");
	
	/*
	 * public void clickOnSamsung() {
	 * //driver.findElement(brandSamsung).isSelected();
	 * driver.findElement(brandSamsung).click(); //return
	 * driver.findElement(brandSamsung).isSelected(); }
	 */

	public SamsungResultPage getBrandSamsung() {
		driver.findElement(brandSamsung).click();
		SamsungResultPage samsungResultPage = new SamsungResultPage(driver);
		return samsungResultPage;
	}
}
