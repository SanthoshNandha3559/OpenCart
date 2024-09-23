package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.baseTest.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.MyAccountPage;
import com.qa.opencart.utilities.DataProviders;

public class TC003_LoginDataDriven extends BaseTest {
	protected LoginPage loginPage;
	protected MyAccountPage accountPage;

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups= {"Datadriven","Master"})
	public void loginDDT(String user, String pwd, String exp) {
		logger.info("******* TC003_LoginDataDriven Execution Started *******");
		try {
		loginPage = homePage.gotoLoginPage();
		accountPage=loginPage.loginCheck(user, pwd);
        boolean targetPage=accountPage.loginSuccesful();
        if(exp.equalsIgnoreCase("Valid")) {
        	if(targetPage==true) {
        		accountPage.clickLogOut();
        		Assert.assertTrue(true);
        	}
        	  else {
              	Assert.assertTrue(false);
              }
        }
        if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				accountPage.clickLogOut();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}catch (Exception e) {
			Assert.fail();
		}
		logger.info("******* TC003_LoginDataDriven Execution Finshed *******");
	}

}
