package com.mystore.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="user-name")
    WebElement userName;
	
	@FindBy(id="password")
    WebElement passWord;
	
	@FindBy(id="login-button")
    WebElement loginButton;
	
	public void EnterUsername(String UserName)
	{
		userName.sendKeys(UserName);
	}
	public void EnterPassword(String Password)
	{
		passWord.sendKeys(Password);
	}
	public void ClickOnsignInButton()
	{
		loginButton.click();
	}
}
