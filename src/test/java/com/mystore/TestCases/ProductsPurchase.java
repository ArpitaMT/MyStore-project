package com.mystore.TestCases;

import org.testng.annotations.Test;

import com.mystore.PageObjects.LoginPage;
import com.mystore.PageObjects.ProductsPage;

public class ProductsPurchase extends BaseClass{
	@Test
	public void AddProductToCart()
	{
		LoginPage lp=new LoginPage(driver);
		ProductsPage pp=new ProductsPage(driver);
		lp.EnterUsername("standard_user");
		lp.EnterPassword("secret_sauce");
		lp.ClickOnsignInButton();
		pp.ClickOnProductName("Sauce Labs Bike Light");
		pp.clickOnAddToCart();
	}

}
