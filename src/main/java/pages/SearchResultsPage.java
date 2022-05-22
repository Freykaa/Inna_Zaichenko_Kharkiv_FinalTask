package pages;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@data-component-type ='s-search-result']//div[@class='a-section a-spacing-base']//span[@class='a-size-base-plus a-color-base a-text-normal']")
    private List<WebElement> productList;

    @FindBy(id = "brandsRefinements")
    private WebElement brandsFilter;

    @FindBy(xpath = "//ul[@aria-labelledby='p_89-title']//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']")
    private List<WebElement> brandsList;

    @FindBy(xpath = "//span[@class='a-price-symbol']")
    private WebElement priceSymbol;


    public SearchResultsPage(WebDriver driver) { super(driver); }

    public List<WebElement> getProductList() { return productList; }

    public void isBrandsFilterVisible() {
        brandsFilter.isDisplayed();
    }

    public void selectBrandToFilter() {
        brandsList.get(1).click();
    }

    public boolean isBrandSelected() {
        return brandsList.get(0).isSelected();
    }

    public WebElement isPriceVisible() { return priceSymbol; }

    public boolean priceSymbol(final String symbol) { return
        priceSymbol.getText().contains(symbol); }

    public void openProductPage() {
        productList.get(0).click();
    }
}
