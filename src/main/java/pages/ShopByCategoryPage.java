package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopByCategoryPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, 'computers')]")
    private WebElement computerPage;

    public ShopByCategoryPage(WebDriver driver) { super(driver); }

    public void clickComputerPage() {
        computerPage.click();
    }
}
