package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public WebDriver driver;

    @FindBy(linkText = "My Account")
    private WebElement myAccountDropdown;

    @FindBy(linkText = "Login")
    private WebElement loginButton;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnMyAccountDropdown() {
        myAccountDropdown.click();
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public LoginPage navigateDirectlyToLoginPage() {
        myAccountDropdown.click();
        loginButton.click();

        return new LoginPage(driver);
    }
}
