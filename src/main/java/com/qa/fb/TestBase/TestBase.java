package com.qa.fb.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.fb.Utils.UtilClass;

public class TestBase {

	public static FileInputStream fis;
	public static Properties prop;

	public static WebDriver driver;

	public TestBase() {

		try {
			fis = new FileInputStream(
					"C:\\SeleniumCopy\\Selenium_WorkSpace_Copy\\POMFramework\\src\\main\\java\\com\\qa\\fb\\Config\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initilize() {

		String browserName = prop.getProperty("Browser");
		if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumCopy\\SeleniumJars_Copy\\geckodriver.exe");
			driver = new FirefoxDriver();
			// log.debug("launching Firefox browser");
		} else if (browserName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumCopy\\SeleniumJars_Copy\\chromedriver.exe");
			driver = new ChromeDriver();
			// log.debug("launching Chrome browser");
		} else {

			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			driver = new SafariDriver();
			// log.debug("launching Safari browser");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(UtilClass.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilClass.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		// log.debug("entering application URL");

	}

}
