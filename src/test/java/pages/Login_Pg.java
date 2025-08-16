package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Pg {




		public Login_Pg(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(xpath = "//iframe[@id='PegaGadget0Ifr']")
		private WebElement HomeFrame;
		public WebElement getHomeFrame() {
			return HomeFrame;
		}
		
		@FindBy(xpath = "//input[@id='txtUserID']")
		private WebElement username;
		
		public WebElement getUsername() {
			return username;
		}
		
		
		@FindBy(xpath = "//input[@id='txtPassword']")
		private WebElement password;
		
		public WebElement getPassword() {
			return password;
		}
		
		
		
		@FindBy(xpath = "//button[@Id='sub']")
		private WebElement submitButton;
		
		public WebElement getSubmitButton() {
			return submitButton;
		}
		
		
		
		public void loginApplication() {
			
			getUsername().sendKeys("zakir_qa");
			getPassword().sendKeys("asdf@123");
			getSubmitButton().click();
			
			
		}

	}

	