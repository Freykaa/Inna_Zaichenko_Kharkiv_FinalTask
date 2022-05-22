package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MonitorsCategoryPage extends BasePage {

    @FindBy(xpath = "//a[@class='s-pagination-item s-pagination-next s-pagination-button s-pagination-separator']")
    private WebElement nextPageButton;

    @FindBy(xpath = "//span[contains(@aria-label, 'Current page')]")
    private WebElement currentPage;

    public MonitorsCategoryPage(WebDriver driver) { super(driver); }

    public void isNextPageButtonVisible() {
        nextPageButton.isDisplayed();
    }

    public void clickNextPageButton() {
        nextPageButton.click();
    }

    public String getCurrentPage() {
        return currentPage.getText();
    }

}
