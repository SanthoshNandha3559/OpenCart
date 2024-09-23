package com.qa.opencart.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.basePage.BasePage;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[text()='Logout' and @class='list-group-item']")
	WebElement button_Logout;
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement header_MyAccount;
	
	public void clickLogOut() {
       JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("arguments[0].click()",button_Logout );
	}
	public boolean loginSuccesful() {
		try {
		return header_MyAccount.isDisplayed();
		}catch (Exception e) {
			return false;
		}
	}

}
