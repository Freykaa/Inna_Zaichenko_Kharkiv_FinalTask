package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(id = "acrCustomerReviewText")
    private WebElement reviewIcon;

    @FindBy(xpath = "//table[@id='histogramTable']//a[@class='a-link-normal 1star']")
    private WebElement oneStarReview;

    @FindBy(xpath = "//a[@class='a-icon a-icon-star a-star-1 review-rating']")
    private List<WebElement> reviewRating;

    public ProductPage(WebDriver driver) { super(driver); }

    public void isReviewIconVisible() {
        reviewIcon.isDisplayed();
    }

    public void clickReviewIcon() {
        reviewIcon.click();
    }

    public void filterByRating() {
        oneStarReview.click();
    }

    public List<WebElement> getReviewRating() {
        return reviewRating;
    }
}
