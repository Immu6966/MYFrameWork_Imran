package commonMethods;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class  FindElementByText{  

    // Initialize Logger
    private static final Logger log = LogManager.getLogger(FindElementByText.class.getName());

    // Method to handle dropdown selection using if-else
    public static void selectDropdownOption(WebElement dropdownElement, String selectionType, Object value) {
        try {
            Select dropdown = new Select(dropdownElement);

            if ("visibleText".equalsIgnoreCase(selectionType)) {
                dropdown.selectByVisibleText((String) value);
                log.info("Selected option with visible text: " + value);
            } else if ("value".equalsIgnoreCase(selectionType)) {
                dropdown.selectByValue((String) value);
                log.info("Selected option with value: " + value);
            } else if ("index".equalsIgnoreCase(selectionType)) {
                dropdown.selectByIndex((Integer) value);
                log.info("Selected option at index: " + value);
            } else {
                log.error("Invalid selection type: " + selectionType);
                throw new IllegalArgumentException("Unsupported selection type. Use 'visibleText', 'value', or 'index'.");
            }
        } catch (Exception e) {
            log.error("Error selecting dropdown option: " + e.getMessage());
            throw e;
        }
    }
}