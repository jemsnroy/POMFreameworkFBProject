package com.qa.fb.Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.fb.Pages.HomePage;
import com.qa.fb.Pages.LoginPage;
import com.qa.fb.Pages.MarketplacePage;
import com.qa.fb.TestBase.TestBase;

public class MarketplaceTest extends TestBase {

	LoginPage lp;
	HomePage hp;
	MarketplacePage mp;

	public MarketplaceTest() {

		super();
	}

	@BeforeMethod
	public void setUp() {
		initilize();
		lp = new LoginPage();
		hp = lp.lgnTest(prop.getProperty("Email"), prop.getProperty("Password"));
		mp = hp.mktTest();
	}

	@Test(priority = 1)
	public void vldCLKTest() throws IOException {
		mp.clkTest();
	}

	@Test(priority = 2)
	public void vldLgoTest() {
		mp.lgoTest();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
