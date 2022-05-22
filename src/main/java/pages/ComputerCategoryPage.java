package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputerCategoryPage extends BasePage {

    @FindBy(xpath = "//span[text()='Monitors']")
    private WebElement monitorCategoryPage;

    public ComputerCategoryPage(WebDriver driver) { super(driver); }

    public void clickMonitorCategoryPage() {
        monitorCategoryPage.click();
    }
}
