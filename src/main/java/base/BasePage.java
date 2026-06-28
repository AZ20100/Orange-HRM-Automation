package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.File;



public class BasePage {
    protected WebDriver driver;




    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By by) {
        driver.findElement(by).click();
    }

    public void type(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void upload(By by, String filePath) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(
                System.getProperty("user.dir") + File.separator + filePath
        );
    }

    public String getText(By by) {
        return driver.findElement(by).getText();
    }

    public boolean isDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}