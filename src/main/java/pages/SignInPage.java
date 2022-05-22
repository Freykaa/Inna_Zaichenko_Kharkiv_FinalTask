package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id = "ap_email")
    private WebElement emailField;

    @FindBy(xpath = "//span[@id='continue']/span[@class='a-button-inner']")
    private WebElement continueButton;

    @FindBy(id = "auth-email-missing-alert")
    private WebElement emptyEmailErrorMessage;

    public SignInPage(WebDriver driver) { super(driver); }

    public void isEmailFieldVisible() {
        emailField.isDisplayed();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean isEmptyEmailErrorMessageVisible() {
       return emptyEmailErrorMessage.isDisplayed();
    }


}
