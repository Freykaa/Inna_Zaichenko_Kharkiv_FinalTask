package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@data-component-type ='s-search-result']//div[@class='a-section a-spacing-base']//span[@class='a-size-base-plus a-color-base a-text-normal']")
    private List<WebElement> productList;

    @FindBy(xpath = "//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")
    private List<WebElement> productPageLink;

    @FindBy(id = "brandsRefinements")
    private WebElement brandsFilter;

    @FindBy(xpath = "//ul[@aria-labelledby='p_89-title']//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']")
    private List<WebElement> brandsList;

    @FindBy(xpath = "//ul[@aria-labelledby='p_89-title']//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']//input")
    private List<WebElement> checkboxBrandsList;

    @FindBy(xpath = "//span[@class='a-price-symbol']")
    private WebElement priceSymbol;


    public SearchResultsPage(WebDriver driver) { super(driver); }

    public WebElement isPriceVisible() { return priceSymbol; }

    public List<WebElement> getProductList() { return productList; }

    public void isBrandsFilterVisible() { brandsFilter.isDisplayed(); }

    public void selectBrandToFilter() { brandsList.get(0).click(); }

    public boolean isBrandSelected() { return checkboxBrandsList.get(0).isSelected(); }

    public boolean priceSymbol(final String symbol) { return priceSymbol.getText().contains(symbol); }

    public void openProductPage() { productPageLink.get(1).click(); }
}
