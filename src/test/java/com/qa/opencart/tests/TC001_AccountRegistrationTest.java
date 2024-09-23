package com.qa.opencart.tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.baseTest.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.RegistrationPage;
import com.qa.opencart.utilities.RandomDataProvider;


public class TC001_AccountRegistrationTest extends BaseTest{

	WebDriver driver;
	RegistrationPage registerPage;
	RandomDataProvider randomData;
	@Test(groups={"Sanity","Master"})
	public void creatAccount() throws InterruptedException {
		logger.info("******* TC001_AccountRegistrationTest Execution Started *******");
		registerPage=homePage.gotoRegister();
		//registerPage.getRegister(randomData.randomName(), randomData.randomName(), randomData.randomEmail(), randomData.randomPassword());
		String expected_Message=registerPage.getRegister("Santhu", "Nandha", "santhosh35@gmail.com", "Santhusre3");
		Assert.assertEquals(expected_Message,AppConstants.Account_Created_Message);
		logger.info("******* Account Created Successfully *******");
	}
	
	
}
