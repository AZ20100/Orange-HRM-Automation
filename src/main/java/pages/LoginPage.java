package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    // Locators
    private final By username = By.cssSelector("input[name='username']");
    private final By password = By.cssSelector("input[type='password']");
    private final By submit   = RelativeLocator.with(By.tagName("button")).below(password);
    private final By errorMsg = By.cssSelector(".oxd-alert-content-text");

    private static final String LOGIN_URL =
            "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    // 2. ADD THESE LINES TO FIX THE RED ERRORS:
    private final By usernameRequiredLabel = By.cssSelector(".oxd-form-row:nth-child(2) .oxd-input-group__message");
    private final By passwordRequiredLabel = By.cssSelector(".oxd-form-row:nth-child(3) .oxd-input-group__message");
    private final By invalidCredentialsAlert = By.cssSelector(".oxd-alert--error");

    // Constructor

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        navigateTo(LOGIN_URL);
    }

    public void enterUsername(String user) {
        type(username, user);
    }

    public void enterPassword(String pass) {
        type(password, pass);
    }

    public void clickLogin() {
        click(submit);
    }

    // Main reusable login method
    public void loginWith(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public String getErrorMessage() {
        return getText(errorMsg);
    }

    public boolean isErrorDisplayed() {
        return isDisplayed(errorMsg);
    }
    public boolean areRequiredFieldWarningsDisplayed() {
        try {
            org.openqa.selenium.support.ui.WebDriverWait localWait =
                    new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));

            String userWarning = localWait.until(ExpectedConditions.visibilityOfElementLocated(usernameRequiredLabel)).getText();
            String passWarning = localWait.until(ExpectedConditions.visibilityOfElementLocated(passwordRequiredLabel)).getText();

            return userWarning.equalsIgnoreCase("Required") && passWarning.equalsIgnoreCase("Required");
        } catch (Exception e) {
            return false;
        }
    }
    // Checks if ONLY the password warning message appears
    public boolean isPasswordWarningDisplayed() {
        try {
            org.openqa.selenium.support.ui.WebDriverWait localWait =
                    new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(5));

            String passWarning = localWait.until(ExpectedConditions.visibilityOfElementLocated(passwordRequiredLabel)).getText();
            return passWarning.equalsIgnoreCase("Required");
        } catch (Exception e) {
            return false;
        }
    }

    // Checks if ONLY the username warning message appears (Useful for an emptyUsernameTest)
    public boolean isUsernameWarningDisplayed() {
        try {
            org.openqa.selenium.support.ui.WebDriverWait localWait =
                    new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(5));

            String userWarning = localWait.until(ExpectedConditions.visibilityOfElementLocated(usernameRequiredLabel)).getText();
            return userWarning.equalsIgnoreCase("Required");
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isInvalidCredentialsAlertDisplayed() {
        try {
            org.openqa.selenium.support.ui.WebDriverWait localWait =
                    new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(5));

            // Wait for the red error alert banner to appear and grab its text text
            String alertText = localWait.until(ExpectedConditions.visibilityOfElementLocated(invalidCredentialsAlert)).getText();
            return alertText.contains("Invalid credentials");
        } catch (Exception e) {
            return false; // Returns false if the banner does not render within 5 seconds
        }
    }
}