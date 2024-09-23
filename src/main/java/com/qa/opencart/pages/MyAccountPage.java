package com.qa.opencart.pages;

import java.util.List;

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
	
	@FindBy(xpath="//aside[@id='column-right']/div[@class='list-group mb-3']/a")
	List<WebElement> linksList_right;
	
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
	public int fetch_AlllinkText() {
		int count=0;
		for (WebElement webElement : linksList_right) {
			System.out.println(webElement.getText());
			count++;
		}
		return count;
	}

}
