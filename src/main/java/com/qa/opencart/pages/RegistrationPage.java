package com.qa.opencart.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qa.opencart.basePage.BasePage;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "input-firstname")
	WebElement text_FristName;

	@FindBy(id = "input-lastname")
	WebElement text_LastName;

	@FindBy(id = "input-email")
	WebElement text_Email;

	@FindBy(id = "input-password")
	WebElement text_Password;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement toggle;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement button_Continue;

	@FindBy(xpath = "//h1")
	WebElement confirm_Message;

	public String getRegister(String fName, String lName, String email, String pwd) throws InterruptedException {
		text_FristName.sendKeys(fName);
		text_LastName.sendKeys(lName);
		text_Email.sendKeys(email);
		text_Password.sendKeys(pwd);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", toggle);
		button_Continue.submit();
		try {
			return confirm_Message.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
