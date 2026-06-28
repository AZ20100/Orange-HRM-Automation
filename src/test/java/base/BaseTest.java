package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.DashboardPage;
import pages.LoginPage;
import utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;

    private static final String LOGIN_URL =
            "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        loginPage.open();
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    // Reusable admin login
    protected void loginAsAdmin() {
        loginPage.loginWith("Admin", "admin123");
    }
}