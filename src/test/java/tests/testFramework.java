package tests;

import java.sql.DriverManager;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.CreateDriverObject;
import utils.ExcelFileReader;
import utils.PropertyFileReader;

public class testFramework {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		String environment = PropertyFileReader.getKeyValue("env");
		System.out.println(environment);

		
		WebDriver driver = CreateDriverObject.getDriver();
		driver.get("https://mvnrepository.com/artifact/io.rest-assured/rest-assured/5.5.5");
		
		
		HashMap<String,String>hmap=ExcelFileReader.getExcelData("Test", "tc02");
		String value=hmap.get("p");
		System.out.println(value);
		
		
		WebDriver driver1 = (WebDriver) DriverManager.getDrivers();
        WebElement element = driver1.findElement(By.xpath("//*[contains(text(), '" + value + "')]"));
		
	}

}
