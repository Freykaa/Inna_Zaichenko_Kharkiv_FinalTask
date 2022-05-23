package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    CustomerPreferencePage customerPreferencePage;
    HomePage homePage;
    MonitorsCategoryPage monitorsCategoryPage;
    ProductPage productPage;
    PageFactoryManager pageFactoryManager;
    SignInPage signInPage;
    SearchResultsPage searchResultsPage;
    ShopByCategoryPage shopByCategoryPage;
    ComputerCategoryPage computerCategoryPage;
    StorePage storePage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks location popover visibility")
    public void checkLocationVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isLocationVisible();
    }

    @And("User clicks location button")
    public void clickLocationButton() {
        homePage.clickLocation();
    }

    @And("User checks zip code field visibility")
    public void checkZipCodeFieldVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.zipField());
        homePage.isLocationPopoverVisible();
    }

    @And("User enters invalid zipcode {string}")
    public void enterZipcode(final String zipcode) {
        homePage.enterZipcode(zipcode);
    }

    @And("User clicks zipcode button")
    public void clickZipcodeButton() {
        homePage.clickZipcodeButton();
    }

    @And("User gets *INVALID ZIPCODE* message")
    public void getInvalidZipcodeMessage() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getInvalidZipcodeError());
        assertTrue(homePage.getInvalidZipcodeError().isDisplayed());
    }

    @And("User checks country list button visibility")
    public void checkCountryListButtonVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.countryList());
        homePage.isCountryListVisible();
    }

    @And("User clicks country list button")
    public void clickCountryListButton() {
        homePage.clickCountryListButton();
    }


    @And("User checks country list dropdown visibility")
    public void checksCountryListDropdownVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCountryListOpenDropdown());
        homePage.isCountryListDropdownVisible();
    }

    @And("User chooses country from the list")
    public void selectCountryFromDropdown() {
        homePage.chooseCountry();
    }

    @And("User clicks done button")
    public void closeLocationPopover() {
        homePage.waitInvisibilityOfElement(DEFAULT_TIMEOUT, homePage.getCountryListOpenDropdown());
        homePage.clickLocationPopoverCloseButton();
    }

    @And("delivery country changes to {string}")
    public void checkThatCountryDeliveryChanged(final String country) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(homePage.getCountryDeliveryName().contains(country));
    }

    @And("User checks sign in button visibility")
    public void checkSignInButtonVisibility() {
        homePage.isSignInButtonVisible();
    }

    @And("User opens sign in page")
    public void userOpensSignInPage() {
        homePage.clickSignInButton();
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks email field visibility")
    public void checkEmailFieldVisibility() {
        signInPage.isEmailFieldVisible();
    }

    @And("User clicks sign in button on sign in page")
    public void clickContinueButton() {
        signInPage.clickContinueButton();
    }

    @Then("User gets error message")
    public void getEmptyEmailErrorMessage() {
        assertTrue(signInPage.isEmptyEmailErrorMessageVisible());
    }

    @And("User checks search field visibility")
    public void checkSearchFieldVisibility() {
        homePage.isSearchFieldVisible();
    }

    @And("User makes search by keyword {string}")
    public void searchByKeyword(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clickSearchButton() {
        homePage.clickSearchField();
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that all products contain search {string}")
    public void checkThatAllProductsContainSearchKeyword(final String keyword) {
        searchResultsPage.getProductList().forEach(product ->
            assertTrue(product.getText().contains(keyword)));
    }

    @And("User checks brand filters visibility")
    public void checkBrandFiltersVisibility() {
        searchResultsPage.isBrandsFilterVisible();
    }

    @And("User filters by brand")
    public void filterByBrand() {
        searchResultsPage.selectBrandToFilter();
    }

    @And("User checks filtered product visibility")
    public void checkFilteredProductVisibility() {
       assertFalse(searchResultsPage.isBrandSelected());
    }

    @And("User checks customer preference button visibility")
    public void checkLanguageButtonVisibility() {
        homePage.isLanguageButtonVisible();
    }

    @And("User clicks customer preference button")
    public void clickLanguageButton() {
        homePage.clickLanguageButton();
        customerPreferencePage = pageFactoryManager.getCustomerPreferencePage();
        customerPreferencePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks language list visibility")
    public void checkLanguageListVisibility() { customerPreferencePage.isLanguageListVisible(); }

    @And("User chooses language")
    public void userChoosesSpanish() {
        customerPreferencePage.chooseLanguageSpanish();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that current url contains {string} language")
    public void checkCurrentUrl(final String language) {
        assertTrue(driver.getCurrentUrl().contains(language));
    }

    @And("User checks currency list visibility")
    public void checkCurrencyListVisibility() {
        customerPreferencePage.isCurrencyDropdownButtonVisible();
    }

    @And("User chooses currency")
    public void selectCurrency() {
        customerPreferencePage.clickCurrencyDropdown();
        customerPreferencePage.selectCurrency();
    }

    @And("User checks that price contains {string}")
    public void checkPriceSymbolContains(final String symbol) {
        searchResultsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultsPage.isPriceVisible());
        assertTrue(searchResultsPage.priceSymbol(symbol));
    }

    @And("User checks shop by category button visibility")
    public void checkShopByCategoryVisibility() {
        homePage.isShopByCategoryVisible();
    }

    @And("User clicks shop by category button")
    public void clicksShopByCategoryButton() {
        homePage.clickShopByCategoryButton();
        shopByCategoryPage = pageFactoryManager.getShopByCategoryPage();
        shopByCategoryPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User selects computer category")
    public void clickComputerCategory() {
        shopByCategoryPage.clickComputerPage();
        computerCategoryPage = pageFactoryManager.getComputerCategoryPage();
        computerCategoryPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User selects monitors category")
    public void clickMonitorsCategory() {
        computerCategoryPage.clickMonitorCategoryPage();
        monitorsCategoryPage = pageFactoryManager.getMonitorsCategoryPage();
        monitorsCategoryPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("Users checks next page button visibility")
    public void checkNextPageButtonVisibility() {
        monitorsCategoryPage.isNextPageButtonVisible();
    }

    @And("Users clicks next page button")
    public void clickNextPageButton() {
        monitorsCategoryPage.clickNextPageButton();
        monitorsCategoryPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that page changes to {string}")
    public void checkPageChange(final String page) {
        assertTrue(monitorsCategoryPage.getCurrentPage().contains(page));
    }

    @And("User opens product page")
    public void clickProductPage() {
        searchResultsPage.openProductPage();
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks customer review button visibility")
    public void checkReviewButtonVisibility() {
        productPage.isReviewIconVisible();
    }

    @And("User clicks customer review button")
    public void clickCustomerReviewButton() {
        productPage.clickReviewIcon();
    }

    @And("User filters reviews by rating")
    public void filterReviewsByRating() {
        productPage.filterByRating();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("User checks that {string} equals filter")
    public void checksThatRatingEqualsFilter(final String rating) {
        productPage.getReviewRating().forEach(review -> assertTrue(review.getText().contains(rating)));
    }

    @And("User checks store page link visibility")
    public void checksStorePageVisibility() {
        productPage.isStorePageLinkVisible();
    }

    @And("User click store page")
    public void clickStorePage() {
        productPage.clickStorePageLink();
    }

    @And("User checks that store page opens")
    public void userChecksThatStorePageOpens() {
        storePage = pageFactoryManager.getStorePage();
        productPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains("stores"));
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
