package manager;

import org.openqa.selenium.WebDriver;
import pages.*;


public class PageFactoryManager {

    final WebDriver driver;

    public PageFactoryManager(WebDriver driver) { this.driver = driver; }

    public HomePage getHomePage() { return new HomePage(driver); }

    public CustomerPreferencePage getCustomerPreferencePage() { return new CustomerPreferencePage(driver); }

    public MonitorsCategoryPage getMonitorsCategoryPage() { return new MonitorsCategoryPage(driver); }

    public ProductPage getProductPage() {return new ProductPage(driver); }

    public SearchResultsPage getSearchResultsPage() {return new SearchResultsPage(driver); }

    public SignInPage getSignInPage() { return new SignInPage(driver); }

    public ShopByCategoryPage getShopByCategoryPage() { return new ShopByCategoryPage(driver); }

    public ComputerCategoryPage getComputerCategoryPage() { return new ComputerCategoryPage(driver); }

    public StorePage getStorePage() { return new StorePage(driver); }
}
