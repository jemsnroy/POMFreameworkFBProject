package com.qa.fb.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.fb.Pages.RegisterPage;
import com.qa.fb.TestBase.TestBase;
import com.qa.fb.Utils.UtilClass;

public class RegisterTest extends TestBase {

	String sheetName = "Sheet1";

	RegisterPage rp;

	public RegisterTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilize();
		rp = new RegisterPage();
	}

	@DataProvider
	public Object[][] getRegisterData() {
		Object data[][] = UtilClass.getRegisterData(sheetName);
		return data;
	}

	@Test(dataProvider = "getRegisterData")
	public void vldCNATest(String fnA, String lnA, String elA, String psA) {
		rp.cnaTest(fnA, lnA, elA, psA);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
