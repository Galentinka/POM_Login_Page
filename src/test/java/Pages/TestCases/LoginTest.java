package Pages.TestCases;

import Pages.AccountPage;
import Pages.LandingPage;
import Pages.LoginPage;
import TestBase.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    public LoginTest() throws Exception {
        super();
    }

    public WebDriver driver;
    public LandingPage landingPage;
    public LoginPage loginPage;
    public AccountPage accountPage;

    @BeforeMethod
    public void setup() {

        driver = initializeBrowser(properties.getProperty("browser"));
        landingPage = new LandingPage(driver);
        loginPage = landingPage.navigateDirectlyToLoginPage();
    }

    @Test
    public void verifyLoginWithValidCredentials() {

        accountPage = loginPage.navigateDirectlyToAccountPage(properties.getProperty("validEmail"), properties.getProperty("validPassword"));
        Assert.assertTrue(accountPage.displayStatusOfLogoutLink());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
