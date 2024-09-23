package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.baseTest.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MyAccountPage;

public class TC002_LoginTest extends BaseTest {

	LoginPage loginPage;
	MyAccountPage accountPage;

	@Test(groups= {"Regression","Master"})
	public void loginSuccessfulTest() {
		logger.info("******* TC002_LoginTest Execution Started *******");
		loginPage =homePage.gotoLoginPage();
		accountPage=loginPage.loginCheck(properties.getProperty("userEmail"),
				properties.getProperty("userPassword"));
		boolean expectedvalue=accountPage.loginSuccesful();
		if(expectedvalue==true) {
		Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
		logger.info("******* User Loged in Successfully *******");
	}
}
