package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    @FindBy(id = "input-email")
    private WebElement emailTextBox;

    @FindBy(id = "input-password")
    private WebElement passwordTextBox;

    @FindBy(css = "input.btn.btn-primary")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
    private WebElement loginWarningMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail(String email) {
        emailTextBox.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public String loginWaningMessage() {
        return loginWarningMessage.getText();
    }

    public AccountPage navigateDirectlyToAccountPage(String email, String password) {
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        loginButton.click();

        return new AccountPage(driver);
    }
}
