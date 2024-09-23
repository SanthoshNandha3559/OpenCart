package com.qa.opencart.baseTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.opencart.factory.SeleniumFactory;
import com.qa.opencart.pages.HomePage;

import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; //Log4j

public class BaseTest {
	static WebDriver driver;
	SeleniumFactory seleniumFactory;
	protected Properties properties;
	protected HomePage homePage;
	public Logger logger;

	@SuppressWarnings("deprecation")
	@BeforeClass(groups = { "Sanity", "Regression", "Master" })
	@Parameters({ "os", "browser" })
	public void setUp(String os, String browser) throws IOException {
		logger = LogManager.getLogger(this.getClass());
		logger.info("****** Started The Execution *****");
		seleniumFactory = new SeleniumFactory();
		properties = seleniumFactory.init_Properties();
		if (properties.getProperty("execute_env").equalsIgnoreCase("remote")) {
			//String hubUrl = "http://192.168.1.29:4444/wd/hub";
			DesiredCapabilities capabilities = new DesiredCapabilities();
			switch (os.toLowerCase()) {
			case "windows":
				capabilities.setPlatform(Platform.WIN11);
				break;
			case "mac":
				capabilities.setPlatform(Platform.MAC);
				break;
			case "linux":
				capabilities.setPlatform(Platform.LINUX);
				break;
			default:
				System.out.println("No Matching Operating System");
				return;
			}
			switch (browser.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capabilities.setBrowserName("Firefox");
				break;
			default:
				System.out.println("No Matching Browser");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://192.168.1.29:4444/wd/hub"), capabilities);
		}
		if (properties.getProperty("execute_env").equalsIgnoreCase("local")) {
			switch (browser.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
			default:
				System.out.println("Please Choose valid browser");
				return;
			}
		}
		driver.get(properties.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homePage = new HomePage(driver);
	}

	@AfterClass(groups = { "Sanity", "Regression", "Master" })
	public void tearDown() {
		driver.quit();
		logger.info("******  The Execution Finshed *****");
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenShots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}

}
