package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //   locators
    private final By userName_textBox = By.id("user-name");
    private final By password_textBox = By.id("password");
    private final By login_button = By.id("login-button");
    private final By errorMassage = By.xpath("//div[@class='error-message-container error']");


    //    Actions
    public void Navigate() {
        driver.get("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        driver.findElement(userName_textBox).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(password_textBox).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(login_button).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Assertion
//    public void validateInvalidDateErrorMessage() {
//        Assert.assertTrue(driver.findElement(errorMassage).isDisplayed());
//        Assert.assertTrue(driver.findElement(errorMassage).getText().contains("Epic sadface: Username and password do not match any user in this service"));
//    }
//
//    public void validateEmptyFieldsErrorMessage() {
//        Assert.assertTrue(driver.findElement(errorMassage).isDisplayed());
//        Assert.assertTrue(driver.findElement(errorMassage).getText().contains("Epic sadface: Username is required"));
//    }
//
//
//    public void validateEmptyPasswordFieldsErrorMessage() {
//        Assert.assertTrue(driver.findElement(errorMassage).isDisplayed());
//        Assert.assertTrue(driver.findElement(errorMassage).getText().contains("Epic sadface: Password is required"));
//    }

    public void validateErrorMessage(String errorMessage) {
        Assert.assertTrue(driver.findElement(errorMassage).isDisplayed());
        Assert.assertTrue(driver.findElement(errorMassage).getText().contains(errorMessage));
    }


}
