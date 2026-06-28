package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void validLoginTest() {
        loginPage.loginWith("Admin", "admin123");
        Assert.assertTrue(dashboardPage.isLoggedIn(),
                "Dashboard should be visible after valid login");
    }

    @Test
    public void wrongUsernameTest() {
        loginPage.loginWith("admin0", "admin123");
        Assert.assertTrue(loginPage.isInvalidCredentialsAlertDisplayed(),
                "Error message should appear for wrong username");
    }

    @Test
    public void emptyUsernameTest() {
        loginPage.loginWith("", "admin123");
        Assert.assertTrue(loginPage.isUsernameWarningDisplayed(),
                "Error message should appear for empty username");
    }

    @Test
    public void emptyPasswordTest() {
        loginPage.loginWith("Admin", "");
        Assert.assertTrue(loginPage.isPasswordWarningDisplayed(),
                "Error message should appear for empty password");
    }

    @Test
    public void emptyBothFieldsTest() {
        loginPage.loginWith("", "");
        Assert.assertTrue(loginPage.areRequiredFieldWarningsDisplayed(),
                "Error message should appear for empty fields");
    }

    @Test
    public void logoutTest() {
        loginAsAdmin();
        dashboardPage.logout();
        Assert.assertTrue(loginPage.isErrorDisplayed() == false,
                "User should be redirected to login page after logout");
    }
}