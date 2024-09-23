package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.baseTest.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MyAccountPage;

public class TC004_GetLinkText extends BaseTest{
	protected LoginPage loginPage;
	protected MyAccountPage accountPage;
	@Test(groups="Regression")
	public void GetLinkTextsTest() {
		logger.info("******** TC004_GetLinkText Execution Started *****");
		loginPage=homePage.gotoLoginPage();
		accountPage=loginPage.loginCheck(properties.getProperty("userEmail"),
				properties.getProperty("userPassword"));
		int links_Count=accountPage.fetch_AlllinkText();
		Assert.assertEquals(links_Count, 13);
		accountPage.clickLogOut();    
	}

}
