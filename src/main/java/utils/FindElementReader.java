package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class  FindElementReader{
    public static void main(String[] args) {
       
        WebElement dropdown = driver.findElement(By.id("dropdownId"));

        // Use the dropdown handling method with if-else
        DropdownHandler.selectDropdownOption(dropdown, "visibleText", "Option 1");
        DropdownHandler.selectDropdownOption(dropdown, "value", "value1");
        DropdownHandler.selectDropdownOption(dropdown, "index", 2);

        driver.quit();
    }
}
}
