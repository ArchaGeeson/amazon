package com.archa.amazon.pageobjects;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SamsungResultPage {
	public static Logger log = LogManager.getLogger(LandingPage.class.getName());
	public WebDriver driver;

	public SamsungResultPage(WebDriver driver) {
		this.driver = driver;
	}

	private By filerSortBy = By.cssSelector("span#a-autoid-0-announce");
	private By priceHighToLow = By.cssSelector("a#s-result-sort-select_2");
	private By resList = By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']/a");
	private By aboutItem = By.xpath("//h1[text()=' About this item ']");

	public void clickOnPriceHighToLow() {
		driver.findElement(filerSortBy).click();
		driver.findElement(priceHighToLow).click();
	}
	
	public List<WebElement> getResultList() {
		return driver.findElements(resList);
		
	}
	
	public Set<String> getWindows(){
		return driver.getWindowHandles();
	}
	
	public WebElement getAboutItem() {
		return driver.findElement(aboutItem);
	}
}
