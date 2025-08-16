
package TestCases;


import java.io.IOException;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.CreateDriverObject;
import pages.CommonMethods;
import pages.Login_Pg;
import pages.Search_pg;
import utils.ExcelFileReader;

public class Search_Testcase {
	
	WebDriver driver ;
	Search_pg search;
	Login_Pg login;
	CommonMethods common;
	HashMap<String, String> testData;

	
	@BeforeMethod
	public void login() throws IOException {
		
		driver = CreateDriverObject.getDriver();
		System.out.println(driver);
		search = new Search_pg(driver);
		login = new Login_Pg(driver);
		common = new 	CommonMethods(driver);	
		login.loginApplication();

	}
	
	@Test
	public void LoginTestCase() throws Exception {
		testData = ExcelFileReader.getExcelData("Search", "TC01");		
		common.getSwtichToFrameByWebElement(login.getHomeFrame());
		search.getSearchTab().click();
		search.getRequestGroupIDTxtBox().sendKeys(testData.get("RequestGroupID"));
		search.getRGSearch().click();
		
	}
	

		    
		    
		
	}