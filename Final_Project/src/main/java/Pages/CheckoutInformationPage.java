package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutInformationPage {
    WebDriver driver;
    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    //   locators
    private final By firstName_textBox = By.id("first-name");
    private final By lastName_textBox = By.id("last-name");
    private final By postalCode_textBox = By.id("postal-code");
    private final By continue_Button = By.id("continue");
    private final By cancel_Button = By.id("cancel");
    private final By errorMassage = By.xpath("//div[@class='error-message-container error']");

    // Actions
    public void enterData(String firstName, String lastName, String postalCode) {
        driver.findElement(firstName_textBox).sendKeys(firstName);
        driver.findElement(lastName_textBox).sendKeys(lastName);
        driver.findElement(postalCode_textBox).sendKeys(postalCode);
    }
    public void clickContinue() {
        driver.findElement(continue_Button).click();
    }
    public void clickCancel() {
        driver.findElement(cancel_Button).click();
    }

    // Assertion
    public void validateEnterValidData() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
    }
    public void validateErrorMessage(String errorMessage) {
        Assert.assertTrue(driver.findElement(errorMassage).isDisplayed());
        Assert.assertTrue(driver.findElement(errorMassage).getText().contains(errorMessage));
    }

}
