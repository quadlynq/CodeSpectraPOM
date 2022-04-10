package com.lynn.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lynn.qa.base.TestBase;
import com.lynn.qa.pages.LoginPage;

public class LoginPageTests extends TestBase{
	
	LoginPage loginPage;
	public LoginPageTests() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		Initialization();
		loginPage = new LoginPage();
	}
	
	@Test
	public void LogoDisplayed() {
		boolean flag = loginPage.verifyLogoDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void ValidatePageTitle() {
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "Spectranet Selfcare");
	}
	
	/*
	 * @Test public void UserCanLogin() {
	 * loginPage.loginFunction(prop.getProperty("usernameField"));
	 * loginPage.loginFunction(prop.getProperty("passwordField"));
	 * 
	 * }
	 */
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
