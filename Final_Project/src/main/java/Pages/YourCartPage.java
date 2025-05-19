package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class YourCartPage {
    WebDriver driver;
    WebDriverWait wait;


    public YourCartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }




    //   locators
    private final By checkout_Button = By.id("checkout");
    private final By continue_Button = By.id("continue-shopping");
    private final By cart_Products = By.xpath("//div[@class=\"cart_item\"]");





    // Actions
    public void clickCheckout() {
        driver.findElement(checkout_Button).click();
    }
    public void clickContinueShopping() {
        driver.findElement(continue_Button).click();
    }

    // Assertion
    public void returnToYourCartPage() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/cart.html");
    }
    public void validateCheckout() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-one.html");
    }

    public void validateContinueShopping() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
    }

}
