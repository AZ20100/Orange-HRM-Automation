package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {

    private final By userDropdown = By.cssSelector(".oxd-userdropdown-tab");
    private final By logoutLink   = By.cssSelector("a[href$='logout']");
    private final By PIMMenu      = By.cssSelector("a[href*='viewPimModule']");
    private final By dashboardTitle = By.cssSelector(".oxd-topbar-header-breadcrumb h6");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        click(userDropdown);
        click(logoutLink);
    }

    public void goToPIM() {
        click(PIMMenu);
    }

    public boolean isLoggedIn() {
        return isDisplayed(dashboardTitle);
    }
}