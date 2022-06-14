package com.archa.amazon.testclasses;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.archa.amazon.pageobjects.LandingPage;
import com.archa.amazon.pageobjects.SamsungResultPage;
import com.archa.amazon.pageobjects.TelevisionsPage;
import com.archa.amazon.resources.BaseClass;
import com.archa.amazon.utilities.HelperClass;

public class AmazonTest extends BaseClass {

	@Test
	public void testCase() {

		extentLogger = report.createTest("Amazon Test Case");
		driver.get(config.getUrl());
		extentLogger.info("Starting the amazon");

		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickOnHamburgerButton();
		extentLogger.info("Clicked on Hamburger button");

		landingPage.clickOnTvAppElec();
		extentLogger.info("Clicked on TV, appliances, electronics");

		landingPage.getTelevisions();
		TelevisionsPage telePage = new TelevisionsPage(driver);
		extentLogger.info("Navigated to Televisions page");

		// telePage.clickOnSamsung();
		// Assert.assertTrue(telePage.clickOnSamsung());

		telePage.getBrandSamsung();
		extentLogger.info("Navigated to the Result page for Samsung");

		SamsungResultPage samsungResPage = new SamsungResultPage(driver);
		samsungResPage.clickOnPriceHighToLow();

		//String parentWindowId = driver.getWindowHandle();
		Assert.assertEquals(samsungResPage.getResultList().get(1).getText(),
				"Samsung 138 cm (55 inches) 4K Ultra HD Smart QLED TV QA55QN90AAKLXL (Titan Black) (2021 Model)");

		samsungResPage.getResultList().get(1).click();
		List<String> windows = new ArrayList<String>(samsungResPage.getWindows());
		if(HelperClass.switchToRightWindow(driver, samsungResPage.getResultList().get(1).getText(), windows)) {
			System.out.println(driver.getCurrentUrl()+":" + driver.getTitle());
		}
		
		Assert.assertEquals(samsungResPage.getAboutItem().getText(), "About this item");
		extentLogger.info("'About this item is present'");
	}

}
