package com.mystore.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.PageObjects.LoginPage;
import com.mystore.PageObjects.ProductsPage;
import com.mystore.Utilities.ReadExcelFile;

public class LoginTestcaseDataDriven extends BaseClass {
	@Test(dataProvider = "LoginDataProvider")
	public void verifyLogin(String UserName,String Password)
	{
		LoginPage lp=new LoginPage(driver);
		ProductsPage pp=new ProductsPage(driver);
		lp.EnterUsername(UserName);
		logger.info("Entered Username");
		lp.EnterPassword(Password);
		logger.info("Entered password");
		lp.ClickOnsignInButton();
		logger.info("clicked on signin button");
		pp.clickOnMenuIcon();
		pp.clickOnLogout();
		
	}
	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\Testdata.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "Userdata");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "Userdata");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"Userdata", i,j);
			}

		}
		return data;
	}

}
