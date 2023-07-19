package com.mystore.TestCases;

import org.testng.annotations.Test;

import com.mystore.PageObjects.LoginPage;

public class LoginTestcase extends BaseClass {
	@Test
	public void verifyLogin()
	{
		LoginPage lp=new LoginPage(driver);
		lp.EnterUsername("standard_user");
		logger.info("Entered Username");
		lp.EnterPassword("secret_sauce");
		logger.info("Entered password");
		lp.ClickOnsignInButton();
		logger.info("clicked on signin button");
	}

}
