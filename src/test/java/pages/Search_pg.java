package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_pg {


    public Search_pg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	

	
	/*
	 * First find xpath
	 * then use @findby 
	 * then give prover name 
	 * Then create a method
	 * Return webelement in that method
	 **/

@FindBy(xpath = "//input[@name='$PAdvancedSearchCriteriaPage$pRGSearchData$pRequestGroupID']")
private WebElement RequestGroupIDTxtBox;
public WebElement getRequestGroupIDTxtBox() {
	return RequestGroupIDTxtBox;
}


@FindBy(xpath="//div[contains(@class,'right-spacing right-aligned')]//button[contains(@name,'RequestGroupSearch_pyDisplayHarness')]")
private WebElement RGSearch;
public WebElement getRGSearch() {
	return RGSearch;
}

@FindBy(xpath="//span[text()='Search']")
private WebElement SearchTab;
public WebElement getSearchTab() {
	return SearchTab;
}







}

