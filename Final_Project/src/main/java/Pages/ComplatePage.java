package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ComplatePage {
    WebDriver driver;
    public ComplatePage(WebDriver driver) {
        this.driver = driver;
    }
    // locators
    private final By completeText = By.xpath("//h2[@class=\"complete-header\"]");
    private final By backHomeButton = By.id("back-to-products");

    // Actions
    public void clickBackHomeButton() {
        driver.findElement(backHomeButton).click();
    }
    // Assertions
    public void validateCompleteText() {
        Assert.assertEquals(driver.findElement(completeText).getText(),"Thank you for your order!");;

    }
    }

