package com.mystore.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
WebDriver driver;
	
	public ProductsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String ProductPart1="//div[.='";
	public String ProductPart2="']";
	
	@FindBy(xpath="//button[.='Add to cart']")
    WebElement AddToCartButton;

	@FindBy(id="react-burger-menu-btn")
    WebElement menuLocator;
	
	@FindBy(xpath="//a[@id='logout_sidebar_link']")
    WebElement logout;
	
	public void ClickOnProductName(String productName)
	{
		WebElement ele=driver.findElement(By.xpath("//div[.='"+productName+"']"));
		ele.click();
		
	}
	public void clickOnAddToCart()
	{
		AddToCartButton.click();
	}
	public void clickOnMenuIcon()
	{
		menuLocator.click();
	}
	public void clickOnLogout()
	{
		logout.click();
	}
}
