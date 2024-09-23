package com.qa.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.basePage.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement link_Myaccount;

	@FindBy(xpath = "//a[text()='Register' and @class='dropdown-item']")
	WebElement link_Registration;

	@FindBy(xpath = "//a[text()='Login' and @class='dropdown-item']")
	WebElement link_Login;

	public RegistrationPage gotoRegister() {
		link_Myaccount.click();
		link_Registration.click();
		return new RegistrationPage(driver);
	}

	public LoginPage gotoLoginPage() {
		link_Myaccount.click();
		link_Login.click();
		return new LoginPage(driver);
	}

}
