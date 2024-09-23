package com.qa.opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.basePage.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-email")
	WebElement text_Email;

	@FindBy(id = "input-password")
	WebElement text_Password;

	@FindBy(xpath = "//button[text()='Login']")
	WebElement button_Login;

	public MyAccountPage loginCheck(String email, String pwd) {
		text_Email.sendKeys(email);
		text_Password.sendKeys(pwd);
		button_Login.click();
		return new MyAccountPage(driver);
	}
}
