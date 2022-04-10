package com.lynn.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lynn.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(xpath = "//img[@alt='Spectranet Logo' and @src='/_next/image?url=%2Fstatic%2Flogo%2Fspectranet_logo.png&w=384&q=100']")
	WebElement spectraLogo;
	
	@FindBy(id = "userid")
	WebElement usernameField;
	
	@FindBy(id = "password")
	WebElement passwordField;
	
	@FindBy(linkText = "FORGOT PASSWORD?")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//h6[contains(text(),'Login to your Spectranet Account')]")
	WebElement loginInstructionText;
	

	@FindBy(xpath = "//input[@type='radio' and @value='accountNo']")
	WebElement accountNumberLoginOptionRadioBtn;

	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyLogoDisplayed() {
		return spectraLogo.isDisplayed();
	}
	
	public AccountSummaryPage loginFunction() {
		usernameField.sendKeys("16113650");
		passwordField.sendKeys("123456");
		submitButton.click();
		return new AccountSummaryPage();
	}
	
	
	
	
	

}
