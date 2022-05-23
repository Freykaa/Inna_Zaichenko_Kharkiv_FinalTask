package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CustomerPreferencePage extends BasePage {

    @FindBy(id = "icp-language-settings")
    private WebElement languageList;

    @FindBy(xpath = "//div[@class='a-row a-spacing-mini']")
    private List<WebElement> getLanguageList;

    @FindBy(id = "icp-save-button")
    private WebElement saveButton;

    @FindBy(id = "icp-currency-dropdown-selected-item-prompt")
    private WebElement currencyDropdown;

    @FindBy(xpath = "//li[@class='a-dropdown-item']")
    private List<WebElement> currencyList;

    public CustomerPreferencePage(WebDriver driver) { super(driver); }

    public void isLanguageListVisible() {
        languageList.isDisplayed();
    }

    public void chooseLanguage() {
        getLanguageList.get(1).click();
        saveButton.click();
    }

    public void isCurrencyDropdownButtonVisible() {
        currencyDropdown.isDisplayed();
    }

    public void clickCurrencyDropdown() {
        currencyDropdown.click();
        waitVisibilityOfElement(30, currencyList.get(18));
    }

    public void selectCurrency() {
        currencyList.get(18).click();
        waitInvisibilityOfElement(30, currencyList.get(18));
        saveButton.click();
    }
}
