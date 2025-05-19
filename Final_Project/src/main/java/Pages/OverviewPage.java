package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OverviewPage {
    WebDriver driver;
    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }
    // locators
    private final By finish_button = By.id("finish");
    private final By cancel_button = By.id("cancel");

    // Actions
    public void clickFinishButton() {
        driver.findElement(finish_button).click();
    }
    public void clickCancelButton() {
        driver.findElement(cancel_button).click();
    }
    // Assertions
    public void validateFinishButton() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");    }

}
