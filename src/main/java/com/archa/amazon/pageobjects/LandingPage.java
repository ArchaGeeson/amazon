package com.archa.amazon.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public static Logger log = LogManager.getLogger(LandingPage.class.getName());
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By hamburgerMenu = By.xpath("//a[@id='nav-hamburger-menu']");
	private By tvAppElectronics = By.xpath("//div[@id='hmenu-content']/ul[1]/li[16]/a/i");
	private By televisions = By.xpath("//a[text()='Televisions']");

	public void clickOnHamburgerButton() {
		driver.findElement(hamburgerMenu).click();
	}

	public void clickOnTvAppElec() {
		driver.findElement(tvAppElectronics).click();
	}

	public TelevisionsPage getTelevisions() {
		driver.findElement(televisions).click();
		TelevisionsPage televisionsPage = new TelevisionsPage(driver);
		return televisionsPage;
	}

}