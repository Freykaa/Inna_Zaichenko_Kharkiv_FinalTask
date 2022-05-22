package pages;

import org.apache.commons.compress.archivers.StreamingNotSupportedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "nav-global-location-popover-link")
    private WebElement locationIcon;

    @FindBy(xpath = "//input[@class='GLUX_Full_Width a-declarative']")
    private WebElement zipcodeField;

    @FindBy(id = "a-popover-1")
    private WebElement locationPopover;

    @FindBy(xpath = "//span[@id='GLUXZipUpdate']//input")
    private WebElement zipcodeButton;

    @FindBy(id = "GLUXZipError")
    private WebElement invalidZipcodeError;

    @FindBy(xpath = "//div[@class=' a-declarative']")
    private WebElement countryListDefaultItem;

    @FindBy(xpath = "//span[@class='a-button-text a-declarative']")
    private WebElement countryListDropdown;

    @FindBy(id = "a-popover-2")
    private WebElement countryListOpenDropdown;

    @FindBy(xpath = "//a[@id='GLUXCountryList_1']")
    private WebElement countryFromListDropdown;

    @FindBy(xpath = "//span[@data-action='a-popover-close']")
    private WebElement closeLocationPopoverButton;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private WebElement signInButton;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;

    @FindBy(id = "icp-nav-flyout")
    private WebElement languageButton;

    @FindBy(xpath = "//div[@id='desktop-grid-2']//div[@class='a-cardui-footer']//a[@class='a-link-normal see-more truncate-1line']")
    private WebElement shopByCategoryButton;

    public HomePage(WebDriver driver) { super(driver); }

    public void openHomePage(String url) { driver.get(url); }

    public void isLocationVisible() { locationIcon.isDisplayed(); }

    public void clickLocation() { locationIcon.click(); }

    public WebElement zipField() { return zipcodeField; }

    public void isLocationPopoverVisible() { locationPopover.isDisplayed(); }

    public void enterZipcode(final String zipcode) { zipcodeField.sendKeys(zipcode); }

    public void clickZipcodeButton() { zipcodeButton.click(); }

    public WebElement getInvalidZipcodeError() { return invalidZipcodeError; }

    public WebElement countryList() { return countryListDefaultItem; }

    public void isCountryListVisible() { countryListDefaultItem.isDisplayed(); }

    public void clickCountryListButton() { countryListDropdown.click(); }

    public WebElement getCountryListOpenDropdown() { return countryListOpenDropdown; }

    public void isCountryListDropdownVisible() { countryListOpenDropdown.isDisplayed(); }

    public void chooseCountry() { countryFromListDropdown.click(); }

    public void clickLocationPopoverCloseButton() { closeLocationPopoverButton.click(); }

    public String getCountryDeliveryName() { return locationIcon.getText(); }

    public void isSignInButtonVisible() { signInButton.isDisplayed(); }

    public void clickSignInButton() { signInButton.click(); }

    public void isSearchFieldVisible() { searchField.isDisplayed(); }

    public void enterTextToSearchField(final String keyword) {
        searchField.sendKeys(keyword);
    }

    public void clickSearchField() { searchField.sendKeys(Keys.ENTER); }

    public void isLanguageButtonVisible() {
        languageButton.isDisplayed();
    }

    public void clickLanguageButton() {
        languageButton.click();
    }

    public void isShopByCategoryVisible() {
        shopByCategoryButton.isDisplayed();
    }

    public void clickShopByCategoryButton() {
        shopByCategoryButton.click();
    }
}
